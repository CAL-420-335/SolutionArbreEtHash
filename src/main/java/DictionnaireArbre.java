public class DictionnaireArbre {

    Arbre<PaireCleValeur<String, String>> arbre = new Arbre();

    public void ajouter(String mot, String definition){
        PaireCleValeur kv = new PaireCleValeur(mot, definition);
        if(!arbre.ajouter(kv)) {
            arbre.get(kv).val = definition;
        }
    }

    public String getDefinition(String mot) {
        PaireCleValeur<String, String> kv = arbre.get( new PaireCleValeur<>(mot, null));
        return kv == null ? null : kv.val;
    }


}
