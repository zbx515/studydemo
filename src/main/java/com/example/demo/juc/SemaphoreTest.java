package com.example.demo.juc;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    /**
     * Semaphore  信号量：类似于连接池的东西，初始化一个给定大小的信号量，其中会包含给数量的许可(虚拟的)
     * 当使用semaphore.acquire()时，会首先从其中拿一个许可出来，如果拿不到则进入阻塞状态
     * 当使用完后调用 semaphore.release();，会将该许可返还回去
     *
     */

    public static void main(String[] args) {
        //设置初始化许可大小
        Semaphore semaphore = new Semaphore(10);

        //t1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"等待获取中...");
                    //试获取许可，获取不到则会进入阻塞状态
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" 获取到许可");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放许可
                    //semaphore.release();
                }
            }
        },"t1").start();

        //t2
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"等待获取中...");
                    //查询当前有效的许可
                    if(semaphore.availablePermits()==0){
                        System.out.println("算了放弃了");
                    }else{
                        //尝试获取许可，获取不到则会进入阻塞状态
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" 获取到许可");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放许可
                    semaphore.release();
                }
            }
        },"t2").start();
        System.out.println("当前有："+semaphore.availablePermits()+" 个有效的许可");
    }


}
