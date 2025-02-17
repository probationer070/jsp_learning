package ch17_10.sec03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ch17_10.sec02.Car;

public class ComparatorDemo {
  public static void main(String[] args) {
    List<Car> list = Car.cars.subList(0, 3);
    Car[] cars = list.toArray(new Car[3]);

    Comparator<Car> modelComparator = Comparator.comparing(Car::getModel);

    System.out.println(Arrays.toString(cars));
    Arrays.sort(cars, modelComparator);
    System.out.println(Arrays.toString(cars));
  }
}
