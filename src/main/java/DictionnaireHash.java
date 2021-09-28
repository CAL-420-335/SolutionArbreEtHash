public class DictionnaireHash {
    TableHashage<PaireCleValeur<String, String>> hash = new TableHashage<>(32);

    public void ajouter(String mot, String definition){
        PaireCleValeur kv = new PaireCleValeur(mot, definition);
        if(!hash.ajouter(kv)) {
            hash.get(kv).val = definition;
        }
    }

    public String getDefinition(String mot) {
        PaireCleValeur<String, String> kv = hash.get( new PaireCleValeur<>(mot, null));
        return kv == null ? null : kv.val;
    }
}
