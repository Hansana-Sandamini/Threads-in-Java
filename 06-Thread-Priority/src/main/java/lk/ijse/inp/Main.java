package lk.ijse.inp;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("A : " + Thread.currentThread().getPriority());
                }
            }
        }));

        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("B : " + Thread.currentThread().getPriority());
                }
            }
        }));
        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();

        System.out.println("T1 : " + t1.getPriority());
        System.out.println("T2 : " + t2.getPriority());
    }
}