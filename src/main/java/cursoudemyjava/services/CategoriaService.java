package cursoudemyjava.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoudemyjava.domain.Categoria;
import cursoudemyjava.exception.ObjectNotFoundException;
import cursoudemyjava.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepositoy;

	public Categoria buscar(Integer id) {

		Optional<Categoria> obj = categoriaRepositoy.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
