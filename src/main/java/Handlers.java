

class Handlers {

    public static Runnable getPalindromeTask(final String[] texts, final Repository repository) {
        return () -> {
            for (String string : texts) {
                if (string.equals(new StringBuilder(string).reverse().toString())) {
                    repository.increment(string);
                }
            }
        };
    }


    public static Runnable getIdenticalTask(final String[] texts, final Repository repository) {
        return () -> {
            for (String string : texts) {
                boolean result = true;
                char f = string.charAt(0);
                for (int i = 1; i < string.length(); i++) {
                    if (f != string.charAt(i)) {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    repository.increment(string);
                }
            }
        };
    }

    public static Runnable getAlphabetTask(final String[] texts, final Repository repository) {
        return () -> {
            for (String string : texts) {
                boolean res = true;
                int prev = (int) string.charAt(0);

                for (int i = 1; i < string.length(); i++) {
                    int balance = (int) string.charAt(i) - prev;
                    if (balance > 1 || balance < 0) {
                        res = false;
                        break;
                    } else {
                        prev = (int) string.charAt(i);
                    }
                }
                if (res == true) {
                    repository.increment(string);
                }
            }
        };
    }

}
