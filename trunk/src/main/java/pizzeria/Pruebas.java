package pizzeria;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import pizzeria.empanadas.EmpanadaCarne;
import pizzeria.empanadas.EmpanadaHumita;
import pizzeria.empanadas.EmpanadaQuesoYCebolla;
import pizzeria.enums.CapacidadHorno;
import pizzeria.enums.Competencia;
import pizzeria.enums.Mes;
import pizzeria.ingredientes.Ingrediente;
import pizzeria.pizzas.PizzaFugazzeta;
import pizzeria.pizzas.PizzaMuzzarella;
import pizzeria.pizzas.PizzaNapolitana;
import pizzeria.pizzas.TipoPizza;

public class Pruebas {
	
	@SuppressWarnings("restriction")
	static void resultadosIngredientes(List<ElementoVendible> elementos, WritableSheet s) throws Exception{
		Map<Ingrediente, Ingrediente> ingredientes = new HashMap<>(); 
		for (ElementoVendible elemento: elementos){			
			ElementoConIngredientes elementoConIngredientes = (ElementoConIngredientes) elemento;
			for (Ingrediente ingrediente: elementoConIngredientes.getTodosLosIngredientes()){				
				if (ingredientes.containsKey(ingrediente)){
					ingredientes.get(ingrediente).incrementarCantidad(ingrediente.getCantidad() * elemento.getCantidadDeVentas());					
				} else {
					ingredientes.put(ingrediente, new Ingrediente(ingrediente.getNombre(), ingrediente.getCantidad() * elemento.getCantidadDeVentas()));
				}
			}
		}
		
		/* Format the Font */
	    WritableFont wf = new WritableFont(WritableFont.ARIAL, 
	      10, WritableFont.BOLD);
	    WritableCellFormat cf = new WritableCellFormat(wf);
	    cf.setWrap(false);
	    
	    NumberFormat nf=new NumberFormat("#.##");        
	    WritableCellFormat cf2obj=new WritableCellFormat(nf);
	    s.addCell(new Label(0,0,"Ingrediente",cf));
	    s.addCell(new Label(1,0,"Cantidad",cf));
		int i = 1;		
		for (Ingrediente ingrediente: ingredientes.values()){
			s.addCell(new Label(0,i,ingrediente.getNombre()));			
			s.addCell(new Number(1,i,ingrediente.getCantidad(),cf2obj));
			i++;
		}
	}
	
	@SuppressWarnings("restriction")
	public static void main(String[] args) throws Exception {
		
		//Excel generation
		String filename = "resultado.xls";
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("es", "ES"));
		WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
		
		ejemploCompetenciaCaraHornoAlto(workbook);
		ejemploNuevaCompetenciaHornoBajo(workbook);
		ejemploNuevaCompetencia(workbook);
		ejemploPascuas(workbook);		
		ejemploFeriadoEnVerano(workbook);
		ejemploInvierno(workbook);
		ejemploVerano(workbook);
        
        //Close excel file
        workbook.write();
		workbook.close();
	}

	@SuppressWarnings("restriction")
	private static void ejemploInvierno(WritableWorkbook workbook)
			throws Exception {
		Contexto contexto = new Contexto();
		contexto.cambiarMes(Mes.JUNIO);
		ejecutarReglasEnContexto(workbook,"Ej Invierno",contexto);
	}
	
	@SuppressWarnings("restriction")
	private static void ejemploVerano(WritableWorkbook workbook)
			throws Exception {
		Contexto contexto = new Contexto();
		contexto.cambiarMes(Mes.ENERO);
		ejecutarReglasEnContexto(workbook,"Ej verano",contexto);
	}
	
	@SuppressWarnings("restriction")
	private static void ejemploFeriadoEnVerano(WritableWorkbook workbook)
			throws Exception {
		Contexto contexto = new Contexto();
		contexto.cambiarMes(Mes.ENERO);
		contexto.setAvecinaFeriado(true);
		ejecutarReglasEnContexto(workbook,"Ej feriado en verano",contexto);
	}
	
	@SuppressWarnings("restriction")
	private static void ejemploPascuas(WritableWorkbook workbook)
			throws Exception {
		Contexto contexto = new Contexto();
		contexto.cambiarMes(Mes.ABRIL);
		contexto.setAvecinaFeriado(true);
		contexto.setPascuas(true);
		ejecutarReglasEnContexto(workbook,"Ej Pascuas",contexto);
	}
	
	@SuppressWarnings("restriction")
	private static void ejemploNuevaCompetencia(WritableWorkbook workbook)
			throws Exception {
		Contexto contexto = new Contexto();
		contexto.cambiarMes(Mes.ABRIL);
		contexto.setCompetencia(Competencia.EN_PROMOCION);
		ejecutarReglasEnContexto(workbook,"Ej Competencia en promocion",contexto);
	}
	
	@SuppressWarnings("restriction")
	private static void ejemploNuevaCompetenciaHornoBajo(WritableWorkbook workbook)
			throws Exception {
		Contexto contexto = new Contexto();
		contexto.cambiarMes(Mes.ABRIL);
		contexto.setCompetencia(Competencia.EN_PROMOCION);
		contexto.setProduccionHorno(CapacidadHorno.BAJA);
		ejecutarReglasEnContexto(workbook,"Ej Competencia en promo y horno bajo",contexto);
	}
	
	@SuppressWarnings("restriction")
	private static void ejemploCompetenciaCaraHornoAlto(WritableWorkbook workbook)
			throws Exception {
		Contexto contexto = new Contexto();
		contexto.cambiarMes(Mes.ABRIL);
		contexto.setCompetencia(Competencia.MAS_CARO);
		contexto.setProduccionHorno(CapacidadHorno.ALTA);
		ejecutarReglasEnContexto(workbook,"Ej Competencia cara y horno alto",contexto);
	}

	@SuppressWarnings("restriction")
	private static void ejecutarReglasEnContexto(WritableWorkbook workbook, String sheetName, Contexto contexto)
			throws Exception {
		WritableSheet s = workbook.createSheet(sheetName, 0);
		
		//Knoledge ussage
		KnowledgeBase kbase = readKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
        // go !
        List<ElementoVendible> elementos = new ArrayList<>();
        elementos.add(new PizzaMuzzarella(10, TipoPizza.GRANDE));
        elementos.add(new PizzaMuzzarella(4, TipoPizza.CHICA));
        elementos.add(new PizzaFugazzeta(7, TipoPizza.RELLENA));
        elementos.add(new PizzaFugazzeta(2, TipoPizza.CHICA));
        elementos.add(new PizzaNapolitana(5, TipoPizza.GRANDE));
        elementos.add(new PizzaNapolitana(2, TipoPizza.CHICA));
        elementos.add(new EmpanadaCarne(40));
        elementos.add(new EmpanadaHumita(20));
        elementos.add(new EmpanadaQuesoYCebolla(20));
        
        for (ElementoVendible elemento: elementos){
        	ksession.insert(elemento);
        }       
        
		ksession.insert(contexto);
        
        ksession.fireAllRules();
        logger.close();
        
        resultadosIngredientes(elementos,s);
	}
	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("reglas.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

}
