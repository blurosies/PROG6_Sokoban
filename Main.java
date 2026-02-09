import java.io.FileInputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String args[]){
        try {
            FileInputStream fichier = new FileInputStream("Niveaux.txt");
            Niveau niv = new Niveau();
            LecteurNiveaux lect = new LecteurNiveaux(fichier);

            while ((niv=lect.lisProchainNiveau())!=null) {
                PrintStream out = new PrintStream(System.out);
                RedacteurNiveau write = new RedacteurNiveau(out);
                write.ecrisNiveau(niv);
                String nom = new String();
                nom = niv.nom();
                System.out.println("; "+ nom); 
            }
            fichier.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
