package pizzeria.pizzas;

import java.util.ArrayList;

import pizzeria.ingredientes.Ingrediente;

public class PizzaNapolitana extends Pizza {

	public PizzaNapolitana(double cantidadInicial, TipoPizza tipo) {
		super(cantidadInicial, tipo);
	}

	@Override
	public String getNombre() {
		return "Pizza Napolitana";
	}

	@Override
	public ArrayList<Ingrediente> getIngredientes() {		
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente(Ingrediente.TOMATE, 200.0 * getTipo().multiplicadorIngrediente));
		ingredientes.add(new Ingrediente(Ingrediente.MUZZARELLA, 250.0 * getTipo().multiplicadorIngrediente));
		ingredientes.add(new Ingrediente(Ingrediente.JAMON, 200.0 * getTipo().multiplicadorIngrediente));
		return ingredientes;
	}

}
