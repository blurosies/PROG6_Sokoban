import java.util.NoSuchElementException;

public class SequenceListe implements Sequence {
    Maillon tete;

    class Maillon {
    int valeur;
    Maillon suivant;

    Maillon(int valeur, Maillon suivant){
        this.valeur=valeur;
        this.suivant=suivant;
        }
    }

// constructeur
    SequenceListe(){
        this.tete=null;
}

    class Iterateur {

        Maillon current;
        Maillon precedent;
        Maillon precedent2;
        boolean supprimable;

        Iterateur(){
            this.current=tete;
            this.precedent=null;
            this.precedent2=null;
        }

        boolean aProchain(){
            return this.current!=null;
        }

        int prochain(){
            if (!this.aProchain()) {
                throw new RuntimeException("Pas de prochain");
            }
            this.supprimable=true;
            this.precedent2=this.precedent;
            this.precedent=this.current;
            this.current=this.current.suivant;
            return this.precedent.valeur;
        }

        void supprime(){
            if (supprimable) {
                this.supprimable=false;
                // supression du tout premier élément
                if (this.precedent==tete) {
                    tete=this.current;
                } else {
                    this.precedent2.suivant=this.current;
                    this.precedent=this.precedent2;
                }
                
            } else {
                throw new IllegalStateException("Impossible de supprimer"); 
            }
            
        }

    }


// insère l'élément nommé element en début de séquence (en première position)
    public void insereTete(int element){
        Maillon insere= new Maillon(element, this.tete);
        this.tete=insere;
    }

// insère l'élément nommé element en fin de séquence (en dernière position) 
    public void insereQueue(int element){
        Maillon insere = new Maillon(element, null);
        if (this.tete!=null) {
            Maillon currMaillon=this.tete;
    
            while (currMaillon.suivant!=null) {
                currMaillon=currMaillon.suivant;
            }
            currMaillon.suivant=insere;
        } else {
            this.tete=insere;
        }
    }

// extrait et renvoie la valeur de l'élément situé en début de séquence (en première position)
    public int extraitTete(){
        if (this.tete!=null) {
            int valeur=this.tete.valeur;
            this.tete=this.tete.suivant;
            return valeur;
        }else {
            throw new NoSuchElementException("La liste est vide.");
        }
    }

// renvoie vrai si et seulement si la séquence est vide.
    public boolean estVide(){
        return this.tete==null;
    }

    public Iterateur iterateur() {
        return new Iterateur();
    }

// fonction pour affichage et débugage
    public String toString(){
        // debut affichage
       StringBuilder liste =  new StringBuilder("[ ");
       // liste vide
       if (this.tete==null) {
            return "[ ]";
       }
       //met la prem valeur
       liste.append(this.tete.valeur);
       Maillon curr= this.tete.suivant;
       while (curr!=null) {
            liste.append(" ->" + curr.valeur);
                curr=curr.suivant;
       }
       liste.append(" ]");

       return liste.toString();
        
    }
}
