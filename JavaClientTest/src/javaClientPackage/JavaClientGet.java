package javaClientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class JavaClientGet {
	public static String getRequest(String targetURL) {
		String response = "";
		
		try {
			URL url = new URL(targetURL);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET"); //전송 방식 GET
			connection.setRequestProperty("Content-Type", "String; charset=utf-8");
			
			System.out.println(String.format("콘텐츠 타입 = %s", connection.getContentType()));
			System.out.println(String.format("응답 코드 = %s", connection.getResponseCode()));
			System.out.println(String.format("응답 메세지 = %s", connection.getResponseMessage()));
			
			Charset charset = Charset.forName("UTF-8");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
			
			String inputLine;
			StringBuffer sBuffer = new StringBuffer();
			while((inputLine = bReader.readLine()) != null) {
				sBuffer.append(inputLine);
			}
			bReader.close();
			
			response = sBuffer.toString();
		}catch(IOException e) {
			System.out.println(String.format("입출력 오류1 = %s", e.getMessage()));
		}
		return response;
	}
}
