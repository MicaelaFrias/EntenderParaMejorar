package Models;

import Enums.ImpactoIndividuoEmisorEnum;
import Enums.PlanHabitosMejorarEnum;

public class PlanReduccionModel {
	ImpactoIndividuoEmisorEnum ImpactIndividuoEmisor;
	PlanHabitosMejorarEnum PlanHabitosMejorar;

	public ImpactoIndividuoEmisorEnum getImpactIndividuoEmisor() {
		return ImpactIndividuoEmisor;
	}
	public void setImpactIndividuoEmisor(
			ImpactoIndividuoEmisorEnum impactIndividuoEmisor) {
		ImpactIndividuoEmisor = impactIndividuoEmisor;
	}
	public PlanHabitosMejorarEnum getPlanHabitosMejorar() {
		return PlanHabitosMejorar;
	}
	public void setPlanHabitosMejorar(PlanHabitosMejorarEnum planHabitosMejorar) {
		PlanHabitosMejorar = planHabitosMejorar;
	}
	@Override
	public String toString() {
		return "PlanReduccionModel [ImpactIndividuoEmisor="
				+ ImpactIndividuoEmisor + ", PlanHabitosMejorar="
				+ PlanHabitosMejorar + "]";
	}
	
	
}
