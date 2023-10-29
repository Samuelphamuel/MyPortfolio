//Sam Pham
//Phase 1


import java.io.*;
import java.util.*;
import java.lang.*;

public class Phase1Java{

	public static final String delimiter = ",";
	public static void read(String csvFile){

		try{

			//creates output.txt file
			FileWriter outputFile = new FileWriter("output.txt");
			
			//reads the input file, phase1.csv
			File inputFile = new File(csvFile);
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line = "";

			//this will read the csv file line by line
			String[] tempArr;
			while ((line = br.readLine()) != null){
				tempArr = line.split(delimiter);
				for (String tempStr : tempArr){
					System.out.print(tempStr + " ");
				}
				if (line.length() == 0){
					outputFile.write("\n");
				} else{
					outputFile.write(processLine(line));
				}
				System.out.println();
			}

			/* Scanner input = new Scanner(inputFile);
			while(input.hasNextLine()){
				String line = input.nextLine();
				if (line.length() == 0){
					outputFile.write("\n");
				} else{
					outputFile.write(processLine(line));
				}
			} */

			br.close();

		} catch(FileNotFoundException e){
			System.out.println("file not found");
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args){

		String csvFile = "phase1.csv";
		Phase1Java.read(csvFile);
	
	}

	public static String processLine(String line){

		String output;
		ArrayList<String> cleanValues = new ArrayList<String>();
		String[] values = line.split(",");
		
		for (String value : values){
			cleanValues.add(value.trim());
		}

		try{

			int a = Integer.parseInt("Integer");
			int b = Integer.parseInt("Text");

		} catch (NumberFormatException e){
			//
		}
		

		//System.out.println(Arrays.toString(values));
		System.out.println("\nInteger");
		System.out.println("Text");

		output = String.join(",", cleanValues);
		return output;
	}


}