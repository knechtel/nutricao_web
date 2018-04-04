package br.com.nutricao;

import javax.inject.Named;

@Named("usuario")
public class Usuario {
	
	private String testando;

	public String getTestando() {
		return testando;
	}

	public void setTestando(String testando) {
		this.testando = testando;
	}



}
