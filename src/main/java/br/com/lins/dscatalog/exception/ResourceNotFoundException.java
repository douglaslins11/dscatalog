package br.com.lins.dscatalog.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4838068743404990615L;
	
	public ResourceNotFoundException(String mensagem) {
		super(mensagem);
	}
}
