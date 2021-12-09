import java.util.Scanner;
public class Network {

    public static void  main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("What is the number of WI-FI Connections?");

        int numberOfConnections = input.nextInt();
        Router router = new Router(numberOfConnections);

        System.out.println("What is the number of devices Clients want to connect?");
        int numberOfDevices = input.nextInt();

        for(int i = 0; i < numberOfDevices; i++){
            String nameOfDevice = input.next();
            String typeOfDevice = input.next();
            Device device = new Device(nameOfDevice, typeOfDevice, router);
            router.setDevices(device);
        }

        for (Device device : router.getDevices()) {
            device.start();
        }


    }
}
