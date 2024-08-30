package org.example.iteration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@Slf4j
public class IterationApplication {

    List<Counter> counters = List.of(new Counter(1), new Counter(2), new Counter(3));

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/counters/{counterId}")
    public int getCounter(@PathVariable int counterId) {
        Counter counter = findCounterById(counterId);
        int count = counter.getCount();
        log.info("Counter " + counterId + " has count " + count);
        return count;
    }

    @PostMapping("/counters/{counterId}")
    public int incrementCounter(@PathVariable int counterId, @RequestBody int increment) {
        Counter counter = findCounterById(counterId);
        int result = counter.increment(increment);
        log.info("Counter " + counterId + " incremented by " + increment + " to " + result);
        return result;
    }

    public Counter findCounterById(int counterId) {
        for (Counter counter : counters) {
            if (counter.getId() == counterId) {
                return counter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(IterationApplication.class, args);
    }
}
