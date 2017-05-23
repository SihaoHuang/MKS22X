public class MazeSolver{
    private Maze board;
    private Frontier frontier;
    public MazeSolver(String filename){
        board = new Maze(filename);
    }
    public String toString(){
        return board.toString();
    }
    public void solve(){
        solve(1);
    }
    // public void solve(int n){
    //     boolean astar = false;
    //     if(n == 0) frontier = new StackFrontier();
    //     if(n == 1) frontier = new QueueFrontier();
    //     if(n == 2) frontier = new FrontierPriorityQueue();
    //     if(n == 3){
    //         frontier = new FrontierPriorityQueue();
    //         astar = true;
    //     }
    //     Location current = board.getStart();
    //     while((frontier.next().compareTo(board.getEnd()) != 0) && frontier.hasNext()){ //remember to write hasNext
    //         makeValidNeighbors(current, astar);
    //         board.set(current.getRow(), current.getCol(), '.');
    //         current = frontier.next();
    //     }
    // }
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
    }
    public void solve(int n){
        boolean astar = false;
        if(n == 0) frontier = new StackFrontier();
        if(n == 1) frontier = new QueueFrontier();
        if(n == 2) frontier = new FrontierPriorityQueue();
        if(n == 3){
            frontier = new FrontierPriorityQueue();
            astar = true;
        }
        frontier.add(board.getStart());
        board.set(board.getStart().getRow(), board.getStart().getCol(), '?');
        while(frontier.hasNext()){ //remember to write hasNext
            Location current = frontier.next();
            board.set(current.getRow(), current.getCol(), '.');
            if(frontier.next().compareTo(board.getEnd()) == 0){
                while(current.previous != null){
                    board.set(current.getRow(), current.getCol(), '@');
                    current = current.previous;
                }
                return;
            }
            makeValidNeighbors(current, astar);
        }
    }
}
    
// to solve():
//     rest = new frontier
//     rest.add(getStart(maze))
//     while(rest.size > 0):
//         current = rest.next; set to .
//         if(solved) traceBackWith'@'(current); return; //just loop back with loc = loc.previous
//         addValidNeighbors; set to ?
        
