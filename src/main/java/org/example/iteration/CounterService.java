package org.example.iteration;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final CounterRepository counterRepository;
    private final MongoTemplate mongoTemplate;

    @Transactional
    public Counter incrementCounter(int counterId, int increment) {
        Query query = new Query(Criteria.where("_id").is(String.valueOf(counterId)));
        Update update = new Update().inc("count", increment);
        Counter counter = mongoTemplate.findAndModify(query, update, Counter.class);
        if (counter == null) {
            throw new RuntimeException("Counter not found");
        }
        return counter;
    }
}