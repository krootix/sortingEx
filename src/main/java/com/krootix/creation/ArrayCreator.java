package com.krootix.creation;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayCreator {

    private final Random random;

    public ArrayCreator() {
        random = new Random();
    }

    public int[] createInts(int count) {

        int[] ints = new int[count];
        IntStream
                .iterate(0, n -> n + 1)
                .limit(count)
                .forEach(i -> ints[i] = random.nextInt(count));
        return ints;
    }
}