public interface Frontier{
    int size();
    boolean hasNext();
    void add(Location loc);
    Location next();
    Location peek();    
} 
