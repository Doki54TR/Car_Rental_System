package MyCarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class HondaData implements ICarDataProvider {
    @Override
    public List<CarModel> getCarList() {
        List<CarModel> list = new ArrayList<>();

        // 1. Araba: Honda Civic (Sporty Sedan)
        list.add(new CarModel(
            "Honda Civic", 
            2500, 
            "Images/HondaCivic2025.jpg", 
            "Engine: 1.5L VTEC Turbo\n" +
            "HP: 182 HP / 240 Nm Torque\n" +
            "Transmission: CVT Automatic\n" +
            "Performance: 0-100 km/h in 8.1s\n" +
            "Safety: Honda Sensing Suite (Autopilot assist)\n" +
            "Style: Low stance, sporty handling"
        ));

        // 2. Araba: Honda CR-V (Family SUV)
        list.add(new CarModel(
            "Honda CR-V 2025", 
            3500, 
            "Images/HondaCRV2025.jpg", 
            "Engine: 2.0L e:HEV Full Hybrid\n" +
            "HP: 184 HP (Combined)\n" +
            "Drive: Real Time AWD (4x4)\n" +
            "Fuel Cons.: 5.4L / 100km (City Efficiency)\n" +
            "Interior: Leather seats, Panoramic Sunroof\n" +
            "Space: Largest cargo space in its class"
        ));

        // 3. Araba: Honda Jazz Crosstar (Urban Crossover)
        list.add(new CarModel(
            "Honda Jazz Crosstar", 
            1900, 
            "Images/HondaJazz2025.jpg", 
            "Engine: 1.5L i-MMD Hybrid\n" +
            "HP: 114 HP\n" +
            "Feature: 'Magic Seats' (Ultra versatile cargo)\n" +
            "Visibility: Panoramic windshield design\n" +
            "Fuel: 4.5L / 100km (Very Low)\n" +
            "Type: Compact outside, huge inside"
        ));

        return list;
    }
}