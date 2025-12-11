import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AtBatAggregator {

	private String gameDate;
	private String batterName;
	private int batterID;
	private int lastBatter;
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
	private boolean contact;
	private int batterAge;
	private int pitcherAge;
	public static int atBatNumber = 0;
	private ArrayList<AtBat> atBats;
	private String line;
	
	public AtBatAggregator() {
		atBats = new ArrayList<AtBat>();
		
	}
	
	public void writeFile(String str) {
		
		try {
			PrintWriter writer = new PrintWriter(new File("2025RegularSeasonAllPitchesDivvied.csv"));
			Scanner scanner = new Scanner(new File(str));
			scanner.useDelimiter(",");
			writer.write(scanner.nextLine() + ", AtBatID,,\n");
			while (scanner.hasNext()) {
				line = "";
				for (int i = 0; i < 105; i++) {
					String nextItem = scanner.next();
					line += nextItem + ",";
					if (i == 0) {
						batterID = Integer.parseInt(nextItem);
						try {
							if (batterID != lastBatter) {
								atBats.add(new AtBat(gameDate, batterName, lastBatter, pitcherID, batterHand, pitcherHand, gameID, numPitches, outcome, 
										battingTeam, pitchingTeam, numBalls, numStrikes, contact, batterAge, pitcherAge, atBatNumber));
								numBalls = 0;
								numStrikes = 0;
								atBatNumber += 1;
							}
						} catch (Exception e) {
							// NullPointerExpection when the lastBatter isn't defined yet. 
							// We Intentionally do nothing here because we don't heed to do anything special to handle the first pitch of the season. 
						} 
					} else if (i == 3) { //date
						gameDate = nextItem;
					} else if (i == 7) { //name
						// Had to split this one into two because the workaround to Excel hating me
						// completely messed up the formatting on the name column. 
						String a = nextItem;
						nextItem = scanner.next();
						String b = nextItem;
						line += nextItem + ",";
						batterName = a.substring(1) + "," + b.substring(0, b.length()-1);
					} else if (i == 8) { //pitcher
						pitcherID = Integer.parseInt(nextItem);
					} else if (i == 9) { //pitch result
						outcome = nextItem;
					} else if (i == 17) { //batter's hand
						batterHand = nextItem;
					} else if (i == 18) { //pitcher's hand
						pitcherHand = nextItem;
					} else if (i == 19) { //home team
						pitchingTeam = nextItem;
					} else if (i == 20) { //away team
						battingTeam = nextItem;
					} else if (i == 21) { //ball/strike
						String pitchType = nextItem;
						if (pitchType.equals("S")) {
							numStrikes++;
							contact = false;
						} else if (pitchType.equals("B")) {
							numBalls++;
							contact = false;
						} else {
							contact = true;
						}
					} else if (i == 36) { //swaps pitching and batting teams if it's the bottom half of the inning
						if (nextItem.equals("Bot")) {
							String team = pitchingTeam;
							pitchingTeam = battingTeam;
							battingTeam = team;
						}
					} else if (i == 57) { //game ID
						gameID = Integer.parseInt(nextItem);
					} else if (i == 75) { //Pitch number
						numPitches = Integer.parseInt(nextItem);
					} else if (i == 101) { //pitcher age
						pitcherAge = Integer.parseInt(nextItem); 
					} else if (i == 102) { //batter age
						batterAge = Integer.parseInt(nextItem);
					}
				}
				line += scanner.nextLine() + atBatNumber + ",,\n";
				writer.write(line);
				lastBatter = batterID;
			}
			scanner.close();
			writer = new PrintWriter(new File("2025RegularSeasonAllAtBats.csv"));
			writer.write("Game Date, Batter Last Name, Batter First Name ,Batter ID, PitcherID, Batter Hand, Pitcher Hand, Game ID, Number of Pitches, Outcome,"
					+ "Batting Team, Pitching Team, Num Balls, Num Strikes, Contact, Batter Age, Pitcher Age, At Bat Number, DummyColumn \n");
			for (AtBat atbat : atBats) {
				writer.write(atbat.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("There was an issue.");
		}
	}
	
}
