package fr.uparis.projet_genie_logiciel.util;

public final class StringUtils {

    private StringUtils() {
        // Empêche l'instanciation
    }

    public static String lowerCase(String name) {
        if (name == null) {
            return null;
        }
        return name.toLowerCase().trim();
    }
}
