import java.io.PrintStream;
import java.io.OutputStream;

public class RedacteurNiveau {
    private PrintStream redacteur;

    RedacteurNiveau(OutputStream out) {
    this.redacteur = new PrintStream(out);
    }

//  Ecris le niveau "niv" sur le flux de sortie "out"
    void ecrisNiveau(OutputStream out, Niveau niv){
        int lignes= niv.lignes();
        int colonnes= niv.colonnes();
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {


        }
    }
    }
}
