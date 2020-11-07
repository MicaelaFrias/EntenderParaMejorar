package Models;

import Enums.GestionResiduosEnum;
import Enums.TipoAlimentacionEnum;

public class IndicadoresEmisiónCO2IndirectosModel {
	int ConsumoEléctricoMaximo;
	TipoAlimentacionEnum Tipoalimentacion;
	GestionResiduosEnum GestionResiduos;
	int CantidadCO2GestionResiduos;
	int CantidadCO2TipoAlimentacion;
	float ConsumoGasMaximo; 
	int ConsumoGarrafa;
	int ConsumoInternet;
	double TotalCO2EmitidoIndirectamente;
	
	@Override
	public String toString() {
		return "IndicadoresEmisiónCO2IndirectosModel [ConsumoEléctricoMaximo="
				+ ConsumoEléctricoMaximo + ", Tipoalimentacion="
				+ Tipoalimentacion + ", GetionResiduos=" + GestionResiduos
				+ ", CantidadCO2GestionResiduos=" + CantidadCO2GestionResiduos
				+ ", CantidadCO2TipoAlimentacion="
				+ CantidadCO2TipoAlimentacion + ", ConsumoGasMaximo="
				+ ConsumoGasMaximo + ", ConsumoGarrafa=" + ConsumoGarrafa
				+ ", ConsumoInternet=" + ConsumoInternet
				+ ", TotalCO2EmitidoIndirectamente="
				+ TotalCO2EmitidoIndirectamente + "]";
	}

	public IndicadoresEmisiónCO2IndirectosModel(int consumoEléctricoMaximo,
			TipoAlimentacionEnum tipoalimentacion,
			GestionResiduosEnum getionResiduos, float consumoGasMaximo,
			int consumoGarrafa, int consumoInternet) {
		super();
		ConsumoEléctricoMaximo = consumoEléctricoMaximo;
		Tipoalimentacion = tipoalimentacion;
		GestionResiduos = getionResiduos;
		ConsumoGasMaximo = consumoGasMaximo;
		ConsumoGarrafa = consumoGarrafa;
		ConsumoInternet = consumoInternet;
		//Formula para CO2 emitido indirectamente
		TotalCO2EmitidoIndirectamente = 
				ConsumoEléctricoMaximo * 0.000186 +
				ConsumoGasMaximo * 0.00215 + 
				ConsumoGarrafa * 0.00294 +
				ConsumoInternet * 0.08   +
				CantidadCO2GestionResiduos  + 
				CantidadCO2TipoAlimentacion;
	}

	public int getConsumoEléctricoMaximo() {
		return ConsumoEléctricoMaximo;
	}

	public void setConsumoEléctricoMaximo(int consumoEléctricoMaximo) {
		ConsumoEléctricoMaximo = consumoEléctricoMaximo;
	}

	public TipoAlimentacionEnum getTipoalimentacion() {
		return Tipoalimentacion;
	}

	public void setTipoalimentacion(TipoAlimentacionEnum tipoalimentacion) {
		Tipoalimentacion = tipoalimentacion;
	}

	public GestionResiduosEnum getGetionResiduos() {
		return GestionResiduos;
	}

	public void setGetionResiduos(GestionResiduosEnum getionResiduos) {
		GestionResiduos = getionResiduos;
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

	public double getTotalCO2EmitidoIndirectamente() {
		return TotalCO2EmitidoIndirectamente;
	}

	public void setTotalCO2EmitidoIndirectamente(int totalCO2EmitidoIndirectamente) {
		TotalCO2EmitidoIndirectamente = totalCO2EmitidoIndirectamente;
	}

	
	
}