import java.io.FileInputStream;
import java.io.PrintStream;

public class Sokoban {
    public static void main(String args[]){
        try {
            //  // Test niveaux
            if (args[0].equals("0")) {
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
            }

            //  // Test SequenceListe + interface
            if (args[0].equals("1")) {
                SequenceListe liste = new SequenceListe();
                liste.insereTete(1);
                liste.insereTete(2);
                liste.insereQueue(3);
                System.err.println(liste.toString());  
            }

            //  // Test SequenceTableau (testé avec max length 2 pour verif redimensionnage) + interface
            if (args[0].equals("2")) {
                SequenceTableau tab = new SequenceTableau();
                System.out.println(tab.estVide());
                System.out.println(tab.toString());
                tab.insereTete(1);
                tab.insereTete(2);
                tab.insereQueue(3);
                System.out.println(tab.toString());
                tab.insereTete(1);
                tab.insereTete(2);
                tab.insereTete(1);
                tab.insereTete(2);
                System.out.println(tab.toString());
                System.out.println(tab.extraitTete());
            }



        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
