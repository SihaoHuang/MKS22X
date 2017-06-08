public class MazeSolver{
    private Maze board;
    private Frontier frontier;
    private boolean animate;
    public MazeSolver(String filename){
        board = new Maze(filename);
    }
    public MazeSolver(String filename, boolean animate){
        board = new Maze(filename);
        this.animate = animate;
    }
    public String toString(){
        return board.toString();
    }
    public String toString(int n){
        return board.toString(n);
    }
    public void solve(){
        solve(1);
    }
    private void makeValidNeighbors(Location loc, boolean astar){
        //if not # or . create location, push to stack
        if(board.get(loc.getRow() + 1, loc.getCol()) != '.' && board.get(loc.getRow() + 1, loc.getCol()) != '#'){
            frontier.add(toLocation(loc.getRow() + 1, loc.getCol(), loc, astar));
            board.set(loc.getRow()  + 1, loc.getCol(), '?');
        }
        if(board.get(loc.getRow() - 1, loc.getCol()) != '.' && board.get(loc.getRow() - 1, loc.getCol()) != '#'){
            frontier.add(toLocation(loc.getRow() - 1, loc.getCol(), loc, astar));
            board.set(loc.getRow()  - 1, loc.getCol(), '?');
        }
        if(board.get(loc.getRow(), loc.getCol() + 1) != '.' && board.get(loc.getRow(), loc.getCol() + 1) != '#'){
            frontier.add(toLocation(loc.getRow(), loc.getCol() + 1, loc, astar));
            board.set(loc.getRow(), loc.getCol() + 1, '?');
        }
        if(board.get(loc.getRow(), loc.getCol() - 1) != '.' && board.get(loc.getRow(), loc.getCol() - 1) != '#'){
            frontier.add(toLocation(loc.getRow(), loc.getCol() - 1, loc, astar));
            board.set(loc.getRow(), loc.getCol() - 1, '?');
        }
    }
    private int distance(int row, int col, Location loc2){
        return Math.abs(row - loc2.getRow()) + Math.abs(col - loc2.getCol());
    }
    private Location toLocation(int row, int col, Location loc, boolean astar){
        return new Location(row, col, loc, distance(row, col, board.getStart()), distance(row, col, board.getEnd()), astar);
    }
    public static void main(String[] args){
        String filename = args[0];
        int solveMethod = Integer.parseInt(args[1]);
        MazeSolver solver = new MazeSolver(filename);
        System.out.println(solver.toString());
        solver.solve(solveMethod);
        System.out.println(solver.toString());
    }
    public void solve(int n){
        if(animate) System.out.println(toString(50));
        boolean astar = false;
        if(n == 0) frontier = new StackFrontier();
        if(n == 1) frontier = new QueueFrontier();
        if(n == 2) frontier = new FrontierPriorityQueue();
        if(n == 3){
            frontier = new FrontierPriorityQueue();
            astar = true;
        }
        frontier.add(board.getStart()); //add start
        board.set(board.getStart().getRow(), board.getStart().getCol(), '?');
        //System.out.println("here 1");
        while(frontier.hasNext()){ //remember to write hasNext
            //System.out.println("here 2");
            Location current = frontier.next();
            if(current.compareTo(board.getEnd()) == 0){ //if solved, loop through and set @
                while(current.previous != null){
                    board.set(current.getRow(), current.getCol(), '@');
                    current = current.previous;
                }
                return;
            }
            board.set(current.getRow(), current.getCol(), '.');
            makeValidNeighbors(current, astar); //makeValidNeighbors adds the ?
        }
    }
    // public void solve(){
    //     solve(1);
    // }
}
    
// to solve():
//     rest = new frontier
//     rest.add(getStart(maze))
//     while(rest.size > 0):
//         current = rest.next; set to .
//         if(solved) traceBackWith'@'(current); return; //just loop back with loc = loc.previous
//         addValidNeighbors; set to ?
        
