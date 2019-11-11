package ma.adria.ensa;

import java.util.Random;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import ma.adria.ensa.dao.ClientRepository;
import ma.adria.ensa.entities.Client;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository) {
		Random r = new Random();
		// char c = (char) (r.nextInt(26) + 'a');
		return args -> {
			Stream.of("ClientA" + (char) (r.nextInt(26) + 'a') + (int) (Math.random() * 100),
					"ClientB" + (char) (r.nextInt(26) + 'a') + (int) (Math.random() * 100),
					"ClientC" + (char) (r.nextInt(26) + 'a') + (int) (Math.random() * 100)).forEach(cl -> {
						clientRepository.save(
								new Client(cl, "address" + (char) (r.nextInt(26) + 'a') + (int) (Math.random() * 100)));
					});
			clientRepository.findAll().forEach(System.out::println);
		};
	}

}
