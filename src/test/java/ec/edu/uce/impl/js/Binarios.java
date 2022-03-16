package ec.edu.uce.impl.js;

import ec.edu.uce.interfaz.js.IExpresion;
import ec.edu.uce.modelo.js.Contexto;

public class Binarios implements IExpresion {

	private String s;

	public Binarios() {
		
	}
	
	public Binarios(String s) {
		this.s=s;
		
	}

	@Override
	public String interprete(Contexto contexto) {
		// TODO Auto-generated method stub
		 return contexto.getBinaryForm(s);
	}

}
