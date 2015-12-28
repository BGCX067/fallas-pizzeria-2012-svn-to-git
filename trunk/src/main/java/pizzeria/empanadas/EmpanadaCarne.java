package pizzeria.empanadas;

import java.util.ArrayList;
import java.util.List;

import pizzeria.ingredientes.Ingrediente;

public class EmpanadaCarne extends Empanada {

	public EmpanadaCarne(double cantidadInicial) {
		super(cantidadInicial);
	}

	@Override
	public String getNombre() {
		return "Empanada de carne";
	}

	@Override
	public ArrayList<Ingrediente> getIngredientes() {
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente(Ingrediente.CARNE_PICADA, 100.0));
		return ingredientes;
	}

}
