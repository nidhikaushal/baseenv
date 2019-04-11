import org.apache.kafka.common.serialization.IntegerSerializer;

import java.util.*;
import java.util.concurrent.*;

public class Test {

    public static class WordLenghtCallable implements Callable {

        private String word;

        public WordLenghtCallable(String word){
            this.word = word;
        }

        @Override
        public Integer call() throws Exception {
            return Integer.valueOf(word.length());
        }
    }

    public static void main(String args[]) throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();

        for(String word:args){
            Callable<Integer> callable = new WordLenghtCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }

        int sum = 0;
        for(Future<Integer> future: set){
            sum = future.get();
        }

        System.out.println("sum is " + sum);
        System.exit(sum);
    }
}
