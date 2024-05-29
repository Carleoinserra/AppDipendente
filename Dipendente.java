package com.example.demo;

public class Dipendente {
	String nome;
	String cognome;
	String mansione;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	@Override
	public String toString() {
		return "Dipendente [nome=" + nome + ", cognome=" + cognome + ", mansione=" + mansione + "]";
	}
	
	
}
