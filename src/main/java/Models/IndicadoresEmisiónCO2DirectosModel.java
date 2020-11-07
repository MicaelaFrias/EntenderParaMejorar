package Models;

import AggregatesModels.RecorridoTransporteLargaDistancia;

public class IndicadoresEmisiónCO2DirectosModel {
	AggregatesModels.RecorridoTransporteCotidiano RecorridoTransporteCotidiano;
	AggregatesModels.ConstanteMultiplicativaTransporteCotidiano ConstanteMultiplicativaTransporteCotidiano;
	RecorridoTransporteLargaDistancia RecorridoTransporteLargaDistancia;
	AggregatesModels.ConstanteMultiplicativaTransporteLargaDistancia ConstanteMultiplicativaTransporteLargaDistancia;
	float TotalCO2EmitidoDirectamente;
	
	
	@Override
	public String toString() {
		return "IndicadoresEmisiónCO2DirectosModel [RecorridoTransporteCotidiano="
				+ RecorridoTransporteCotidiano
				+ ", ConstanteMultiplicativaTransporteCotidiano="
				+ ConstanteMultiplicativaTransporteCotidiano
				+ ", RecorridoTransporteLargaDistancia="
				+ RecorridoTransporteLargaDistancia
				+ ", ConstanteMultiplicativaTransporteLargaDistancia="
				+ ConstanteMultiplicativaTransporteLargaDistancia
				+ ", TotalCO2EmitidoDirectamente="
				+ TotalCO2EmitidoDirectamente + "]";
	}

	public IndicadoresEmisiónCO2DirectosModel(
			AggregatesModels.RecorridoTransporteCotidiano recorridoTransporteCotidiano,
			AggregatesModels.ConstanteMultiplicativaTransporteCotidiano constanteMultiplicativaTransporteCotidiano,
			AggregatesModels.RecorridoTransporteLargaDistancia recorridoTransporteLargaDistancia,
			AggregatesModels.ConstanteMultiplicativaTransporteLargaDistancia constanteMultiplicativaTransporteLargaDistancia) {
		super();
		RecorridoTransporteCotidiano = recorridoTransporteCotidiano;
		ConstanteMultiplicativaTransporteCotidiano = constanteMultiplicativaTransporteCotidiano;
		RecorridoTransporteLargaDistancia = recorridoTransporteLargaDistancia;
		ConstanteMultiplicativaTransporteLargaDistancia = constanteMultiplicativaTransporteLargaDistancia;
		TotalCO2EmitidoDirectamente = 
				RecorridoTransporteCotidiano.getMoto() * ConstanteMultiplicativaTransporteCotidiano.getMoto() + 
				RecorridoTransporteCotidiano.getAuto() * ConstanteMultiplicativaTransporteCotidiano.getAuto() +
				RecorridoTransporteCotidiano.getColectivo() * constanteMultiplicativaTransporteCotidiano.getColectivo()+
				RecorridoTransporteCotidiano.getSubte() * constanteMultiplicativaTransporteCotidiano.getSubte() +
				RecorridoTransporteCotidiano.getCombie() * constanteMultiplicativaTransporteCotidiano.getCombie()+ 
				RecorridoTransporteCotidiano.getTren() * constanteMultiplicativaTransporteCotidiano.getTren()  +
				RecorridoTransporteLargaDistancia.getAvion() * constanteMultiplicativaTransporteLargaDistancia.getAvion() +  
				RecorridoTransporteLargaDistancia.getAuto() * constanteMultiplicativaTransporteLargaDistancia.getAuto() +  
				RecorridoTransporteLargaDistancia.getMicro() * constanteMultiplicativaTransporteLargaDistancia.getMicro();
	}

	public AggregatesModels.RecorridoTransporteCotidiano getRecorridoTransporteCotidiano() {
		return RecorridoTransporteCotidiano;
	}


	public void setRecorridoTransporteCotidiano(
			AggregatesModels.RecorridoTransporteCotidiano recorridoTransporteCotidiano) {
		RecorridoTransporteCotidiano = recorridoTransporteCotidiano;
	}

	public RecorridoTransporteLargaDistancia getRecorridoTransporteLargaDistancia() {
		return RecorridoTransporteLargaDistancia;
	}


	public void setRecorridoTransporteLargaDistancia(
			RecorridoTransporteLargaDistancia recorridoTransporteLargaDistancia) {
		RecorridoTransporteLargaDistancia = recorridoTransporteLargaDistancia;
	}


	public float getTotalCO2EmitidoDirectamente() {
		return TotalCO2EmitidoDirectamente;
	}


	public void setTotalCO2EmitidoDirectamente(int totalCO2EmitidoDirectamente) {
		TotalCO2EmitidoDirectamente = totalCO2EmitidoDirectamente;
	}

	
	
	
}
