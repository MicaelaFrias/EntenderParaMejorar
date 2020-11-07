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
import Models.IndicadoresEmisi�nCO2DirectosModel;
import Models.IndicadoresEmisi�nCO2IndirectosModel;
import Utils.KnowledgeSessionHelper;

;
public class Main {

	public static void main(String[] args) {
		KieContainer container = KnowledgeSessionHelper.createRuleBase();
		String sessionName = "ksesion-entender-para-mejorar-rules";
		KieSession session = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, sessionName);
		
		ArrayList<HuellaCarbonoModel> huellasDeCarbono =  new ArrayList<HuellaCarbonoModel>();

		//insertar datos en la base de hechos
		for (int i = 0; i <5; i++) {
			//indicadores indirectos
			IndicadoresEmisi�nCO2IndirectosModel indicadoresIndirectos =  new IndicadoresEmisi�nCO2IndirectosModel(200, 
					TipoAlimentacionEnum.Omnivora, GestionResiduosEnum.NoHaceNada, 200, 10, 8);
			
			//indicadores directos
			RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(0,0,200,0,0,0);
			RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(0,2000,0);

			IndicadoresEmisi�nCO2DirectosModel indicadoresDirectos =  new IndicadoresEmisi�nCO2DirectosModel(recorridoCotidiano, 
					new ConstanteMultiplicativaTransporteCotidiano(), recorridoLargaDistancia, new ConstanteMultiplicativaTransporteLargaDistancia());
			
			//huella de caerbono
			HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(new Random().nextInt(50), 
					indicadoresDirectos,indicadoresIndirectos);
			
			huellasDeCarbono.add(huellaCarbono);
			session.insert(huellaCarbono);
		}
		
		session.fireAllRules();
		
		//mostramos las huellas a analizar
		for (HuellaCarbonoModel huellaCarbono : huellasDeCarbono) {
			System.out.println(huellaCarbono);
			System.out.println(huellaCarbono.getPlanReduccion());
		}
	}
}
