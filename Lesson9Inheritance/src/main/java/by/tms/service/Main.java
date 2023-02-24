package by.tms.service;

import by.tms.model.CargoTransport;
import by.tms.model.CivilAirTransport;
import by.tms.model.MilitaryAirTransport;
import by.tms.model.PassengerTransport;
import by.tms.model.Transport;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Transport cargoTransport = CargoTransport.builder()
                                                 .powerInHorsepower(200)
                                                 .maxSpeedKmPerHour(110)
                                                 .weightKg(2300)
                                                 .brand("Toyota")
                                                 .wheelsCount(6)
                                                 .fuelConsumption(16)
                                                 .loadCapacity(4)
                                                 .build();
        Transport civilAirTransport = CivilAirTransport.builder()
                                                       .powerInHorsepower(45_000)
                                                       .maxSpeedKmPerHour(965)
                                                       .weightKg(120000)
                                                       .brand("Boing")
                                                       .wingspan(64.4)
                                                       .minimumRunwayLengthForTakeOff(350)
                                                       .numberOfPassengers(340)
                                                       .businessClass(true)
                                                       .build();
        Transport militaryAirTransport = MilitaryAirTransport.builder()
                                                             .powerInHorsepower(2250)
                                                             .maxSpeedKmPerHour(621)
                                                             .weightKg(4472)
                                                             .brand("Fairey Firefly")
                                                             .wingspan(15.55)
                                                             .minimumRunwayLengthForTakeOff(100)
                                                             .ejectionSystems(true)
                                                             .numberOfMissilesOnBoard(4)
                                                             .build();
        Transport passengerTransport = PassengerTransport.builder()
                                                         .powerInHorsepower(381)
                                                         .maxSpeedKmPerHour(250)
                                                         .weightKg(2490)
                                                         .brand("BMW X7")
                                                         .wheelsCount(4)
                                                         .fuelConsumption(10.6)
                                                         .bodyType("Universal")
                                                         .numberOfPassengers(3)
                                                         .build();

        ArrayList<Transport> transports = new ArrayList<>();
        transports.add(cargoTransport);
        transports.add(civilAirTransport);
        transports.add(militaryAirTransport);
        transports.add(passengerTransport);
        for (Transport transport : transports) {
            System.out.println(transport.givesInfo());
            if (transport instanceof PassengerTransport passengerTransportNew) {
                System.out.println(passengerTransportNew.givesInfoAboutTripCertainDuration(5));
            }
            if (transport instanceof CargoTransport cargoTransportNew) {
                System.out.println(cargoTransportNew.givesInfoAboutPossibilityOfTransportation(5));
            }
            if (transport instanceof CivilAirTransport civilAirTransportNew) {
                System.out.println(civilAirTransportNew.givesInfoAboutPossibilityOfTransportation(100));
            }
            if (transport instanceof MilitaryAirTransport militaryAirTransportNew) {
                while (militaryAirTransportNew.getNumberOfMissilesOnBoard() > 0) {
                    System.out.println(militaryAirTransportNew.returnsStatusOfMissileShot());
                }
                System.out.println(militaryAirTransportNew.returnsStatusOfMissileShot());
                System.out.println(militaryAirTransportNew.tryingToEject());
            }
            System.out.println();
        }
    }
}