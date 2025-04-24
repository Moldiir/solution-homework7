package airport.aircraft;

import airport.mediator.TowerMediator;

public abstract class Aircraft {
    protected String id;
    protected boolean emergency = false;

    public Aircraft(String id) {
        this.id = id;
    }

    public abstract boolean isTakingOff();

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator mediator) {
        mediator.broadcast(msg, this);
    }

    public String getId() {
        return id;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void declareEmergency() {
        this.emergency = true;
        System.out.println(id + " declares MAYDAY!");
    }
}
