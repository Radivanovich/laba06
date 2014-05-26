package laba;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Phone {

    public static void main(String args[]) {
        List<Caller> ct = new ArrayList<Caller>();

        Caller tad = new Caller("Tad", ct);
        ct.add(tad);

        Caller barny = new Caller("Barny", ct);
        ct.add(barny);

        Caller robin = new Caller("Robin", ct);
        ct.add(robin);

        Caller lilly = new Caller("Lilly", ct);
        ct.add(lilly);

        Caller marshal = new Caller("Marshal", ct);
        ct.add(marshal);

        tad.start();
        barny.start();
        robin.start();
        lilly.start();
        marshal.start();
    }
}

class Caller extends Thread {

    private List<Caller> ct;
    private String name;
    private boolean check = false;

    public Caller(String name, List<Caller> ct) {
        this.name = name;
        this.ct = ct;
    }

    @Override
    public void run() {
        for (int k = 0; k < 3; k++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Caller.class.getName()).log(Level.SEVERE, null, ex);
            }
            call(name);
        }
    }

    public void hate(){System.out.println("bombom")}
    
    public static synchronized void call(String name) {
    	hate();
        System.out.println("Phone is busy by " + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Phone is free");
    }

}
