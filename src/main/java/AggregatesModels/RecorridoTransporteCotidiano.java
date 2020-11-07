package AggregatesModels;

public class RecorridoTransporteCotidiano {
	float Moto;
	float Colectivo;
	float Subte;
	float Auto;
	float Combie;
	float Tren;
	
	public RecorridoTransporteCotidiano(float moto, float colectivo,
			float subte, float auto, float combie, float tren) {
		super();
		Moto = moto;
		Colectivo = colectivo;
		Subte = subte;
		Auto = auto;
		Combie = combie;
		Tren = tren;
	}
	@Override
	public String toString() {
		return "RecorridoTransporteCotidiano [Moto=" + Moto + ", Colectivo="
				+ Colectivo + ", Subte=" + Subte + ", Auto=" + Auto
				+ ", Combie=" + Combie + ", Tren=" + Tren + "]";
	}
	public float getMoto() {
		return Moto;
	}
	public void setMoto(float moto) {
		Moto = moto;
	}
	public float getColectivo() {
		return Colectivo;
	}
	public void setColectivo(float colectivo) {
		Colectivo = colectivo;
	}
	public float getSubte() {
		return Subte;
	}
	public void setSubte(float subte) {
		Subte = subte;
	}
	public float getAuto() {
		return Auto;
	}
	public void setAuto(float auto) {
		Auto = auto;
	}
	public float getCombie() {
		return Combie;
	}
	public void setCombie(float combie) {
		Combie = combie;
	}
	public float getTren() {
		return Tren;
	}
	public void setTren(float tren) {
		Tren = tren;
	}

}
