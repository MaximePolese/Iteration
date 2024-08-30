// src/main/java/org/example/iteration/Counter.java
package org.example.iteration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import static java.lang.Thread.sleep;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int count;

    public Counter() {
    }

    public Counter(int id) {
        this.id = id;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public int increment(int increment) {
        // Simulate a long running operation
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