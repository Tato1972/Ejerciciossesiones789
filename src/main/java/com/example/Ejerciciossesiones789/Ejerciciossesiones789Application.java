package com.example.Ejerciciossesiones789;

import com.example.Ejerciciossesiones789.entities.Laptop;
import com.example.Ejerciciossesiones789.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
public class Ejerciciossesiones789Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejerciciossesiones789Application.class, args);
		//HelloController hola = context.getBean(HelloController.class);
		//System.out.println(hola);

		LaptopRepository repository = context.getBean(LaptopRepository.class);
		System.out.println(repository);

		//crear laptop

		Laptop laptop1 = new Laptop(null, "Apple", "MacBook Air",2000.00, 8, "core i7");
		Laptop laptop2 = new Laptop(null, "Lenovo", "ThinkPad T15",1500.40, 16, "core i7");
		Laptop laptop3 = new Laptop(null, "Lenovo", "IdealPad 5i",1000.40, 4, "core i3");

		//Guardar en BD
		System.out.println("Cantidad Laptops: " + repository.findAll().size());

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);

		//Recuperar datos BD

		System.out.println("Cantidad Laptops: " + repository.findAll().size());
	}

}
