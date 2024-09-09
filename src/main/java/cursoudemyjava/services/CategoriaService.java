package cursoudemyjava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoudemyjava.domain.Categoria;
import cursoudemyjava.repositories.CategoriaRepositoy;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositoy categoriaRepositoy;

	public Categoria buscar(Integer id) {

		Optional<Categoria> obj = categoriaRepositoy.findById(id);
		return obj.orElse(null);

	}
}
