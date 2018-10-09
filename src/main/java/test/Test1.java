package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import redis.clients.jedis.Jedis;
import tools.MD5SaltUtils;

public class Test1 {
    
	@Value("${REDIS_HOST}")
	private String REDIS_HOST;
	@Value("${REDIS_PORT}")
	private Integer REDIS_PORT;

	@Test
	public void test() {
        System.out.println(REDIS_PORT+REDIS_HOST);
		Jedis jedis = new Jedis("REDIS_HOST",REDIS_PORT);
		if (jedis.ping().equals("PONG")) {
			jedis.set("key", "hello");
			String string = jedis.get("key");
			System.out.println("Server is running: " + jedis.ping());
			System.out.println(string);
			jedis.close();
		}
		System.out.println("xxx");

	}
	
	@Test
	public void test1(){
		String encode = MD5SaltUtils.encode("123", "G&!zLf3q");
		System.out.println(encode);
	}

}
