import org.junit.Test;


public class TestMd5 {
	@Test
	public void test1(){
		org.springframework.security.providers.encoding.Md5PasswordEncoder md5e = new org.springframework.security.providers.encoding.Md5PasswordEncoder();
		md5e.setEncodeHashAsBase64(false);
		System.out.println("==="+md5e.encodePassword("123", null));
	}
}
