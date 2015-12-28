package pizzeria.enums;

public enum Mes {
	
	ENERO(Estacion.VERANO),
	FEBRERO(Estacion.VERANO),
	MARZO(Estacion.VERANO),
	ABRIL(Estacion.OTONIO),
	MAYO(Estacion.OTONIO),
	JUNIO(Estacion.OTONIO),
	JULIO(Estacion.INVIERNO),
	AGOSTO(Estacion.INVIERNO),
	SEPTIEMBRE(Estacion.INVIERNO),
	OCTUBRE(Estacion.PRIMAVERA),
	NOVIEMBRE(Estacion.PRIMAVERA),
	DICIEMBRE(Estacion.PRIMAVERA);
	
	public Estacion estacion;
	
	private Mes(Estacion estacion){
		this.estacion = estacion;
	}

}
