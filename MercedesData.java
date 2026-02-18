package MyCarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class MercedesData implements ICarDataProvider {
    @Override
    public List<CarModel> getCarList() {
        List<CarModel> list = new ArrayList<>();

        // 1. Araba: Mercedes C200 4Matic (Compact Executive)
        list.add(new CarModel(
            "Mercedes C200 4Matic", 
            3000, 
            "Images/MercedesC2004Matic.jpg", 
            "Engine: 1.5L Turbo EQ Boost\n" +
            "HP: 204 HP + 20 HP (Electric)\n" +
            "Transmission: 9G-TRONIC Automatic\n" +
            "Tech: MBUX Multimedia & Digital Dash\n" +
            "Interior: 64-Color Ambient Lighting\n" +
            "Performance: 0-100 km/h in 7.1s"
        ));

        // 2. Araba: Mercedes CLA200 AMG (Sporty Coupe)
        list.add(new CarModel(
            "Mercedes CLA200 AMG", 
            5200, 
            "Images/MercedesCLA200.jpg", 
            "Engine: 1.33L Turbo\n" +
            "HP: 163 HP\n" +
            "Style: 4-Door Coupe / AMG Body Kit\n" +
            "Features: Frameless Doors, Sport Seats\n" +
            "Tech: Widescreen Cockpit\n" +
            "Design: Diamond Grille & Shark Nose"
        ));

        // 3. Araba: Mercedes S450d 4Matic Long (Ultra Luxury)
        list.add(new CarModel(
            "Mercedes S450d 4Matic L", 
            15000, 
            "Images/MercedesS450.jpg", 
            "Engine: 3.0L Inline-6 Diesel\n" +
            "HP: 367 HP / 750 Nm Torque\n" +
            "Luxury: Massage Seats, Burmester 4D Sound\n" +
            "Ride: AIRMATIC Air Suspension\n" +
            "Status: The World's Best Luxury Sedan\n" +
            "Comfort: Executive Rear Seating"
        ));

        return list;
    }
}
