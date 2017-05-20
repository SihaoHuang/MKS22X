import java.util.*;
public class QueueFrontier implements Frontier{
    private LinkedList data;
    public QueueFrontier(){
        data = new LinkedList<Location>();
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