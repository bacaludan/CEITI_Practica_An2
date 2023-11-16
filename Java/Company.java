import java.io.Serializable;

public class Company implements Serializable {

	private String denumire;
	private String adresa;
	private String telefon;
	private double cost;
	
	public Company() {};

	public Company(String denumire, String adresa, String telefon) {
		this.denumire = denumire;
		this.adresa = adresa;
		this.telefon = telefon;
	}
	
	public Company(String denumire, String adresa, String telefon, double cost) {
		this.denumire = denumire;
		this.adresa = adresa;
		this.telefon = telefon;
		this.cost = cost;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
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
		return "\tCompany [denumire=" + denumire + ", adresa=" + adresa + ", telefon=" + telefon + "]\n\n";
	};
	
	public double costLunar(double cost) {
		return cost * 30;
	}
	
}