public interface Frontier{
    boolean hasNext();
    void add(Location loc);
    Location next(); 
} 
