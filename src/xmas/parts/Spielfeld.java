package xmas.parts;

public class Spielfeld {
		

	private String ersteZeile = " ___________________________________";
	
	public void spielfeldzeichen() {
		// Erstellt einen Tower an der ausgewählten Postion auf dem Spielfeld
		
	}
	
	public String toString() {
		StringBuilder feld = new StringBuilder();
		feld.append(ersteZeile).append("\n").append("|                                   |").append("\n")
		.append("|    P1     P2	    P3	   P4 	    |").append("\n").append("|----><-----><------><-----><-______|:Reihe 1").append("\n")
		.append("| ___________________________|  __  |").append("\n").append("<|                           | |  | |").append("\n")
		.append("<|___________________________| |__| |:Kamin").append("\n").append("|                            |______|").append("\n")
		.append("|----><-----><------><-----><-      |:Reihe 2").append("\n").append("|    P1	    P2	    P3	   P4 	    |").append("\n")
		.append("|___________________________________|").append("\n");
		return feld.toString();
	}
	

}
