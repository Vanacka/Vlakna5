public class Test extends Thread {
    public static volatile int hodnota;  //volatile = necachovat na procesoru

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            pricti();
        }
    }
    public static synchronized void pricti() {
        hodnota++;
    }

    public static void main(String[] args) throws InterruptedException {
        Test t1 = new Test();
        Test t2 = new Test();

        t1.start();
        t2.start();

        t1.join();    // pocka az vlakno t1 skonci
        t2.join();    // pocka az vlakno t2 skonci

        System.out.println(hodnota);
    }
}
