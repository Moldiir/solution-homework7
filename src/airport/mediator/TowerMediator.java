package airport.mediator;

import airport.aircraft.Aircraft;

public interface TowerMediator {
    void broadcast(String message, Aircraft sender);
    boolean requestRunway(Aircraft aircraft);
}
