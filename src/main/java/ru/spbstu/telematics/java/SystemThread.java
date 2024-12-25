package ru.spbstu.telematics.java;

public class SystemThread extends Thread {
    private final BinarySemaphore semaphore;

    public SystemThread(BinarySemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            // Логика работы системного процесса с консолью
            System.out.println("Системный процесс " + this.getName() + " начал взаимодействие с консолью.");
            Thread.sleep(1000); // Имитация работы с консолью
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Системный процесс " + this.getName() + " закончил взаимодействие с консолью.");
        }
    }
}