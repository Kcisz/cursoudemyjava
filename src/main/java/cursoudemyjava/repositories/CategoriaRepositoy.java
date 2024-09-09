package cursoudemyjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cursoudemyjava.domain.Categoria;

@Repository
public interface CategoriaRepositoy extends JpaRepository<Categoria, Integer> {

}
