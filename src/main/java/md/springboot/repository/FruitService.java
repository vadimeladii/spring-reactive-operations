package md.springboot.repository;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public interface FruitService {
    Flux<String> retrieve();

    Flux<String> retrieveFromArray();

    Flux<String> retrieveFromStream();

    Flux<Integer> generateRangeFlux(Integer start, Integer count);

    Flux<Long> generateIntervalFlux(Integer sencond, Integer timespan);

    Flux<String> mergeFluxes(Flux<String> fluxFirst, Flux<String> fluxSecond);

    Flux<Tuple2<String, String>> zipFluxes(Flux<String> fluxFirst, Flux<String> fluxSecond);

    Flux<String> firstFlux(Flux<String> fluxFirst, Flux<String> fluxSecond);

    Flux<String> skipAFew(Long skipped);

    Flux<String> skipAFewSeconds(Long skipped);

    Flux<String> takeAFew(Long skipped);

    Flux<String> takeAFewSeconds(Long skipped);

    Flux<String> filterFlux();

    Flux<String> distinctFlux();

    Flux<Tuple2<String, String>> mapFlux();

    Flux<Tuple2<String, String>> flatMapFlux();
}
