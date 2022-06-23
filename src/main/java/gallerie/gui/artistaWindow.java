package gallerie.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.List;

import javax.swing.*;

import gallerie.db.tables.ArtistiTable;
import gallerie.model.Artista;

public class artistaWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5886652683163025600L;
	private final JPanel panel;
	private final JButton btn;
	private final JTextArea ta;
//	private final JTable table;
	
	public artistaWindow(final Connection connection) {
		panel = new JPanel(new GridLayout(1, 2));
		ta = new JTextArea();
		btn = new JButton("Artisti");
		btn.setSize(100, 50);
		JScrollPane pane = new JScrollPane(ta);
		pane.setPreferredSize(new Dimension(500, 500));
		
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
			ta.selectAll();
			ta.replaceSelection("");
			list.stream().forEach(a -> ta.append(a.toString() + "\n"));
			this.repaint();
		});
		
		panel.add(btn);
		panel.add(pane);
		
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
}
