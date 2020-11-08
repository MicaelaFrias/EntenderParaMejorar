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
import Utils.KnowledgeSessionHelper;

;
public class Main {

	public static void main(String[] args) {
		KieContainer container = KnowledgeSessionHelper.createRuleBase();
		String sessionName = "ksesion-entender-para-mejorar-rules";
		KieSession session = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, sessionName);
		
		ArrayList<HuellaCarbonoModel> huellasDeCarbono =  new ArrayList<HuellaCarbonoModel>();

		//insertar datos en la base de hechos
		//for (int i = 0; i <5; i++) {
			//indicadores indirectos
			IndicadoresEmisionCO2IndirectosModel indicadoresIndirectos =  new IndicadoresEmisionCO2IndirectosModel(200, 
					TipoAlimentacionEnum.Omnivora, GestionResiduosEnum.NoHaceNada, 200, 10, 8);
			
			//indicadores directos
			RecorridoTransporteCotidiano recorridoCotidiano = new RecorridoTransporteCotidiano(0,0,200,0,0,0);
			RecorridoTransporteLargaDistancia recorridoLargaDistancia = new RecorridoTransporteLargaDistancia(0,2000,0);

			IndicadoresEmisionCO2DirectosModel indicadoresDirectos =  new IndicadoresEmisionCO2DirectosModel(recorridoCotidiano, 
					new ConstanteMultiplicativaTransporteCotidiano(), recorridoLargaDistancia, new ConstanteMultiplicativaTransporteLargaDistancia());
			
			//huella de caerbono
			HuellaCarbonoModel huellaCarbono = new HuellaCarbonoModel(new Random().nextInt(50), 
					indicadoresDirectos,indicadoresIndirectos);
			
	
			huellasDeCarbono.add(huellaCarbono);
			session.insert(huellaCarbono);
		//}
		session.fireAllRules();
		
		//mostramos las huellas a analizar
		for (HuellaCarbonoModel huellaCarbono1 : huellasDeCarbono) {
			System.out.println(huellaCarbono1.getCantidadCO2Emitido());
			System.out.println(huellaCarbono1.getIndicadoresEmisionCO2Directos());
			System.out.println(huellaCarbono1.getIndicadoresEmisionCO2Indirectos());
		}
	}
}
