
public class AtBat {

	private String gameDate;
	private String batterFName;
	private String batterLName;
	private int batterID;
	private int pitcherID;
	private String batterHand;
	private String pitcherHand;
	private int gameID;
	private int numPitches;
	
	public AtBat(String gameDay, String batName, int batID, int pitID, String batHand, String pitHand, int gamID, int nP) {
		this.gameDate = gameDay;
		batterLName = batName.split(", ")[0];
		batterFName = batName.split(", ")[1];
		this.batterID = batID;
		this.pitcherID = pitID;
		this.batterHand = batHand;
		this.pitcherHand = pitHand;
		this.gameID = gamID;
		this.numPitches = nP;
	}

	public String toString() {
		String str = gameDate + "," + batterLName + "," + batterFName + "," + batterID + "," + pitcherID + "," + batterHand + "," + pitcherHand + "," + gameID + "," + numPitches + "\n";
		return str;
	}
	
}
