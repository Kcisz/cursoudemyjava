package cursoudemyjava.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoudemyjava.domain.Pedido;
import cursoudemyjava.exception.ObjectNotFoundException;
import cursoudemyjava.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscar(Integer id) {

		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
