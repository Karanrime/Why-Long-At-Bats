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
				for (int i = 0; i < 15; i++) { //there are *16* columns in the csv that I'm using, but since I don't need the last one I'll just make sure to always cut it off so that nextLine gives the actual next line and doesn't skip.
					if (i == 0) {
						batterID = Integer.parseInt(scanner.next());
						try {
							if (batterID != lastBatter) {
								atBats.add(new AtBat(gameDate, batterName, lastBatter, pitcherID, batterHand,
										pitcherHand, gameID, numPitches));
							}
						} catch (Exception e) {
							
						} 
					}
					else if (i == 1) {
						pitcherID = Integer.parseInt(scanner.next());
					}
					else if (i == 3) {
						gameDate = scanner.next();
					}
					else if (i == 5) {
						// Had to split this one into two because the workaround to Excel hating me
						// completely messed up the formatting on the name column. 
						String a = scanner.next();
						String b = scanner.next();
						batterName = a.substring(1) + "," + b.substring(0, b.length()-1);
					}
					else if (i == 8) {
						batterHand = scanner.next();
					}
					else if (i == 9) {
						pitcherHand = scanner.next();
					}
					else if (i == 12) {
						gameID = Integer.parseInt(scanner.next());
					}
					else if (i == 14) {
						numPitches = Integer.parseInt(scanner.next());
					}
					else {
						scanner.next();
					}
				}
				scanner.nextLine();
				lastBatter = batterID;
			}
			scanner.close();
			PrintWriter writer = new PrintWriter(new File("2025RegularSeasonAllAtBats.csv"));
			for (AtBat atbat : atBats) {
				writer.write(atbat.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("There was an issue.");
		}
	}
	
}
