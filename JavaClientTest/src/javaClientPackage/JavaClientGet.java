package javaClientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class JavaClientGet {
	@Test
	public static void main(String[] args) {
		System.out.println("HttpURLConnection을 사용");
		
		String url = "http://localhost:8087/servletTest01/test";
		String data = "Get";//한글은 입력을 못받는다.
		
		httpGetConnection(url, data);
		
		//assertEquals(url, data);
	}
	@Test
	public static void httpGetConnection(String urlData, String paramData) {
		String totalUrl = "";
		
		if(paramData != null && paramData.length() > 0 && !paramData.equals("") && !paramData.contains("null")) {
			totalUrl = urlData.trim().toString() + "?" + paramData.trim().toString();
		}else {
			totalUrl = urlData.trim().toString();
		}
		
		//http 통신을 하기 위한 객체 선언
		URL url = null;
		HttpURLConnection connection = null;
		
		//http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
		String responseData = "";
		BufferedReader bReader = null;
		StringBuffer sBuffer = null;
		
		//메서드 호출 결과값을 반환받기 위한 변수
		String returnData = "";
		
		try {
			//파라미터로 들어온 url을 사용해 connection 실시
			url = new URL(totalUrl);
			connection = (HttpURLConnection)url.openConnection();
			
			//http 요청에 필요한 타입 정의 실시
			connection.setRequestProperty("Accept", "String");
			connection.setRequestMethod("GET");
			
			//http 요청 실시
			connection.connect();
			System.out.println("http 요청 방식 : " + "GET");
			System.out.println("http 요청 타입 : " + "String");
			System.out.println("http 요청 주소 : " + urlData);
			System.out.println("http 요청 데이터 : " + paramData);
			System.out.println("");//간격 조절
			
			//http 요청 후 응답 받을 데이터를 버퍼에 적재
			bReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			sBuffer = new StringBuffer();
			while((responseData = bReader.readLine()) != null) {
				sBuffer.append(responseData); //StringBuffer에 응답받은 데이터를 순차적으로 저장
			}
			
			//메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
			returnData = sBuffer.toString();
			
			//http 요청 응답코드 확인 실시
			String responseCode = String.valueOf(connection.getResponseCode());
			System.out.println("http 응답 코드 : " + responseCode);
			System.out.println("http 응답 데이터 : " + returnData);
			
			
			
		} catch (MalformedURLException e) {//MalformedURLException은 잘못된 URL에 대한 예외처리, 각종 프로토콜을 다루는 클래스에서 잘못된 인자로 정상적인 프로토콜을 발생할 수 없을 때 나옴
			System.out.println(String.format("잘못된 URL = %s", e.getMessage()));
		}catch (IOException e) {
			System.out.println(String.format("입출력 예외 처리 = %s", e.getMessage()));
		}finally {
			try {
				if(bReader != null) {
					bReader.close();
				}
			}catch(IOException e) {
				System.out.println(String.format("자바 입출력 에러 = %s", e.getMessage()));
			}
		}
	}
}
