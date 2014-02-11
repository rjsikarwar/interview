/**
* Given a set of integers and allowed to apply sign change operation
* on all elements. Write an efficient algorithm to find minim sum.
* The minimum sum should be greater than or equal to zero
* e.g. if Set is {2,1,3,4,2} minimum sum is 0 since you can modify 
* the original set as{-2, -1, -3, 4, 2}.
*/
public class MinSum{
	public static int minSum(int[] set){
		if(set.length == 0){
			return 0;
		}

		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		for(int i:set){
			maxHeap.push(Math.abs(i));
		}
		int tempItem = 0;
		int anotherItem = 0;
		int minus = 0;
		while(maxHeap.size() > 1){
			tempItem = maxHeap.pop();
			anotherItem = maxHeap.pop();
			minus = tempItem - anotherItem;
			maxHeap.push(minus);
		}

		return maxHeap.pop();

	}

	public static void main(String[] args){
		int[] set = new int[]{ -2,1,3,4,2, 5};
		System.out.println(minSum(set));
	}
}
