import java.util.concurrent.*;
public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            completionService.submit(() -> {
                int sleepTime = 6 - taskId; // shorter sleep for higher taskId
                Thread.sleep(sleepTime * 1000);
                return "Task " + taskId + " completed after " + sleepTime + " seconds";
            });
        }

        for (int i = 0; i < 5; i++) {
            Future<String> resultFuture = completionService.take(); // blocks until a task completes
            String result = resultFuture.get();
            System.out.println(result);
        }

        executor.shutdown();
    }
}
