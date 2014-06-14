package com.example.clientprojintegracao;

public interface Config {

	// used to share GCM regId with application server - using php app server
	//static final String APP_SERVER_URL = "http://192.168.1.17/gcm/gcm.php?shareRegId=1";

	// GCM server using java
	static final String APP_SERVER_URL =
	"http://192.168.0.3:8080/ProjIntegracao2014/GCMNotification?shareRegId=1";

	// Google Project Number
	static final String GOOGLE_PROJECT_ID = "838158826655";
	static final String MESSAGE_KEY = "mensagem";

}
