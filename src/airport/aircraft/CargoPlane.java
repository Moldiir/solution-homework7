package airport.aircraft;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id) {
        super(id);
    }

    @Override
    public boolean isTakingOff() {
        return false;
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Cargo " + id + "] received: " + msg);
    }
}
