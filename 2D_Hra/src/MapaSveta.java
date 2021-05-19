import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class MapaSveta {
	private Mistnost[][] mapa; //= new Mistnost[3][3];
	private HashSet<Predmet> predmetyVeHre = new HashSet<>();
	private HashSet<NPC> NPCVeHre = new HashSet <>();

	public static String[] smery = {"sever","vychod","jih","zapad"};
	//pozice hrace
	private int radek; 
	private int sloupec;
	
	public MapaSveta(int pocetRadku, int pocetSloupcu) {
		mapa = new Mistnost[pocetRadku][pocetSloupcu];
		radek = 1;
		sloupec = 1;
		this.getPredmetyVeHre();//metoda vraci false zatim
		this.getNPCVeHre();
	}

//-----------------------------------------------	
	public boolean inicializace() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("mistnosti"));
			String radek = "";
			int i = 0, j = 0;
			while((radek = br.readLine()) != null) {
				mapa[i][j] = new Mistnost(radek);
				//musim mit ve hre aspon 1 predmet
				int pocetPredmetuVMistnosti = rnd.nextInt(3)+1;
				int pocetNPCVMistnosti = rnd.nextInt(3)+1;

				for(int k =0; k<pocetPredmetuVMistnosti; k++) {
					mapa[i][j].add(nahodnyPredmet());
				}
				for(int k =0; k<pocetNPCVMistnosti; k++) {
					mapa[i][j].add(nahodnyNPC());
				}
				j++;
				if(j == mapa[i].length) {
					j = 0;
					i++;
				}
			}
			br.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
//-----------------------------------------------
//-----------------------------------------------
	
	public static Random rnd = new Random();
	public Predmet nahodnyPredmet() {
		int pocetPredmetuVeHre=this.predmetyVeHre.size();
		//System.out.print(pocetPredmetuVeHre);
		int cislo = rnd.nextInt(pocetPredmetuVeHre);
		int index=0;
		for(Predmet p : this.predmetyVeHre) {
			if(index == cislo) {
				return p;
			}
			index++;
		}
		return null;
	}
	public NPC nahodnyNPC() {
		int pocetNPCVeHre=this.NPCVeHre.size();
		//System.out.print(pocetPredmetuVeHre);
		int cislo = rnd.nextInt(pocetNPCVeHre);
		int index=0;
		for(NPC n : this.NPCVeHre) {
			if(index == cislo) {
				return n;
			}
			index++;
		}
		return null;
	}
//-----------------------------------------------
	public boolean getPredmetyVeHre() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Predmety"));
			String radek = "";
			int i = 0, j = 0;
			while((radek = br.readLine()) != null) {	
				String [] pole=radek.split(";");
				int cena = Integer.parseInt(pole[2].trim());
				if(pole.length == 3) {//pokud pridame vic vlast tak se 3 meni
					predmetyVeHre.add(new Predmet(pole[0].trim(),true,cena));
				}else	{
					String typ = pole[3].trim();
					switch(typ) {
					case"zbran":{
						predmetyVeHre.add(new Zbran(pole[0].trim(),cena));
						break;
 					}
					case"stit":{
						predmetyVeHre.add(new Stit(pole[0].trim(),cena));
						break;
 					}
					case"odev":{
						predmetyVeHre.add(new Odev(pole[0].trim(),cena));
						break;
 					}
				case"sperk":{
					predmetyVeHre.add(new Sperk(pole[0].trim(),cena));
					break;
					}
					}//switch
					
					
					}

				}
			
			br.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean getNPCVeHre() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("NPC"));
			String radek = "";
			int i = 0, j = 0;
			
			while((radek = br.readLine()) != null) {	
				String [] pole=radek.split(";");
				//NPCVeHre.add(new NPC(radek));
				NPCVeHre.add(new NPC(pole[0].trim()));

			} return true;
			}catch (Exception e) {
				return false;}
		}
				/* if(pole.length == 3) {//pokud pridame vic vlast tak se 3 meni
					NPCVeHre.add(new NPC(pole[0].trim(),true));
				}else	{
					String typ = pole[3].trim();
					switch(typ) {
					case"zbran":{
						predmetyVeHre.add(new Zbran(pole[0].trim(),cena));
						break;
 					}
					case"stit":{
						predmetyVeHre.add(new Stit(pole[0].trim(),cena));
						break;
 					}
					case"odev":{
						predmetyVeHre.add(new Odev(pole[0].trim(),cena));
						break;
 					}
				case"sperk":{
					predmetyVeHre.add(new Sperk(pole[0].trim(),cena));
					break;
					}
					}//switch
					
					
					}

				}
			
			br.close();
			return true;
		} */
			
//-----------------------------------------------	
	@Override
	public String toString() {
		String vypis = "";
		for(int i = 0; i < mapa.length; i++) {
			for(int j = 0; j < mapa[i].length; j++) {
				vypis += mapa[i][j].getNazev()+"\t";
			}
			vypis += "\n";
		}
		return vypis;
	}
    //sever = 0, vychod = 1, jih = 2. zapad = 3
	public boolean pohyb(int smer) {
		switch(smer) {
		case 0:{
			if(radek > 0) {
				radek--; 
				return true;
			}else {
				return false;
			}
		}
		case 1:{
			if(sloupec < mapa[radek].length-1) {
				sloupec++; 
				return true;
			}else {
				return false;
			}
		}
		case 2:{
			if(radek < mapa.length-1) {
				radek++; 
				return true;
			}else {
				return false;
			}
		}
		case 3:{
			if(sloupec > 0) {
				sloupec--; 
				return true;
			}else {
				return false;
			}
		}
		}
		return false;
	}

	public String getPozice() {
		return mapa[radek][sloupec].getNazev()+"\nPredmety: " +mapa[radek][sloupec].getPredmety()+"\nNPC: "+mapa[radek][sloupec].getNPC();
	}
	
	

}
