import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap data;
    public FrontierPriorityQueue(){
        data = new MyHeap();
    }
    public void add(Location loc){
        data.add(loc);
    }
    public Location next(){
        return data.remove();
    }
    public Location peek(){
        return data.peek();
    }
    public boolean hasNext(){
        return !(data.peek() == null);
    }
}

