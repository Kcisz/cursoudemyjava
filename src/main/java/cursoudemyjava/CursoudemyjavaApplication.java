package cursoudemyjava;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cursoudemyjava.domain.Categoria;
import cursoudemyjava.domain.Cidade;
import cursoudemyjava.domain.Cliente;
import cursoudemyjava.domain.Endereco;
import cursoudemyjava.domain.Estado;
import cursoudemyjava.domain.Pagamento;
import cursoudemyjava.domain.PagamentoComBoleto;
import cursoudemyjava.domain.PagamentoComCartao;
import cursoudemyjava.domain.Pedido;
import cursoudemyjava.domain.Produto;
import cursoudemyjava.domain.enums.EstadoPagamento;
import cursoudemyjava.domain.enums.TipoCliente;
import cursoudemyjava.repositories.CategoriaRepository;
import cursoudemyjava.repositories.CidadeRepository;
import cursoudemyjava.repositories.ClienteRepository;
import cursoudemyjava.repositories.EnderecoRepository;
import cursoudemyjava.repositories.EstadoRepository;
import cursoudemyjava.repositories.PagamentoRepository;
import cursoudemyjava.repositories.PedidoRepository;
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
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

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

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "Maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93839393"));

		Endereco e1 = new Endereco(null, "Rua flores", "300", "apt 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 208", "Centro", "79852369", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("13/09/2024 21:50"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("13/09/2024 21:30"), cli1, e2);
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);

		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("12/09/2024 20:23"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
		
	}

}
