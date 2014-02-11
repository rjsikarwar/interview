import java.util.ArrayList;
import java.util.List;

public abstract class Heap<T extends Comparable<? super T>>{
	protected List<T> heap;
	public Heap(){
		heap = new ArrayList<T>();
	}

	public void push(T item){
		heap.add(item);
		increaseKey(heap.size() - 1, item);
	}

	public T pop(){
		T top = getFirst();
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		heapify(0);
		return top;
	}

	public T getFirst(){
		return heap.get(0);
	}

	public T get(int index){
		return heap.get(index);
	}

	public int size(){
		return heap.size();
	}

	protected int parent(int i){
		if(i == 0){
			throw new IllegalArgumentException("can not find the parent of the root");
		}
		return (i - 1) / 2;
	}

	protected int left(int i){
		return 2 * i + 1;
	}

	protected int right(int i){
		return 2 * i + 2;
	}

	protected void swap(int i, int j){
		T itemAtI = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, itemAtI);
	}

	public void buildHeap(){
		int size = heap.size();
		int middle = size / 2 - 1;

		for(int i = middle; i >= 0; i--){
			heapify(i);
		}

	}

	public abstract void heapify(int i);

	public abstract void increaseKey(int i, T key);

}
