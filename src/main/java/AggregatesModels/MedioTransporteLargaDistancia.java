package AggregatesModels;

public class MedioTransporteLargaDistancia {
	int Auto;
	int Micro;
	int Avion;

	public MedioTransporteLargaDistancia() {
		Auto = 0;
		Micro = 0;
		Avion = 0;
	}


	public int getAuto() {
		return Auto;
	}

	public void setAuto(int auto) {
		Auto = auto;
	}

	public int getMicro() {
		return Micro;
	}

	public void setMicro(int micro) {
		Micro = micro;
	}

	public int getAvion() {
		return Avion;
	}

	public void setAvion(int avion) {
		Avion = avion;
	}

}
