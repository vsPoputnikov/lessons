package patterns.dicontainer;


import patterns.dicontainer.di.Config;

@Config
public class Cat {
  private   String catName;

    public String getCatName() {
        return catName;
    }

    public Cat() {
        System.out.println("catINIT");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                '}';
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
