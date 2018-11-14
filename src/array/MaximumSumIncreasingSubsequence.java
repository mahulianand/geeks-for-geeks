package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				String[] stringNumbers = br.readLine().split(" ");

				int[] numbers = Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();

				int maxSum = 0;

				Node[] allNodes = new Node[numbers.length];
				for (int i = 0; i < numbers.length; i++) {
					int currentNumber = numbers[i];
					Node node = new Node(null, currentNumber);
					allNodes[i] = node;
					
					int sum = 0;
					Node parentNode = null;
					for (int j = 0; j < i; j++) {
						if(allNodes[j].number < node.number && sum < allNodes[j].sum){
							sum = allNodes[j].sum;
							parentNode = allNodes[j];
						}
					}
					node.parent = parentNode;
					if(parentNode!=null){
						node.sum = parentNode.sum + node.number;
						parentNode.child.add(node);
					}
					if(maxSum < node.sum){
						maxSum = node.sum;
					}
				}

				System.out.println(maxSum);
			}

		} catch (IOException e) {
		}

	}

}

class Node {
	Node parent;
	List<Node> child = new ArrayList<Node>();
	int number;
	int sum;

	public Node(Node parent, int number) {
		super();
		this.parent = parent;
		this.number = number;
		this.sum = number;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + ", sum=" + sum + "]";
	}

}
