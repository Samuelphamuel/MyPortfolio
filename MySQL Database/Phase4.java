//Samuel Pham
//Phase 3


import java.util.*;
import java.io.*;
import java.lang.*;

public class Phase4 {

	public static void main(String[] args){
		//Make sure you didn't forget to pass the table name
		if (args.length == 0){
			System.out.println("You forget to pass a table name!");			
			return;
		}
		
		String tableName = args[0]; // store the table name in a variable
	
		try{
			File infile = new File(String.format("seller.csv", tableName)); // In this project, the table names will match the input .csv files.	
			FileWriter outfile = new FileWriter(String.format("seller.sql", tableName)); // We will also name our output .sql files accordingly.
			
			Scanner input = new Scanner(infile);
			while (input.hasNextLine()){ //read through the file line-by-line
				String line = input.nextLine();				
				String output = getSQLInsert(tableName, line); // I created a separate method to generate my insert statements.				
				outfile.write(output);
			}
			outfile.close();	

		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());			
		}		
	}

	public static String getSQLInsert(String tableName, String line){

		String insertTemplate = "INSERT INTO %s VALUES(%s);\n"; //I used placeholders to simply place my table name and correctly formatted values into an insert statement.

		//This is where it is up to you to properly format values for your insert statements.
		List<String> cleanValues = new ArrayList<String>(); 
		cleanValues = Arrays.asList(line.split(",")); //store values and searate by commas in array and removing extra whitespaces
		line = line.trim();

		for (int i = 0; i < cleanValues.size(); i++){
			String element = cleanValues.get(i);
			element.replaceAll("[\\[\\]]", ""); //remove all brackets

			if (element.matches("[a-zA-Z ]+")){
				if (!element.equals("NULL")){
					cleanValues.set(i, "'" + element + "'");
				} else {
					cleanValues.set(i, element);
				}
			}
		}

		String values = String.join(",", cleanValues);
		insertTemplate = String.format(insertTemplate, tableName, cleanValues);

		System.out.println(values.trim());
		return insertTemplate;
		
	}
}