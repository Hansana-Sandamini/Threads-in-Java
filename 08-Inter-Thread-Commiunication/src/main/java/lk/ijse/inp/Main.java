//package lk.ijse.inp;
//
//public class Main {
//    public static void main(String[] args) {
//        A a = new A();
//        new Producer(a);
//        new Consumer(a);
//    }
//}
//
//class Producer implements Runnable {
//    A a;
//    public Producer(A a) {
//        this.a = a;
//        Thread thread1 = new Thread(this, "Producer");
//        thread1.start();
//    }
//
//    @Override
//    public void run() {
//        int num = 0;
//        while (true) {
//            A a = new A();
//            a.put(num++);
//        }
//    }
//}
//
//class Consumer implements Runnable {
//    A a;
//    public Consumer(A a) {
//        this.a = a;
//        Thread thread1 = new Thread(this, "Consumer");
//        thread1.start();
//    }
//
//    @Override
//    public void run() {
//        A a = new A();
//        a.get();
//    }
//}
//
//class A{
//    int num;
//    boolean flag=false;
//
//    public synchronized void put(int num){
//        while(flag){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("PUT : " + num);
//        this.num = num;
//        flag=true;
//        notify();
//    }
//
//    public synchronized void get(){
//        while(!flag){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("GET :" + num);
//        flag=false;
//        notify();
//    }
//}
//
//class A {
//    int num;
//    boolean flag = false;
//
//    public synchronized void put(int num) {
//        this.num = num;
//        this.flag = true;
//        System.out.println("Put : " + num);
//        try {
//            wait(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public synchronized void get() {
//        while (!flag) {
//            try {
//                wait(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Get : " + num++);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}


package lk.ijse.inp;

class A{
    int num;
    boolean flag=false;

    public synchronized void put(int num){
        while(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("PUT : "+num);
        this.num = num;
        flag=true;
        notify();
    }

    public synchronized void get(){
        while(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("GET :"+num);
        flag=false;
        notify();
    }
}

class Producer implements Runnable{
    A a;
    public Producer(A a){
        this.a=a;
        Thread t1 = new Thread(this,"Producer");
        t1.start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true){
            a.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable{
    A a;
    public Consumer(A a){
        this.a=a;
        Thread t1 = new Thread(this,"Consumer");
        t1.start();
    }

    @Override
    public void run() {
        while (true){
            a.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        new Producer(a);
        new Consumer(a);
    }
}