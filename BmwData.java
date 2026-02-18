package MyCarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class BmwData implements ICarDataProvider {
    @Override
    public List<CarModel> getCarList() {
        List<CarModel> list = new ArrayList<>();

        // 1. Araba: BMW 520d (Luxury Sedan)
        list.add(new CarModel(
            "BMW 520d", 
            2250, 
            "Images/Bmw520F30.jpg", 
            "Engine: 2.0L TwinPower Turbo Diesel\n" +
            "HP: 190 HP / 400 Nm Torque\n" +
            "Transmission: 8-Speed Steptronic\n" +
            "Performance: 0-100 km/h in 7.5s\n" +
            "Fuel Cons.: 4.8L / 100km\n" +
            "Features: Leather Seats, Sunroof, Business Class Comfort"
        ));

        // 2. Araba: BMW 420d Cabrio (Sporty)
        list.add(new CarModel(
            "BMW 420d Cabrio", 
            3350, 
            "Images/Bmw420dCabrio.jpg", 
            "Engine: 2.0L Turbo Diesel\n" +
            "HP: 190 HP\n" +
            "Style: Convertible / M Sport Package\n" +
            "Roof: Retractable Hardtop\n" +
            "Performance: 0-100 km/h in 8.0s\n" +
            "Experience: Open-top driving with ultimate sporty handling"
        ));

        // 3. Araba: BMW X3 (SUV)
        list.add(new CarModel(
            "BMW X3 xDrive", 
            5000, 
            "Images/BmwX3.jpg", 
            "Engine: 2.0L Hybrid / Petrol\n" +
            "HP: 292 HP (Combined)\n" +
            "Drive: Intelligent xDrive (4x4)\n" +
            "Trunk Volume: 550 Liters\n" +
            "Performance: 0-100 km/h in 6.1s\n" +
            "Type: Premium Family SUV with Off-road capability"
        ));

        return list;
    }
}
