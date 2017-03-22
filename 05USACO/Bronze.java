import java.util.*;
import java.io.*;

public class Bronze{

  private String textBuffer = "";
  private int[][] steps;
  private int[][] lake;
  private int row;
  private int col;
  private int e;
  private int n;

  public Bronze(String name){
    try{
      loadFile(name);
    }
    catch(FileNotFoundException e){
      System.exit(0);
    }

    String[] temp = textBuffer.split("\n");
    row = Integer.parseInt(temp[0].split(" ")[0]);
    col = Integer.parseInt(temp[0].split(" ")[1]);
    e = Integer.parseInt(temp[0].split(" ")[2]);
    n = Integer.parseInt(temp[0].split(" ")[3]);

    lake = new int[row][col];
    for(int lineNumber = 1; lineNumber < row + 1; lineNumber ++){
      String[] buff;
      buff = temp[lineNumber].split(" ");
      for(int columnNumber = 0; columnNumber < col; columnNumber ++){
        lake[lineNumber - 1][columnNumber] = Integer.parseInt(buff[columnNumber]);
      }
    }

    steps = new int[temp.length - row - 1][3];
    for(int lineNumber = row  + 1; lineNumber < temp.length; lineNumber ++){
      String[] buff;
      buff = temp[lineNumber].split(" ");
      steps[lineNumber - row - 1][0] = Integer.parseInt(buff[0]);
      steps[lineNumber - row - 1][1] = Integer.parseInt(buff[1]);
      steps[lineNumber - row - 1][2] = Integer.parseInt(buff[2]);
    }

    //System.out.println("done");
  }

  public void loadFile(String name) throws FileNotFoundException{
      File infile = new File(name);
      Scanner inf = new Scanner(infile);
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        textBuffer += line + "\n";  
      }   
  }

  public void makeLake(){
    for(int step = 0; step < steps.length; step ++){
      int stompedHeight = findLargest(steps[step][0], steps[step][1]) - steps[step][2];
      for(int r = steps[step][0] - 1; r < steps[step][0] + 2; r ++){
        for(int c = steps[step][1] - 1; c < steps[step][1] + 2; c ++){
          if(lake[r][c] > stompedHeight) lake[r][c] = stompedHeight;
        }
      }
    }
  }

  private int findLargest(int row, int col){
    int largest = 0;
    for (int r = row - 1; r < row + 2; r ++){
      for (int c = col - 1; c < col + 2; c ++){
        if (lake[r][c] > largest){
          largest = lake[r][c];
        }
      }
    }
    return largest;
  }

  public int volume(){
    int totalDepth = 0;
    for (int i = 0; i < lake.length; i ++){
      for (int j = 0; j < lake[0].length; j ++){
        if (e - lake[i][j] > 0){
          totalDepth += e - lake[i][j];
        }
      }
    }
    return 72 * 72 * totalDepth;
  }

}