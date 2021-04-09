package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;
    private double avgComponentsPerformans;
    private double avgPeripheralsPerformance;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty() && peripherals.isEmpty()) {
            return super.getOverallPerformance();
        }
        avgComponentsPerformans = components.stream().mapToDouble(Component::getOverallPerformance)
                .sum() / components.size();
        avgPeripheralsPerformance = peripherals.stream().mapToDouble(Peripheral::getOverallPerformance)
                .sum() / peripherals.size();

        return (super.getOverallPerformance() + avgComponentsPerformans + avgPeripheralsPerformance) / 3;
    }

    @Override
    public double getPrice() {
        double totalPrice = super.getPrice();
        totalPrice += components.stream().mapToDouble(Component::getPrice).sum();
        totalPrice += peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        return totalPrice;
    }

    @Override
    public void addComponent(Component component) {
        for (Component component1 : components) {
            if (component1.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                        component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
            }
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (components.isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        for (Component component : components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                components.remove(component);
                return component;
            }
        }
        return null;
    }



    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral peripheral1 : peripherals) {
            if (peripheral1.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                        peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
            }
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                components.remove(peripheral);
                return peripheral;
            }
        }
        return null;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());
        out.append(System.lineSeparator()).append(String.format(" Components (%d):",components.size()));
        for (Component component : components) {
            out.append(System.lineSeparator()).append(String.format("  %s", component));
        }
        out.append(System.lineSeparator());
        out.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", peripherals.size(), avgPeripheralsPerformance));
        for (Peripheral peripheral : peripherals) {
            out.append(System.lineSeparator()).append(String.format("  %s", peripheral));
        }
        return out.toString().trim();
    }
}
