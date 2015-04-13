public void run() {
    RecognitionResult result = SphinxRecEngineARPA.this.waitForResult();
	RecogListener recogListener = null;
    synchronized (SphinxRecEngineARPA.this) {
        recogListener = _recogListener;
    }
	// pass on the result upwards through the recognition listener
    recogListener.recognitionComplete(result);
}
