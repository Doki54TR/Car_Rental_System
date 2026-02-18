package MyCarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class ToyotaData implements ICarDataProvider {
    @Override
    public List<CarModel> getCarList() {
        List<CarModel> list = new ArrayList<>();

        // 1. Araba: Toyota Auris (Hybrid Hatchback)
        list.add(new CarModel(
            "Toyota Auris 2025", 
            2300, 
            "Images/ToyotaAuris2025.jpg", 
            "Engine: 1.8L Full Hybrid System\n" +
            "HP: 140 HP (Combined)\n" +
            "Fuel Cons.: 3.8L / 100km (Eco Master)\n" +
            "Transmission: e-CVT Automatic\n" +
            "Drive: Silent EV (Electric) Mode\n" +
            "Perfect for: City traffic efficiency"
        ));

        // 2. Araba: Toyota Corolla Cross (Family SUV)
        list.add(new CarModel(
            "Toyota Corolla Cross", 
            2500, 
            "Images/ToyotaCorollaCross2025.jpg", 
            "Engine: 1.8L Hybrid Dynamic Force\n" +
            "HP: 140 HP + Electric Torque\n" +
            "Trunk: 440 Liters & Power Tailgate\n" +
            "Safety: Toyota Safety Sense 3.0 (TSS)\n" +
            "Tech: Wireless Apple CarPlay\n" +
            "Comfort: High seating position SUV"
        ));

        // 3. Araba: Toyota Corolla Sedan (The Legend)
        list.add(new CarModel(
            "Toyota Corolla 2024", 
            2000, 
            "Images/ToyotaCorolla2024.png", 
            "Engine: 1.5L Dynamic Force Petrol\n" +
            "HP: 123 HP\n" +
            "Reliability: World's Best Selling Car\n" +
            "Interior: 10.5'' Multimedia Screen\n" +
            "Safety: 7 Airbags & Adaptive Cruise Control\n" +
            "Ride: Smooth and durable suspension"
        ));

        return list;
    }
}
