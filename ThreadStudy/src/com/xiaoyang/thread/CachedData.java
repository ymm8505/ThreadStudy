package com.xiaoyang.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class CachedData {
	// 缓存对象
	Object data;
	// 缓存对象是否有值
	volatile boolean cacheValid;
	// ReadWirteLock对象
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
		//多个线程来读取数据 上读锁   读锁是可以多个多个线程共同读的 这里加锁的目的在于防止写锁的进入。
		rwl.readLock().lock();
		//【】【】【】IF A 如果没有数据    进入写数据逻辑
		if (!cacheValid) {
			// Must release read lock before acquiring write lock
			//【】【】【】在写数据之前,先要释放读锁  然后加写锁
			rwl.readLock().unlock();
			rwl.writeLock().lock();
			// Recheck state because another thread might have acquired
			// write lock and changed state before we did.
			//【】【】【】写数据之前再次检查 缓存释放有数据，多线程下同一时间可能有多个线程进入到第一个IF判断 line17
			if (!cacheValid) {
				data = "...";
				cacheValid = true;
			}
			// Downgrade by acquiring read lock before releasing write lock
			rwl.readLock().lock();
			rwl.writeLock().unlock(); // Unlock write, still hold read
		}
		//ELSE A如果有数据    	进入读数据逻辑
//		use(data); 伪代码
		//读数据结束			释放读锁
		rwl.readLock().unlock();
	}
}
