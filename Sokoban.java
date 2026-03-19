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
            
            //  // Test global des tableaux + itérateurs
            if (args[0].equals("3")) {
                SequenceTableau tab = new SequenceTableau();
                for (int i = 0; i < 30; i++) {
                    
                    if(tab.nbElem%2==0){
                        tab.insereTete(i);
                    }else {
                        tab.insereQueue(i);
                    }

                    System.out.println(tab.toString());
                }

                Iterateur it1 = tab.iterateur();
                System.out.print("Éléments lus par l'itérateur : ");
        
                while (it1.aProchain()) {
                    System.out.print(it1.prochain() + " ");
                }
                System.out.println();

                Iterateur it2 = tab.iterateur();
        
                while (it2.aProchain()) {
                    int valeur = it2.prochain();
                    if (valeur % 5 == 0) {
                        System.out.println("-> Suppression du nombre : " + valeur);
                        it2.supprime();
                    }
                }
        
            System.out.println("Séquence finale : \n" + tab.toString());
         }

        //  // Test global des Listes + itérateurs
            if (args[0].equals("4")) {
                SequenceListe liste = new SequenceListe();
                for (int i = 0; i < 30; i++) {
                    
                    if(i%2==0){
                        liste.insereTete(i);
                    }else {
                        liste.insereQueue(i);
                    }

                    System.out.println(liste.toString());
                }

                Iterateur it1 = liste.iterateur();
                System.out.print("Éléments lus par l'itérateur : ");
        
                while (it1.aProchain()) {
                    System.out.print(it1.prochain() + " ");
                }
                System.out.println();

                Iterateur it2 = liste.iterateur();
        
                while (it2.aProchain()) {
                    int valeur = it2.prochain();
                    if (valeur % 5 == 0) {
                        System.out.println("-> Suppression du nombre : " + valeur);
                        it2.supprime();
                    }
                }
        
            System.out.println("Séquence finale : \n" + liste.toString());
         }




        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
