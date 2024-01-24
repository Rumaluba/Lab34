package enums;

public enum Volume {
        ALOT("немало напитка");
        private final String name;

        Volume(String name) {
            this.name = name;
        }

        public String getNameVolume() {
            return name;
        }
    }
