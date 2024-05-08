package ch17_12.sec01;
import java.util.List;

public class Nation {
  private final String name;
  private final Type type;
  private final double population;
  private final int gdpRank;



  public Nation(String name, Type type, double population, int gdpRank) {
    this.gdpRank = gdpRank;
    this.name = name;
    this.type = type;
    this.population = population;
  }

  public String getName() { return name; }
  public Type getType() { return type; }
  public double getPopulation() { return population; }
  public int getGdpRank() { return gdpRank; }
  public boolean isIsland() { return getType() != Type.LAND; }
  public enum Type { LAND, ISLAND }
  public String toString() { return name; }


  public static final List<Nation> nations = List.of(
    new Nation("ROK", Nation.Type.LAND, 51.4, 11),
    new Nation("New Zealand", Nation.Type.ISLAND, 4.5, 49),
    new Nation("USA", Nation.Type.LAND, 318.9, 1),
    new Nation("China", Nation.Type.LAND, 1355.7, 2),
    new Nation("Philiphine", Nation.Type.ISLAND, 107.7, 36),
    new Nation("India", Nation.Type.LAND, 1365.7, 20),
    new Nation("United Kingdom", Nation.Type.ISLAND, 63.7, 5),
    new Nation("Sri Lanka", Nation.Type.ISLAND, 21.9, 63),
    new Nation("Morocco", Nation.Type.LAND, 33.0, 60)
  );

}
