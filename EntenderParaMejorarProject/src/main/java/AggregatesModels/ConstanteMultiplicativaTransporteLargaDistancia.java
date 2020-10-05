package AggregatesModels;

public class ConstanteMultiplicativaTransporteLargaDistancia {
	float Avion;
	float Auto;
	float Micro;

	public ConstanteMultiplicativaTransporteLargaDistancia() {
		super();
		Micro = new Float(0.00012552 );
		Auto = new Float(0.00019212);
		Avion = new Float(0.000242);
	}
}
