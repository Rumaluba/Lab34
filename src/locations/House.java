package locations;

public class House extends Builds {
    public House() {
        setName("Дом");
    }
    public static class Kitchen extends Rooms {
        public Kitchen() {
            setName("Кухня");
        }

        static private Kitchen kitchen;
        public Kitchen kitchen() {
            if (kitchen == null) {
                kitchen = new Kitchen();
            }
            return kitchen;
        }

        public class kitchenTable extends House {
            public kitchenTable() {
                setName("Кухонный стол");
            }

            static private kitchenTable kitchenTable;

            public kitchenTable checkkitchenTable() {
                if (kitchenTable == null) {
                    kitchenTable = new kitchenTable();
                }
                return kitchenTable;
            }
        }
    }

    public static class BackRoom extends Rooms {
        public BackRoom() {
            setName("Задняя комната");
        }

        static private BackRoom backRoom;

        public BackRoom backRoom() {
            if (backRoom == null) {
                backRoom = new BackRoom();
            }
            return backRoom;
        }

        public class TableWithPapers extends House {
            public TableWithPapers() {
               setName("Стол с бумагами");
            }

            static private TableWithPapers tableWithPapers;

            public TableWithPapers tableWithPapers() {
                if (tableWithPapers == null) {
                    tableWithPapers = new TableWithPapers();
                }
                return tableWithPapers;
            }
        }
    }
}

