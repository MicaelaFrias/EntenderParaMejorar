package Utils;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import AggregatesModels.ConstanteMultiplicativaTransporteCotidiano;
import AggregatesModels.ConstanteMultiplicativaTransporteLargaDistancia;
import AggregatesModels.RecorridoTransporteCotidiano;
import AggregatesModels.RecorridoTransporteLargaDistancia;
import Enums.GestionResiduosEnum;
import Enums.ImpactoIndividuoEmisorEnum;
import Enums.TipoAlimentacionEnum;
import Models.HuellaCarbonoModel;
import Models.IndicadoresEmisionCO2DirectosModel;
import Models.IndicadoresEmisionCO2IndirectosModel;
import Models.PlanReduccionModel;

public class EmisionCO2TestCases {
	String K_SESSION_NAME = "ksesion-entender-para-mejorar-rules";

	KieSession sessionStatefull;
	static KieContainer kieContainer;
	

	public EmisionCO2TestCases() {
	}
		
	@BeforeClass
	public static void beforeallTestSetup() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	private void prepareKnowledgeSession() {
		
		
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
	}
	
	@Before
	public void setUp() {
		print("----------Start----------");
		print();
		this.prepareKnowledgeSession(); // Inicializa una nueva base de hechos
	}

	@After
	public void tearDown() {
		print();
		print("----------End----------");
		print();
	}
	
	//TEST CASES
	@Test
	public void AlimentacionOmnivora() {
		print("Caso de prueba alimentación omnivora:");
		
		//indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos =  new IndicadoresEmisionCO2IndirectosModel(200, 
				TipoAlimentacionEnum.Omnivora, GestionResiduosEnum.NoHaceNada, 200, 10, 8);
		
		//indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(0,0,200,0,0,0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(0,2000,0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos =  new IndicadoresEmisionCO2DirectosModel(recorridoCotidiano, 
				new ConstanteMultiplicativaTransporteCotidiano(), recorridoLargaDistancia, new ConstanteMultiplicativaTransporteLargaDistancia());
		
		//huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(new Random().nextInt(50), 
				indicadoresDirectos,indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);
		
		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos().getCantidadCO2TipoAlimentacion() == 2.28);
	}
	@Test
	public void ImpactoEmisorMedio() {
		print("Caso de prueba impacto medio del emisor:");
		
		//indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos =  new IndicadoresEmisionCO2IndirectosModel(200, 
				TipoAlimentacionEnum.Omnivora, GestionResiduosEnum.NoHaceNada, 200, 50, 10);
		
		//indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(2000,2000,2000,0,1500,0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(2000,2000,2000);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos =  new IndicadoresEmisionCO2DirectosModel(recorridoCotidiano, 
				new ConstanteMultiplicativaTransporteCotidiano(), recorridoLargaDistancia, new ConstanteMultiplicativaTransporteLargaDistancia());
		
		//huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(new Random().nextInt(50), 
				indicadoresDirectos,indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);
		
		assertTrue(huellaCarbono.getPlanReduccion().getImpactIndividuoEmisor() == ImpactoIndividuoEmisorEnum.Medio);
	}
	
	//UTILITIES
	public static void print(String title) {
		System.out.println(title);
	}

	public static void print() {
		print("");
	}

	public static void print(HuellaCarbonoModel huellaCarbono) {

		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = huellaCarbono.getIndicadoresEmisionCO2Indirectos();
		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = huellaCarbono.getIndicadoresEmisionCO2Directos();
		PlanReduccionModel planReduccion = huellaCarbono.getPlanReduccion();
		print();
		print("Cantidad de CO2 emitido por el individuo: " + huellaCarbono.getCantidadCO2Emitido());
		print("Indicadores Directos");
		print("Cantidad de CO2 emitido directamente: " + indicadoresDirectos.getTotalCO2EmitidoDirectamente());
		print("Indicadores Indirectos: ");
		print("Cantidad de CO2 emitido indirectamente: " + indicadoresIndirectos.getTotalCO2EmitidoIndirectamente());
		print("Gestión de residuos: " + indicadoresIndirectos.getGestionResiduos().toString());
		print(indicadoresIndirectos.getGestionResiduos().toString());
		print("Alimentación: " + indicadoresIndirectos.getTipoalimentacion().toString());
		print("Consumo de garrafa: " + indicadoresIndirectos.getConsumoGarrafa());
		print("Consumo de gas máximo: " + indicadoresIndirectos.getConsumoGarrafa());
		print("Consumo de eléctrico máximo: " + indicadoresIndirectos.getConsumoEléctricoMaximo());
		print("Consumo de internet: " + indicadoresIndirectos.getConsumoInternet());
		print("Plan de reducción: ");
		print("Impacto del individuo: " + planReduccion.getImpactIndividuoEmisor().toString());
		print("Plan de hábitos a mejorar: " + planReduccion.getPlanHabitosMejorar().toString());

		print();
	}
}
