package Models;

public class HuellaCarbonoModel {
	int idHuella;
	int CantidadCO2Emitido;
	IndicadoresEmisi�nCO2DirectosModel indicadoresEmisi�nCO2Directos;
	IndicadoresEmisi�nCO2IndirectosModel IndicadoresEmisi�nCO2Indirectos;
	PlanReduccionModel PlanReduccion;
	
	public HuellaCarbonoModel(
			int idHuella,
			int cantidadCO2Emitido,
			IndicadoresEmisi�nCO2DirectosModel indicadoresEmisi�nCO2Directos,
			IndicadoresEmisi�nCO2IndirectosModel indicadoresEmisi�nCO2Indirectos,
			PlanReduccionModel planReduccion) {
		super();
		this.idHuella = idHuella;
		CantidadCO2Emitido = cantidadCO2Emitido;
		this.indicadoresEmisi�nCO2Directos = indicadoresEmisi�nCO2Directos;
		IndicadoresEmisi�nCO2Indirectos = indicadoresEmisi�nCO2Indirectos;
		PlanReduccion = planReduccion;
	}

	public int getIdHuella() {
		return idHuella;
	}

	public void setIdHuella(int idHuella) {
		this.idHuella = idHuella;
	}

	public int getCantidadCO2Emitido() {
		return CantidadCO2Emitido;
	}

	public void setCantidadCO2Emitido(int cantidadCO2Emitido) {
		CantidadCO2Emitido = cantidadCO2Emitido;
	}

	public IndicadoresEmisi�nCO2DirectosModel getIndicadoresEmisi�nCO2Directos() {
		return indicadoresEmisi�nCO2Directos;
	}

	public void setIndicadoresEmisi�nCO2Directos(
			IndicadoresEmisi�nCO2DirectosModel indicadoresEmisi�nCO2Directos) {
		this.indicadoresEmisi�nCO2Directos = indicadoresEmisi�nCO2Directos;
	}

	public IndicadoresEmisi�nCO2IndirectosModel getIndicadoresEmisi�nCO2Indirectos() {
		return IndicadoresEmisi�nCO2Indirectos;
	}

	public void setIndicadoresEmisi�nCO2Indirectos(
			IndicadoresEmisi�nCO2IndirectosModel indicadoresEmisi�nCO2Indirectos) {
		IndicadoresEmisi�nCO2Indirectos = indicadoresEmisi�nCO2Indirectos;
	}

	public PlanReduccionModel getPlanReduccion() {
		return PlanReduccion;
	}

	public void setPlanReduccion(PlanReduccionModel planReduccion) {
		PlanReduccion = planReduccion;
	}




	
	
}
