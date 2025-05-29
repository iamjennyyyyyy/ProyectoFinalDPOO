package Utiles;

import javax.swing.table.DefaultTableModel;

import Logica.UsuarioAcreditado;

public class UsuarioTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public UsuarioTableModel(UsuarioAcreditado[] usuarios){

		String[] columnNames = {"ID Usuario", "Nombre y apellidos", "Sexo", "Edad"};
		setColumnIdentifiers(columnNames);

		for (int i = 0; i < usuarios.length; i++) {
			Object[] newRow = new Object[]{usuarios[i].getId(), usuarios[i].getNombreCompleto(), usuarios[i].getSexo(), usuarios[i].getEdad()};
			addRow(newRow);
		}
	}
}