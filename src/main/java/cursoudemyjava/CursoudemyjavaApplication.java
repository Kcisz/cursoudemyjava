package cursoudemyjava;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cursoudemyjava.domain.Categoria;
import cursoudemyjava.repositories.CategoriaRepositoy;

@SpringBootApplication
public class CursoudemyjavaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositoy categoriaRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(CursoudemyjavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");

		categoriaRepositoy.saveAll(Arrays.asList(cat1, cat2));

	}

}
