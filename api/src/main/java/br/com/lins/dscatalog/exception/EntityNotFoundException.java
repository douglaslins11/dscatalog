package br.com.lins.dscatalog.exception;

public class EntityNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4838068743404990615L;
	
	public EntityNotFoundException (String mensagem) {
		super(mensagem);
	}

}
