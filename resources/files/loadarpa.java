protected final SimpleNGramModel _nGramModel;
protected final LexTreeLinguist _linguist;
private PropertySheet _ps;

public void load(GrammarLocation grammarLocation) throws IOException, GrammarException {
    String file = grammarLocation.getBaseURL().toString() + "/" + grammarLocation.getGrammarName() + ".lm";
    _nGramModel.deallocate();
    _ps.setString(LanguageModel.PROP_LOCATION, file);
    _nGramModel.newProperties(_ps);
    _nGramModel.allocate();
    _linguist.allocate();
}

