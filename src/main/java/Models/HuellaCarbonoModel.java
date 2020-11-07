package Models;

public class HuellaCarbonoModel {
	int idHuella;
	double CantidadCO2Emitido;
	IndicadoresEmisi�nCO2DirectosModel IndicadoresEmisi�nCO2Directos;
	IndicadoresEmisi�nCO2IndirectosModel IndicadoresEmisi�nCO2Indirectos;
	PlanReduccionModel PlanReduccion;
	
	public HuellaCarbonoModel(
			int idHuella,
			IndicadoresEmisi�nCO2DirectosModel IndicadoresEmisi�nCO2Directos,
			IndicadoresEmisi�nCO2IndirectosModel IndicadoresEmisi�nCO2Indirectos) {
		super();
		this.idHuella = idHuella;
		this.IndicadoresEmisi�nCO2Directos = IndicadoresEmisi�nCO2Directos;
		this.IndicadoresEmisi�nCO2Indirectos = IndicadoresEmisi�nCO2Indirectos;
		CantidadCO2Emitido = IndicadoresEmisi�nCO2Directos.getTotalCO2EmitidoDirectamente() + 
				IndicadoresEmisi�nCO2Indirectos.getTotalCO2EmitidoIndirectamente();
		this.PlanReduccion = new PlanReduccionModel();
	}

	@Override
	public String toString() {
		return "HuellaCarbonoModel [idHuella=" + idHuella
				+ ", CantidadCO2Emitido=" + CantidadCO2Emitido
				+ ", IndicadoresEmisi�nCO2Directos="
				+ IndicadoresEmisi�nCO2Directos
				+ ", IndicadoresEmisi�nCO2Indirectos="
				+ IndicadoresEmisi�nCO2Indirectos + ", PlanReduccion="
				+ PlanReduccion + "]";
	}

	public int getIdHuella() {
		return idHuella;
	}

	public void setIdHuella(int idHuella) {
		this.idHuella = idHuella;
	}

	public double getCantidadCO2Emitido() {
		return CantidadCO2Emitido;
	}

	public void setCantidadCO2Emitido(int cantidadCO2Emitido) {
		CantidadCO2Emitido = cantidadCO2Emitido;
	}

	public IndicadoresEmisi�nCO2DirectosModel getIndicadoresEmisi�nCO2Directos() {
		return IndicadoresEmisi�nCO2Directos;
	}

	public void setIndicadoresEmisi�nCO2Directos(
			IndicadoresEmisi�nCO2DirectosModel indicadoresEmisi�nCO2Directos) {
		this.IndicadoresEmisi�nCO2Directos = indicadoresEmisi�nCO2Directos;
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
