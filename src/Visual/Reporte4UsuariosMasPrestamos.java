package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.List;
import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import Logica.UsuarioAcreditado;

/**
 * Diálogo que muestra un gráfico de barras verticales con
 * los top 5 usuarios que más préstamos han realizado.
 */
public class Reporte4UsuariosMasPrestamos extends JDialog {
	private final List<UsuarioAcreditado> top5;

	/**
	 * Construye el diálogo.
	 *
	 * @param owner ventana padre (puede ser null)
	 * @param top5  lista con hasta 5 usuarios ordenados por préstamos descendente
	 */
	public Reporte4UsuariosMasPrestamos(Frame owner, List<UsuarioAcreditado> top5) {
		super(owner, "Top 5 Usuarios con Más Préstamos", true);
		this.top5 = top5;
		initUI();
	}

	private void initUI() {
		// 1) Crear el dataset
		DefaultCategoryDataset dataset = createDataset();

		// 2) Crear el gráfico de barras verticales
		JFreeChart chart = createChart(dataset);

		// 3) Configurar el renderizador para mostrar valores
		configureRenderer(chart);

		// 4) Colocar el chart en un ChartPanel
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(800, 600));

		// 5) Montarlo todo en el JDialog
		configureDialog(chartPanel);
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (UsuarioAcreditado u : top5) {
			int cantidad = u.getPrestamos().size();
			dataset.addValue(cantidad, "Préstamos", u.getNombreCompleto());
		}
		return dataset;
	}

	private JFreeChart createChart(DefaultCategoryDataset dataset) {
		return ChartFactory.createBarChart(
				"Top 5 Usuarios con Más Préstamos",
				"Usuario",
				"Cantidad de Préstamos",
				dataset,
				PlotOrientation.VERTICAL,
				false,  // no mostrar leyenda
				true,    // tooltips
				false    // URLs
				);
	}

	private void configureRenderer(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
	}

	private void configureDialog(ChartPanel chartPanel) {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(chartPanel, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}