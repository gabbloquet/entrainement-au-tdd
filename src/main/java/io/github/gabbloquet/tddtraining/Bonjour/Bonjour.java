package io.github.gabbloquet.tddtraining.Bonjour;

public class Bonjour {

    private final HourSupplier hourSupplier;

    public Bonjour(HourSupplier hourSupplier) {
        this.hourSupplier = hourSupplier;
    }

    public String greet(String firstname) {
        String cleanedFirstname = firstname.trim();
        String uppercaseFirstname = cleanedFirstname.substring(0, 1).toUpperCase() + cleanedFirstname.substring(1);

        return switch (hourSupplier.getHour()) {
            case 23, 0, 1, 2, 3, 4, 5 -> "Bonne nuit " + uppercaseFirstname;
            case 18, 19, 20, 21, 22 -> "Bonsoir " + uppercaseFirstname;
            default -> "Bonjour " + uppercaseFirstname;
        };
    }
}
