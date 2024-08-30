package org.example.iteration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@Slf4j
@RequiredArgsConstructor
public class IterationApplication {

//    List<Counter> counters = List.of(new Counter(1), new Counter(2), new Counter(3));

    private final CounterRepository counterRepository;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/counters/{counterId}")
    public int getCount(@PathVariable int counterId) {
        Counter counter = counterRepository.getReferenceById(counterId);
        int count = counter.getCount();
        log.info("Counter " + counterId + " has count " + count);
        return count;
    }

    @PostMapping("/counters/{counterId}")
    public Counter incrementCounter(@PathVariable int counterId, @RequestBody int increment) {
        Counter counter = counterRepository.getReferenceById(counterId);
        int result = counter.increment(increment);
        log.info("Counter " + counterId + " incremented by " + increment + " to " + result);
        counterRepository.save(counter);
        return counter;
    }

    public static void main(String[] args) {
        SpringApplication.run(IterationApplication.class, args);
    }
}
