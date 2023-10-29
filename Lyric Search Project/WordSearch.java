import java.util.*;
import java.io.*;
import java.util.Scanner;
 
 
//The driver class of the word search program
 
public class WordSearch{
public static void main(String[] args){
 
  //The timer that goes off right after the user inputs the name of the song and starts the preliminary work before we can search
  long start;
 
  //The timer that goes off after the preliminary work is done 
  Long endOfPreliminary;
 
  //the timer that goes off right before the sorting and searching starts
  Long startOfSearch;
 
  //The timer that goes off after the searching is done. Had to set it to something beforehand.
  Long theEnd = 0L;
 
 
 
  //This will hold the song lyrics. 
  //I went with an arraylist since I wouldn't know how big an array to make for each song and arraylists go as big as you need
  ArrayList<String> theLyrics = new ArrayList<String>();
 
 
  //Scanner for user input
  Scanner scanner = new Scanner(System.in);
  String song;
  System.out.println("Please enter the name of the song you'd like to search");
 
 
  //After the message, the user will need to input name of the song they want searched
  //The user will have to write the name of a text file that already exists in the directory of this very program or else an error will occur
  //The user can write the title with or without capital letters, empty spaces, and punctuation since those will al be removed in line 28-30
  //misspelling is the only thing that ruins everything but that's just life  
  song = scanner.nextLine();
 
  start = System.currentTimeMillis();
 
  String rawSong = song;
  song = song.replaceAll("\\p{Punct}","");
  song = song.toLowerCase();
  song = song.replaceAll(" ","");
  song = song + ".txt";
 
 
  //The user input will be used for the file name
  //If a a valid file name exists, then we will go through every word of that text file
  //Every word will have capitalization and punctuation removed
  //If no such file by that name exists, then an error shall appear and the program will end
  try{
    File mySong = new File(song);
     scanner = new Scanner(mySong);
     while (scanner.hasNext()){
    String lyric = scanner.next();
    lyric = lyric.replaceAll("\\p{Punct}","");
    lyric = lyric.toLowerCase();
        theLyrics.add(lyric);
  }
  }
 
  catch (FileNotFoundException e){
    System.out.println("No file found");
    System.exit(0);
  }
 
 
  //The completed array list data will be put into an array
  //The blocked out text on lines 59 through 61 were just for testing. You can uncomment them out if you wanna test that the array is ordered properly
  scanner = new Scanner(System.in);
  String [] theLyricsArray = theLyrics.toArray(new String[0]);
  //for (String i : theLyricsArray){
  //System.out.println(i);
  //}
 
  endOfPreliminary = System.currentTimeMillis();
 
 
 
  //The user is now prompted to input the word they're searching for
  //punctuation and capital letters are not allowed
  System.out.println("Please pick one word to search for");
  System.out.println("(NO CAPITAL LETTERS AND NO PUCTUATION PLEASE)");
  String theWord = scanner.nextLine();
  System.out.println("------");
 
 
 
  //The user is tasked with choosing a method of sorting the lyrics
  //Option 1 will not sort and instead run theough the lyrics array index by index, checking to see if any of the entries is the user's word
  //Option 2 will use the built in sort method for Object arrays which uses Tim sort with n log(n) average runtime
  //Option 3 and onwards will call a method from a seperate file with that sorting method
  //Every option that sorts will then use binary search to search for the word. Binary Search will also be in another file.
  System.out.println("How Would you like to sort?");
  System.out.println("1)No sort  2)Tim sort  3)Bubble Sort  4)Selection Sort  5)Merge sort");
  int sortOption = scanner.nextInt();
 
  startOfSearch = System.currentTimeMillis(); 
 
 
  //This giant block of code will run the various options of sorting
  //At the end of each option, whether the word was found or not, the final runtime of the program is recorded with "theEnd" 
  if (sortOption == 1){
    if (noSort.noSorter(theWord, theLyricsArray)){
      System.out.println("'" + theWord + "'" + " is in " + "(" + rawSong + ")" + " and was found through brute force!");
      theEnd = System.currentTimeMillis();
    }
    else{
      System.out.println("'" + theWord + "'" + " is NOT in " + "(" + rawSong + ")" + "!");
      theEnd = System.currentTimeMillis();
    }
  }
 
 
  else if (sortOption == 2){
    Arrays.sort(theLyricsArray);
    if (BinarySearch.BinarySearcher(theWord, theLyricsArray)){
      System.out.println("'" + theWord + "'" + " is in " + "(" + rawSong + ")" + " and was found through Tim Sort!");
      theEnd = System.currentTimeMillis();  
    }
    else{
      System.out.println("'" + theWord + "'" + " is NOT in " + "(" + rawSong + ")" + "!");
      theEnd = System.currentTimeMillis();
    }
  }
 
 
  else if (sortOption == 3){
    BubbleSort.bubbleSorter(theLyricsArray, theLyricsArray.length);
    if (BinarySearch.BinarySearcher(theWord, theLyricsArray)){
      System.out.println("'" + theWord + "'" + " is in " + "(" + rawSong + ")" + " and was found through Bubble Sort!");
      theEnd = System.currentTimeMillis();
    }
    else{
      System.out.println("'" + theWord + "'" + " is NOT in " + "(" + rawSong + ")" + "!");
      theEnd = System.currentTimeMillis(); 
    }
  }
 
 
  else if (sortOption == 4){
    SelectionSort.selectionSorter(theLyricsArray, theLyricsArray.length);
    if (BinarySearch.BinarySearcher(theWord, theLyricsArray)){
      System.out.println("'" + theWord + "'" + " is in " + "(" + rawSong + ")" + " and was found through Selection Sort!");
      theEnd = System.currentTimeMillis();
    }
    else{
      System.out.println("'" + theWord + "'" + " is NOT in " + "(" + rawSong + ")" + "!");
      theEnd = System.currentTimeMillis(); 
    }
  }
 
 
  else if (sortOption == 5){
    MergeSort.mergeSorter(theLyricsArray, 0, theLyricsArray.length - 1);
    if (BinarySearch.BinarySearcher(theWord, theLyricsArray)){
      System.out.println("'" + theWord + "'" + " is in " + "(" + rawSong + ")" + " and was found through Merge Sort!");
      theEnd = System.currentTimeMillis();
    }
    else{
      System.out.println("'" + theWord + "'" + " is NOT in " + "(" + rawSong + ")" + "!");
      theEnd = System.currentTimeMillis(); 
    }
  } 
 
 
 
  //Finally we display how long it took to get to the sorting, how long it took to sort and search, and how long everything took 
  Long Preliminary = (endOfPreliminary - start);
  Long theSorting = (theEnd - startOfSearch);
  Long allOfIt = (Preliminary + theSorting);
 
 
  System.out.println("----------------------");
  System.out.println("It took about " + Preliminary + " milliseconds to get to the sorting and searching.");
  System.out.println("AND");
  System.out.println("It took about " + theSorting + " milliseconds to sort and search");
  System.out.println("SO");
  System.out.println("It took about " + allOfIt + " milliseconds for the whole program");
  System.out.println("----------------------");
 
}  
}