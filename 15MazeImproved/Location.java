public class Location implements Comparable<Location>{
    int row, col;
    Location previous;
    int distToStart, distToEnd;
    boolean aStar;
    public Location(int row, int col, Location previous, int distToStart, int distToEnd){
        this.row = row;
        this.col = col;
        this.previous = previous;
        this.distToStart = distToStart;
        this.distToEnd = distToEnd;
        aStar = false;
    }
    public Location(int row, int col, Location previous, int distToStart, int distToEnd, boolean aStar){
        this.row = row;
        this.col = col;
        this.previous = previous;
        this.distToStart = distToStart;
        this.distToEnd = distToEnd;
        this.aStar = aStar;
    }
    public int compareTo(Location other){
        if(aStar){
            return (distToEnd + distToStart) - (other.getDistToEnd() + other.getDistToStart());
        }
        else{
            return distToEnd - other.getDistToEnd();
        }
    }
    public int getDistToStart(){
        return distToStart;
    }
    public int getDistToEnd(){
        return distToEnd;
    }
    public int getRow(){
        return distToEnd;
    }
    public int getCol(){
        return distToEnd;
    }
}




