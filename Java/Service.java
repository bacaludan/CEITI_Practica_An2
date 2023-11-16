import java.io.Serializable;

public class Service extends Apartment implements Serializable {
	
	private String serviciiAcordate;
	private int cost; // pentru o zi
	private int zileIntarziate;	
	
	public Service() {}

	public Service(String serviciiAcordate, int cost) {
		this.serviciiAcordate = serviciiAcordate;
		this.cost = cost;
	}
	
	public Service(String serviciiAcordate, int cost, int zileIntarziate) {
		this.serviciiAcordate = serviciiAcordate;
		this.cost = cost;
		this.zileIntarziate = zileIntarziate;
	}
	
	public Service(int nrApartament, String numeProprietar, int nrCamere, int nrLocatari, int suprafata, String serviciiAcordate, int cost) {
		setNrApartament(nrApartament);
		setNumeProprietar(numeProprietar);
		setNrCamere(nrCamere);
		setNrLocatari(nrLocatari);
		setSuprafata(suprafata);
		this.serviciiAcordate = serviciiAcordate;
		this.cost = cost;
	}

	public String getServiciiAcordate() {
		return serviciiAcordate;
	}

	public void setServiciiAcordate(String serviciiAcordate) {
		this.serviciiAcordate = serviciiAcordate;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getZileIntarziate() {
		return zileIntarziate;
	}

	public void setZileIntarziate(int zileIntarziate) {
		this.zileIntarziate = zileIntarziate;
	}

	@Override
	public String toString() {
		return "\tService [serviciiAcordate=" + serviciiAcordate + ", cost=" + cost + "]\n\n";
	}	
	
	public double convertMoney(double val, double ccc) {
		return val * ccc;
	}
	
	public double sumeLunare(int cost) { // pentru intretinere
		return cost * 30;
	}
	
	public double penalizare(int cost, int zileIntarziate) {
		double p;
		p = (cost * 0.1) * zileIntarziate;
		return p;
	}
	
}