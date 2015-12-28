package pizzeria.empanadas;

import java.util.ArrayList;
import java.util.List;

import pizzeria.ElementoConIngredientes;
import pizzeria.ElementoVendible;
import pizzeria.ingredientes.Ingrediente;

public abstract class Empanada extends ElementoVendible implements ElementoConIngredientes{
	
	private Ingrediente harina;
	
	public Empanada(double cantidadInicial){
		super(cantidadInicial);
		harina = new Ingrediente(Ingrediente.HARINA, 100.0);
	}
	
	public abstract String getNombre();
	public abstract ArrayList<Ingrediente> getIngredientes();
	
	public double getCantidadHarina(){
		return harina.getCantidad();
	}
	
	@Override
	public List<Ingrediente> getTodosLosIngredientes() {
		List<Ingrediente> ingredientes = (List<Ingrediente>) getIngredientes().clone();
		ingredientes.add(harina);
		return ingredientes;
	}
	
	@Override
	public String toString() {		
		return getNombre() + ": " + getCantidadDeVentas();
	}

}
