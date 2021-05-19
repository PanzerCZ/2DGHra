import java.util.ArrayList;

public class Mistnost {
	private String nazev;
	private ArrayList<Predmet> predmety = new ArrayList<Predmet>();
	private ArrayList<NPC> Npcc = new ArrayList<NPC>();

	public Mistnost(String nazev) {
		super();
		this.nazev = nazev;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	
	public boolean add(Predmet nahodnyPredmet) {
		return predmety.add(nahodnyPredmet);
	}
	
	public String getPredmety() {
		return this.predmety.toString();
	}
	public boolean add(NPC nahodnyNPC) {
		return Npcc.add(nahodnyNPC);
	}
	
	public String getNPC() {
		return this.Npcc.toString();
	}
}
