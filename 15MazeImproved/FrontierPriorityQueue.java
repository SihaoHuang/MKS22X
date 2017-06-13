import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue<Location> data;
    public FrontierPriorityQueue(){
        data = new PriorityQueue<Location>();
    }
    public void add(Location loc){
        data.add(loc);
    }
    public Location next(){
        return data.remove();
    }
    public int size(){
        return data.size();
    }
    public boolean hasNext(){
        return !(data.peek() == null);
    }
}

