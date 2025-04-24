package airport.mediator;

import airport.aircraft.Aircraft;

import java.util.*;

public class ControlTower implements TowerMediator {
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean isRunwayFree = true;

    private final List<Aircraft> allAircraft = new ArrayList<>();

    public void registerAircraft(Aircraft aircraft) {
        allAircraft.add(aircraft);
    }

    @Override
    public void broadcast(String message, Aircraft sender) {
        for (Aircraft a : allAircraft) {
            if (!a.equals(sender)) a.receive("Tower >> " + message);
        }

        if (message.contains("MAYDAY")) {
            isRunwayFree = true;
            landingQueue.clear(); // emergency landing
            System.out.println(">>> EMERGENCY LANDING GRANTED to " + sender.getId());
            sender.receive("Land immediately!");
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (isRunwayFree) {
            isRunwayFree = false;
            System.out.println(a.getId() + " granted access to runway.");
            return true;
        } else {
            if (a.isEmergency()) {
                isRunwayFree = true;
                landingQueue.clear();
                System.out.println(">>> PRIORITY LANDING: " + a.getId());
                return true;
            }

            if (a.isTakingOff()) takeoffQueue.add(a);
            else landingQueue.add(a);

            System.out.println(a.getId() + " added to queue.");
            return false;
        }
    }

    public void freeRunway() {
        isRunwayFree = true;
    }
}
