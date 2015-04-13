private RecognitionResult waitForResult() {
    Result result = null;
    do {
        result = _recognizer.recognize();
    } while (result != null && result.getBestResultNoFiller().trim().isEmpty());
    stopProcessing();
    if (result != null) {
        Result result2clear = _recognizer.recognize();
    } else {
		// recognizer returned a null result
        return null;
    }
    RecognitionResult recognitionResult = null;
    try {
        recognitionResult = RecognitionResult.constructResultFromString(result.getBestResultNoFiller());
    } catch (InvalidRecognitionResultException ex) {
    	// invalid recognition result
    }
    return recognitionResult;
}
