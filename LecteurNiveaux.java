import java.io.InputStream;
import java.util.*;

public class LecteurNiveaux {
    private Scanner lecteur;
    
    LecteurNiveaux(InputStream in) {
        this.lecteur = new Scanner(in);
    }
    
    // Renvoie le niveau lu ou null si la fin du flux à été atteinte. Le niveau est décrit textuellement sur le flux d'entrée
    // ligne par ligne.
    Niveau lisProchainNiveau(InputStream in){
        Niveau current = new Niveau();
        int i = 0;
        int nb_colonne=0;
        while (lecteur.hasNextLine()) {
            String ligne =lecteur.nextLine();

            // ligne vide entre deux niveaux
            if (ligne.length()==0) {
                return current;
            }

            // stockage du nom
            if (ligne.charAt(0)==';') {
                String nom = ligne.substring(1);
                current.fixeNom(nom);

            } else {

                // remplissage de la map
                for (int j = 0; j < ligne.length(); j++) {
                    if (ligne.charAt(j)=='#') {
                        current.ajouteMur(i, j);

                    } else if (ligne.charAt(j)=='*') {
                        current.ajouteBut(i, j);
                        current.ajouteCaisse(i, j);

                    } else if (ligne.charAt(j)=='+') {
                        current.ajouteBut(i, j);
                        current.ajoutePousseur(i, j);

                    } else if (ligne.charAt(j)=='@') {
                        current.ajoutePousseur(i, j);

                    } else if (ligne.charAt(j)=='$') {
                        current.ajouteCaisse(i, j);

                    } else if (ligne.charAt(j)=='.') {
                        current.ajouteBut(i, j);
                    }
                    if (j>nb_colonne) {
                        nb_colonne=j;
                    }
                }
                i++;
        }
        }
        
        return current;
    }
}
 
