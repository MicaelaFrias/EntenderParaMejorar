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
import Enums.PlanHabitosMejorarEnum;
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

		sessionStatefull = KnowledgeSessionHelper
				.getStatefulKnowledgeSessionWithCallback(kieContainer,
						K_SESSION_NAME);
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

	// TEST CASES
	@Test
	public void CantidadCO2AlimentacionOmnivora() {
		print("Caso de prueba Cantidad CO2 Alimentacion Omnivora:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos()
				.getCantidadCO2TipoAlimentacion() == 2.28);
	}

	@Test
	public void CantidadCO2Compost() {
		print("Caso de prueba Cantidad CO2 al gestionar residuos por compost:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.Compost, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos()
				.getCantidadCO2GestionResiduos() == 0.8);
	}

	@Test
	public void CantidadCO2SepararResiduos() {
		print("Caso de prueba Cantidad CO2 al gestionar residuos por separar residuos:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.SeparaResiduos, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos()
				.getCantidadCO2GestionResiduos() == 1.4);
	}

	@Test
	public void CantidadCO2NoHaceNada() {
		print("Caso de prueba Cantidad CO2 al gestionar residuos por no hacer nada:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos()
				.getCantidadCO2GestionResiduos() == 2.1);
	}

	@Test
	public void CantidadCO2AlimentacionVegetariana() {
		print("Caso de prueba Cantidad CO2 Alimentacion vegetariana:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Vegetariana,
				GestionResiduosEnum.NoHaceNada, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos()
				.getCantidadCO2TipoAlimentacion() == 1.58);
	}

	@Test
	public void CantidadCO2AlimentacionVegana() {
		print("Caso de prueba alimentación vegana:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Vegana,
				GestionResiduosEnum.NoHaceNada, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos()
				.getCantidadCO2TipoAlimentacion() == 1.13);
	}

	@Test
	public void CantidadCO2AlimentacionPescetariana() {
		print("Caso de prueba alimentación pescetariana:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Pescetariana,
				GestionResiduosEnum.NoHaceNada, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getIndicadoresEmisionCO2Indirectos()
				.getCantidadCO2TipoAlimentacion() == 1.66);
	}

	@Test
	public void PlanBajoImpacto() {
		print("Caso de prueba plan bajo impacto:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);
		assertTrue(huellaCarbono.getPlanReduccion().getPlanHabitosMejorar() == PlanHabitosMejorarEnum.BajoImpacto);
	}

	@Test
	public void PlanMedioImpacto() {
		print("Caso de prueba plan bajo impacto:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 100, 100);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				2000, 2000, 2000, 2000, 2000, 2000);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				2000, 2000, 2000);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getPlanReduccion().getPlanHabitosMejorar() == PlanHabitosMejorarEnum.MedioImpacto);
	}

	@Test
	public void PlanAltoImpacto() {
		print("Caso de prueba plan bajo impacto:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 1000, 1000);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				2000, 2000, 2000, 2000, 2000, 2000);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				2000, 2000, 2000);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getPlanReduccion().getPlanHabitosMejorar() == PlanHabitosMejorarEnum.AltoImpacto);
	}

	@Test
	public void ImpactoEmisorBajo() {
		print("Caso de prueba impacto bajo del emisor:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 10, 8);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				0, 0, 200, 0, 0, 0);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				0, 2000, 0);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getPlanReduccion().getImpactIndividuoEmisor() == ImpactoIndividuoEmisorEnum.Bajo);
	}

	@Test
	public void ImpactoEmisorMedio() {
		print("Caso de prueba impacto medio del emisor:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 100, 100);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				2000, 2000, 2000, 2000, 2000, 2000);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				2000, 2000, 2000);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getPlanReduccion().getImpactIndividuoEmisor() == ImpactoIndividuoEmisorEnum.Medio);
	}

	@Test
	public void ImpactoEmisorAlto() {
		print("Caso de prueba impacto alto del emisor:");

		// indicadores indirectos
		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = new IndicadoresEmisionCO2IndirectosModel(
				200, TipoAlimentacionEnum.Omnivora,
				GestionResiduosEnum.NoHaceNada, 200, 1000, 1000);

		// indicadores directos
		RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(
				2000, 2000, 2000, 2000, 2000, 2000);
		RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(
				2000, 2000, 2000);

		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = new IndicadoresEmisionCO2DirectosModel(
				recorridoCotidiano,
				new ConstanteMultiplicativaTransporteCotidiano(),
				recorridoLargaDistancia,
				new ConstanteMultiplicativaTransporteLargaDistancia());

		// huella de carbono
		HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(
				new Random().nextInt(50), indicadoresDirectos,
				indicadoresIndirectos);
		sessionStatefull.insert(huellaCarbono);
		sessionStatefull.fireAllRules();
		print(huellaCarbono);

		assertTrue(huellaCarbono.getPlanReduccion().getImpactIndividuoEmisor() == ImpactoIndividuoEmisorEnum.Alto);
	}

	// UTILITIES
	public static void print(String title) {
		System.out.println(title);
	}

	public static void print() {
		print("");
	}

	public static void print(HuellaCarbonoModel huellaCarbono) {

		IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos = huellaCarbono
				.getIndicadoresEmisionCO2Indirectos();
		IndicadoresEmisionCO2DirectosModel indicadoresDirectos = huellaCarbono
				.getIndicadoresEmisionCO2Directos();
		PlanReduccionModel planReduccion = huellaCarbono.getPlanReduccion();
		print();
		print("Cantidad de CO2 emitido por el individuo: "
				+ huellaCarbono.getCantidadCO2Emitido());
		print("Indicadores Directos");
		print("Cantidad de CO2 emitido directamente: "
				+ indicadoresDirectos.getTotalCO2EmitidoDirectamente());
		print("Indicadores Indirectos: ");
		print("Cantidad de CO2 emitido indirectamente: "
				+ indicadoresIndirectos.getTotalCO2EmitidoIndirectamente());
		print("Gestión de residuos: "
				+ indicadoresIndirectos.getGestionResiduos().toString());
		print(indicadoresIndirectos.getGestionResiduos().toString());
		print("Alimentación: "
				+ indicadoresIndirectos.getTipoalimentacion().toString());
		print("Consumo de garrafa: "
				+ indicadoresIndirectos.getConsumoGarrafa());
		print("Consumo de gas máximo: "
				+ indicadoresIndirectos.getConsumoGarrafa());
		print("Consumo de eléctrico máximo: "
				+ indicadoresIndirectos.getConsumoEléctricoMaximo());
		print("Consumo de internet: "
				+ indicadoresIndirectos.getConsumoInternet());
		print("Plan de reducción: ");
		print("Impacto del individuo: "
				+ planReduccion.getImpactIndividuoEmisor().toString());
		print("Plan de hábitos a mejorar: "
				+ planReduccion.getPlanHabitosMejorar().toString());

		print();
	}
}
