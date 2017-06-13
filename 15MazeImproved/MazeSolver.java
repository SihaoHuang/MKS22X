public class MazeSolver{
    private Maze board;
    private Frontier frontier;
    private boolean animate;
    public MazeSolver(String filename){
        board = new Maze(filename);
        animate = false;
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
    private void makeValidNeighbors(Location loc, boolean astar){
        //if not # or . create location, push to stack
        if(board.get(loc.getRow() + 1, loc.getCol()) == ' '){
            frontier.add(toLocation(loc.getRow() + 1, loc.getCol(), loc, astar));
            board.set(loc.getRow()  + 1, loc.getCol(), '?');
        }
        if(board.get(loc.getRow() - 1, loc.getCol()) == ' ' ){
            frontier.add(toLocation(loc.getRow() - 1, loc.getCol(), loc, astar));
            board.set(loc.getRow()  - 1, loc.getCol(), '?');
        }
        if(board.get(loc.getRow(), loc.getCol() + 1) == ' '){
            frontier.add(toLocation(loc.getRow(), loc.getCol() + 1, loc, astar));
            board.set(loc.getRow(), loc.getCol() + 1, '?');
        }
        if(board.get(loc.getRow(), loc.getCol() - 1) == ' '){
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
    // public static void main(String[] args){
    //     String filename = args[0];
    //     int solveMethod = Integer.parseInt(args[1]);
    //     MazeSolver solver = new MazeSolver(filename);
    //     System.out.println(solver.toString());
    //     solver.solve(solveMethod);
    //     System.out.println(solver.toString());
    // }
    public void solve() {
        solve(1);
    }
    public void solve(int style){
        boolean astar = false;
        if (style == 0) frontier = new StackFrontier();
        if (style == 1) frontier = new QueueFrontier();
        if (style == 2) frontier = new FrontierPriorityQueue(); 
        if (style == 3) {
            frontier = new FrontierPriorityQueue();
            astar = true;
        } 
        frontier.add(board.getStart());
        Location current = null;
        while (frontier.hasNext()) {
            if (animate) {
                System.out.println(board.toString(10));
            }
            current = frontier.next();
            board.set(current.getRow(), current.getCol(), '.');
            if (distance(current.getRow(), current.getCol(), board.getEnd()) == 0) {
                board.set(current.getRow(), current.getCol(), 'E');
                current = current.previous;
                while (current.previous != null) {
                    board.set(current.getRow(), current.getCol(), '@');
                    current = current.previous;
                }
                board.set(current.getRow(), current.getCol(), 'S');
                return;
            }
            makeValidNeighbors(current, astar);
        }
    }
}
