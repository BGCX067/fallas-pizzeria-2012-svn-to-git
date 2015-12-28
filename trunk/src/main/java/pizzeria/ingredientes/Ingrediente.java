package pizzeria.ingredientes;

public class Ingrediente implements Cloneable {
	
	public static final String HARINA = "Harina";
	public static final String CARNE_PICADA = "Carne picada";
	public static final String MUZZARELLA = "Muzzarella";
	public static final String CEBOLLA = "Cebolla";
	public static final String CHOCLO = "Choclo";
	public static final String CREMA = "Crema";
	public static final String AGUA = "Agua";
	public static final String LEVADURA = "Levadura";
	public static final String SALSA_DE_TOMATE = "Salsa de tomate";
	public static final String TOMATE = "Tomate";
	public static final String JAMON = "Jamon";
	
	private double cantidad;
	private String nombre;
	
	public Ingrediente(String nombre, double cantidadInicial){
		this.nombre = nombre;
		this.cantidad = cantidadInicial;
	}
	
	public double getCantidad(){ return cantidad; }
	public void setCantidad(double cantidad){ this.cantidad = cantidad; }
	public void incrementarCantidad(double cantidadAIncrementar){ this.cantidad += cantidadAIncrementar; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Ingrediente(this.nombre, this.cantidad);
	}
	
	@Override
	public String toString() {		
		return this.nombre + " \t\t" + this.cantidad;
	}

	public String getNombre() {
		return this.nombre;
	}
	
}