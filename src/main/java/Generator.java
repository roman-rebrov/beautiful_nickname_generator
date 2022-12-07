import java.util.Random;

class Generator {
    public static String generateString(final String letters, final int length){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(letters.charAt(random.nextInt(letters.length())));
        }
        return builder.toString();
    }

    public static String [] generateText(final int length) {
        final String [] texts = new String [length];
        Random random = new Random();
        for (int i = 0; i < texts.length; i++) {
            final int letterNumber = 3  + random.nextInt(3);
            texts[i] = generateString("abc", letterNumber);
        }
        return texts;
    }
}
