package locations;

public class Road extends World{
        public Road() {
            super("Улица");
        }

        static private Road road;

        public Road newRoad() {
            if (road == null) {
                road = new Road();
            }
            return road;
        }
    public class Lawn extends Road {

        public Lawn() {
           setName("Лужайка");
        }
        static private Lawn lawn;

        public Lawn lawn() {
            if (lawn == null) {
                lawn = new Lawn();
            }
            return lawn;
        }
    }
    public class NearTheHouse extends Road {
        public NearTheHouse() {
            setName("Около дома");
        }

        static private NearTheHouse nearTheHouse;
        public NearTheHouse nearTheHouse() {
            if (nearTheHouse == null) {
                nearTheHouse = new NearTheHouse();
            }
            return nearTheHouse;
        }
    }
}
