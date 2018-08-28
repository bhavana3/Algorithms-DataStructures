/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
/**
 *
 * @author bhavana
 */
public class BookDistribution {
    
    
    public static int max_number_of_books_per_person(int[] arr, int k) {
        int[] subsequent_sum = new int[arr.length];
        int max_sum = 0;
        int current_rem = 0;
        HashMap<Integer,Integer> rem_index = new HashMap<Integer,Integer>();
        subsequent_sum[0] = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            subsequent_sum[i] = subsequent_sum[i-1] + arr[i];
        }
        
        for(int i = 0; i < arr.length; i++) {
            current_rem = subsequent_sum[i] % k;
            
            if (current_rem == 0) {
                if(max_sum < subsequent_sum[i]) {
                    max_sum = subsequent_sum[i];
                }
            }
            
            else if (!rem_index.containsKey(current_rem)) {
                rem_index.put(current_rem, i);
            }
            else {
                if(max_sum < (subsequent_sum[i] - subsequent_sum[rem_index.get(current_rem)])) {
                    max_sum = (subsequent_sum[i] - subsequent_sum[rem_index.get(current_rem)]);
                }
            }
        }
        
        return (max_sum/k);
    }
    
    
    public static void main(String[] args) {
        int[] arr = {2,7,6,1,4,5};
        System.out.println(max_number_of_books_per_person(arr, 3));
    }
}
