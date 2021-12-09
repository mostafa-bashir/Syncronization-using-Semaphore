import java.util.ArrayList;

public class Router {
    int maxConnections;
    boolean []busySpots;
    int numberOfConnections = 0;
    public Semaphore semaphore;
    ArrayList<Device> devices = new ArrayList<Device>();

    public Router(int max){
        maxConnections = max;
        busySpots = new boolean[max];
        semaphore = new Semaphore(maxConnections, this);
    }

    public int connecting(Device device)throws InterruptedException{
        int returnConnectionId = 0;
        for (int i = 0; i < maxConnections; i++){


            if(busySpots[i] == false){
                busySpots[i] = true;
                numberOfConnections++;
                returnConnectionId = (i + 1);
                break;
            }
        }

        System.out.println("Connection " + returnConnectionId + " : " + device.name +" Occupied");
        return returnConnectionId;
    }

    public void disconnecting(Device device){
        busySpots[(device.connectionId - 1)] = false;
        numberOfConnections--;
    }


    public void setDevices(Device device){
        devices.add(device);
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}


