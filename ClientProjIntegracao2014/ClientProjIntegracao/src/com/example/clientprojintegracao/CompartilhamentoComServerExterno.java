package com.example.clientprojintegracao;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import android.content.Context;
import android.util.Log;

public class CompartilhamentoComServerExterno {

	public String compartilharRegIdComAppServer(final Context context, final String regId) {

		String resultado = "";
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("regId", regId);
		
		try {
			URL serverUrl = null;
			try {
				serverUrl = new URL(Config.APP_SERVER_URL);
			} catch (MalformedURLException e) {
				Log.e("AppUtil", "Erro de Conexão com URL: "
						+ Config.APP_SERVER_URL, e);
				resultado = "URL inválida: " + Config.APP_SERVER_URL;
			}

			StringBuilder postBody = new StringBuilder();
			Iterator<Entry<String, String>> iterator = paramsMap.entrySet()
					.iterator();

			while (iterator.hasNext()) {
				Entry<String, String> param = iterator.next();
				postBody.append(param.getKey()).append('=')
						.append(param.getValue());
				if (iterator.hasNext()) {
					postBody.append('&');
				}
			}
			
			String body = postBody.toString();
			byte[] bytes = body.getBytes();
			HttpURLConnection httpConnection = null;
			
			try {
				httpConnection = (HttpURLConnection) serverUrl.openConnection();
				httpConnection.setDoOutput(true);
				httpConnection.setUseCaches(false);
				httpConnection.setFixedLengthStreamingMode(bytes.length);
				httpConnection.setRequestMethod("POST");
				httpConnection.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded;charset=UTF-8");
				OutputStream out = httpConnection.getOutputStream();
				out.write(bytes);
				out.close();

				int status = httpConnection.getResponseCode();
				if (status == 200) {
					resultado = "RegId compartilhado com App Server. RegId: "
							+ regId;
				} else {
					resultado = "Falha no Post." + " Status: " + status;
				}
			} finally {
				if (httpConnection != null) {
					httpConnection.disconnect();
				}
			}

		} catch (IOException e) {
			resultado = "Falha no Post. Erro no compartilhamento com o App Server.";
			Log.e("AppUtil", "Erro no compartilhamento com o App Server: " + e);
		}
		return resultado;
	}
}