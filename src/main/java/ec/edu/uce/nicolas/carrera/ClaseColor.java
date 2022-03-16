package ec.edu.uce.nicolas.carrera;

public class ClaseColor {

	private int rojo;
	private int verde;
	private int azul;
	
	public ClaseColor() {
		// TODO Auto-generated constructor stub
	}
	
	public ClaseColor(int rojo, int verde, int azul) {
		super();
		this.rojo = rojo;
		this.verde = verde;
		this.azul = azul;
	}
	
	public ClaseColor combinarColores(ClaseColor color) {
		return new ClaseColor(sumar(this.rojo, color.rojo), sumar(this.verde, color.verde), sumar(this.azul, color.azul));
	}

	private int sumar(int a, int b) {
		if (a + b <= 255) 
			return a + b;
		else
			return 255;
	}
	
	@Override
	public String toString() {
		return "ClaseColor [rojo=" + rojo + ", verde=" + verde + ", azul=" + azul + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaseColor other = (ClaseColor) obj;
		if (azul != other.azul)
			return false;
		if (rojo != other.rojo)
			return false;
		if (verde != other.verde)
			return false;
		return true;
	}
	
}
