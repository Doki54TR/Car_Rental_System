package MyCarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class FiatData implements ICarDataProvider {
    @Override
    public List<CarModel> getCarList() {
        List<CarModel> list = new ArrayList<>();

        // 1. Araba: Fiat Egea Cross (Crossover)
        list.add(new CarModel(
            "Fiat Egea Cross", 
            2000, 
            "Images/FiatEgeaCross2025.jpg", 
            "Engine: 1.4L Fire Gasoline\n" +
            "HP: 95 HP / 127 Nm Torque\n" +
            "Tech: 10'' Tablet Screen & Apple CarPlay\n" +
            "Style: Crossover Body Kit & Roof Rails\n" +
            "Safety: Lane Support System\n" +
            "Clearance: High ground clearance for comfort"
        ));

        // 2. Araba: Fiat Egea Sedan (Family/Economy)
        list.add(new CarModel(
            "Fiat Egea Sedan", 
            1800, 
            "Images/FiatEgea.jpg", 
            "Engine: 1.3L / 1.6L MultiJet Diesel\n" +
            "HP: 105 HP\n" +
            "Fuel Cons.: 4.1L / 100km (Very Economic)\n" +
            "Trunk: 520 Liters Huge Capacity\n" +
            "Comfort: Automatic Climate Control\n" +
            "Type: The most preferred family sedan"
        ));

        // 3. Araba: Fiat Linea (Budget)
        list.add(new CarModel(
            "Fiat Linea 2017", 
            800, 
            "Images/FiatLinea.jpg", 
            "Engine: 1.4L Fire Pop\n" +
            "HP: 77 HP\n" +
            "Transmission: 5-Speed Manual\n" +
            "Economy: Best Budget Choice\n" +
            "Durability: Robust suspension for rough roads\n" +
            "Features: Classic interior, large trunk space"
        ));

        return list;
    }
}
