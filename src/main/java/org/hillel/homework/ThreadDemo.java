package org.hillel.homework;

public class ThreadDemo {

    /*1) из главного потока запустить новый поток, задать ему имя, в новом потоке с интервалом 5 секунд вывести цифры 1 ... 5.
      После окончания нового потока в главном потоке вывести информацию, что поток был завершен. Для синхронизации потоков использовать join*/
    public static void main(String[] args) {

        // main thread (start work, change name)
        Thread thread = Thread.currentThread();
        System.out.println(String.format("Main thread started!\r\nMain thread name is %s", thread.getName()));
        thread.setName("firstThread");
        System.out.println("New MAIN thread name is: " + thread.getName());

        // first child thread (start, working, finish), thread.sleep(5 sec)
        SecondThread secondThread = new SecondThread("secondThread");
        secondThread.start();
        try {
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //second child thread(start, working, finish), thread.sleep(10 sec)
        Thread thirdThread = new Thread(new ThirdThread(), "thirdThread");
        thirdThread.start();
        try {
            thirdThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //main thread finished
        System.out.println(String.format("\r\nMain thread %s finished!", thread.getName()));

    }
}
