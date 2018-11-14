package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 Given an array arr[] of size n where every element is in range from 0 to n-1. 
 Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.
 

Input:

First line contains an integer denoting the test cases 'T'. Every test case contains an integer value depicting size of array 'N' and N integer elements are to be inserted in the next line with spaces between them.


Output:

Print all elements of the array after rearranging, each separated by a space, in separate line for each test case.


Constraints:

1 <= T <= 70
1 <= N<= 100
1 <= Arr[i] <= 100
Arr[i]<=N


Example:

Input:

3
2
1 0
5
4 0 2 1 3
4
3 2 0 1

Output:

0 1
3 4 2 0 1
1 0 3 2
 */
public class RearrangeAnArrayWithO1ExtraSpace {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				
				/*
				 * 4 0 2 1 3
				 * 
				 * 
				 * arr[0] = a	::	arr[a] = 0
				 * arr[1] = b	::	arr[b] = 1
				 * arr[2] = c	::	arr[c] = 2
				 * arr[3] = d	::	arr[d] = 3
				 * arr[4] = e	::	arr[e] = 4
				 * 
				 * arr[0] = 4	::	arr[0] = 3	5 - (2-0)
				 * arr[1] = 0	::	arr[1] = 4	5 - (2-1)
				 * arr[2] = 2	::	arr[2] = 0
				 * arr[3] = 1	::	arr[3] = 2
				 * arr[4] = 3	::	arr[4] = 1
				 * 
				 * arr[0] = 3	::	arr[0] = 1	4 - (2+1)
				 * arr[1] = 2	::	arr[1] = 0	4 - (2+2)
				 * arr[2] = 0	::	arr[2] = 3	4 - (2+3)
				 * arr[3] = 1	::	arr[3] = 2

				 * 
				 * */
				int length = arr.length;
				int lengthBy2 = length / 2;
				int[] newArr = new int[length];
				for (int i = 0; i < length ; i++) {
					arr[i] = length - (lengthBy2 + i + 1);
				}
				System.out.println(Arrays.toString(arr));
				for (int i = length; i > lengthBy2 ; i--) {
					arr[i] = lengthBy2 - (length + 1);
				}
				
					System.out.println(Arrays.toString(arr));

			}

		} catch (IOException e) {
		}

	}

	private static void swap(int i, int j) {
		
	}

}