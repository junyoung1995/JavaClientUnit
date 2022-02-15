package javaClientPackage;

import org.junit.Test;

public class JavaClientGetJUnitTest {
	@Test
	public void testGetRequest() {
		String url = "http://localhost:8087/servletTest01/test";
		
		String response = JavaClientGet.getRequest(url);
		System.out.println(String.format("getRequest = %s", response));
	}
}
