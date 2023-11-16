import java.io.Serializable;

public class Agent extends Company implements Serializable {

	private String nume;
	private String prenume;
	private String cod;
	private String adresa;
	private String telefon;
	private double salariu;
	
	public Agent() {};

	public Agent(String nume, String prenume, double salariu) {
		this.nume = nume;
		this.prenume = prenume;
		this.salariu = salariu;
	}

	public Agent(String nume, String prenume, String cod, String adresa, String telefon) {
		this.nume = nume;
		this.prenume = prenume;
		this.cod = cod;
		this.adresa = adresa;
		this.telefon = telefon;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "\tAgent [nume=" + nume + ", prenume=" + prenume + ", cod=" + cod + ", adresa=" + adresa + ", telefon="
				+ telefon + "]\n\n";
	};
	
	public double salariuLunar(double salariu) {
		return salariu * 30;
	}
	
}