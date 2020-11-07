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

	@Override
	public String toString() {
		return "ConstanteMultiplicativaTransporteCotidiano [Moto=" + Moto
				+ ", Colectivo=" + Colectivo + ", Subte=" + Subte + ", Auto="
				+ Auto + ", Combie=" + Combie + ", Tren=" + Tren + "]";
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