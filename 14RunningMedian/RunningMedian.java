public class RunningMedian{
    public MyHeap maxHeap;
    public MyHeap minHeap;
    public RunningMedian(){
        maxHeap = new MyHeap(true);
        minHeap = new MyHeap(false);
    }
    public void add(int val){
        if(maxHeap.size() == 0){
            maxHeap.add(val);
        }
        else{
            if(val > maxHeap.peek()){
                minHeap.add(val);
            }
            else maxHeap.add(val);
            balance();
        }
    }
    public void balance(){
        if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.remove());
        }
        else if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.remove());
        }
    }
    public Double getMedian(){
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else if(maxHeap.size() > minHeap.size()) return maxHeap.peek()*1.0;
        else return minHeap.peek()*1.0;
    }
}