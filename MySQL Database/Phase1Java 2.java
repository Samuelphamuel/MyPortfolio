// Sam Pham
// Phase 1


import java.io.*;
import java.util.*;
import java.lang.*;

public class Phase1Java{

	public static void main(String[] args){

		try{

			FileWriter outfile = new FileWriter("phase1.csv");
			File infile = new File("output.txt"); 
			Scanner input = new Scanner(new File("output.txt"));

			while (input.hasNextLine()){ 
				String str = input.nextLine();
				if(str.length() == 0){
					outfile.write("\n");
				} 
				else{
					outfile.write(processLine(str));
				}
			}

			outfile.close();
			input.close();

		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

	public static String processLine(String str){

		String output;
		ArrayList<String> cleanValues = new ArrayList<String>();
		String[] Values = str.trim().split(",");
		
		output = String.join(",", cleanValues);
		
		int a = Integer.parseInt("");

		if (Integer.parseInt(output) <= 0){
			System.out.println("Integer");
		} else{
			System.out.println("Text");
		}

		return output;
	}


}