import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private String textBuffer = "";

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        //try{
        animate = false;
        try{
            loadMaze(filename);
        }
        catch(FileNotFoundException e){
            System.out.println(filename + " is invalid");
            System.exit(0);
        }
        writeMaze();
        if(!textBuffer.contains("E") || !textBuffer.contains("S")){
            System.out.println("File does not contain both a start and end");
            System.exit(0);
        }
       // }
        // catch(FileNotFoundException e){
        //     System.out.println("Bad file");
        // }
    }

    public void writeMaze(){
        String[] temp = textBuffer.split("\n");
        maze = new char[temp.length][temp[0].length()];
        for(int lineNumber = 0;lineNumber < temp.length;lineNumber ++){
            for(int i = 0;i < temp[lineNumber].length();i ++){
                maze[lineNumber][i] = temp[lineNumber].charAt(i);
            }
        }
    }

    public void loadMaze(String name) throws FileNotFoundException{
        File infile = new File(name);// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(infile);
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            textBuffer += line + "\n";  
        }   
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;
            for(int row = 0; row < maze.length; row ++){
                for(int col = 0; col < maze[0].length; col ++){
                    if(maze[row][col] == 'S') {
                        startr = row;
                        startc = col;
                    }
                }
            }
            //Initialize starting row and startint col with the location of the S. 
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    public boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H" + toStringAnimate());
            try{
                wait(20);
            }
            catch(Exception e){};
        }
        if(maze[row][col] == 'E') return true;
        if((maze[row][col] == '#') || (maze[row][col] == '.') || (maze[row][col] == '@')) return false;

        maze[row][col] = '@';

        if((solve(row, col + 1)) || solve(row + 1, col) || solve(row, col - 1) || solve(row - 1, col)){  
            return true;
        }
        else{
            maze[row][col] = '.';
            return false;
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */

    public String toString(){
        String out = "";
        for(char[] each:maze){
            out += Arrays.toString(each);
            out += "\n";
        }
        return out;
    }

    public String toStringAnimate(){
        String out = "";
        for(int row = 0; row < maze.length; row ++){
            for(int col = 0; col < maze[0].length; col ++){
                if(maze[row][col] == '#') out += "\0[48;5;196";
                else if(maze[row][col] == '@') out += "\0[48;5;46 ";
                else if(maze[row][col] == '.') out += "\0[48;5;7 ";
                else out += "\0[48;5;0 ";
            }
            out += "\n";
        }
        return out;
    }

    public static void main(String[] args){
        Maze test = new Maze("data3.dat");
        test.setAnimate(false);
        test.solve();
        System.out.println(test.toString());
    }

}

//@ where the solver goes, . where it has failed and backtracks (set back to .)