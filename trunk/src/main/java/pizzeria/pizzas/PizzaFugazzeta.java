package pizzeria.pizzas;

import java.util.ArrayList;

import pizzeria.ingredientes.Ingrediente;

public class PizzaFugazzeta extends Pizza{

	public PizzaFugazzeta(double cantidadInicial, TipoPizza tipo) {
		super(cantidadInicial, tipo);
	}

	@Override
	public String getNombre() {
		return "Pizza de fugazzeta";
	}

	@Override
	public ArrayList<Ingrediente> getIngredientes() {
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente(Ingrediente.CEBOLLA, 200.0 * getTipo().multiplicadorIngrediente));
		ingredientes.add(new Ingrediente(Ingrediente.MUZZARELLA, 250.0 * getTipo().multiplicadorIngrediente));
		return ingredientes;
	}

}
