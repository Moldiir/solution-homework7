package airport.aircraft;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id) {
        super(id);
    }

    @Override
    public boolean isTakingOff() {
        return false;
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Passenger " + id + "] received: " + msg);
    }
}
