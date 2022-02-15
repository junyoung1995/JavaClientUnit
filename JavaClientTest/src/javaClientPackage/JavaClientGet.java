package javaClientPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class JavaClientGet {
	@Test
	public static void main(String[] args) {
		System.out.println("HttpURLConnection을 사용");
		
		String url = "http://localhost:8087/JavaClientTest";
		String data = "user=user&userID=userID";
		
		httpGetConnection(url, data);
		
		assertEquals(url, data);
	}
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
			url = new URL(totalUrl);
		} catch (MalformedURLException e) {//MalformedURLException은 잘못된 URL에 대한 예외처리, 각종 프로토콜을 다루는 클래스에서 잘못된 인자로 정상적인 프로토콜을 발생할 수 없을 때 나옴
			System.out.println(String.format("잘못된 URL = %s", e.getMessage()));
		}
	}
}
