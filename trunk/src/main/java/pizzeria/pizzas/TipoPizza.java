package pizzeria.pizzas;

public enum TipoPizza {
	
	CHICA(0.5, 250.0),
	GRANDE(0.8, 400.0),
	RELLENA(1.0, 600.0);
	
	public double multiplicadorIngrediente;
	public double cantidadDeHarina;
	
	private TipoPizza(double multiplicadorIngrediente, double cantidadDeHarina) {
		this.multiplicadorIngrediente = multiplicadorIngrediente;
		this.cantidadDeHarina = cantidadDeHarina;
	}

}
