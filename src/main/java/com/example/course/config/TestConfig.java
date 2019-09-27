package com.example.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

//Para informar ao JPA que é uma classe de configuração
@Configuration
@Profile("test") //Informar que é exclusiva de teste, o nome tem que ser igual ao definido no arquivo de propriedades
public class TestConfig implements CommandLineRunner{
	
	@Autowired //Injeta com facilidade as dependencia
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// Esse método é responsável por executar qdo a aplicação for iniciada
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Chama os dados e passa a lista de objetos para salvar no BD
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		
	}

}
