package br.com.project.util.all;

public enum EstatusPersistencia {

	ERRO("erro"), SUCESSO("sucesso"), OBJETO_REFERENCIADO(
			"Esse objeto nãp pode ser apagado por possuir referencias ao mesmo");

	private String name;

	private EstatusPersistencia(String s) {
		this.name = s;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
