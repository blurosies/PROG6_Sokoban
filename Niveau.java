public class Niveau {
// Structure d'un niveau
    String nom;
    int[][] map;

// Constructeur
    // Niveau(String nom, int ligne, int colonne){

    // }

// fixe le nom du niveau
    void fixeNom(String s){
    }

    void videCase(int i, int j){

    }

    void ajouteMur(int i, int j){

    }

    void ajoutePousseur(int i, int j){

    }
    void ajouteCaisse(int i, int j){

    }
    void ajouteBut(int i, int j){

    }
    int lignes(){
        return 0;
    }
    int colonnes(){
        return 0;
    }
    String nom(){
        return "ha";
    }
    boolean estVide(int l, int c){
        return true;
    }
    boolean aMur(int l, int c){
        return true;
    } 
    boolean aBut(int l, int c){
        return true;
    } 
    boolean aPousseur(int l, int c){
        return true;
    } 
    boolean aCaisse(int l, int c){
        return true;

    }
}
