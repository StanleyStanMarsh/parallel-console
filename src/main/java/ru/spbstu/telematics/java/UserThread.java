package ru.spbstu.telematics.java;

public class UserThread implements Runnable {
    private final BinarySemaphore semaphore;

    public UserThread(BinarySemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            // Логика работы с консолью
            System.out.println("Пользователь " + this.getName() + " начал взаимодействие с консолью.");
            Thread.sleep(1000); // Имитация работы с консолью
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Пользователь " + this.getName() + " закончил взаимодействие с консолью.");
        }
    }
}