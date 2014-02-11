import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> extends Heap<T>{
	@Override
	public void heapify(int i){
		int left = left(i);
		int right = right(i);
		if(left < heap.size() && get(left).compareTo(get(i)) > 0){
			swap(left, i);
			heapify(left);
		}else if(right < heap.size() && get(right).compareTo(get(i)) > 0){
			swap(right, i);
			heapify(right);
		}
	}

	@Override
	public void increaseKey(int i, T key){
	    while(i > 0 && key.compareTo(get(parent(i))) > 0){
            swap(i, parent(i));
            i = parent(i);
        }
	}

	public static void main(String[] args){
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		maxHeap.push(3);
		maxHeap.push(5);
		maxHeap.push(6);
		maxHeap.push(2);
		maxHeap.push(8);
		maxHeap.push(7);
		maxHeap.push(4);
		maxHeap.push(3);

		int size = maxHeap.size();
		for(int i = 0; i < size; i++){
			System.out.println(maxHeap.get(i));
		}

        
		maxHeap.pop();
		size = maxHeap.size();

		for(int i = 0; i < size; i++){
			System.out.println(maxHeap.get(i));
		}
		
	}

}
