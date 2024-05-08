package ch17_10.sec02;

import java.util.Arrays;
import java.util.List;

public class Car {
  private String model;
  private boolean gasoline;
  private int age;
  private int mileage;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public boolean isGasoline() {
    return gasoline;
  }

  public void setGasoline(boolean gasoline) {
    this.gasoline = gasoline;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public String toString() {
    return String.format("Car(%s, %s, %d, %d)", model, gasoline, age, mileage);
  }

  public static final List<Car> cars = Arrays.asList(
    new Car("sonata", true, 18, 210000),
    new Car("corando", false, 15, 200000),
    new Car("grandeur", true, 12, 150000),
    new Car("Santafe", false, 10, 220000),
    new Car("Avante", true, 10, 70000),
    new Car("Equus", true, 6, 100000),
    new Car("grandeur", true, 5, 80000),
    new Car("sonata", true, 2, 35000),
    new Car("Sorento", false, 1, 10000),
    new Car("Avante", true, 1, 7000)
  );

  public Car(String model, boolean gasoline, int age, int mileage) {
    this.model = model;
    this.gasoline = gasoline;
    this.age = age;
    this.mileage = mileage;
  }

  
}

