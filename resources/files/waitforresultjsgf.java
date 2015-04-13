private RecognitionResult waitForResult(boolean hotword) {
    Result result = null;

    //if hotword mode, run recognize until a match occurs
    if (hotword) {
        RecognitionResult rr = new RecognitionResult();
        boolean inGrammarResult = false;
        while (!inGrammarResult) {
            result = _recognizer.recognize();
            rr.setNewResult(result, _jsgfGrammar.getRuleGrammar());
            if ((!rr.getRuleMatches().isEmpty()) && (!rr.isOutOfGrammar())) {
                inGrammarResult = true;
            }
        }
    } else { //if not hotword, just run recognize once
        while(result==null || result.getBestFinalResultNoFiller() == null || result.getBestFinalResultNoFiller().trim().isEmpty())
            result = _recognizer.recognize();
    }
    stopProcessing();
    if (result != null) {
        Result result2clear = _recognizer.recognize();
    } else {
		// recognizer returned a null result
        return null;
    }
    return new RecognitionResult(result, _jsgfGrammar.getRuleGrammar());
}
