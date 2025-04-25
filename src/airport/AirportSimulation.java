package airport;

import airport.aircraft.*;
import airport.mediator.ControlTower;

public class AirportSimulation {
    public static void main(String[] args) throws InterruptedException {
        ControlTower tower = new ControlTower();

        Aircraft[] aircrafts = {
                new PassengerPlane("P1"),
                new CargoPlane("C1"),
                new Helicopter("H1"),
                new PassengerPlane("P2")
        };

        for (Aircraft a : aircrafts) {
            tower.registerAircraft(a);
        }

        aircrafts[0].declareEmergency();
        aircrafts[0].send("MAYDAY", tower);
        tower.requestRunway(aircrafts[0]);

        Thread.sleep(1000);

        for (int i = 1; i < aircrafts.length; i++) {
            tower.requestRunway(aircrafts[i]);
        }
    }
}
