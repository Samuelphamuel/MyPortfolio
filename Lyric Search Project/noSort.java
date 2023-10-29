public class noSort{
	
  public static boolean noSorter(String word, String arr[]){
    
    for (String i: arr){
      if (word.equals(i)){
        return true;
      }
    }
    return false;

	}
}