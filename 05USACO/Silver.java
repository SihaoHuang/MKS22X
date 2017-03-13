import java.util.*;
import java.io.*;

public class Silver{

  String textBuffer = "";
  char[][] pasture;
  int n;
  int m;
  int t;
  int count;
  int r1;
  int c1;
  int r2;
  int c2;

  public Silver(String name){
    try{
      loadFile(name);
    }
    catch(FileNotFoundException e){
      System.exit(0);
    }
    String[] temp = textBuffer.split("\n");
    n = Integer.parseInt(temp[0].split(" ")[0]);
    m = Integer.parseInt(temp[0].split(" ")[1]);
    t = Integer.parseInt(temp[0].split(" ")[2]);

    pasture = new char[n][m];
    for(int lineNumber = 1; lineNumber < n + 1; lineNumber ++){
      for(int columnNumber = 0; columnNumber < m; columnNumber ++){
        pasture[lineNumber - 1][columnNumber] = temp[lineNumber].charAt(columnNumber);
      }
    }
  
    r1 = Integer.parseInt(temp[n + 1].split(" ")[0]) - 1;
    c1 = Integer.parseInt(temp[n + 1].split(" ")[1]) - 1;
    r2 = Integer.parseInt(temp[n + 1].split(" ")[2]) - 1;
    c2 = Integer.parseInt(temp[n + 1].split(" ")[3]) - 1;
  }

  public void loadFile(String name) throws FileNotFoundException{
      File infile = new File(name);
      Scanner inf = new Scanner(infile);
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        textBuffer += line + "\n";  
      }   
  }

  public int get(){
    if((pasture[r1][c1] == '*') || (pasture[r2][c2] == '*')) return 0;
    getH(r1, c1, r2, c2, t);
    return count;
  }

  public void getH(int r, int c, int endr, int endc, int t){
    // System.out.println(toString());
    // for(long i = 0; i < 100000; i ++){
    //   for(long j = 0; j < 1000; j ++){
    //     for(long k = 0; k < 10; k ++){
    //       long a = k;
    //     }
    //   }
    // }
    if((t == 0) && (r == endr) && (c == endc)) count ++;
    if(((r + 1) >= 0) && ((r + 1) < n) && (c >= 0) && (c < m)){
      if(pasture[r + 1][c] == '.'){
        pasture[r][c] = '@';
        getH(r + 1, c, endr, endc, t - 1);
        pasture[r][c] = '.';
      }
    }
    if(((r - 1) >= 0) && ((r - 1) < n) && (c >= 0) && (c < m)){
      if(pasture[r - 1][c] == '.'){
        pasture[r][c] = '@';
        getH(r - 1, c, endr, endc, t - 1);
        pasture[r][c] = '.';
      }
    }
    if((r >= 0) && (r < n) && ((c + 1) >= 0) && ((c + 1) < m)){
      if(pasture[r][c + 1] == '.'){
        pasture[r][c] = '@';
        getH(r, c + 1, endr, endc, t - 1);
        pasture[r][c] = '.';
      }
    }
    if((r >= 0) && (r < n) && ((c - 1) >= 0) && ((c - 1) < m)){
      if(pasture[r][c - 1] == '.'){
        pasture[r][c] = '@';
        getH(r, c - 1, endr, endc, t - 1);
        pasture[r][c] = '.';
      }
    }
    //System.out.println(toString());
  }

  public String toString(){
        String out = "";
        for(char[] each:pasture){
            out += Arrays.toString(each);
            out += "\n";
        }
        return out;
    }
  
}