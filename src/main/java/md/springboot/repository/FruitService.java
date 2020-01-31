package md.springboot.repository;

import reactor.core.publisher.Flux;

public interface FruitService {
    Flux<String> retrieve();

    Flux<String> retrieveFromArray();

    Flux<String> retrieveFromStream();

    Flux<Integer> generateRangeFlux(Integer start, Integer count);

    Flux<Long> generateIntervalFlux(Integer sencond, Integer timespan);
}
