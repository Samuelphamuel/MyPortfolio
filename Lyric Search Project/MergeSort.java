import java.util.*;

public class MergeSort{

	public static void mergeSorter(String arr[], int first, int last)
    {
        if (first < last && (last - first)>=1) {
            // Find the middle point
            //int middle = (last + first)/2;
            int middle = (last + first)/2;
  
            // Sort first and second halves
            mergeSorter(arr, first, middle);
            mergeSorter(arr, middle + 1, last);
  
            // Merge the sorted halves
            merge(arr, first, middle, last);
        }
    }

	public static void merge(String[] arr, int first, int middle, int last){
    
        int leftIndex = first;
        int rightIndex = middle + 1;
        ArrayList<String> newarr = new ArrayList<String>();

        while (leftIndex <= middle && rightIndex <= last){
            if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0){
                newarr.add(arr[leftIndex]);
                leftIndex++;
            }
            else{
                newarr.add(arr[rightIndex]);
                rightIndex++;    
            }
        }
        while (leftIndex <= middle){
                newarr.add(arr[leftIndex]);
                leftIndex++;
        }
        while (rightIndex <= last){
                newarr.add(arr[rightIndex]);
                rightIndex++;
        }

            //System.out.println(newarr.toString());

        int i = 0;
        int j = first;

        while (i < newarr.size()){
            arr[j] = newarr.get(i);
            j++;
            i++;
        }  
        
        
	}
}