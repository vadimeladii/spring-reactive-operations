package md.springboot.repository.impl;

import md.springboot.repository.FruitService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

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

    @Override
    public Flux<String> mergeFluxes(Flux<String> fluxFirst, Flux<String> fluxSecond) {
        return fluxFirst.mergeWith(fluxSecond);
    }

    @Override
    public Flux<Tuple2<String, String>> zipFluxes(Flux<String> fluxFirst, Flux<String> fluxSecond) {
        return fluxFirst.zipWith(fluxSecond);
    }

    @Override
    public Flux<String> firstFlux(Flux<String> fluxFirst, Flux<String> fluxSecond) {
        return Flux.first(fluxFirst, fluxSecond);
    }

    @Override
    public Flux<String> skipAFew(Long skipped) {
        return Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry").skip(skipped);
    }

    @Override
    public Flux<String> skipAFewSeconds(Long skipped) {
        return Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry").skip(Duration.ofSeconds(skipped));
    }

    @Override
    public Flux<String> takeAFew(Long skipped) {
        return Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry").take(skipped);
    }

    @Override
    public Flux<String> takeAFewSeconds(Long skipped) {
        return Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry").take(Duration.ofSeconds(skipped));
    }

    @Override
    public Flux<String> filterFlux() {
        return Flux.just(
                "Yellowstone", "Yosemite", "Grand Canyon",
                "Zion", "Grand Teton")
                .filter(np -> !np.contains(" "));
    }

    @Override
    public Flux<String> distinctFlux() {
        return Flux.just("dog", "cat", "bird", "dog", "bird", "anteater").distinct();
    }

    @Override
    public Flux<Tuple2<String, String>> mapFlux() {
        return Flux.just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
                .map(name -> {
                    String[] split = name.split("\\s");
                    return Tuples.of(split[0], split[1]);
                });
    }

    @Override
    public Flux<Tuple2<String, String>> flatMapFlux() {
        return Flux.just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
                .flatMap(n -> Mono.just(n)
                        .map(name -> {
                            String[] split = name.split("\\s");
                            return Tuples.of(split[0], split[1]);
                        }).subscribeOn(Schedulers.parallel()));
    }
}
