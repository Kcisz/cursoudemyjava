/**
 * 
 */
package cursoudemyjava.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="categorias")
public class CategoriaResources {
	
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping(name="categorias")
	public String listar() {
		return "Rest esta funcionando";
	}
	

}
