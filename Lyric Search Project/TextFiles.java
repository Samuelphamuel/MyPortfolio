import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFiles{ //class

	public static void main (String[] args) throws FileNotFoundException{ //method

		String text = readString("SongLyrics.txt");
		System.out.println(text);


	}
} //end main

/*
Takes one string one representing the name of the file and then copies
all of the information from the file to a single String and returns it.
*/

public static String readString(String file){

	String text = "";
	try{
		Scanner s = new Scanner(new File(file));
		while(s.hasNextLine()){
			text = text + s.nextLine() + " "; 
		}
	}
	catch(FileNotFoundException e){
		System.out.println("file not found"); //if there is no file with that file name
	}


	return text;
}	