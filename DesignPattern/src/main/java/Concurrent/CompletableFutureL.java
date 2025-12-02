package Concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureL {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*A) runAsync()
            Used when no return value is needed.*/
        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {
                    System.out.println("Task running...");
                });


        /*B) supplyAsync()

            Used when the task returns a value.*/

        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(() -> 10);

        future1.thenApply(n->n*3).thenAccept(n-> System.out.println(n)).thenRun(()-> System.out.println("Task Completed"));



        // combine() (VERY IMPORTANT)

        CompletableFuture<Integer> future2 =
                CompletableFuture.supplyAsync(() -> 50);

        CompletableFuture<Integer> future3 =
                CompletableFuture.supplyAsync(() -> 70);

        future2.thenCombine(future3,(a,b)->a+b).thenAccept(n-> System.out.println(n));


        // compose() (VERY IMPORTANT)

        CompletableFuture<Integer> future4 =
                CompletableFuture.supplyAsync(() -> 10).thenCompose(a->CompletableFuture.supplyAsync(()->a*4));

        future4.thenAccept(n-> System.out.println(n));

        ///  All Of

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);

        // Running multiple tasks in parallel
        CompletableFuture<Void> allOf = CompletableFuture.allOf(f1, f2);
        // Waits for both futures to complete
        allOf.thenRun(()-> {
            try {
                int i = f1.get() + f2.get();
                System.out.println("ABC "+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Future1 Result: " + f1.get());
        System.out.println("Future2 Result: " + f2.get());



        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(()->10/0).exceptionally(ex->0);
        System.out.println(intFuture.get());


        // Any Of

        CompletableFuture<String> slow =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Slow";
                });

        CompletableFuture<String> fast =
                CompletableFuture.supplyAsync(() -> "Fast");

        CompletableFuture<Object> result =
                CompletableFuture.anyOf(slow, fast);

        result.thenAccept(System.out::println);
// Output: Fast


        CompletableFuture<Integer> future6 =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenCompose(a ->
                                CompletableFuture.supplyAsync(() -> a * 2)
                        );

        System.out.println(future6.get());  // 20



        CompletableFuture<Integer> future7 =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApplyAsync(n -> n * 2);

        System.out.println(future7.get());


        CompletableFuture<Integer> f =
                CompletableFuture.supplyAsync(() -> 10/0)
                        .handle((res, ex) -> ex == null ? res : 999);

        System.out.println(f.get());  // 999



        /*
        * ⭐ Task 1:

Use allOf() to run 3 tasks:

return 10

return 20

return 30

Then print the sum: 60*/


        CompletableFuture<Integer> a1 = CompletableFuture.supplyAsync(()->10);
        CompletableFuture<Integer> a2 = CompletableFuture.supplyAsync(()->20);
        CompletableFuture<Integer> a3 = CompletableFuture.supplyAsync(()->30);


        CompletableFuture<Void> res = CompletableFuture.allOf(a1,a2,a3);
        res.thenRun(()-> {
            try {
                int i = a1.get() + a2.get() + a3.get();
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });



        CompletableFuture<String> a4 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Slow";
        });
        CompletableFuture<String> a5 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Fast";
        });


        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(a4, a5);
        System.out.println(objectCompletableFuture.get());




        CompletableFuture<Integer> a6 = CompletableFuture.supplyAsync(()->5).thenCompose(a->CompletableFuture.supplyAsync(()->a*10));
        System.out.println(a6.get());


        CompletableFuture<Integer> a7 = CompletableFuture.supplyAsync(()->10/0).handle((res1,ex)->ex==null?res1:999);
        System.out.println("-------------------------");

        List<Integer> li = Arrays.asList(1,2,3,4,5);
        li.parallelStream().map(a->a*2).forEach(System.out::println);



        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(()->100);
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(()->200);

        CompletableFuture<Integer> integerCompletableFuture = task1.thenCombine(task2, (t1, t2) -> t1 + t2);

        System.out.println(integerCompletableFuture.get());


        //  Because it used commin fork Join pool , and if the task is heavy then whole server can be down

        /*
        * 1- Parallel Stream
        * 2-CompletableFuture
        * 3-Parallel Stream
        * yes
        * */

    }
}
