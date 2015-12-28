package pizzeria;

public abstract class ElementoVendible {
	
	private double cantidadDeVentas;
	
	public ElementoVendible(double cantidadInicial){
		this.cantidadDeVentas = cantidadInicial;
	}
	
	public double getCantidadDeVentas() {
		return cantidadDeVentas;
	}
	
	public void setCantidadDeVentas(double cantidadDeVentas) {
		this.cantidadDeVentas = cantidadDeVentas;
	}
	
	public void incrementarVentas(double porcentaje){
		cantidadDeVentas = cantidadDeVentas+(cantidadDeVentas*porcentaje / 100.0);
	}

}
