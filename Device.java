import javax.swing.*;

public class Device extends Thread{
    String name = "";
    String type = "";
    Router router;
    public int connectionId ;
    public Device(String Name, String Type, Router r){
        this.name = Name;
        this.type = Type;
        router = r;
    }

    @Override
    public void run(){
        try {
            router.semaphore.joining(this);
            Thread.sleep((long)(Math.random() * 3000));
            connectionId = router.connecting(this);

            System.out.println("Connection " + connectionId + ": " + name + " Login");
            //JOptionPane.showMessageDialog(null, "Connection " + connectionId + ": " + name + " Login");

            System.out.println("Connection " + connectionId + ": " + name + " Performs online activity");
            //JOptionPane.showMessageDialog(null, "Connection " + connectionId + ": " + name + " Performs online activity");
            Thread.sleep((long)(Math.random() * 10000));


            router.disconnecting(this);
            router.semaphore.leaving(this);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
