package jedisService.impl;

import jedisService.JedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.net.SocketTimeoutException;

public class JedisClientSingle implements JedisClient {

//	@Autowired
	private JedisPool jedisPool;
//	@Value("${REDIS_PORT}")
	private Integer REDIS_PORT;
//	@Value("${REDIS_HOST}")
	private String REDIS_HOST;
	
	@Override
	public String get(String key) {
		//System.err.println(REDIS_HOST+REDIS_PORT);
		Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
		
		if(jedis.ping().equals("PONG"))
		{   jedis = jedisPool.getResource();
			String string = jedis.get(key);
			//System.out.println("Server is running: " + jedis.ping());
			jedis.close();
			return string;
		}
		
		return null;
		/**while (true) // 如果是网络超时则多试几次
		{
			System.out.println("第" + timeoutCount + "次进来" + jedisPool);
			

			//try {
				
			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						System.err.println(e.toString());
						return null;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					
					return null;
				}
			}
		}**/

	}

	@Override
	public String set(String key, String value) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{
			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);

			try {
				Jedis jedis = jedisPool.getResource();
				String string = jedis.set(key, value);
				jedis.close();
				return string;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return null;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return null;
				}
			}
		}

	}

	@Override
	public String hget(String hkey, String key) {
		int timeoutCount = 0;
		while (true) {
			// 如果是网络超时则多试几次
			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);

			try {
				Jedis jedis = jedisPool.getResource();
				String string = jedis.hget(hkey, key);
				jedis.close();
				return string;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return null;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return null;
				}
			}
		}

	}

	@Override
	public long hset(String hkey, String key, String value) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{
			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);

			try {
				Jedis jedis = jedisPool.getResource();
				Long result = jedis.hset(hkey, key, value);
				jedis.close();
				return result;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return 0;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return 0;
				}
			}
		}

	}

	@Override
	public long incr(String key) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{

			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);
			try {
				Jedis jedis = jedisPool.getResource();
				Long result = jedis.incr(key);
				jedis.close();
				return result;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return 0;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return 0;
				}
			}
		}

	}

	@Override
	public long expire(String key, int second) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{

			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);
			try {
				Jedis jedis = jedisPool.getResource();
				Long result = jedis.expire(key, second);
				jedis.close();
				return result;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return 0;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return 0;
				}
			}
		}

	}

	@Override
	public long ttl(String key) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{

			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);
			try {
				Jedis jedis = jedisPool.getResource();
				Long result = jedis.ttl(key);
				jedis.close();
				return result;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return 0;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return 0;
				}
			}
		}

	}

	@Override
	public long del(String key) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{

			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);
			try {
				Jedis jedis = jedisPool.getResource();
				Long del = jedis.del(key);
				jedis.close();
				return del;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return 0;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return 0;
				}
			}
		}

	}

	@Override
	public long hdel(String hkey, String key) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{

			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);
			try {
				Jedis jedis = jedisPool.getResource();
				Long del = jedis.hdel(hkey, key);
				jedis.close();
				return del;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return 0;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return 0;
				}
			}
		}

	}

	@Override
	public long EXPIRE(String key, long time) {
		int timeoutCount = 0;
		while (true) // 如果是网络超时则多试几次
		{

			// System.out.println("第"+timeoutCount+"次进来"+jedisPool);
			try {
				Jedis jedis = jedisPool.getResource();
				Long expire = jedis.expireAt(key, time);
				jedis.close();
				return expire;

			} catch (Exception e) {
				// 底层原因是SocketTimeoutException，不过redis已经捕捉且抛出JedisConnectionException，不继承于前者
				if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException) {
					timeoutCount++;
					// log.warn("getJedis timeoutCount={}", timeoutCount);
					if (timeoutCount > 3) {
						return 0;
					}
				} else {
					/*
					 * log.warn("jedisInfo。NumActive=" +
					 * jedisPool.getBalancePool().getNumActive() + ", NumIdle="
					 * + jedisPool.getNumIdle() + ", NumWaiters=" +
					 * jedisPool.getNumWaiters() + ", isClosed=" +
					 * jedisPool.isClosed()); log.error("getJedis error", e);
					 */
					return 0;
				}
			}
		}

	}

}