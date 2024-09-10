package cursoudemyjava;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cursoudemyjava.domain.Categoria;
import cursoudemyjava.domain.Cidade;
import cursoudemyjava.domain.Estado;
import cursoudemyjava.domain.Produto;
import cursoudemyjava.repositories.CategoriaRepository;
import cursoudemyjava.repositories.CidadeRepository;
import cursoudemyjava.repositories.EstadoRepository;
import cursoudemyjava.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoudemyjavaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepositoy;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(CursoudemyjavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);

//		Associando produto a categoria
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

//		Associando categoria ao produto
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepositoy.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}
