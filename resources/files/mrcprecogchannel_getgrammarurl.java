// check if the MRCP message has any content. If so, extract the URL of the language model.
if (request.hasContent()) {
	contentType = request.getContentType(); // recognizer type to use
	if (contentType.equalsIgnoreCase("application/jsgf") || contentType.equalsIgnoreCase("application/arpa") ) {
		// if it's one of the supported recognizer types, fetch the language model's URL.
		try {
			grammarLocation = new GrammarLocation(new URL(request.getContent()));
		} catch (IOException e) {
		    statusCode = MrcpResponse.STATUS_SERVER_INTERNAL_ERROR;
		}
	}
}
