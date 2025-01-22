package ru.spbstu.telematics.java;


public class BinarySemaphore {
    private final volatile boolean isLocked;

    public BinarySemaphore() {
        this.isLocked = false;
    }

    public BinarySemaphore(boolean initialState) {
        this.isLocked = initialState;
    }

    public synchronized void acquire() throws InterruptedException {
        while(isLocked) {
            wait();
        }
        this.isLocked = true;
    }

    public synchronized void release() {
        isLocked = false;
        // notify так как семафор бинарный, гарантированно
        // только 1 поток получит доступ
        notify();
    }
}
