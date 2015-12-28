package pizzeria;

import pizzeria.enums.*;

public class Contexto {
	
	private Mes mesActual = Mes.ENERO;
	private boolean avecinaFeriado = false;
	private boolean pascuas = false;
	private CapacidadHorno capacidadHorno = CapacidadHorno.ALTA;
	private Competencia competencia = Competencia.IGUAL_PRECIO;
	
	public Estacion getEstacion() {
		return mesActual.estacion;
	}
	
	public void cambiarMes(Mes nuevoMes) {
		this.mesActual = nuevoMes;
	}
	
	public void setAvecinaFeriado(boolean avecinaFeriado) {
		this.avecinaFeriado = avecinaFeriado;
	}
	
	public boolean getAvecinaFeriado() {
		return avecinaFeriado;
	}
	
	public boolean getPascuas(){
		return this.pascuas;
	}
	
	public void setPascuas(boolean pascuas) {
		this.pascuas = pascuas;
	}

	public void cambioPreciosCompetencia(Competencia preciosCompetencia) {
		this.competencia = preciosCompetencia;
	}

	public void setProduccionHorno(CapacidadHorno capacidad) {
		this.capacidadHorno = capacidad;
	}

	public CapacidadHorno getCapacidadHorno() {
		return capacidadHorno;
	}

	public void setCapacidadHorno(CapacidadHorno capacidadHorno) {
		this.capacidadHorno = capacidadHorno;
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}	

}
