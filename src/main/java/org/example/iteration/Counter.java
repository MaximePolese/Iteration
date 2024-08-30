package org.example.iteration;

import static java.lang.Thread.sleep;

public class Counter {
    private int id;
    private int count;

    public Counter(int id) {
        this.id = id;
        this.count = 0;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public int increment(int increment) {
        int count = getCount();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.count = count + increment;
        return this.count;
    }
}
