package Utiles;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * AutoSuggestor sin lambdas y con popup persistente, compatible con Java 8.
 */
public class AutoSuggestor<T> {
	private final JTextField textField;
	private final List<T> items;
	private final Function<T, String> displayFunction;
	private final JPopupMenu suggestionPopup;
	private final SuggestionSelectedListener<T> listener;

	public interface SuggestionSelectedListener<T> {
		void onItemSelected(T selectedItem);
	}

	public AutoSuggestor(final JTextField textField, List<T> items,
			Function<T, String> displayFunction,
			SuggestionSelectedListener<T> listener) {

		this.textField = textField;
		this.items = items;
		this.displayFunction = displayFunction;
		this.listener = listener;
		this.suggestionPopup = new JPopupMenu();
		this.suggestionPopup.setFocusable(false);

		// Escucha cuando se escribe texto
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) { updateSuggestions(); }
			public void removeUpdate(DocumentEvent e) { updateSuggestions(); }
			public void changedUpdate(DocumentEvent e) {}
		});

		// 🔻 Aquí insertas esto:
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
					suggestionPopup.setVisible(false);
				}
			}
		});

		// Ocultar si se hace clic fuera
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			public void eventDispatched(AWTEvent event) {
				if (event instanceof MouseEvent) {
					MouseEvent me = (MouseEvent) event;
					if (me.getID() == MouseEvent.MOUSE_PRESSED) {
						Component comp = SwingUtilities.getDeepestComponentAt(me.getComponent(), me.getX(), me.getY());
						if (comp != null && !SwingUtilities.isDescendingFrom(comp, suggestionPopup)
								&& comp != textField) {
							suggestionPopup.setVisible(false);
						}
					}
				}
			}
		}, AWTEvent.MOUSE_EVENT_MASK);
	}

	private void updateSuggestions() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				String input = textField.getText();
				if (input == null || input.trim().isEmpty()) {
					suggestionPopup.setVisible(false);
					return;
				}
				input = input.trim().toLowerCase();

				List<T> filtered = new ArrayList<T>();
				for (T item : items) {
					String texto = displayFunction.apply(item).toLowerCase();
					if (texto.contains(input)) {
						filtered.add(item);
					}
				}

				if (filtered.isEmpty()) return;

				suggestionPopup.removeAll();
				for (final T item : filtered) {
					final String label = displayFunction.apply(item);
					JMenuItem menuItem = new JMenuItem(label);
					menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					menuItem.setBackground(Color.WHITE);
					menuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textField.setText(label);
							suggestionPopup.setVisible(false);
							listener.onItemSelected(item);
						}
					});
					suggestionPopup.add(menuItem);
				}

				try {
					suggestionPopup.show(textField, 0, textField.getHeight());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}