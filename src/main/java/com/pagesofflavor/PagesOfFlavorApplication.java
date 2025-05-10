package com.pagesofflavor;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import com.pagesofflavor.models.Book;
import com.pagesofflavor.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class PagesOfFlavorApplication {

    public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
		SpringApplication.run(PagesOfFlavorApplication.class, args);
    }
	@Bean
	CommandLineRunner loadData(BookRepository repo) {
		return args -> {
			if (repo.count() == 0) {
				repo.save(new Book("desserts", "Delicious Desserts"));
				repo.save(new Book("starters", "Savory Starters"));
				repo.save(new Book("drinks", "Cool Drinks"));
			}
		};
	}

}
