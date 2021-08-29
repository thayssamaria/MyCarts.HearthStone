package MyCarts.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import MyCarts.orm.Cartas;
import MyCarts.orm.Classe;
import MyCarts.orm.Tipo;
import MyCarts.repository.CartasRepository;

@RestController
public class CartasController {

	@Autowired
	private CartasRepository repo;

	public CartasController() {
		// TODO Auto-generated constructor stub
	}

	// CONSULTAR POR ID
	@GetMapping(path = "/carta/consultarid/{id}")
	public ResponseEntity consultarId(@PathVariable("id") Integer id) {
		return repo.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	// CONSULTAR POR NOME
	@GetMapping(path = "/carta/consultarnome/{nome}")
	public List<Cartas> consultarNome(@PathVariable("nome") String nome) {
return repo.findByNome(nome);
	}

	// CONSULTAR POR CLASSE
	@GetMapping(path = "/carta/consultarclasse/{classe}")
	public List<Cartas> consultarClasse(@PathVariable("classe") Classe classe) {
		return repo.findByClasse(classe);
	}

	// CONSULTAR POR TIPO
	@GetMapping(path = "/carta/consultartipo/{tipo}")
	public List<Cartas> consultarTipo(@PathVariable("tipo") Tipo tipo) {
		return repo.findByTipo(tipo);
	}

	// SALVAR CARTA NOVA
	@PostMapping(path = "/carta/cadastrar")
	public void salvar(@RequestBody @Valid Cartas carta) {

		switch (verificar(carta.getNome())) {
		case 0:
			System.out.println("O Baralho já possui o máximo de 30 cartas.");
			break;
		case 1:
			System.out.println("O Baralho já possui duas cartas iguais a esta.");
			break;
		case 2:
			repo.save(carta);
			System.out.println("Carta salva!");
		}

	}

	@DeleteMapping(path = "/carta/deletar/{id}")
	public void deletar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}

	public int verificar(String nome) {
		long cont = repo.count();
		List<Cartas> c = repo.findByNome(nome);
		int mens;
		if (cont >= 30) {
			return 0;
		} else {
			if (c.stream().count() >= 2) {
				return 1;
			}
			return 2;

		}
		
		

	}

}
