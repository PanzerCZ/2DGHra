import java.util.ArrayList;

public class Inventory {
private ArrayList<Predmet> inventar = new ArrayList<>();
private int maxPocet;


public Inventory(int maxPocet) {
	super();
	this.maxPocet = maxPocet;
}

//------------------------------------------
public boolean add(Predmet p) {
	if(maxPocet == inventar.size()) {
		return false;
	}
	inventar.add(p);
	return true;
}

//------------------------------------------

public Predmet drop(String nazevPredmet) {
	for(int i= 0;i<inventar.size();i++) {  //	for(Predmet p : inventar) {

		if(inventar.get(i).getNazev().equalsIgnoreCase(nazevPredmet)) {
			Predmet pomP=inventar.get(i);
			inventar.remove(pomP);
			return pomP;
		}
	}
	return null;
	
	
	
	
	
	
}

@Override
public String toString() {
	return "Inventory [inventar=" + inventar + "]";
		}

public int getmaxPocet() {
	return maxPocet;
}

public int aktualniPocetPolozek() {
	return inventar.size();
}











}
