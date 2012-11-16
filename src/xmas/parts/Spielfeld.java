package xmas.parts;

public class Spielfeld {
		

	private String ersteZeile = " ___________________________________";
	private String r1p1 = "P1";
	private String r1p2 = "P2";
	private String r1p3 = "P3"; 
	private String r1p4 = "P4";
	private String r2p1 = "P1";
	private String r2p2 = "P2";
	private String r2p3 = "P3";
	private String r2p4 = "P4";

	
	public void towerSetzen(Tower tower) {
		// Erstellt einen Tower an der ausgewählten Postion auf dem Spielfeld
		if (tower.getReihe() == 1) {
			switch(tower.getStelle()) {
			case 1:
				r1p1 = tower.getSymbol();
				break;
			case 2:
				r1p2 = tower.getSymbol();
				break;
			case 3:
				r1p3 = tower.getSymbol();
				break;
			case 4:
				r1p4 = tower.getSymbol();
				break;
			}
		} else {
			switch(tower.getStelle()) {
			case 1:
				r2p1 = tower.getSymbol();
				break;
			case 2:
				r2p2 = tower.getSymbol();
				break;
			case 3:
				r2p3 = tower.getSymbol();
				break;
			case 4:
				r2p4 = tower.getSymbol();
				break;
			}
		}
		
		
	}
	
	public String toString() {
		StringBuilder feld = new StringBuilder();
		feld.append(ersteZeile).append("\n")
		.append("|                                   |\n")
		.append("|    ").append(r1p1).append("     ").append(r1p2).append("      ").append(r1p3).append("     ").append(r1p4).append(" 	    |\n")
		.append("|----><-----><------><-----><-______|:Reihe 1\n")
		.append("| ___________________________|  __  |\n")
		.append("<|                           | |  | |\n")
		.append("<|___________________________| |__| |:Kamin\n")
		.append("|                            |______|\n")
		.append("|----><-----><------><-----><-      |:Reihe 2\n")
		.append("|    ").append(r2p1).append("     ").append(r2p2).append("      ").append(r2p3).append("     ").append(r2p4).append(" 	    |\n")
		.append("|___________________________________|\n");
		return feld.toString();
	}
	

}
