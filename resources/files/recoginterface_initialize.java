private ReceiverConfig _config;

public void initialize(){
	try {
		_recPools.put(
				"application/jsgf",
				SphinxRecEngineFactoryJsgf.createObjectPool(
						_config.getSphinxConfigURL(),
						_config.getEngines()));
		_recPools.put(
				"application/arpa",
				SphinxRecEngineFactoryArpa.createObjectPool(
						_config.getSphinxArpaConfigURL(),
						_config.getEngines()));
	} catch (InstantiationException e) {
		e.printStackTrace();
	}
}
