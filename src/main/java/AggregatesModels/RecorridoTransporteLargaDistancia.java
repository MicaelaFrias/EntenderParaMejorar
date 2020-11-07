package AggregatesModels;

public class RecorridoTransporteLargaDistancia {
	float Auto;
	float Micro;
	float Avion;
	
	public RecorridoTransporteLargaDistancia(float auto, float micro,
			float avion) {
		super();
		Auto = auto;
		Micro = micro;
		Avion = avion;
	}
	@Override
	public String toString() {
		return "RecorridoTransporteLargaDistancia [Auto=" + Auto + ", Micro="
				+ Micro + ", Avion=" + Avion + "]";
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
	public float getAvion() {
		return Avion;
	}
	public void setAvion(float avion) {
		Avion = avion;
	}
	
}

