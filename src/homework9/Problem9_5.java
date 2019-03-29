package homework9;

import java.util.Arrays;

public class Problem9_5 {
    public static void solve(){
        System.out.println(Arrays.toString(Planet.values()));
    }
    enum Sys{SA, AS}
    enum Planet {
        MERCURY(123, 12, 16),
        VENUS(123,333,123),
        EARTH(2232,2311,2313);
        private int mass;
        private int radius;
        private int orbit;


        Planet(int mass, int radius, int orbit) {
            this.mass = mass;
            this.radius = radius;
            this.orbit = orbit;
        }

        @Override
        public String toString() {
            return "Planet{" +
                    "mass=" + mass +
                    ", radius=" + radius +
                    ", orbit=" + orbit +
                    '}';
        }

        public int getMass() {
            return mass;
        }

        public int getRadius() {
            return radius;
        }

        public int getOrbit() {
            return orbit;
        }
    }
}

