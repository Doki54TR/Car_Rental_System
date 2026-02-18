package MyCarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class FordData implements ICarDataProvider {
    @Override
    public List<CarModel> getCarList() {
        List<CarModel> list = new ArrayList<>();

        // 1. Araba: Ford Focus (Dynamic Hatchback)
        list.add(new CarModel(
            "Ford Focus 2025", 
            2750, 
            "Images/FordFocus2025.jpg", 
            "Engine: 1.0L EcoBoost Hybrid (mHEV)\n" +
            "HP: 125 HP / 170 Nm Torque\n" +
            "Transmission: 7-Speed Powershift Auto\n" +
            "Tech: SYNC 4 Huge Touchscreen\n" +
            "Handling: Class-leading driving dynamics\n" +
            "Safety: Pre-Collision Assist & Lane Keeping"
        ));

        // 2. Araba: Ford Fiesta (Compact City Car)
        list.add(new CarModel(
            "Ford Fiesta", 
            750, 
            "Images/FordFiesta.jpg", 
            "Engine: 1.4L Duratec / Hybrid\n" +
            "HP: 75 HP\n" +
            "Style: Compact Hatchback\n" +
            "Transmission: 5-Speed Manual\n" +
            "City: Best for parking in tight spots\n" +
            "Fuel: Very economic for daily commute"
        ));

        // 3. Araba: Ford Tourneo Courier (MPV/Utility)
        list.add(new CarModel(
            "Ford Tourneo Courier", 
            1550, 
            "Images/FordCourier.jpg", 
            "Engine: 1.0L EcoBoost / 1.5L Diesel\n" +
            "HP: 100 HP\n" +
            "Type: Multi-Purpose Vehicle (MPV)\n" +
            "Doors: Sliding rear doors for easy access\n" +
            "Cargo: Huge trunk space for luggage\n" +
            "Ideal for: Family trips and heavy loading"
        ));

        return list;
    }
}
