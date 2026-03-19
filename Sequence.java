public interface Sequence {
    Iterateur iterateur();
    void insereTete(int element);
    void insereQueue(int element);
    int extraitTete();
    boolean estVide();
    String toString();

} 