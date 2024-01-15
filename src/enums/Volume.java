package enums;

public enum Volume {
        ALITTLE("немного напитка"),
        ALOT("немало напитка"),
        SOME("некоторое количество напитка");
        private final String name;

        Volume(String name) {
            this.name = name;
        }

        public String getNameVolume() {
            return name;
        }
    }
