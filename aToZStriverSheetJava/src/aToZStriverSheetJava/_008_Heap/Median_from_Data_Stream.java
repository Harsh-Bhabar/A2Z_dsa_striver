package aToZStriverSheetJava._008_Heap;

import java.util.PriorityQueue;

//link - https://leetcode.com/problems/find-median-from-data-stream/

public class Median_from_Data_Stream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b-a
    );

    public void balance(){
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.offer(minHeap.poll());
        }
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        balance();
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return (double) maxHeap.peek();
        }
        else if(minHeap.size() > maxHeap.size()){
            return (double) minHeap.peek();
        }
        else if(minHeap.size() == maxHeap.size()){
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return 0.0;
    }
}
