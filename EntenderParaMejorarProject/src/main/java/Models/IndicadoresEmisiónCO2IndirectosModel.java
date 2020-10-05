package Models;

import Enums.GestionResiduosEnum;
import Enums.TipoAlimentacionEnum;

public class IndicadoresEmisi�nCO2IndirectosModel {
	int ConsumoEl�ctricoMaximo;
	TipoAlimentacionEnum Tipoalimentacion;
	GestionResiduosEnum GetionResiduos;
	int CantidadCO2GestionResiduos;
	int CantidadCO2TipoAlimentacion;
	float ConsumoGasMaximo; 
	int ConsumoGarrafa;
	int ConsumoInternet;
	int TotalCO2EmitidoIndirectamente;
	
	public IndicadoresEmisi�nCO2IndirectosModel(int consumoEl�ctricoMaximo,
			TipoAlimentacionEnum tipoalimentacion,
			GestionResiduosEnum getionResiduos, int cantidadCO2GestionResiduos,
			int cantidadCO2TipoAlimentacion, float consumoGasMaximo,
			int consumoGarrafa, int consumoInternet,
			int totalCO2EmitidoIndirectamente) {
		super();
		ConsumoEl�ctricoMaximo = consumoEl�ctricoMaximo;
		Tipoalimentacion = tipoalimentacion;
		GetionResiduos = getionResiduos;
		CantidadCO2GestionResiduos = cantidadCO2GestionResiduos;
		CantidadCO2TipoAlimentacion = cantidadCO2TipoAlimentacion;
		ConsumoGasMaximo = consumoGasMaximo;
		ConsumoGarrafa = consumoGarrafa;
		ConsumoInternet = consumoInternet;
		TotalCO2EmitidoIndirectamente = totalCO2EmitidoIndirectamente;
	}

	public int getConsumoEl�ctricoMaximo() {
		return ConsumoEl�ctricoMaximo;
	}

	public void setConsumoEl�ctricoMaximo(int consumoEl�ctricoMaximo) {
		ConsumoEl�ctricoMaximo = consumoEl�ctricoMaximo;
	}

	public TipoAlimentacionEnum getTipoalimentacion() {
		return Tipoalimentacion;
	}

	public void setTipoalimentacion(TipoAlimentacionEnum tipoalimentacion) {
		Tipoalimentacion = tipoalimentacion;
	}

	public GestionResiduosEnum getGetionResiduos() {
		return GetionResiduos;
	}

	public void setGetionResiduos(GestionResiduosEnum getionResiduos) {
		GetionResiduos = getionResiduos;
	}

	public int getCantidadCO2GestionResiduos() {
		return CantidadCO2GestionResiduos;
	}

	public void setCantidadCO2GestionResiduos(int cantidadCO2GestionResiduos) {
		CantidadCO2GestionResiduos = cantidadCO2GestionResiduos;
	}

	public int getCantidadCO2TipoAlimentacion() {
		return CantidadCO2TipoAlimentacion;
	}

	public void setCantidadCO2TipoAlimentacion(int cantidadCO2TipoAlimentacion) {
		CantidadCO2TipoAlimentacion = cantidadCO2TipoAlimentacion;
	}

	public float getConsumoGasMaximo() {
		return ConsumoGasMaximo;
	}

	public void setConsumoGasMaximo(float consumoGasMaximo) {
		ConsumoGasMaximo = consumoGasMaximo;
	}

	public int getConsumoGarrafa() {
		return ConsumoGarrafa;
	}

	public void setConsumoGarrafa(int consumoGarrafa) {
		ConsumoGarrafa = consumoGarrafa;
	}

	public int getConsumoInternet() {
		return ConsumoInternet;
	}

	public void setConsumoInternet(int consumoInternet) {
		ConsumoInternet = consumoInternet;
	}

	public int getTotalCO2EmitidoIndirectamente() {
		return TotalCO2EmitidoIndirectamente;
	}

	public void setTotalCO2EmitidoIndirectamente(int totalCO2EmitidoIndirectamente) {
		TotalCO2EmitidoIndirectamente = totalCO2EmitidoIndirectamente;
	}

	
	
}