import java.util.HashMap;

public class Postava {

	
	private String jmeno;
	private int zivoty;
	private int poskozeni;//az bude poskozeni 100 uberu zivot
	
	private static String[] seznamVlastnosti ={ "sila", "inteligence","obratnost","odolnost"};
	
	private HashMap<String, Integer> vlastnosti = new HashMap<>();
	
    private int penize;
    private Inventory inventory;
    private Equipment equipment;
    
    public Postava(String jmeno) {
    	this.jmeno=jmeno;
    	zivoty=10;
    	poskozeni=0;
    	penize=100;
    	inventory = new Inventory(5);
    	equipment= new Equipment();
    	for(String vlastnost: seznamVlastnosti) {
    		vlastnosti.put(vlastnost, 5);
    	}
    	}

	public Postava(String jmeno, int zivoty, int poskozeni, HashMap<String, Integer> vlastnosti, int penize,
			Inventory inventory, Equipment equipment) {
		super();
		this.jmeno = jmeno;
		this.zivoty = zivoty;
		this.poskozeni = poskozeni;
		this.vlastnosti = vlastnosti;
		this.penize = penize;
		this.inventory = inventory;
		this.equipment = equipment;
	}
	
	

	
	@Override
	public String toString() {
		String vl="";
		for(String vlastnost: seznamVlastnosti) {
			vl+=vlastnost+": "+vlastnosti.get(vlastnost)+"\n";
		}
		return  jmeno + "\nzivoty=" + zivoty + "\nposkozeni=" + poskozeni + "\npenize=" + penize;
	}
    
    
    
    
    
}
