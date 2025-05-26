//package Utiles;
//
//import javax.swing.table.DefaultTableModel;
//
//import Logica.UsuarioAcreditado;
//
//public class UsuarioTableModel extends DefaultTableModel {
//
//	private static final long serialVersionUID = 1L;
//
//	public UsuarioTableModel(UsuarioAcreditado[] usuarios){
//
//		String[] columnNames = {"ID Usuario", "Nombre y apellidos", "Sexo", "Edad"};
//		setColumnIdentifiers(columnNames);
//
//		for (int i = 0; i < usuarios.length; i++) {
//			Object[] newRow = new Object[]{usuarios[i].getId(), usuarios[i].getNombreCompleto(), usuarios[i].getSexo(), usuarios[i].getEdad()};
//			addRow(newRow);
//		}
//	}
//}

package Utiles;

import javax.swing.table.DefaultTableModel;
import Logica.UsuarioAcreditado;

public class UsuarioTableModel extends DefaultTableModel {
    private static final long serialVersionUID = 1L;
    private static final String[] COLUMN_NAMES = {"ID Usuario", "Nombre y apellidos", "Sexo", "Edad"};

    public UsuarioTableModel(UsuarioAcreditado[] usuarios) {
        super(COLUMN_NAMES, 0); // Inicializa con nombres de columnas y 0 filas
        
        if (usuarios != null) {
            for (UsuarioAcreditado usuario : usuarios) {
                addRow(createRowData(usuario));
            }
        }
    }

    private Object[] createRowData(UsuarioAcreditado usuario) {
        return new Object[]{
            usuario.getId(),
            usuario.getNombreCompleto(),
            usuario.getSexo(),
            usuario.getEdad()
        };
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hacer que las celdas no sean editables
    }
}