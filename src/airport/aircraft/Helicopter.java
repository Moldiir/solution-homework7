package airport.aircraft;

public class Helicopter extends Aircraft {
    public Helicopter(String id) {
        super(id);
    }

    @Override
    public boolean isTakingOff() {
        return true;
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Helicopter " + id + "] received: " + msg);
    }
}
