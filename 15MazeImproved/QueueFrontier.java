import java.util.*;
public class QueueFrontier implements Frontier{
    private ArrayDeque<Location> data;
    public QueueFrontier(){
        data = new ArrayDeque<Location>();
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