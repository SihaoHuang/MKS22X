import java.util.*;
public class QueueFrontier implements Frontier{
    private Queue<Location> data;
    public QueueFrontier(){
        data = new LinkedList<Location>();
    }
    public void add(Location loc){
        data.add(loc);
    }
    public Location next(){
        return data.remove();
    }
    public boolean hasNext(){
        return !(data.peek() == null);
    }
}