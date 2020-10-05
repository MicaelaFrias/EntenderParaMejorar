package Models;

import AggregatesModels.MedioTransporteCotidiano;
import AggregatesModels.MedioTransporteLargaDistancia;
import AggregatesModels.RecorridoTransporteLargaDistancia;

public class IndicadoresEmisiónCO2DirectosModel {
	MedioTransporteCotidiano MedioTransporteCotidiano;
	AggregatesModels.RecorridoTransporteCotidiano RecorridoTransporteCotidiano;
	AggregatesModels.ConstanteMultiplicativaTransporteCotidiano ConstanteMultiplicativaTransporteCotidiano;
	MedioTransporteLargaDistancia MedioTransporteLargaDistancia;
	RecorridoTransporteLargaDistancia RecorridoTransporteLargaDistancia;
	AggregatesModels.ConstanteMultiplicativaTransporteLargaDistancia ConstanteMultiplicativaTransporteLargaDistancia;
	int TotalCO2EmitidoDirectamente;
	
	
	public IndicadoresEmisiónCO2DirectosModel(
			MedioTransporteCotidiano mediaTransporteCotidiano,
			AggregatesModels.RecorridoTransporteCotidiano recorridoTransporteCotidiano,
			AggregatesModels.ConstanteMultiplicativaTransporteCotidiano constanteMultiplicativaTransporteCotidiano,
			MedioTransporteLargaDistancia mediaTransporteLargaDistancia,
			AggregatesModels.RecorridoTransporteLargaDistancia recorridoTransporteLargaDistancia,
			AggregatesModels.ConstanteMultiplicativaTransporteLargaDistancia constanteMultiplicativaTransporteLargaDistancia,
			int totalCO2EmitidoDirectamente) {
		super();
		MedioTransporteCotidiano = mediaTransporteCotidiano;
		RecorridoTransporteCotidiano = recorridoTransporteCotidiano;
		ConstanteMultiplicativaTransporteCotidiano = constanteMultiplicativaTransporteCotidiano;
		MedioTransporteLargaDistancia = mediaTransporteLargaDistancia;
		RecorridoTransporteLargaDistancia = recorridoTransporteLargaDistancia;
		ConstanteMultiplicativaTransporteLargaDistancia = constanteMultiplicativaTransporteLargaDistancia;
		TotalCO2EmitidoDirectamente = totalCO2EmitidoDirectamente;
	}


	public MedioTransporteCotidiano getMediaTransporteCotidiano() {
		return MedioTransporteCotidiano;
	}


	public void setMediaTransporteCotidiano(
			MedioTransporteCotidiano mediaTransporteCotidiano) {
		MedioTransporteCotidiano = mediaTransporteCotidiano;
	}


	public AggregatesModels.RecorridoTransporteCotidiano getRecorridoTransporteCotidiano() {
		return RecorridoTransporteCotidiano;
	}


	public void setRecorridoTransporteCotidiano(
			AggregatesModels.RecorridoTransporteCotidiano recorridoTransporteCotidiano) {
		RecorridoTransporteCotidiano = recorridoTransporteCotidiano;
	}


	public MedioTransporteLargaDistancia getMediaTransporteLargaDistancia() {
		return MedioTransporteLargaDistancia;
	}


	public void setMediaTransporteLargaDistancia(
			MedioTransporteLargaDistancia mediaTransporteLargaDistancia) {
		MedioTransporteLargaDistancia = mediaTransporteLargaDistancia;
	}


	public RecorridoTransporteLargaDistancia getRecorridoTransporteLargaDistancia() {
		return RecorridoTransporteLargaDistancia;
	}


	public void setRecorridoTransporteLargaDistancia(
			RecorridoTransporteLargaDistancia recorridoTransporteLargaDistancia) {
		RecorridoTransporteLargaDistancia = recorridoTransporteLargaDistancia;
	}


	public int getTotalCO2EmitidoDirectamente() {
		return TotalCO2EmitidoDirectamente;
	}


	public void setTotalCO2EmitidoDirectamente(int totalCO2EmitidoDirectamente) {
		TotalCO2EmitidoDirectamente = totalCO2EmitidoDirectamente;
	}

	
	
	
}
