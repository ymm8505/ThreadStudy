package com.xiaoyang.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class CachedData {
	// �������
	Object data;
	// ��������Ƿ���ֵ
	volatile boolean cacheValid;
	// ReadWirteLock����
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
		//����߳�����ȡ���� �϶���   �����ǿ��Զ������̹߳�ͬ���� ���������Ŀ�����ڷ�ֹд���Ľ��롣
		rwl.readLock().lock();
		//������������IF A ���û������    ����д�����߼�
		if (!cacheValid) {
			// Must release read lock before acquiring write lock
			//��������������д����֮ǰ,��Ҫ�ͷŶ���  Ȼ���д��
			rwl.readLock().unlock();
			rwl.writeLock().lock();
			// Recheck state because another thread might have acquired
			// write lock and changed state before we did.
			//������������д����֮ǰ�ٴμ�� �����ͷ������ݣ����߳���ͬһʱ������ж���߳̽��뵽��һ��IF�ж� line17
			if (!cacheValid) {
				data = "...";
				cacheValid = true;
			}
			// Downgrade by acquiring read lock before releasing write lock
			rwl.readLock().lock();
			rwl.writeLock().unlock(); // Unlock write, still hold read
		}
		//ELSE A���������    	����������߼�
//		use(data); α����
		//�����ݽ���			�ͷŶ���
		rwl.readLock().unlock();
	}
}
