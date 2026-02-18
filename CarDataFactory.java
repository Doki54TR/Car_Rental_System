package MyCarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class CarDataFactory {

    public static List<CarModel> getCarsByBrand(String brand) {
        if (brand == null) return new ArrayList<>();

        // Polimorfizm
        ICarDataProvider provider;

        switch (brand.toLowerCase()) {
            case "toyota":   
                provider = new ToyotaData(); 
                break;
            case "honda":    
                provider = new HondaData(); 
                break;
            case "mercedes": 
                provider = new MercedesData(); 
                break;
            case "bmw":      
                provider = new BmwData(); 
                break;
            case "ford":     
                provider = new FordData(); 
                break;
            case "fiat":     
                provider = new FiatData(); 
                break;
            default: return new ArrayList<>();
        }

        // Takes and prints the car list from the selected provider
        return provider.getCarList();
    }
}
