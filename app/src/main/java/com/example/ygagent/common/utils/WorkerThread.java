package com.example.ygagent.common.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkerThread {
    private static volatile WorkerThread instance;
    private final ThreadPoolExecutor executor;

    private WorkerThread() {
        executor = new ThreadPoolExecutor(
                4,
                20,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
    }


    public static WorkerThread getInstance() {
        if (instance == null) {
            synchronized (WorkerThread.class) {
                if (instance == null) {
                    instance = new WorkerThread();
                }
            }
        }
        return instance;
    }

    public void execute(Runnable task) {
        if (task != null) {
            executor.execute(task);
        }
    }


    public <T> Future<T> submit(Callable<T> task) {
        if (task != null) {
            return executor.submit(task);
        }
        return null;
    }


    public void shutdown() {
        if (!executor.isShutdown()) {
            executor.shutdown(); // 温和关闭
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow(); // 强制关闭
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

}
