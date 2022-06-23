package gallerie.gui;

import java.awt.GridLayout;
import java.sql.Connection;
import java.util.List;

import javax.swing.*;

import gallerie.db.tables.ArtistiTable;
import gallerie.db.tables.ClientiTable;
import gallerie.model.*;

public class artistaWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5886652683163025600L;
	private final JPanel panel;
	private final JButton btn;
	private final JButton btnClienti;
//	private final JTable table;
	
	public artistaWindow(final Connection connection) {
		panel = new JPanel(new GridLayout(1, 2));
		btn = new JButton("Artisti");
		btnClienti = new JButton("Clienti");
		btn.setSize(20, 12);
		btnClienti.setSize(20,12);
		
//		String columns[] = {
//				"Nome",
//				"Cognome",
//				"Nome d'arte",
//				"Telefono",
//				"Mail",
//				"Data morte",
//				"Codice"
//		};
//		String data[][] = new String[list.size()][7];
//		int i = 0;
//		for (Artista a : list) {
//			data[i][0] = a.getNome().isPresent() ? a.getNome().get() : "null";
//			data[i][1] = a.getCognome().isPresent() ? a.getCognome().get() : "null";
//			data[i][2] = a.getNomeArte().isPresent() ? a.getNomeArte().get() : "null";
//			data[i][3] = a.getTelefono().isPresent() ? a.getTelefono().get().toString() : "null";
//			data[i][4] = a.getMail().isPresent() ? a.getMail().get() : "null";
//			data[i][5] = a.getDataMorte().isPresent() ? a.getDataMorte().get().toString() : "null";
//			data[i][6] = String.valueOf(a.getCodArtista());
//			i++;
//		}
//		table = new JTable(data, columns);
//		table.setShowGrid(true);
//		table.setShowVerticalLines(true);
//		table.setShowVerticalLines(true);
		
		btn.addActionListener(e -> {
			List<Artista> list = new ArtistiTable(connection).findAll();
			createArtistaFrame(list);
		});
		
		btnClienti.addActionListener(e -> {
			List<Cliente> list = new ClientiTable(connection).findAll();
			createClientiFrame(list);
		});
		
		panel.add(btn);
		panel.add(btnClienti);
		
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
	
	private void createArtistaFrame(final List<Artista> list) {
		JFrame frame = new JFrame("Artisti");
		JPanel panel = new JPanel();
		JTable table = new JTable();
		
		String columns[] = {
				"Nome",
				"Cognome",
				"Nome d'arte",
				"Telefono",
				"Mail",
				"Data morte",
				"Codice"
		};
		String data[][] = new String[list.size()][7];
		int i = 0;
		for (Artista a : list) {
			data[i][0] = a.getNome().isPresent() ? a.getNome().get() : "null";
			data[i][1] = a.getCognome().isPresent() ? a.getCognome().get() : "null";
			data[i][2] = a.getNomeArte().isPresent() ? a.getNomeArte().get() : "null";
			data[i][3] = a.getTelefono().isPresent() ? a.getTelefono().get().toString() : "null";
			data[i][4] = a.getMail().isPresent() ? a.getMail().get() : "null";
			data[i][5] = a.getDataMorte().isPresent() ? a.getDataMorte().get().toString() : "null";
			data[i][6] = String.valueOf(a.getCodArtista());
			i++;
		}
		table = new JTable(data, columns);
		table.setEnabled(false);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setShowVerticalLines(true);
		
		
		panel.add(new JScrollPane(table));
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createClientiFrame(final List<Cliente> list) {
		JFrame frame = new JFrame("Clienti");
		JPanel panel = new JPanel();
		JTable table = new JTable();
		
		String columns[] = {
				"Codice Fiscale",
				"Nome",
				"Cognome",
				"Telefono",
				"Mail"
		};
		String data[][] = new String[list.size()][5];
		int i = 0;
		for (Cliente c : list) {
			data[i][0] = c.getCodFiscale();
			data[i][1] = c.getNome();
			data[i][2] = c.getCognome();
			data[i][3] = String.valueOf(c.getTelefono());
			data[i][4] = c.getMail();
			i++;
		}
		table = new JTable(data, columns);
		table.setEnabled(false);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setShowVerticalLines(true);
		
		
		panel.add(new JScrollPane(table));
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
