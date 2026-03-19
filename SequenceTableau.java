
public class SequenceTableau implements Sequence {
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

    class IterateurTab implements Iterateur {

        int current_ind;
        int elem_parcourus;
        boolean supprimable;

        IterateurTab(){
            current_ind=debut;
            elem_parcourus=0;
        }

        public boolean aProchain(){
            return this.elem_parcourus<nbElem;
        }

        public int prochain(){
            if (!this.aProchain()) {
                throw new RuntimeException("Pas de prochain");
            }
            this.elem_parcourus++;
            this.current_ind= (this.current_ind+1)%tableau.length;
            this.supprimable=true;
            return tableau[(this.current_ind-1+tableau.length)%tableau.length];
        }

        public void supprime(){
            if (supprimable) {
                this.supprimable=false;
                int indice=current_ind;
                for (int i = 0; i < nbElem-elem_parcourus; i++) {
                    int curr_int=tableau[indice];
                    tableau[(indice-1+tableau.length)%tableau.length]=curr_int;
                    indice=(indice+1)%tableau.length;
                }
                nbElem--;
                elem_parcourus--;
                current_ind=(current_ind-1+tableau.length)%tableau.length;
            } else {
                throw new IllegalStateException("Impossible de supprimer"); 
            }
            
        }
    }

// insère l'élément nommé element en début de séquence (en première position) 
    public void insereTete(int element){
    // cas tableau plein, redimensionner
        if (nbElem>=this.tableau.length) {
            int [] newtableau = new int[this.tableau.length*2];
            // copier du debut jusqu'a la fin (physique) du tab
            System.arraycopy(this.tableau, debut , newtableau, 0 , tableau.length-debut);
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
    public void insereQueue(int element){
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
    public int extraitTete(){
        if (this.estVide()) {
            throw new RuntimeException("File Vide");
        }
        int tete=this.tableau[debut];
        this.debut=(debut+1)%this.tableau.length;
        this.nbElem--;
        return tete;
    }

// renvoie vrai si et seulement si la séquence est vide
    public boolean estVide(){
        return this.nbElem==0;
    }

    public Iterateur iterateur() {
        return new IterateurTab();
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

