import java.util.Scanner;
import java.util.ArrayList;

class Solution {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    System.out.println("Enter int's and hit an empty space to end. There is no error checking");
    ArrayList<Integer> numsAL = new ArrayList<Integer>();
    String input = "w";
    while (input != "") {
      input = kbd.nextLine();

      try {
        numsAL.add(Integer.parseInt(input));
      } catch (Exception e) {
        input = "";
      }

    }
    int[] nums = new int[numsAL.size()];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = numsAL.get(i);
    }
    removeDuplicates(nums);

  }

  public static int removeDuplicates(int[] nums) {

    // current index that's available
    int index = 0;
    // how many spaces are to be removed
    int subtract = 0;
    int numOfRepeats = 0;
    for (int i = 0; i < nums.length; i++) {
      // if it's not the value then set the fist available index to the number being
      // looked at
      if (i + 1 != (nums.length)) {
        // if it isn't equal or it only repeats once put it in the array
        if (nums[i] != nums[i + 1] || numOfRepeats < 1) {
          nums[index] = nums[i];
          index++;
          // if its the same value as the next one, add it to the repeats
          if (nums[i] == nums[i + 1]) {
            numOfRepeats++;

          }
          // set repeats to 0 if it's not equal to the next one
          else {
            numOfRepeats = 0;
          }
        }
        // if it is the value and it repeats more than once add 1 more space to be
        // ignored

        else {
          subtract++;
        }
      } else {
        nums[index] = nums[i];
      }
    }
    for (int i = 0; i < nums.length - subtract; i++) {
      if (i != nums.length - subtract - 1) {
        System.out.print(nums[i] + ", ");
      } else {
        System.out.print(nums[i]);
      }
    }
    return nums.length - subtract;
  }
}