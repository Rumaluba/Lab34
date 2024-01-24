package locations;

public abstract class Builds extends World {
    public Builds() {
        super("Здание");
    }

    public static class KinderGarten extends Builds {
        public KinderGarten() {
            setName("Детский сад");
        }

        static private KinderGarten kinderGarten;

        public KinderGarten kinderGarten() {
            if (kinderGarten == null) {
                kinderGarten = new KinderGarten();
            }
            return kinderGarten;
        }

        public class RoomWithKids extends Rooms {
            public RoomWithKids() {
                setName("Детская комната");
            }
        }

        static private RoomWithKids roomWithKids;

        public RoomWithKids roomWithKids() {
            if (roomWithKids == null) {
                roomWithKids = new RoomWithKids();
            }
            return roomWithKids;
        }
    }
    public static class Hospital extends Builds {

        public Hospital() {
           setName("Больница");
        }

        static private Hospital hospital;

        public Hospital hospital() {
            if (hospital == null) {
                hospital = new Hospital();
            }
            return hospital;
        }

        public class RoomWithMedicine extends Rooms {
            public RoomWithMedicine() {
               setName("Приемная врача");
            }

            static private RoomWithMedicine roomWithMedicine;

            public RoomWithMedicine roomWithMedicine() {
                if (roomWithMedicine == null) {
                    roomWithMedicine = new RoomWithMedicine();
                }
                return roomWithMedicine;
            }
        }
    }
}



