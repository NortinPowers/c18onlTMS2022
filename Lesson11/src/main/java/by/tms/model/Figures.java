package by.tms.model;

public enum Figures {
    LINE {
        @Override
        public String getSquareInfo() {
            return "area calculation is not possible for the line";
        }
    },
    TRIANGLE {
        @Override
        public String getSquareInfo() {
            return "the area of the triangle is ";
        }
    },
    RECTANGLE {
        @Override
        public String getSquareInfo() {
            return "the area of the rectangle is ";
        }
    };

    public abstract String getSquareInfo();
}
