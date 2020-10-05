package AggregatesModels;

public class ConstanteMultiplicativaTransporteCotidiano {
	float Moto;
	float Colectivo;
	float Subte;
	float Auto;
	float Combie;
	float Tren;

	public ConstanteMultiplicativaTransporteCotidiano() {
		super();
		Moto = new Float(0.00019212);
		Colectivo = new Float(0.00019212);
		Subte = new Float(0.000186);
		Auto = new Float(0.00019212);
		Combie = new Float(0.00019212);
		Tren = new Float(0.00026);
	}

}