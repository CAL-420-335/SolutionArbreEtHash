public class Arbre<T extends Comparable<T>> {
    class Noeud {
        T valeur;
        Noeud gauche = null;
        Noeud droite = null;

        public Noeud(T valeur) {
            this.valeur = valeur;
        }
    }

    Noeud racine = null;

    public boolean ajouter(T valeur) {
        if(racine == null) {
            racine = new Noeud(valeur);
            return true;
        }

        return insererValeur(racine, valeur);
    }

    public boolean contient(T valeur){
        return !(getNoeud(racine, valeur) == null);
    }

    public T get(T valeur) {
        Noeud n = getNoeud(racine, valeur);
        return n == null ? null : n.valeur;
    }

    private Noeud getNoeud(Noeud depart, T valeur){
        if(depart == null) return null;
        if(valeur.equals(depart.valeur)) return depart;
        if(valeur.compareTo(depart.valeur) < 0) return getNoeud(depart.gauche, valeur);
        return getNoeud(depart.droite, valeur);
    }

    private boolean insererValeur(Noeud depart, T valeur) {
        if(valeur.equals(depart.valeur)) return false;

        Noeud suivant;
        if(valeur.compareTo(depart.valeur) < 0) {
            // valeur < noeud.valeur
            if(depart.gauche == null){
                depart.gauche = new Noeud(valeur);
                return true;
            }
            suivant = depart.gauche;
        }
        else {
            // valeur > noeud.valeur
            if(depart.droite == null){
                depart.droite = new Noeud(valeur);
                return true;
            }
            suivant = depart.droite;
        }

        return insererValeur(suivant, valeur);
    }

}
