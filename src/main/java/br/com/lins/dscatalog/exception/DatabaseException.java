package br.com.lins.dscatalog.exception;

public class DatabaseException extends RuntimeException{

	private static final long serialVersionUID = -4838068743404990615L;

	public DatabaseException(String mensagem) {
		super(mensagem);
	}
}
