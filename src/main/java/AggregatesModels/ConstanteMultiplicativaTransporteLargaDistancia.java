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

	@Override
	public String toString() {
		return "ConstanteMultiplicativaTransporteLargaDistancia [Avion="
				+ Avion + ", Auto=" + Auto + ", Micro=" + Micro + "]";
	}

	public float getAvion() {
		return Avion;
	}

	public void setAvion(float avion) {
		Avion = avion;
	}

	public float getAuto() {
		return Auto;
	}

	public void setAuto(float auto) {
		Auto = auto;
	}

	public float getMicro() {
		return Micro;
	}

	public void setMicro(float micro) {
		Micro = micro;
	}
	
}
