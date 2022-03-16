package ec.edu.uce.modelo.js;

public class Contexto {

	public String input;
	public Contexto(String input) {
		this.input=input;
	}
	
	public String getBinaryForm(String input) {
		int i=Integer.parseInt(input);
		String binaryString=Integer.toBinaryString(i);
		return binaryString;
				
	}
	
	public String imprimirEnPalabras(String input) {
		this.input=input;
		
		
		String c=input.toString();
		String palabra="";
		
		for(int i=0;i<c.length();i++) {
			char cadena []=new char [c.length()];
			cadena[i]=c.charAt(i);
			switch(cadena[i]) {
			
			case '0':
				
				palabra="cero";
				break;
			case '1':
				
				palabra="uno";
				break;
			case '2':
				
				palabra="dos";
				break;
			case '3':
				
				palabra="tres";
				break;
			case '4':
			
				palabra="cuator";
				break;
			case '5':
				
				palabra="cinco";
				break;
			case '6':
				
				palabra="seis";
				break;
			case '7':
				
				palabra="siete";
				break;
			case '8':
				
				palabra="ocho";
				break;
			case '9':
				
				palabra="nueve";
				break;
			default:
				System.out.println("no es un numero");
				break;
			
			}
		}
		
		return palabra;
	}
}
