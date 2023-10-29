public class BubbleSort{
	
  public static void bubbleSorter (String[] arr, int arrayLength){

    String someWord;

    for (int j = 0; j < arrayLength - 1; j++){
      for (int i = j + 1; i < arrayLength; i++){
        if (arr[j].compareTo(arr[i]) > 0){
      	 someWord = arr[j];
      	 arr[j] = arr[i];
      	 arr[i] = someWord;
        }
      }	
    }
  }

}