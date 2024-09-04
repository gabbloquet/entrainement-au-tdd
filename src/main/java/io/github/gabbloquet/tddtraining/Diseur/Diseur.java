package io.github.gabbloquet.tddtraining.Diseur;

public class Diseur {

    public String next(String str) {
        StringBuilder nextStr = new StringBuilder();

        for (int i = 0; i < str.length(); ) {
            char character = str.charAt(i);

            int count = 1;
            while (characterIsTheSame(str, i + count, character)) {
                count++;
            }

            nextStr.append(count).append(character);
            i += count;
        }

        return nextStr.toString();
    }

    private static boolean characterIsTheSame(String chaine, int characterLocalization, char character) {
        return chaine.length() > characterLocalization &&
            chaine.charAt(characterLocalization) == character;
    }
}
