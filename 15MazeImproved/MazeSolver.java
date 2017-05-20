public class MazeSolver{
    private Maze board;
    private Frontier frontier;
    public MazeSolver(String filename){
        board = new Maze(filename);
    }
    public void solve(){
        solve(1);
    }
    public void solve(int n){
        boolean astar = false;
        if(n = 0) frontier = new StackFrontier();
        if(n = 1) frontier = new QueueFrontier();
        if(n = 2) frontier = new FrontierPriorityQueue();
        if(n = 3){
            frontier = new FrontierPriorityQueue();
            astar = true;
        }
        Location current = board.getStart()
        while(frontier.next().compareTo(board.getEnd()) != 0){
            makeValidNeighbors(current);
            board.set(current.getRow(), current.getCol(), '.');
            current = frontier.next();
        }
    }
    public String toString()
    private void makeValidNeighbors(Location loc){
        //if not # or . create location, push to stack
        if(board.get(loc.getRow() + 1, loc.getCol()) != '.' && board.get(loc.getRow() + 1, loc.getCol()) != '#'){
            front.add(toLocation(loc.getRow() + 1, loc.getCol());
        }
        if(board.get(loc.getRow() - 1, loc.getCol()) != '.' && board.get(loc.getRow() - 1, loc.getCol()) != '#'){
            front.add(toLocation(loc.getRow() - 1, loc.getCol());
        }
        if(board.get(loc.getRow(), loc.getCol() + 1) != '.' && board.get(loc.getRow(), loc.getCol() + 1) != '#'){
            front.add(toLocation(loc.getRow(), loc.getCol() + 1);
        }
        if(board.get(loc.getRow(), loc.getCol() - 1) != '.' && board.get(loc.getRow(), loc.getCol() - 1) != '#'){
            front.add(toLocation(loc.getRow(), loc.getCol() - 1);
        }
        
    }
    private int distance(Location loc1, Location loc2){
        return Math.abs(loc1.getRow - loc2.getRow) + Math.abs(loc1.getCol - loc2.getCol);
    }
    private Location toLocation(int row, int col){
        //write this
    }
}