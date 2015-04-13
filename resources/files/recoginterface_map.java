private HashMap<String, ObjectPool> _recPools;

public RecogInterface(ReceiverConfig config) {
	_recPools = new HashMap<String, ObjectPool>();
	initialize();
}
