package utils;

public enum foodType {
    FRUIT, VEGETABLE;

    public String getFruitType() {
        switch (this) {
            case FRUIT:
                return "Фрукт";

            case VEGETABLE:
                return "Овощ";

            default:
                return null;
        }
    }
}