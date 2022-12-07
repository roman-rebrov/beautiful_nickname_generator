import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class BeautifulNicknameGeneratorService {

    private String[] texts = new String[100_000];
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final List<Future> taskList = new ArrayList<>();
    private final Repository repository = new Repository();

    public void start() {

        this.texts = Generator.generateText(texts.length);

        executor.submit(Handlers.getAlphabetTask(texts, repository));
        executor.submit(Handlers.getIdenticalTask(texts, repository));
        executor.submit(Handlers.getPalindromeTask(texts, repository));

        for (Future task : taskList) {
            try {
                task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(repository);

        executor.shutdown();

    }
}
