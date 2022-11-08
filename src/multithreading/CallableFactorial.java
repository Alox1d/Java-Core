package multithreading;

import java.util.concurrent.*;

public class CallableFactorial {
    private static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(6);
        Future<Integer> future = executorService.submit(factorial);
        try {
            factorialResult = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class Factorial implements Callable<Integer> {
    private int n;

    public Factorial(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        if (n <= 0) {
            throw new Exception("Вы ввели неверное число");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
