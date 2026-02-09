public class Niveau {
// Structure d'un niveau
    private String nom;
    private char[][] map;
    private int lignes;
    private int colonnes;

// Constructeur
    Niveau(){
        this.nom = "Vide";
        this.lignes=0;
        this.colonnes=0;
        this.map= new char[100][100];
    }

// fixe le nom du niveau
    void fixeNom(String s){
        this.nom=s;
    }

// supprime le contenu de la case à la ligne i et à la colonne j
    void videCase(int i, int j){
        this.map[i][j]=' ';
        }

// La suite de ces fonctions modifient le contenu de la map

    void ajouteMur(int i, int j){
        this.map[i][j]='#';

        if (i >= this.lignes) {
            this.lignes = i + 1; 
        }
        if (j >= this.colonnes) {
            this.colonnes = j + 1;
            }
    }

    void ajoutePousseur(int i, int j){
        if (this.map[i][j]=='.') {
            this.map[i][j]='+';
        } else {
            this.map[i][j]='@';
        }

        if (i >= this.lignes) {
            this.lignes = i + 1; 
        }
        if (j >= this.colonnes) {
            this.colonnes = j + 1;
            }
    }

    void ajouteCaisse(int i, int j){
        if (this.map[i][j]=='.') {
            this.map[i][j]='*';
        } else {
            this.map[i][j]='$';
        }

        if (i >= this.lignes) {
            this.lignes = i + 1; 
        }
        if (j >= this.colonnes) {
            this.colonnes = j + 1;
            }
    }


    void ajouteBut(int i, int j){
        if (this.map[i][j]=='@') {
            this.map[i][j]='+';

        } else if (this.map[i][j]=='$') {
            this.map[i][j]='*';

        } else {
            this.map[i][j]='.';
        }

        if (i >= this.lignes) {
            this.lignes = i + 1; 
        }
        if (j >= this.colonnes) {
            this.colonnes = j + 1;
            }
    }

// info sur le niveaux

    int lignes(){
        return this.lignes;
    }

    int colonnes(){
        return this.colonnes;
    }

    String nom(){
        return this.nom;
    }

// info sur les cases
    boolean estVide(int l, int c){
        if (this.map[l][c]==' ') {
            return true;
        } else {
            return false;
        }
    }
    boolean aMur(int l, int c){
        if (this.map[l][c]=='#') {
            return true;
        } else {
            return false;
        }
    } 
    boolean aBut(int l, int c){
        if (this.map[l][c]=='.'||this.map[l][c]=='+'||this.map[l][c]=='*') {
            return true;
        } else {
            return false;
        }
    } 
    boolean aPousseur(int l, int c){
        if (this.map[l][c]=='@'||this.map[l][c]=='+') {
            return true;
        } else {
            return false;
        }
    } 
    boolean aCaisse(int l, int c){
        if (this.map[l][c]=='$'||this.map[l][c]=='*') {
            return true;
        } else {
            return false;
        }

    }
}
