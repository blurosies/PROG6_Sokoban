
public class SequenceTableau {
    private int MAX_LENGTH = 25;
    int [] tableau;
    int nbElem;
    int fin;
    int debut;
    
// constructeur
    SequenceTableau(){
        this.tableau= new int[MAX_LENGTH];
        this.fin=0;
        this.debut=0;
}

// insère l'élément nommé element en début de séquence (en première position) 
    void insereTete(int element){
    // cas tableau plein, redimensionner
        if (nbElem>=this.tableau.length) {
            int [] newtableau = new int[this.tableau.length*2];
            // copier du debut jusqu'a la fin (physique) du tab
            System.arraycopy(this.tableau, debut , newtableau, 0 , nbElem-debut);
            // coller le reste a la suite de la premiere partie copiée
            System.arraycopy(this.tableau, 0 , newtableau, nbElem-debut , debut);
            // reset des parametres
            this.tableau=newtableau; 
            this.debut=0;
            this.fin=this.nbElem;
        }
        this.debut=(debut-1+this.tableau.length)%this.tableau.length;
        this.tableau[debut]=element;
        nbElem++;

}

// insère l'élément nommé element en fin de séquence (en dernière position) 
    void insereQueue(int element){
        // cas tableau plein, redimensionner
        if (nbElem>=this.tableau.length) {
            int [] newtableau = new int[this.tableau.length*2];
            // copier du debut jusqu'a la fin (physique) du tab
            System.arraycopy(this.tableau, debut , newtableau, 0 , nbElem-debut);
            // coller le reste a la suite de la premiere partie copiée
            System.arraycopy(this.tableau, 0 , newtableau, nbElem-debut , debut);
            // reset des parametres
            this.tableau=newtableau; 
            this.debut=0;
            this.fin=this.nbElem;

        }
        this.tableau[fin]=element;
        this.fin=(fin+1)%this.tableau.length;
        nbElem++;
    }

// extrait et renvoie la valeur de l'élément situé en début de séquence (en première position) 
// exception si vide
    int extraitTete(){
        if (this.estVide()) {
            throw new RuntimeException("File Vide");
        }
        int tete=this.tableau[debut];
        this.debut=(debut+1)%this.tableau.length;
        this.nbElem--;
        return tete;
    }

// renvoie vrai si et seulement si la séquence est vide
    boolean estVide(){
        return this.nbElem==0;
    }

// fonction pour affichage
    public String toString(){
        StringBuilder tab = new StringBuilder("[ ");
        for (int i = 0; i < this.nbElem; i++) {
            int valeur=this.tableau[(debut+i)%tableau.length];
            tab.append(valeur);
            if (i!=nbElem-1) {
                tab.append(" ,");
            }
        }
        tab.append(" ]");
        return tab.toString();
    }

}

