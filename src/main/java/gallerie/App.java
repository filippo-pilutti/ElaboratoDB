package gallerie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gallerie.db.ConnectionProvider;
import gallerie.db.tables.ArtistiTable;
import gallerie.gui.artistaWindow;
import gallerie.model.Artista;
import gallerie.utils.Utils;

public class App {

    public static void main(String[] args) {
    	final String username = "root";
        final String password = "Filippo1997.";
        final String dbName = "gallerie";
        final ConnectionProvider connectionProvider = new ConnectionProvider(username, password, dbName);
        final ArtistiTable artisti = new ArtistiTable(connectionProvider.getMySQLConnection());
        
        List<Artista> l = new ArrayList<>();
//        
//        
//        final Artista artista1 = new Artista(Optional.of("Leonardo"), Optional.of("da Vinci"), Optional.empty(), Optional.empty(), 
//        										Optional.empty(), Utils.buildDate(2, 5, 1519), 8);
//        artisti.save(artista1);
        
//        l = artisti.findAll();
//        l.forEach(a -> {
//        	System.out.println(a.toString());
//        });
        
        Optional<Artista> art = artisti.findByPrimaryKey(5);
        System.out.println(art.get().toString());
        
        final artistaWindow aw = new artistaWindow(connectionProvider.getMySQLConnection());
    }

}
