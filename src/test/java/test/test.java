package test;

import org.junit.Test;

import tools.MD5SaltUtils;

public class test {
	@Test
	public void test(){
		String encode = MD5SaltUtils.encode("123", "hCKhjyF&");
		System.out.println(encode);
	}
}
