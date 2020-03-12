package copying;

//does not actually NEED to implement Cloneable, since we never use Object.clone()
public class Author implements Cloneable {
  private String name;
  private int age;

  public Author(String name)
  {
      this.name = name;
  }

  //what kind of copy is this? (trick question)// this is NOT a copy at all. Refers to the same object memory
  @Override
  protected Author clone() {
      return this;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getAge() {
      return age;
  }

  public void setAge(int age) {
      this.age = age;
  }

}
