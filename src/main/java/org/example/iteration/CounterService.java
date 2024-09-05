// src/main/java/org/example/iteration/CounterService.java
package org.example.iteration;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final CounterRepository counterRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Counter incrementCounter(int counterId, int increment) {
        Counter counter = counterRepository.getReferenceById(counterId);
        counter.increment(increment);
        counterRepository.save(counter);
        return counter;
    }
}