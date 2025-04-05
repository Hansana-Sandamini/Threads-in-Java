package lk.ijse.inp;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Calculation calculation = new Calculation();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    calculation.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    calculation.increment();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.print("Value is : " + calculation.num);
    }
}

class Calculation {
    int num;
    public synchronized void increment() {
        num++;
    }
}