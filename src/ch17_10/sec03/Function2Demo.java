package ch17_10.sec03;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import ch17_10.sec02.Car;

public class Function2Demo {
  public static void main(String[] args) {
    Function<Car, String> f1 = c -> c.getModel();
    ToIntFunction<Car> f2 = c -> c.getAge();
    for (Car car: Car.cars) {
      System.out.println("("+f1.apply(car)+", "+f2.applyAsInt(car)+")");
    }
    System.out.println();

    double averageAge = average(Car.cars, c -> c.getAge());
    double averageMileage = average(Car.cars, c -> c.getMileage());
    System.out.println("평균 연식 : "+averageAge);
    System.out.println("평균 마일리지 : "+averageMileage);
  }

  public static double average(List<Car> cars, ToIntFunction<Car> f) {
    double sum = 0.0;
    for (Car car: Car.cars) {
      sum += f.applyAsInt(car);
    }
    return sum / cars.size();
  }
}
