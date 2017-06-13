public interface Frontier{
    boolean hasNext();
    void add(Location loc);
    Location next();
    public int size();
} 
