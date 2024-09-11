package cursoudemyjava.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoudemyjava.domain.Cliente;
import cursoudemyjava.exception.ObjectNotFoundException;
import cursoudemyjava.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository categoriaRepositoy;

	public Cliente buscar(Integer id) {

		Optional<Cliente> obj = categoriaRepositoy.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
