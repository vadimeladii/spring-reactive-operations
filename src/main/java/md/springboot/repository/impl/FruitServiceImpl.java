package md.springboot.repository.impl;

import md.springboot.repository.FruitService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FruitServiceImpl implements FruitService {

    @Override
    public Flux<String> retrieve() {
        return Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
    }

    @Override
    public Flux<String> retrieveFromArray() {
        List<String> fruits = List.of("Apple", "Orange", "Grape", "Banana", "Strawberry");
        return Flux.fromIterable(fruits);
    }

    @Override
    public Flux<String> retrieveFromStream() {
        Stream<String> fruitStream = Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");
        return Flux.fromStream(fruitStream);
    }

    @Override
    public Flux<Integer> generateRangeFlux(Integer start, Integer count) {
        return Flux.range(start, count);
    }

    @Override
    public Flux<Long> generateIntervalFlux(Integer sencond, Integer timespan) {
        return Flux.interval(Duration.ofSeconds(5)).take(timespan);
    }
}
