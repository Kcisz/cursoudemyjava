/**
 * 
 */
package cursoudemyjava.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursoudemyjava.domain.Categoria;
import cursoudemyjava.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
	@Autowired
	private CategoriaService service;

//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping(value = "/{id}", name = "categorias/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Categoria obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);

	}

}
