import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap data;
    public QueueFrontier(){
        data = new MyHeap();
    }
    public void add(Location loc){
        data.add(loc);
    }
    public Location next(){
        data.remove();
    }
    public Location peek(){
        data.peek();
    }
}

