package ru.spbstu.telematics.java;

public class App 
{
    public static void main( String[] args )
    {
        // Проверка класса BinarySemaphore
        BinarySemaphore semaphore = new BinarySemaphore();
        try {
            semaphore.acquire();
            System.out.println("Семафор захвачен.");
            semaphore.release();
            System.out.println("Семафор освобожден.");
        } catch (InterruptedException e) {
            System.out.println("Ошибка при захвате семафора: " + e.getMessage());
        }
    }
}
