package solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Description {

	static String csvFile = System.getProperty("user.dir") + "/lib/description.csv";
			
			//"C:/Users/NiklasBae/workspace/dss/lib/description.csv";
	static BufferedReader br = null;
	static String line = "";
	static String cvsSplitBy = ";";

	public static ArrayList<ArrayList<String>> description = new ArrayList<ArrayList<String>>();

	public static void add() {

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(cvsSplitBy);

				ArrayList<String> caseX = new ArrayList<String>(4);
				caseX.add(data[0]);
				caseX.add(data[1]);
				caseX.add(data[2]);
				caseX.add(data[3]);
				description.add(caseX);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeOut() {
		System.out.println(description.get(7).get(3));
	}

}
