package lab6;

public class Main {

    public static void main(String[] args) {
        class Resource1 {
            public boolean r1 = false;
            synchronized void res1(int P1) {
                try {
                    if (r1) wait();
                    r1 = true;
                    System.out.println(" Ресурс 1 используется процессом "+P1);
                    r1=false;
                    notify();
                } // завершення функцiї try
                /* Якщо сон потоку перерваний, нiчого не робити */
                catch(InterruptedException e) {;}

            } // завершення метода res1
        } // завершення класу Resource1
        class Resource2 {
            public boolean r2 = false;
            synchronized void res2(int P2) {
                try {
                    if (r2) wait();
                    r2 = true;
                    System.out.println(" Ресурс 2 используется процессом "+P2);
                    r2 = false;
                    notify();
                } // завершення функцїї try
                /* Якщо сон потоку перерваний, нiчого не робити */
                catch(InterruptedException e) {;}

            } // завершення метода res2


        } // завершення класу Resource2
        class Proc1 implements Runnable {
            Resource1 q1;
            Resource2 q2;
            public Proc1(Resource1 q1,Resource2 q2) {
                this.q1=q1;
                this.q2=q2;
                new Thread(this).start();

            }
            public void run() {
                try {
                    for (int i=1; i<=5; i++) {
                        q1.res1(1); // звернення до ресурсу 1
                        q2.res2(1); // звернення до ресурсу 2
                        /* затримка, засинання потока на 0.1c.*/
                        Thread.sleep(100);}
                } // завершення функцїї try
                /* Якщо сон потоку перерваний, нiчого не робити */
                catch(InterruptedException e) {;}

            } // завершення метода run
        } // завершення класу Proc1
        class Proc2 implements Runnable {
            Resource1 q1;
            Resource2 q2;
            public Proc2(Resource1 q1,Resource2 q2) {
                this.q1=q1;
                this.q2=q2;
                new Thread(this).start();

            }
            public void run() {
                try {
                    for (int j=1; j<=5; j++) {
                        q1.res1(2); // звернення до ресурсу 1
                        q2.res2(2); // звернення до ресурсу 2
                        /* затримка, засинання потока на 0.1c.*/
                        Thread.sleep(100);}
                } // завершення функцїї try
                /* Якщо сон потоку перерваний, нічого не робити */
                catch (InterruptedException e) {;}

            } // завершення метода run
        } // завершення класу Proc2
        class comm1 {
            public void main(String args[]) {
                Resource1 q1=new Resource1();
                Resource2 q2=new Resource2();
                new Proc1(q1,q2);
                new Proc2(q1,q2);
            }
        }
    }
}
