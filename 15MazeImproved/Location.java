public class Location implements Comparable<Location>{
    int row, col;
    Location previous;
    int distToStart, distToEnd;
    boolean aStar;
    public Location(int row, int col, Location previous, int distToStart, int distToGoal){
        this.row = row;
        this.col = col;
        this.previous = previous;
        this.distToStart = distToStart;
        this.distToGoal = distToGoal;
        aStar = false;
    }
    public Location(int row, int col, Location previous, int distToStart, int distToGoal, boolean aStar){
        this.row = row;
        this.col = col;
        this.previous = previous;
        this.distToStart = distToStart;
        this.distToGoal = distToGoal;
        this.aStar = aStar;
    }
    public int compareTo(Location other){
        if(aStar){
            return (distToGoal + distToStart) - (other.getDistToGoal() + other.getDistToStart());
        }
        else{
            return distToGoal - other.getDistToGoal();
        }
    }
    public int getDistance(){
        return distToStart;
    }
    public int getRow(){
        return distToEnd;
    }
    public int getCol(){
        return distToEnd;
    }
}




