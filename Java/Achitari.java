import java.io.Serializable;

public class Achitari implements Serializable {

	private int nrApartament;
	private String serviciul;
	private String dataAchitarii;
	
	public Achitari() {};

	public Achitari(int nrApartament, String serviciul) {
		this.nrApartament = nrApartament;
		this.serviciul = serviciul;
	}

	public Achitari(int nrApartament, String serviciul, String dataAchitarii) {
		this.nrApartament = nrApartament;
		this.serviciul = serviciul;
		this.dataAchitarii = dataAchitarii;
	}

	public int getNrApartament() {
		return nrApartament;
	}

	public void setNrApartament(int nrApartament) {
		this.nrApartament = nrApartament;
	}

	public String getServiciul() {
		return serviciul;
	}

	public void setServiciul(String serviciul) {
		this.serviciul = serviciul;
	}

	public String getDataAchitarii() {
		return dataAchitarii;
	}

	public void setDataAchitarii(String dataAchitarii) {
		this.dataAchitarii = dataAchitarii;
	}

	@Override
	public String toString() {
		return "\tAchitari [nrApartament=" + nrApartament + ", serviciul=" + serviciul + ", dataAchitarii="
				+ dataAchitarii + "]\n\n";
	}
	
}