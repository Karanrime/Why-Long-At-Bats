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

}
