package ch17_10.sec02;

import java.util.ArrayList;
import java.util.List;

public class CarDemo {
  public static void main(String[] args) {
    List<Car> deselCars = findCars(Car.cars, c->!c.isGasoline());
    System.out.println("디젤 자동차는 : "+deselCars);

    List<Car> OldCars = findCars(Car.cars, c->c.getAge()>10);
    System.out.println("오래된 자동차는 : "+OldCars);

    List<Car> OldAndDeselCars = findCars(Car.cars, c->c.getAge()>10 && !c.isGasoline());
    System.out.println("오래된 디젤 자동차는 : "+OldAndDeselCars);
  }

  public static List<Car> findCars(List<Car> all, CarPredicate cp) {
    List<Car> result = new ArrayList<>();

    for (Car c : all) {
      if (cp.test(c)) result.add(c);
    }

    return result;

  }
}
