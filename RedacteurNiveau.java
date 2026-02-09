import java.io.PrintStream;
import java.io.OutputStream;

public class RedacteurNiveau {
    private PrintStream redacteur;

    RedacteurNiveau(OutputStream out) {
    this.redacteur = new PrintStream(out);
    }

//  Ecris le niveau "niv" sur le flux de sortie "out"
    void ecrisNiveau(Niveau niv){
        int lignes= niv.lignes();
        int colonnes= niv.colonnes();
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (niv.aMur(i, j)) {
                    redacteur.append('#');
                }
                if (niv.aCaisse(i, j)) {
                    if (niv.aBut(i, j)) {
                        redacteur.append('*');
                    } else {
                        redacteur.append('$');
                    }
                }
                if (niv.aPousseur(i, j)) {
                    if (niv.aBut(i, j)) {
                        redacteur.append('+');
                    } else {
                        redacteur.append('@');
                    }
                }
                if (niv.aBut(i, j)) {
                    redacteur.append('.');
                }
                if(niv.estVide(i, j)){
                    redacteur.append(' ');
                }
                }
            redacteur.append('\n');
            }
         }
    }
