package org.alladywekjd.kyu6;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class SupermarketQueue {

    public static int solveSuperMarketQueue(int[] customersTimes, int tills) {
        if (tills == 1) return IntStream.of(customersTimes).sum();
        if (customersTimes.length <= tills) return IntStream.of(customersTimes).max().orElse(0);

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(tills) {{
            for (int i = 0; i < tills; i++) add(0);
        }};

        for (int time : customersTimes) queue.add(queue.poll() + time);
        return queue.stream().max(Integer::compareTo).get();
    }
}
