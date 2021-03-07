package CarShop;

/**
 * Created by Zlatimir Ivanov on 6.3.2021 г..
 */

public interface Car {
    int TIRES = 4;

    public String getModel();

    public String getColor();

    public Integer getHorsePower();

    public String countryProduced();
}
