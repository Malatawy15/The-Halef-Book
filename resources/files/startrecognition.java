public synchronized void startRecognition(PushBufferDataSource dataSource, RecogListener listener) throws UnsupportedEncodingException {
    if (_rawAudioTransferHandler != null) {
        throw new IllegalStateException("Recognition already in progress!");
    }
	// extract speech data byte stream 
    PushBufferStream[] streams = dataSource.getStreams();
    if (streams.length != 1) {
        throw new IllegalArgumentException("Rec engine can handle only single stream datasources, # of streams: " + streams);
    }
	// pass the data byte stream into the RawAudioProcesser through the RawAudioTransferHandler
    try {
        _rawAudioTransferHandler = new RawAudioTransferHandler(_rawAudioProcessor);
        _rawAudioTransferHandler.startProcessing(streams[0]);
    } catch (UnsupportedEncodingException e) {
        _rawAudioTransferHandler = null;
        throw e;
    }
    _recogListener = listener;
}
