import java.util.ArrayList;

public class Semaphore {
    int value;
    Router router;
    public Semaphore(int n, Router r)
    {
        value = n;
        router = r;

    }


    public synchronized void joining(Device device) throws InterruptedException {
        value--;
        if(value < 0){
            try {
                System.out.println(device.name + "(" + device.type + ") arrived and waiting");
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{

            System.out.println(device.name + "(" + device.type+ ") arrived");
        }

    }

    public synchronized void leaving(Device device) throws InterruptedException {
        value++;
        if(value <= 0){
            notify();
        }
        System.out.println("Connection " + device.connectionId + ": " + device.name + " Logged out");
    }

}
