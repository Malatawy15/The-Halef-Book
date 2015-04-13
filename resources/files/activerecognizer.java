public class ActiveRecognizer {

	private ObjectPool _recPool;
	private Object _recEngine;
	private String _appType;

	public ActiveRecognizer(ObjectPool recPool, Object recEngine, String appType) {
		_recPool = recPool;
		_recEngine = recEngine;
		_appType = appType;
	}

	public void startRecognition(PushBufferDataSource dataSource,
			RecogListener recogListener) throws UnsupportedEncodingException {
		if (_appType.equals("application/jsgf")) {
			((SphinxRecEngineJSGF) _recEngine).startRecognition(dataSource,
					recogListener);
			((SphinxRecEngineJSGF) _recEngine).startRecogThread();
		} else if (_appType.equals("application/arpa")) {
			((SphinxRecEngineARPA) _recEngine).startRecognition(dataSource,
					recogListener);
			((SphinxRecEngineARPA) _recEngine).startRecogThread();
		}
	}

	public void loadLM(GrammarLocation grammarLocation)
			throws GrammarException, IOException {
		if (_appType.equals("application/jsgf")) {
			((SphinxRecEngineJSGF) _recEngine).load(grammarLocation);
		} else if (_appType.equals("application/arpa")) {
			((SphinxRecEngineARPA) _recEngine).load(grammarLocation);
		}
	}
	
	public void setHotword(boolean hotword) {
		if (_appType.equals("application/jsgf")) {
			((SphinxRecEngineJSGF) _recEngine).setHotword(hotword);
		}
	}

	public void returnRecEngine() throws Exception {
		_recPool.returnObject(_recEngine);
	}

}
