package wiss.m294.wissquizapi.model;

public class Category {

  private int id;
  private String name;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public Category(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(int idCounter) {
    // TODO Auto-generated method stub
    this.id = idCounter;
  }
}
