
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
	private String outcome;
	private String battingTeam;
	private String pitchingTeam;
	private int numBalls;
	private int numStrikes;
	boolean contact;
	int batterAge;
	int pitcherAge;
	
	public AtBat(String gameDay, String batName, int batID, int pitID, String batHand, String pitHand, int gamID, int nP,
			String result, String batTeam, String pitTeam, int numBalls, int numStrikes, boolean fairContact, int batAge, int pitAge) {
		this.gameDate = gameDay;
		batterLName = batName.split(", ")[0];
		batterFName = batName.split(", ")[1];
		this.batterID = batID;
		this.pitcherID = pitID;
		this.batterHand = batHand;
		this.pitcherHand = pitHand;
		this.gameID = gamID;
		this.numPitches = nP;
		this.outcome = result;
		this.battingTeam = batTeam;
		this.pitchingTeam = pitTeam;
		this.numBalls = numBalls;
		this.numStrikes = numStrikes;
		this.contact = fairContact;
		this.batterAge = batAge;
		this.pitcherAge = pitAge;
	}

	public String toString() {
		String str = gameDate + "," + batterLName + "," + batterFName + "," + batterID + "," + pitcherID + "," + batterHand + "," + pitcherHand + "," + gameID + "," + numPitches + 
				"," + outcome + "," + battingTeam + "," + pitchingTeam + "," + numBalls + "," + numStrikes + "," + contact + "," + batterAge + "," + pitcherAge + "\n";
		return str;
	}
	
}
