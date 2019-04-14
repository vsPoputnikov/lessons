package lesson13.container;
@Config
public class SomeClassConfig {
   private String name;
   private int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public static void main(String[] args) {
        SomeClassConfig config = new SomeClassConfig();
        config.setName("SomeClass");
        config.setVersion(2);
    }
}
