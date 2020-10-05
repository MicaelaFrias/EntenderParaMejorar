package Models;

public class HuellaCarbonoModel {
	int idHuella;
	int CantidadCO2Emitido;
	IndicadoresEmisiónCO2DirectosModel indicadoresEmisiónCO2Directos;
	IndicadoresEmisiónCO2IndirectosModel IndicadoresEmisiónCO2Indirectos;
	PlanReduccionModel PlanReduccion;
	
	public HuellaCarbonoModel(
			int idHuella,
			int cantidadCO2Emitido,
			IndicadoresEmisiónCO2DirectosModel indicadoresEmisiónCO2Directos,
			IndicadoresEmisiónCO2IndirectosModel indicadoresEmisiónCO2Indirectos,
			PlanReduccionModel planReduccion) {
		super();
		this.idHuella = idHuella;
		CantidadCO2Emitido = cantidadCO2Emitido;
		this.indicadoresEmisiónCO2Directos = indicadoresEmisiónCO2Directos;
		IndicadoresEmisiónCO2Indirectos = indicadoresEmisiónCO2Indirectos;
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

	public IndicadoresEmisiónCO2DirectosModel getIndicadoresEmisiónCO2Directos() {
		return indicadoresEmisiónCO2Directos;
	}

	public void setIndicadoresEmisiónCO2Directos(
			IndicadoresEmisiónCO2DirectosModel indicadoresEmisiónCO2Directos) {
		this.indicadoresEmisiónCO2Directos = indicadoresEmisiónCO2Directos;
	}

	public IndicadoresEmisiónCO2IndirectosModel getIndicadoresEmisiónCO2Indirectos() {
		return IndicadoresEmisiónCO2Indirectos;
	}

	public void setIndicadoresEmisiónCO2Indirectos(
			IndicadoresEmisiónCO2IndirectosModel indicadoresEmisiónCO2Indirectos) {
		IndicadoresEmisiónCO2Indirectos = indicadoresEmisiónCO2Indirectos;
	}

	public PlanReduccionModel getPlanReduccion() {
		return PlanReduccion;
	}

	public void setPlanReduccion(PlanReduccionModel planReduccion) {
		PlanReduccion = planReduccion;
	}




	
	
}
