package com.springmvc.redis;

import java.util.Random;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisLock {
	// private static final long MILLI_NANO_TIME = 2000;
	// private String key ="";
	// private boolean lock =false;
	// private static final String LOCKED = "locked";

	/** 加锁标志 */
	public static final String LOCKED = "TRUE";
	public static final long MILLI_NANO_TIME = 2000;
	public static final Random RANDOM = new Random();
	 // 锁状态标志  
	private boolean lock = false;  


	private String key;

	public RedisLock(String lockedPrefix, String objectValue) {
		this.key = lockedPrefix;
	}

	/**
	 * 加锁 使用方式为： lock(); try{ executeMethod(); }finally{ unlock(); }
	 * 
	 * @param timeout
	 *            timeout的时间范围内轮询锁
	 * @param expire
	 *            设置锁超时时间
	 * @return 成功 or 失败
	 */
	public boolean lock(long timeout, int expire) {
		long nanoTime = System.nanoTime();
		timeout *= MILLI_NANO_TIME;
		try {
			// 在timeout的时间范围内不断轮询锁
			while (System.nanoTime() - nanoTime < timeout) {
				// 锁不存在的话，设置锁并设置锁过期时间，即加锁
				if (RedisUtil.getJedis().setnx(this.key, LOCKED) == 1) {
					RedisUtil.getJedis().expire(this.key, expire);// 设置锁过期时间是为了在没有释放
					// 锁的情况下锁过期后消失，不会造成永久阻塞
					this.lock = true;
					return this.lock;
				}
				System.out.println("出现锁等待");
				// 短暂休眠，避免可能的活锁
				Thread.sleep(2, RANDOM.nextInt(30));
			}
		} catch (Exception e) {
			throw new RuntimeException("locking error", e);
		}
		return false;
	}

	public void unlock() {
		try {
			if (this.lock) {
				RedisUtil.getJedis().del(key);// 直接删除
			}
		} catch (Throwable e) {

		}
	}
}
