protected final JSGFGrammar _jsgfGrammar;

public synchronized void load(GrammarLocation grammarLocation) throws IOException, GrammarException {
    _jsgfGrammar.setBaseURL(grammarLocation.getBaseURL());
    _jsgfGrammar.loadJSGF(grammarLocation.getGrammarName());
}

