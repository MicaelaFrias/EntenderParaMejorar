package AggregatesModels;

public class MedioTransporteCotidiano {
	int Moto;
	int Colectivo;
	int Subte;
	int Auto;
	int Combie;
	int Tren;
	
	public MedioTransporteCotidiano() {
		Moto = 0;
		Colectivo = 0;
		Subte = 0;
		Auto = 0;
		Combie = 0;
		Tren = 0;
	}
	
	public int getMoto() {
		return Moto;
	}
	public void setMoto(int moto) {
		Moto = moto;
	}
	public int getColectivo() {
		return Colectivo;
	}
	public void setColectivo(int colectivo) {
		Colectivo = colectivo;
	}
	public int getSubte() {
		return Subte;
	}
	public void setSubte(int subte) {
		Subte = subte;
	}
	public int getAuto() {
		return Auto;
	}
	public void setAuto(int auto) {
		Auto = auto;
	}
	public int getCombie() {
		return Combie;
	}
	public void setCombie(int combie) {
		Combie = combie;
	}
	public int getTren() {
		return Tren;
	}
	public void setTren(int tren) {
		Tren = tren;
	}

}
