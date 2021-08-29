package MyCarts.orm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cartas")
public class Cartas {

	public Cartas() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column
	Integer id;
	@Column
	@NotBlank(message = "Escreva o nome da carta.")
	String nome;
	@Column
	@NotBlank(message = "Escreva a descrição da carta.")
	String descricao;
	@Column
	@NotNull(message = "Defina o ataque da carta entre 0 e 10.")
	@Min(0)
	@Max(10)
	int ataque;
	@Column
	@NotNull(message = "Defina a defesa da carta entre 0 e 10.")
	@Min(0)
	@Max(10)
	int defesa;
	@Column
	@NotNull(message = "Defina o tipo da carta entre Magia ou Criatura")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Column
	@NotNull(message = "Defina a classe da carta entre Mago, Paladino, Caçador, Druida e Qualquer")
	@Enumerated(EnumType.STRING)
	private Classe classe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
