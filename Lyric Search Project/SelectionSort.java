public class SelectionSort{
  public static void selectionSorter(String arr[], int arraryLength){
  
    for (int i = 0; i < arraryLength - 1; i++){

      int minimumIndex = i;
      String minimumString = arr[i];

        for (int j = i + 1; j < arraryLength; j++){

          if (arr[j].compareTo(minimumString) < 0){

          	minimumString = arr[j];
          	minimumIndex = j;
          }	
        }	
        
        if (minimumIndex != i){
        	String temp = arr[minimumIndex];
        	arr[minimumIndex] = arr[i];
        	arr[i] = temp;
        }
    }

  } 	
}