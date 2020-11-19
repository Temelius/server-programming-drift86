package com.temelius.drift86;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.temelius.drift86.model.Car;
import com.temelius.drift86.model.CarRepository;
import com.temelius.drift86.model.Map;
import com.temelius.drift86.model.MapRepository;
import com.temelius.drift86.model.Score;
import com.temelius.drift86.model.ScoreRepository;
import com.temelius.drift86.model.User;
import com.temelius.drift86.model.UserRepository;


@SpringBootApplication
public class Drift86Application {
	
	private static final Logger log = LoggerFactory.getLogger(Drift86Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Drift86Application.class, args);
	}
	
	@Bean
	public CommandLineRunner Drift86(
			CarRepository crepository, 
			MapRepository mrepository, 
			ScoreRepository srepository,
			UserRepository urepository) {
		return (args) -> {
			
			crepository.deleteAll();
			crepository.save(new Car("EG86", "The true legend of the drift. Any drift lover is obliged to try drift on this car."));
			crepository.save(new Car("BMG V92", "A work of German engineering, the best combination of equipment, comfort and power."));
			crepository.save(new Car("MuscleCar 1969", "Very powerful, but poorly controlled car, only an experienced driver can cope with it."));
			crepository.save(new Car("SunLine GTE", "This car, which has absorbed all the best technical achievements of mankind, is considered one of the best cars for drift."));
			crepository.save(new Car("EG86 Tuned", "The true legend of the drift. Any drift lover is obliged to try drift on this car."));
			crepository.save(new Car("XR-7", "I'm not gonna lose to some crap 86!"));
			crepository.save(new Car("X13", "Although long out of production, this car still popular in drifting and among tuners."));
			crepository.save(new Car("SuprX", "An iconic car in the world of JDM."));
			crepository.save(new Car("Eva X", "A summary of power that comes to us from the land of the rising sun."));
			crepository.save(new Car("RCX", "Car very appreciated by connoisseurs."));
			crepository.save(new Car("6GE", "Very light Japanese car and efficient handling."));
			crepository.save(new Car("Clia V6", "A jewel of the french automobile industry."));
			crepository.save(new Car("SunLine GTE35", "This car, which has absorbed all the best technical achievements of mankind, is considered one of the best cars for drift."));
			crepository.save(new Car("Vez 6012", "An iconic car that comes straight from the world's largest country."));
			crepository.save(new Car("Eva VIII", "A summary of power that comes to us from the land of the rising sun."));
			crepository.save(new Car("Imprezo", "Japanese car used most of the time in rally racing."));
			crepository.save(new Car("SunLine 2000", "The first car of a mythical series."));
			crepository.save(new Car("TG68", "The little sister."));
			crepository.save(new Car("SuprXX", "The little sister."));
			crepository.save(new Car("R32 Black Reaper", "The original Godzilla. This car has the same name as the best player in the game."));
			crepository.save(new Car("NXS", "The Japanese Ferrari."));
			crepository.save(new Car("XM5", "Small and perfect for the mountains."));
			crepository.save(new Car("S13", "Although long out of production, this car still popular in drifting and among tuners."));
			
			mrepository.deleteAll();
			mrepository.save(new Map("Racetrack"));
			mrepository.save(new Map("Port"));
			mrepository.save(new Map("Gunma"));
			mrepository.save(new Map("Island"));
			mrepository.save(new Map("Forest"));
			mrepository.save(new Map("Snowy Mountain"));
			mrepository.save(new Map("Snowy Country"));
			mrepository.save(new Map("Soviet City"));
			mrepository.save(new Map("Hydropower"));
			mrepository.save(new Map("The Hill"));
			mrepository.save(new Map("FreeDrift"));
			mrepository.save(new Map("FreeDrift Overland"));
			mrepository.save(new Map("FreeDrift City"));
			mrepository.save(new Map("Gunma Night"));
			mrepository.save(new Map("Gunma 2"));
			mrepository.save(new Map("Coal Mine"));
			
			srepository.deleteAll();
			srepository.save(new Score("Temecchi", "700365", "10:06:96", false, true, crepository.findByName("EG86").get(0), mrepository.findByName("Gunma").get(0)));
			srepository.save(new Score("jaska88", "315365", "14:07:92", false, true, crepository.findByName("EG86").get(0), mrepository.findByName("Gunma").get(0)));
			srepository.save(new Score("simpgryn", "635365", "11:06:96", false, true, crepository.findByName("TG68").get(0), mrepository.findByName("Gunma").get(0)));
			srepository.save(new Score("simpgryn", "328017", "12:06:87", true, true, crepository.findByName("XR-7").get(0), mrepository.findByName("Hydropower").get(0)));
			srepository.save(new Score("jaska88", "238187", "11:05:83", true, true, crepository.findByName("Imprezo").get(0), mrepository.findByName("Gunma").get(0)));
			
			urepository.deleteAll();
			// Passwords are role names in lowercase
			urepository.save(new User("Temecchi", "$2a$10$DNqCgrBaLCYocZfbalRSBOFybA67wQ3krWHx/6A7Uns0VvnEu9Q/q", "ADMIN", "admin@example.com"));
			urepository.save(new User("simpgryn", "$2a$10$BEwpmglV.a83YYAE9Eo17uDpqd9T4FGvsbTXhv6itrSSYvQzyLFLS", "MODERATOR", "moderator@example.com"));
			urepository.save(new User("jaska88", "$2a$10$DqP4xmuLPCPre2pz0WcECu5j3SKlzWJSGME7FvfmnWTdsu5N3hkC6", "USER", "user@example.com"));
			
		};
	}

}
