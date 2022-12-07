import java.util.concurrent.atomic.AtomicInteger;

class Repository {
    private static final AtomicInteger threeLetters = new AtomicInteger(0);
    private static final AtomicInteger fourLetters = new AtomicInteger(0);
    private static final AtomicInteger fiveLetters = new AtomicInteger(0);

    public void increment(String string){
        if (string.length() == 3){
            threeLetters.getAndIncrement();
        }else if (string.length() == 4){
            fourLetters.getAndIncrement();
        }else if (string.length() == 5){
            fiveLetters.getAndIncrement();
        }
    }

    @Override
    public String toString(){
        return "beautiful words: \n"
                + "with 3 letters: " + threeLetters + "\n"
                + "with 4 letters: " + fourLetters + "\n"
                + "with 5 letters: " + fiveLetters + "\n";
    }
}
