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
	boolean contact;
	int batterAge;
	int pitcherAge;
	private ArrayList<AtBat> atBats;
	
	public AtBatAggregator() {
		atBats = new ArrayList<AtBat>();
		
	}
	
	public void writeFile(String str) {
		
		try {
			Scanner scanner = new Scanner(new File(str));
			scanner.useDelimiter(",");
			scanner.nextLine();
			while (scanner.hasNext()) {
				
				for (int i = 0; i < 16; i++) {
					if (i == 0) {
						batterID = Integer.parseInt(scanner.next());
						try {
							if (batterID != lastBatter) {
								atBats.add(new AtBat(gameDate, batterName, lastBatter, pitcherID, batterHand, pitcherHand, gameID, numPitches, outcome, 
										battingTeam, pitchingTeam, numBalls, numStrikes, contact, batterAge, pitcherAge));
								numBalls = 0;
								numStrikes = 0;
							}
						} catch (Exception e) {
							
						} 
					} else if (i == 1) {
						gameDate = scanner.next();
					} else if (i == 2) {
						// Had to split this one into two because the workaround to Excel hating me
						// completely messed up the formatting on the name column. 
						String a = scanner.next();
						String b = scanner.next();
						batterName = a.substring(1) + "," + b.substring(0, b.length()-1);
					} else if (i == 3) {
						pitcherID = Integer.parseInt(scanner.next());
					} else if (i == 4) {
						outcome = scanner.next();
					} else if (i == 5) {
						batterHand = scanner.next();
					} else if (i == 6) {
						pitcherHand = scanner.next();
					} else if (i == 7) {
						pitchingTeam = scanner.next();
					} else if (i == 8) {
						battingTeam = scanner.next();
					} else if (i == 9) {
						String pitchType = scanner.next();
						if (pitchType.equals("S")) {
							numStrikes++;
							contact = false;
						} else if (pitchType.equals("B")) {
							numBalls++;
							contact = false;
						} else {
							contact = true;
						}
					} else if (i == 10) {
						if (scanner.next().equals("Bot")) {
							String team = pitchingTeam;
							pitchingTeam = battingTeam;
							battingTeam = team;
						}
					} else if (i == 11) {
						gameID = Integer.parseInt(scanner.next());
					} else if (i == 12) {
						scanner.next();
					} else if (i == 13) {
						numPitches = Integer.parseInt(scanner.next());
					} else if (i == 14) {
						pitcherAge = Integer.parseInt(scanner.next()); 
					} else if (i == 15) {
						batterAge = Integer.parseInt(scanner.next());
					}
				}
				scanner.nextLine();
				lastBatter = batterID;
			}
			scanner.close();
			PrintWriter writer = new PrintWriter(new File("2025RegularSeasonAllAtBats.csv"));
			writer.write("Game Date, Batter Last Name, Batter First Name ,Batter ID, PitcherID, Batter Hand, Pitcher Hand, Game ID, Number of Pitches, Outcome,"
					+ "Batting Team, Pitching Team, Num Balls, Num Strikes, Contact, Batter Age, Pitcher Age \n");
			for (AtBat atbat : atBats) {
				writer.write(atbat.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("There was an issue.");
		}
	}
	
}
