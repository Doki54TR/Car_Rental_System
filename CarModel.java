package MyCarRentalSystem;

public class CarModel {
    private String modelName;
    private int dailyPrice;
    private String imagePath;
    private String details;

    // Constructor (Yapıcı Metod)
    public CarModel(String modelName, int dailyPrice, String imagePath, String details) {
        this.modelName = modelName;
        this.dailyPrice = dailyPrice;
        this.imagePath = imagePath;
        this.details = details;
    }

    // Getter Metodları (Verileri okumak için)
    public String getModelName() {
        return modelName;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDetails() {
        return details;
    }
}
