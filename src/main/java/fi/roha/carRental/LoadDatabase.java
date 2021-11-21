package fi.roha.carRental;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase(CarRepository carRepository) {
		
		return args -> {
			carRepository.save(new Car("Toyota", "Hiace", "Pakettiauto", 5, 100.0));
			carRepository.save(new Car("Toyota", "Hilux", "Lava-auto", 5, 100.0));
			carRepository.save(new Car("Mercedes-Benz", "G", "Maastoauto", 5, 200.0));
			carRepository.save(new Car("Opel", "Astra", "Hatchback", 5, 80.0));
		};
				
	}
	
}
