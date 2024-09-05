package org.example.iteration;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import static java.lang.Thread.sleep;

@Data
@Document(collection = "counters")
public class Counter {
    @Id
    private String id;
    @Getter
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public void increment(int increment) {
        // Simulate a long running operation
        int count = this.count;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.count = count + increment;
    }
}