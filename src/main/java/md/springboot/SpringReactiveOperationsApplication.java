package md.springboot;

import lombok.RequiredArgsConstructor;
import md.springboot.repository.FruitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringReactiveOperationsApplication implements CommandLineRunner {

    private final FruitService fruitService;

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveOperationsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("------ Get Flux ------");
        fruitService.retrieve().subscribe(System.out::println);

        System.out.println("------ Get Flux from Array ------");
        fruitService.retrieveFromArray().subscribe(System.out::println);

        System.out.println("------ Get Flux from Stream ------");
        fruitService.retrieveFromStream().subscribe(System.out::println);

        System.out.println("------Create a range Flux------");
        fruitService.generateRangeFlux(1, 10).subscribe(System.out::println);

        System.out.println("------Create a interval Flux------"); // Thread.sleep(100000);
        fruitService.generateIntervalFlux(1, 4).subscribe(System.out::println);

        System.out.println("------Merging two Flux streams------");
        fruitService.mergeFluxes(fruitService.retrieve(), fruitService.retrieveFromArray()).subscribe(System.out::println);

        System.out.println("------Zipping two Flux streams------");
        fruitService.zipFluxes(fruitService.retrieve(), fruitService.retrieveFromArray()).subscribe(System.out::println);

        System.out.println("------Selecting the first reactive type------");
        fruitService.firstFlux(fruitService.retrieve(), fruitService.retrieveFromArray()).subscribe(System.out::println);

        System.out.println("------Skip a specified number of messages------");
        fruitService.skipAFew(3L).subscribe(System.out::println);

        System.out.println("------Skip operation waits until some duration has passed before passing messages------");
        fruitService.skipAFewSeconds(3L).subscribe(System.out::println);

        System.out.println("------Take a specified number of messages------");
        fruitService.takeAFew(3L).subscribe(System.out::println);

        System.out.println("------Take operation waits until some duration has passed------");
        fruitService.takeAFewSeconds(3L).subscribe(System.out::println);

        System.out.println("------Filter FLux------");
        fruitService.filterFlux().subscribe(System.out::println);

        System.out.println("------Distinct FLux------");
        fruitService.distinctFlux().subscribe(System.out::println);

        System.out.println("------Map FLux------");
        fruitService.mapFlux().subscribe(System.out::println);

        System.out.println("------FlatMap FLux------");
        fruitService.flatMapFlux().subscribe(System.out::println);

        System.out.println("------The buffer operation------");
        fruitService.bufferFlux().subscribe(System.out::println);
    }
}
