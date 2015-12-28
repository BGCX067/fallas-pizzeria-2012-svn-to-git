package pizzeria.empanadas;

import java.util.ArrayList;
import java.util.List;

import pizzeria.ingredientes.Ingrediente;

public class EmpanadaQuesoYCebolla extends Empanada {

	public EmpanadaQuesoYCebolla(double cantidadInicial) {
		super(cantidadInicial);
	}

	@Override
	public String getNombre() {
		return "Empanada de carne";
	}

	@Override
	public ArrayList<Ingrediente> getIngredientes() {
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente(Ingrediente.MUZZARELLA, 20.0));
		ingredientes.add(new Ingrediente(Ingrediente.CEBOLLA, 20.0));
		return ingredientes;
	}

}
