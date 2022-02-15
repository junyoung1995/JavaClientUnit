package javaClientPackage;

import org.junit.Test;

public class JavaClientGetJUnitTest {
	@Test
	public void testGetRequest() {
		String url = "http://localhost:8087/servletTest01/test";
		String data = "Get Method";
		
		httpGetConnection(url, data);
	}
}
