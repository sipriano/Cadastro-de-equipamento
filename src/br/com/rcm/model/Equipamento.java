package br.com.rcm.model;

public class Equipamento {

	private int id;
	private String nome;
	private String tipo;
	private float peso;
	
	public Equipamento(){
		
	}
	public Equipamento(int id){
		this.setId(id);
	}
	public Equipamento(int id, String nome, String tipo, float peso){
		this.setId(id);
		this.setNome(nome);
		this.setTipo(tipo);
		this.setPeso(peso);
	}
	public Equipamento(String nome, String tipo, float peso){
		this.setNome(nome);
		this.setTipo(tipo);
		this.setPeso(peso);
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return nome;
	}

}
