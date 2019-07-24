package xin.sunce.base.chapter8.thread;

public class DeadLock {

    final static Object RESOURCE_A = new Object();
    final static Object RESOURCE_B = new Object();

    static class TroubleMaker {

        private String name;

        public TroubleMaker(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public synchronized void jobA() {
            synchronized (RESOURCE_A) {
                System.out.println(this.name + " get RESOURCE_A");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.name + " wait RESOURCE_B...");
                synchronized (RESOURCE_B) {
                    System.out.println(this.name + " get RESOURCE_B");
                }
            }


        }

        public synchronized void jobB() {
            synchronized (RESOURCE_B) {
                System.out.println(this.name + " get RESOURCE_B");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.name + " wait RESOURCE_A...");
                synchronized (RESOURCE_A) {
                    System.out.println(this.name + " get RESOURCE_A");
                }
            }

        }


    }


    public static void main(String[] args) {
        TroubleMaker ade = new TroubleMaker("Ade");
        TroubleMaker peh = new TroubleMaker("Peh");
        new Thread(new Runnable() {
            @Override
            public void run() {
                ade.jobA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                peh.jobB();
            }
        }).start();
    }

}
