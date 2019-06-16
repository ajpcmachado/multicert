package pt.multicert.client.api.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for client table
 * @author artur
 *
 */
@Table(name = "CLIENT")
@Entity
public class Client{

	public Client() {
		super();
	}

	public Client(Long id, String nome, String nif, String morada, String telefone) {
		setId(id);
		setNome(nome);
		setNif(nif);
		setMorada(morada);
		setTelefone(telefone);
	}

	
	@Id
	@Column(name = "ID", nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "NOME", nullable=false)
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "NIF", nullable=false)
	private String nif;

	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	@Column(name = "MORADA", nullable=false)
	private String morada;

	public String getMorada() {
		return morada;
	}
	
	public void setMorada(String morada) {
		this.morada = morada;
	}
	
	@Column(name = "TELEFONE", nullable=false)
	private String telefone;

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
