package Models;

public class HuellaCarbonoModel {
	int idHuella;
	double CantidadCO2Emitido;
	IndicadoresEmisionCO2DirectosModel IndicadoresEmisionCO2Directos;
	IndicadoresEmisionCO2IndirectosModel IndicadoresEmisionCO2Indirectos;
	PlanReduccionModel PlanReduccion;
	
	public HuellaCarbonoModel(
			int idHuella,
			IndicadoresEmisionCO2DirectosModel IndicadoresEmisionCO2Directos,
			IndicadoresEmisionCO2IndirectosModel IndicadoresEmisionCO2Indirectos) {
		super();
		this.idHuella = idHuella;
		this.IndicadoresEmisionCO2Directos = IndicadoresEmisionCO2Directos;
		this.IndicadoresEmisionCO2Indirectos = IndicadoresEmisionCO2Indirectos;
		CantidadCO2Emitido = IndicadoresEmisionCO2Directos.getTotalCO2EmitidoDirectamente() + 
				IndicadoresEmisionCO2Indirectos.getTotalCO2EmitidoIndirectamente();
		this.PlanReduccion = new PlanReduccionModel();
	}

	@Override
	public String toString() {
		return "HuellaCarbonoModel [idHuella=" + idHuella
				+ ", CantidadCO2Emitido=" + CantidadCO2Emitido
				+ ", IndicadoresEmisionCO2Directos="
				+ IndicadoresEmisionCO2Directos
				+ ", IndicadoresEmisionCO2Indirectos="
				+ IndicadoresEmisionCO2Indirectos + ", PlanReduccion="
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

	public IndicadoresEmisionCO2DirectosModel getIndicadoresEmisionCO2Directos() {
		return IndicadoresEmisionCO2Directos;
	}

	public void setIndicadoresEmisionCO2Directos(
			IndicadoresEmisionCO2DirectosModel indicadoresEmisionCO2Directos) {
		this.IndicadoresEmisionCO2Directos = indicadoresEmisionCO2Directos;
	}

	public IndicadoresEmisionCO2IndirectosModel getIndicadoresEmisionCO2Indirectos() {
		return IndicadoresEmisionCO2Indirectos;
	}

	public void setIndicadoresEmisionCO2Indirectos(
			IndicadoresEmisionCO2IndirectosModel indicadoresEmisionCO2Indirectos) {
		IndicadoresEmisionCO2Indirectos = indicadoresEmisionCO2Indirectos;
	}

	public PlanReduccionModel getPlanReduccion() {
		return PlanReduccion;
	}

	public void setPlanReduccion(PlanReduccionModel planReduccion) {
		PlanReduccion = planReduccion;
	}




	
	
}
