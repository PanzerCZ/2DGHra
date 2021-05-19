
public class Predmet {
protected String nazev;
private boolean spotrebovatelne;
protected int cena;
//list vlastnosti, ktere predmet upravuje

//-----------------------------------------

public String getNazev() {
	return nazev;
}

public void setNazev(String nazev) {
	nazev = nazev;
}
public Predmet(String nazev) {
	super();
	this.nazev = nazev;
}

public Predmet(String nazev, boolean spotrebovatelne, int cena) {
	super();
	this.nazev = nazev;
	this.spotrebovatelne=spotrebovatelne;
	this.cena=cena;
}

//-----------------------------------------

public boolean getSpotrebovatelne () {
	return spotrebovatelne;
}

//-----------------------------------------
@Override
public String toString() {
	return nazev+" "+cena+"$"
			+ "";
}


//-----------------------------------------
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nazev == null) ? 0 : nazev.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Predmet other = (Predmet) obj;
	if (nazev == null) {
		if (other.nazev != null)
			return false;
	} else if (!nazev.equals(other.nazev))
		return false;
	return true;
}


//-----------------------------------------

}
