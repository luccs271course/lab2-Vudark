package edu.luc.cs.cs271.lab2;

import java.util.List;
import java.util.Optional;

public class Search {

  /** Looks for the position of the named team in an array. */
  public static Optional<Integer> findTeamPosition(final Team[] arr, final String key) {
    // Gets the array size
    final int size = arr.length;
    // Runs through a for loop to check
    for (int i = 0; i < size; i++) {
      // Gets the current item at index and compare name to key
      if (arr[i].getName().equals(key)) {
        // Return the index of where the item with key is located
        return Optional.of(i);
      }
    }
    // If it does not exist in the array then return an empty {Optional}
    return Optional.empty();
  }

  /** Looks for the position of the named team in a list. */
  public static Optional<Integer> findTeamPosition(final List<Team> list, final String key) {
    // TODO complete this method
    int result = -1;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getName().equals(key)){
        result = list.indexOf(key);
      }
    }
    if(result > -1){
      return Optional.of(result);
    }else{
      return Optional.empty();
    }
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFunding(final Team[] arr, final int minFunding) {
    // TODO complete this method
    final int size = arr.length;
    int result = 0;
    while(result == 0){
      for(int i = 0; i < size; i++){
        if(arr[i].getFunding() >= minFunding){
          result = arr[i].getFunding();
        }
      }
    }
    
    if(result > 0){
      return Optional.of(result);
    }else{
      return Optional.empty();
    }
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level. 
   * Uses binary search: Initially search the entire array, 
   * then repeatedly eliminate the wrong half of the array until 
   * zero or one items are left.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFundingFast(final Team[] arr, final int minFunding) {
    // TODO complete this method
    // Gets the array size
    final int size = arr.length;
    // Initially search the entire array
    int low = 0;
    int high = size - 1;
    // Keep going as long as there is more than one item to be checked
    // Eliminate the wrong half of the array
    // Return current item only if it meets the condition!
    if (low <= high && arr[low].getFunding() >= minFunding) {
      final int mid = (low + high) / 2;
      if(minFunding == arr[mid].getFunding()){
        return Optional.of(mid);
      }else if(minFunding < arr[mid].getFunding()){
        high = mid - 1;
      }else{
        low = mid + 1;
        return Optional.of(low);
      }
    }
    return Optional.empty();
  }
}
