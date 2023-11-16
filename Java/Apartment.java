import java.io.Serializable;

public class Apartment implements Serializable {

	private int nrApartament;
	private String numeProprietar;
	private int nrCamere;
	private int nrLocatari;
	private int suprafata;
	
	public Apartment() {};

	public Apartment(int nrApartament, String numeProprietar) {
		this.nrApartament = nrApartament;
		this.numeProprietar = numeProprietar;
	}

	public Apartment(int nrApartament, String numeProprietar, int nrCamere, int nrLocatari, int suprafata) {
		this.nrApartament = nrApartament;
		this.numeProprietar = numeProprietar;
		this.nrCamere = nrCamere;
		this.nrLocatari = nrLocatari;
		this.suprafata = suprafata;
	}

	public int getNrApartament() {
		return nrApartament;
	}

	public void setNrApartament(int nrApartament) {
		this.nrApartament = nrApartament;
	}

	public String getNumeProprietar() {
		return numeProprietar;
	}

	public void setNumeProprietar(String numeProprietar) {
		this.numeProprietar = numeProprietar;
	}

	public int getNrCamere() {
		return nrCamere;
	}

	public void setNrCamere(int nrCamere) {
		this.nrCamere = nrCamere;
	}

	public int getNrLocatari() {
		return nrLocatari;
	}

	public void setNrLocatari(int nrLocatari) {
		this.nrLocatari = nrLocatari;
	}

	public int getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(int suprafata) {
		this.suprafata = suprafata;
	}

	@Override
	public String toString() {
		return "\tApartment [nrApartament=" + nrApartament + ", numeProprietar=" + numeProprietar + ", nrCamere="
				+ nrCamere + ", nrLocatari=" + nrLocatari + ", suprafata=" + suprafata + "]\n\n";
	};
	
}