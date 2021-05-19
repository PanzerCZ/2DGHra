import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("zadej jmeno osoby: ");
		String jmpostavy=scanner.nextLine();
		Postava postava = new Postava(jmpostavy);
		System.out.println();
		System.out.println(postava);
		
		MapaSveta mapicka = new MapaSveta(3,3);
		if(mapicka.inicializace()) {
			System.out.println("Mapa sveta ve hre: ");
			System.out.println(mapicka);
			System.out.println();
			System.out.println("Hrac se nachazi v lokaci "+mapicka.getPozice());
			while(true) {
				System.out.print("Kterym smerem se chces pohybovat \n(1. sever, 2. vychod, 3. jih, 4. zapad)");
				int smer = scanner.nextInt();
				if(!mapicka.pohyb(smer-1)) {
				System.out.println("Timto smerem jit nemuzes");
			}
			System.out.println("Hrac se nachazi v lokaci "+mapicka.getPozice());
			}
			
		}else {
			System.out.println("Napodarilo se nacist mapu sveta");
		}
		
		

	}

}
