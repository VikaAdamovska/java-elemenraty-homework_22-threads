package org.hillel.homework;

import java.util.Random;

//B thread created
class B implements Runnable {

    public void run() {
        System.out.printf("\r\nThread %s started ...\r\n", Thread.currentThread().getName());
        int counter = 1;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("\r\nLoop " + counter++);
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                System.out.println("\r\nThread B has been interrupted!");
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("\r\nThread %s finished", Thread.currentThread().getName());
    }
}

public class A {
    /*2) Из главного потока А создать и запустить новый поток В, в котором вызвать Thread.sleep на 10с.
      В главном потоке А сгенерировать случайное число N от 1 до 10. Вызвать interrupt у нового потока по истечению N секунд
      в главном потоке. В потоке В корректно обработать исключение.*/
    public static void main(String[] args) {

        //main A thread
        Thread mainThread = Thread.currentThread();
        mainThread.setName("A");
        System.out.println(String.format("%s thread started", Thread.currentThread().getName()));

        //random time was created
        Random random = new Random();
        int initial = 0;
        int finite = 10;
        int randomTime = initial + random.nextInt(finite - initial + 1);
        System.out.printf("\r\nThread \"B\" will be interrupted after %d seconds!\r\n", randomTime);

        //thread B started
        Thread b = new Thread(new B(), "B");
        b.start();

        //thread B interrupted
        try {
            Thread.sleep(randomTime * 1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread A has been interrupted");
        }
        b.interrupt();

        System.out.printf("\r\n%s thread finished\r\n", Thread.currentThread().getName());
    }
}
