package pizzeria.pizzas;

import java.util.ArrayList;

import pizzeria.ingredientes.Ingrediente;

public class PizzaMuzzarella extends Pizza{

	public PizzaMuzzarella(double cantidadInicial, TipoPizza tipo) {
		super(cantidadInicial, tipo);
	}

	@Override
	public String getNombre() {
		return "Pizza de Muzzarella";
	}

	@Override
	public ArrayList<Ingrediente> getIngredientes() {		
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente(Ingrediente.SALSA_DE_TOMATE, 200.0 * getTipo().multiplicadorIngrediente));
		ingredientes.add(new Ingrediente(Ingrediente.MUZZARELLA, 250.0 * getTipo().multiplicadorIngrediente));
		return ingredientes;
	}

}
