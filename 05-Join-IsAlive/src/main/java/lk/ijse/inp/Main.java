package lk.ijse.inp;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //t1
            // for-loop-5-A
        //t2
            // for-loop-5-B
        // t1 start
        // t2 start
        // sout(BYE...)

        // output should be like
            // A/B*5
            // BYE

        Thread t1 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }));

        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }));

        t1.start();
        System.out.println(t1.isAlive());

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t2.start();
        System.out.println(t1.isAlive());

        t1.join();
        System.out.println(t1.isAlive());

        t2.join();
        System.out.println(t1.isAlive());

        System.out.println("BYE...");
    }
}