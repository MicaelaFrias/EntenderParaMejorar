package Models;

public class HuellaCarbonoModel {
	int idHuella;
	double CantidadCO2Emitido;
	IndicadoresEmisiónCO2DirectosModel IndicadoresEmisiónCO2Directos;
	IndicadoresEmisiónCO2IndirectosModel IndicadoresEmisiónCO2Indirectos;
	PlanReduccionModel PlanReduccion;
	
	public HuellaCarbonoModel(
			int idHuella,
			IndicadoresEmisiónCO2DirectosModel IndicadoresEmisiónCO2Directos,
			IndicadoresEmisiónCO2IndirectosModel IndicadoresEmisiónCO2Indirectos) {
		super();
		this.idHuella = idHuella;
		this.IndicadoresEmisiónCO2Directos = IndicadoresEmisiónCO2Directos;
		this.IndicadoresEmisiónCO2Indirectos = IndicadoresEmisiónCO2Indirectos;
		CantidadCO2Emitido = IndicadoresEmisiónCO2Directos.getTotalCO2EmitidoDirectamente() + 
				IndicadoresEmisiónCO2Indirectos.getTotalCO2EmitidoIndirectamente();
		this.PlanReduccion = new PlanReduccionModel();
	}

	@Override
	public String toString() {
		return "HuellaCarbonoModel [idHuella=" + idHuella
				+ ", CantidadCO2Emitido=" + CantidadCO2Emitido
				+ ", IndicadoresEmisiónCO2Directos="
				+ IndicadoresEmisiónCO2Directos
				+ ", IndicadoresEmisiónCO2Indirectos="
				+ IndicadoresEmisiónCO2Indirectos + ", PlanReduccion="
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

	public IndicadoresEmisiónCO2DirectosModel getIndicadoresEmisiónCO2Directos() {
		return IndicadoresEmisiónCO2Directos;
	}

	public void setIndicadoresEmisiónCO2Directos(
			IndicadoresEmisiónCO2DirectosModel indicadoresEmisiónCO2Directos) {
		this.IndicadoresEmisiónCO2Directos = indicadoresEmisiónCO2Directos;
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
