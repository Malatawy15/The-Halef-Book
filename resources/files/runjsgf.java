public void run() {
    RecognitionResult result = null;
    result = SphinxRecEngineJSGF.this.waitForResult(hotword);
    RecogListener recogListener = null;
    synchronized (SphinxRecEngineJSGF.this) {
        recogListener = _recogListener;
    }
	// pass on the result upwards through the recognition listener
    recogListener.recognitionComplete(result);
}
