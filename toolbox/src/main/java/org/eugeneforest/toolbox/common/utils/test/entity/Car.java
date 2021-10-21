package org.eugeneforest.toolbox.common.utils.test.entity;

/**
 * @author Eugene-Forest
 */
public class Car {
    private String brand;
    private double weight;
    private double height;

    private SafetyIndex safetyIndex;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public SafetyIndex getSafetyIndex() {
        return safetyIndex;
    }

    public void setSafetyIndex(SafetyIndex safetyIndex) {
        this.safetyIndex = safetyIndex;
    }
}
