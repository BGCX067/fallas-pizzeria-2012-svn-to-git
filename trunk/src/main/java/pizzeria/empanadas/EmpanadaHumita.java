package pizzeria.empanadas;

import java.util.ArrayList;
import java.util.List;

import pizzeria.ingredientes.Ingrediente;

public class EmpanadaHumita extends Empanada {

	public EmpanadaHumita(double cantidadInicial) {
		super(cantidadInicial);
	}

	@Override
	public String getNombre() {
		return "Empanada de carne";
	}

	@Override
	public ArrayList<Ingrediente> getIngredientes() {
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente(Ingrediente.CHOCLO, 20.0));
		ingredientes.add(new Ingrediente(Ingrediente.CREMA, 40.0));
		return ingredientes;
	}

}
