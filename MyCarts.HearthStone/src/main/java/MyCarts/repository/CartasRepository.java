package MyCarts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import MyCarts.orm.Cartas;
import MyCarts.orm.Classe;
import MyCarts.orm.Tipo;


@Repository
public interface CartasRepository  extends CrudRepository<Cartas, Integer>  {

	List<Cartas> findByNome(String nome);
	Optional<Cartas> findById(Integer id);
	List<Cartas> findByClasse(Classe classe);
	List<Cartas> findByTipo(Tipo tipo);
	//Optional<Cartas> findByAllNome(String nome);
}
