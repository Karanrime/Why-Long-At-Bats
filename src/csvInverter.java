import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Loads in a csv and returns a .csv file with its rows in reverse order
public class csvInverter {

	public csvInverter() {
		
	}
	
	public String ReadFirstLine(String str) {
		try {
			Scanner scanner = new Scanner(new File(str));
			scanner.nextLine();
		return scanner.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "a";
	}
	
	public Boolean invertCSV(String str) {
		String Output = "";
		String Head = "";
		try {
			Scanner scanner = new Scanner(new File(str));
			Head = scanner.nextLine();
			while (scanner.hasNextLine()) {
				Output = scanner.nextLine() + "\n" + Output;
			}
			Output = Head + "\n" + Output;
			PrintWriter writer = new PrintWriter(new File(str.substring(0, str.length() - 4) + "Inverted.csv"));
				writer.write(Output);
			writer.close();
			scanner.close();
			System.out.println(str + " was succesfully inverted!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("There was an issue with " + str);
			return false;
		}
	}
	
	public void createMaster() {
		try {
			PrintWriter writer = new PrintWriter(new File("AllPitches2025.csv"));
			writer.write("Date, Player Name, BatterID, PitcherID, Result, Batting Side, Pitching Side, Home Team, Away Team, Type, InningNum, InningHalf, GameID, AtBatNum, PitchNum, PitcherAge, BatterAge \n");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Somehow there was an issue making the file...");
		}
	}
	
	public void addToMaster(String str) {
		try {
			Scanner scanner = new Scanner(new File(str));
			scanner.nextLine();
			PrintWriter writer = new PrintWriter(new File("AllPitches2025.csv"));
			while (scanner.hasNext()) {
				for (int i = 1; i < 104; i++) {
					String next = scanner.next();
					if (i == 2 || i == 6 || i == 7 || i == 8 || i == 9 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 36 || i == 37 || i == 58 || i == 75 || i == 76 || i == 102 || i == 103) {
						writer.write(next + ",");
					}
				}
				writer.write("\n");
			}
			scanner.close();
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Issue adding.");
		}
	}

}
