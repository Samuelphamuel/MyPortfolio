public class BinarySearch{
	
  public static boolean BinarySearcher(String word, String arr[]){
    int first = 0;
    int last = arr.length - 1;

    while(first <= last){

    int middle =  (last + first)/2;
    int difference = word.compareTo(arr[middle]);

    if (difference == 0){
      return true;	
    }
    if (difference > 0){
      first = middle + 1;
    }
    else{
      last = middle - 1;	
    }
    }
    return false;
  }

}  