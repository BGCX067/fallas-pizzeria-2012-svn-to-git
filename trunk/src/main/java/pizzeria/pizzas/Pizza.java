package pizzeria.pizzas;

import java.util.ArrayList;
import java.util.List;

import pizzeria.ElementoConIngredientes;
import pizzeria.ElementoVendible;
import pizzeria.ingredientes.Ingrediente;

public abstract class Pizza extends ElementoVendible implements ElementoConIngredientes{
	
	private Ingrediente agua;
	private Ingrediente levadura;
	private Ingrediente harina;
	private TipoPizza tipo;
	
	
	public Pizza(double cantidadInicial, TipoPizza tipo) {
		super(cantidadInicial);
		this.agua = new Ingrediente(Ingrediente.AGUA, 10.0 * tipo.multiplicadorIngrediente);
		this.levadura = new Ingrediente(Ingrediente.LEVADURA, 100.0 * tipo.multiplicadorIngrediente);		
		this.harina = new Ingrediente(Ingrediente.HARINA,tipo.cantidadDeHarina);
		this.tipo = tipo;
	}
	
	public abstract String getNombre();
	public abstract ArrayList<Ingrediente> getIngredientes();
	
	
	public double getCantidadHarina() {
		return harina.getCantidad();
	}
	
	public void setCantidadHarina(double cantidadHarina) {
		this.harina.setCantidad(cantidadHarina);
	}
	
	public double getCantidadDeAgua() {
		return agua.getCantidad();
	}
	public void setCantidadDeAgua(double cantidadDeAgua) {
		this.agua.setCantidad(cantidadDeAgua);
	}
	public double getCantidadDeLevadura() {
		return levadura.getCantidad();
	}
	public void setCantidadDeLevadura(double cantidadDeLevadura) {
		this.levadura.setCantidad(cantidadDeLevadura);
	}
	
	public TipoPizza getTipo(){
		return this.tipo;
	}
	
	@Override
	public List<Ingrediente> getTodosLosIngredientes() {
		List<Ingrediente> ingredientes = (List<Ingrediente>) getIngredientes().clone();
		ingredientes.add(harina);
		ingredientes.add(agua);
		ingredientes.add(levadura);
		return ingredientes;
	}
	
	@Override
	public String toString() {		
		return getNombre() + ": " + getCantidadDeVentas();
	}

}
