import java.util.NoSuchElementException;

public class SequenceListe {
    Maillon tete;

    class Maillon {
    int valeur;
    Maillon suivant;

    Maillon(int valeur, Maillon suivant){
        this.valeur=valeur;
        this.suivant=suivant;
    }
}

// insère l'élément nommé element en début de séquence (en première position)
    void insereTete(int element){
        Maillon insere= new Maillon(element, this.tete);
        this.tete=insere;
    }

// insère l'élément nommé element en fin de séquence (en dernière position) 
    void insereQueue(int element){
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
    int extraitTete(){
        if (this.tete!=null) {
            int valeur=this.tete.valeur;
            this.tete=this.tete.suivant;
            return valeur;
        }else {
            throw new NoSuchElementException("La liste est vide.");
        }
    }

// renvoie vrai si et seulement si la séquence est vide.
    boolean estVide(){
        return this.tete==null;
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
