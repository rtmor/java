/**
 * l_10_1
 */
public class l_10_1 {

    public static void main(String[] args) {
        
    }
}


class Bridge {

}


class Woolie extends Thread {
    
    private String name;
    private int speed;
    private String destination;
    private Bridge bridge;

    /**
     * @param target
     * @param name
     * @param speed
     */
    public Woolie(Runnable target, String name, int speed, String destination, Bridge bridge) {
        super(target);
        this.name = name;
        this.speed = speed;
        this.destination = destination;
        this.bridge = bridge;
    }

    @Override
    public void run() {

//        System.out.printf("%s, has arrived at the bridge, %s.\n", name, bridge.getName());
    }

}