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

import cursoudemyjava.domain.Pedido;
import cursoudemyjava.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {
	@Autowired
	private PedidoService service;

//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping(value = "/{id}", name = "pedidos/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Pedido obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);

	}

}
