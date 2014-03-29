import java.util.List;
import java.util.PriorityQueue;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
* Merge class which provides the method merge 
* which uses a list of sorted inputstreams and output a stream which is combines 
* the inputstreams and also sorted.
*
* @author zhaohui
*/
public class Merge{
  /**
  * Inner class Combine used to combines each integer in the streams and its
  * location in the list of streams. It will be useful in the merge method
  * to get next element in a stream when the element before it has been poped.
  */
  private class Combine implements Comparable<Combine>{
    public int val;
    public int ind;
    public Combine(int value, int index){
      val = value;
      ind = index;
    }

    @Override
    public int compareTo(Combine another){
      return val - another.val;
    }
  }

  /**
  * 
  * merge method is used to merge a list of sorted inputstream and give a sinlge, 
  * sorted output stream
  * 
  * @param input the list of inputstream
  *        output the sorted, merged output stream
  */
  public void merge(List<InputStream> input, OutputStream output){
    int len = input.size();
    PriorityQueue<Combine> heap = new PriorityQueue<Combine>(len);
    try{
      for(int i = 0; i < len; i++){
        heap.add(new Combine(input.get(i).read(), i));
      }
      while(heap.size() > 0){
        Combine smallest = heap.poll();
        output.write(smallest.val);
        int index = smallest.ind;
        if(input.get(index).available() > 0){
          heap.add(new Combine(input.get(index).read(), index));
        }
      }
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }

  /**
  * 1. What is the complexity of your algorithm? Do you think it is the best?
  *    Suppose we have k inputstream in the list and overall n integers in all the inputstream.
  * 
  * The time complexity of my algorithm is O(n * logk) and space complexity is O(n). The algorithm includes two parts: build 
  * the heap use O(k * logk), each write to the outputstream is O(logk) so total time complexitity is O(k * logk + n * logk) = O(n * logk).
  * Each item in the stream list is initialized with a Combine Object so space complexity is O(n). We can also use a map here to indicates 
  * each item's position but I suppose there are duplicates integers in the input stream list, so I use a class to combines the value and index.
  *
  * I think its the best cause the critical part of this problem is to find the next minimum after we pop out one. 
  * The alternative method is to use a list (length is k) to maintain current poped item of each inputstream and 
  * the time complexitiy to find the min is O(n). If we use a min-Heap, the time will be O(logk) and we cannot do better :)
  *
  *
  * 2. Considerations you might make if the input streams are reading from disk and output written to disk.
  * 
  * Because IO operation is a performance hit so if we are reading from and writting to disk, we can maintains a list for each input stream in
  * memory and we first read all integers into the list in memory before the merge method instead of reading from disk one by one. Also we put
  * the output integers in a list and then write to disk at one time.
  * 
  * 3. How might you change your algorithm / data structures to improve concurrency? 
  * Because in Java API ProrityQueue is not synchronized (not thread-safe) so the above merge method cannot work by multiple threads.
  * If we want to make it thread safe, we should use a synchronized queue or we defines our own thread safe heap. We can then allows multiple thread
  * to read from the input stream (say one thread for one input stream) concurrently, and these threads share a single synchronized heap, which could
  * return the smallest integer in the heap at one time. This could improve the concurrency in a multiple threads environment.
  *
  * 4. How much time did you spend on the problem? Any interesting realizations or challenges?
  * 
  * I spend about 30 minutes on the program and 20 minutes on these four questions. I think this problem and the solution is very useful in several
  * places. For example if we want to sort a very large list which extends the capacity of the memory. We can divide it to several small parts, 
  * and sort them seperately. And then we use the method works like the method merge above to merge them togother to return a sinle sorted list.
  **/
}