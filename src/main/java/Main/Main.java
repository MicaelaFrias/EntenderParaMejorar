package Main;

import java.util.ArrayList;
import java.util.Random;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import AggregatesModels.ConstanteMultiplicativaTransporteCotidiano;
import AggregatesModels.ConstanteMultiplicativaTransporteLargaDistancia;
import AggregatesModels.RecorridoTransporteCotidiano;
import AggregatesModels.RecorridoTransporteLargaDistancia;
import Enums.GestionResiduosEnum;
import Enums.TipoAlimentacionEnum;
import Models.HuellaCarbonoModel;
import Models.IndicadoresEmisionCO2DirectosModel;
import Models.IndicadoresEmisionCO2IndirectosModel;
import Models.PlanReduccionModel;
import Utils.KnowledgeSessionHelper;

;
public class Main {

	public static void main(String[] args) {
		KieContainer container = KnowledgeSessionHelper.createRuleBase();
		String sessionName = "ksesion-entender-para-mejorar-rules";
		KieSession session = KnowledgeSessionHelper
				.getStatefulKnowledgeSession(container, sessionName);

		// insertar datos en la base de hechos
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

		session.insert(huellaCarbono);
		session.fireAllRules();

		// mostramos las huellas a analizar
		indicadoresIndirectos = huellaCarbono
				.getIndicadoresEmisionCO2Indirectos();
		indicadoresDirectos = huellaCarbono
				.getIndicadoresEmisionCO2Directos();
		PlanReduccionModel planReduccion = huellaCarbono.getPlanReduccion();
		System.out.println("Cantidad de CO2 emitido por el individuo: "
				+ huellaCarbono.getCantidadCO2Emitido());
		System.out.println("Indicadores Directos");
		System.out.println("Cantidad de CO2 emitido directamente: "
				+ indicadoresDirectos.getTotalCO2EmitidoDirectamente());
		System.out.println("Indicadores Indirectos: ");
		System.out.println("Cantidad de CO2 emitido indirectamente: "
				+ indicadoresIndirectos.getTotalCO2EmitidoIndirectamente());
		System.out.println("Gestión de residuos: "
				+ indicadoresIndirectos.getGestionResiduos().toString());
		System.out.println(indicadoresIndirectos.getGestionResiduos().toString());
		System.out.println("Alimentación: "
				+ indicadoresIndirectos.getTipoalimentacion().toString());
		System.out.println("Consumo de garrafa: "
				+ indicadoresIndirectos.getConsumoGarrafa());
		System.out.println("Consumo de gas máximo: "
				+ indicadoresIndirectos.getConsumoGarrafa());
		System.out.println("Consumo de eléctrico máximo: "
				+ indicadoresIndirectos.getConsumoEléctricoMaximo());
		System.out.println("Consumo de internet: "
				+ indicadoresIndirectos.getConsumoInternet());
		System.out.println("Plan de reducción: ");
		System.out.println("Impacto del individuo: "
				+ planReduccion.getImpactIndividuoEmisor().toString());
		System.out.println("Plan de hábitos a mejorar: "
				+ planReduccion.getPlanHabitosMejorar().toString());
	}
}
