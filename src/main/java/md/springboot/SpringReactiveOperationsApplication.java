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
    public void run(String... args) throws InterruptedException {
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
    }
}
