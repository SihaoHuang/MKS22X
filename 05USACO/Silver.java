import java.util.*;
import java.io.*;

public class Silver{

  String textBuffer = "";
  int[][] pasture;
  int[][] lastPasture;
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

    pasture = new int[n][m];
    lastPasture = new int[n][m];

    for(int lineNumber = 1; lineNumber < n + 1; lineNumber ++){
      for(int columnNumber = 0; columnNumber < m; columnNumber ++){
        if (temp[lineNumber].charAt(columnNumber) == '*'){
	    		pasture[lineNumber - 1][columnNumber] = -1;
	    		lastPasture[lineNumber - 1][columnNumber] = -1;
	    	}
		    else{
	    		pasture[lineNumber - 1][columnNumber] = 0;
	    		lastPasture[lineNumber - 1][columnNumber]= 0;
	    	}
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
    if((pasture[r1][c1] == -1) || (pasture[r2][c2] == -1)) return 0;
    // getH(r1, c1, r2, c2, t);
    count = getH(r1, c1, r2, c2);
    return count;
  }

  private int getH(int r1, int c1, int r2, int c2){
    int[] posX = {-1, 1, 0, 0};
    int[] posY = {0, 0, -1, 1};
    lastPasture[r1][c1] = 1;
    for(int iter = t; iter > 0; iter --){
      for(int r = 0; r < n; r ++){
        for(int c = 0; c < m; c ++){
          if(pasture[r][c] != -1){
            pasture[r][c] = 0;
            for(int pos = 0; pos < 4; pos ++){
              if(((r + posX[pos]) < n) && ((c + posY[pos]) < m) && ((r + posX[pos]) >= 0) && ((c + posY[pos]) >= 0)){
                if(pasture[r + posX[pos]][c + posY[pos]] != -1){
                  pasture[r][c] += lastPasture[r + posX[pos]][c + posY[pos]];
                }
              }
            }
          }
        }
      }
      for(int r = 0; r < n; r ++){
        for(int c = 0; c < m; c ++) lastPasture[r][c] = pasture[r][c];
      }
      
    }
    return lastPasture[r2][c2];
  }


  // public void getH(int r, int c, int endr, int endc, int t){
  //   // System.out.println(toString());
  //   // for(long i = 0; i < 100000; i ++){
  //   //   for(long j = 0; j < 1000; j ++){
  //   //     for(long k = 0; k < 10; k ++){
  //   //       long a = k;
  //   //     }
  //   //   }
  //   // }
  //   if((t == 0) && (r == endr) && (c == endc)) count ++;
  //   if(((r + 1) >= 0) && ((r + 1) < n) && (c >= 0) && (c < m)){
  //     if(pasture[r + 1][c] == '.'){
  //       pasture[r][c] = '@';
  //       getH(r + 1, c, endr, endc, t - 1);
  //       pasture[r][c] = '.';
  //     }
  //   }
  //   if(((r - 1) >= 0) && ((r - 1) < n) && (c >= 0) && (c < m)){
  //     if(pasture[r - 1][c] == '.'){
  //       pasture[r][c] = '@';
  //       getH(r - 1, c, endr, endc, t - 1);
  //       pasture[r][c] = '.';
  //     }
  //   }
  //   if((r >= 0) && (r < n) && ((c + 1) >= 0) && ((c + 1) < m)){
  //     if(pasture[r][c + 1] == '.'){
  //       pasture[r][c] = '@';
  //       getH(r, c + 1, endr, endc, t - 1);
  //       pasture[r][c] = '.';
  //     }
  //   }
  //   if((r >= 0) && (r < n) && ((c - 1) >= 0) && ((c - 1) < m)){
  //     if(pasture[r][c - 1] == '.'){
  //       pasture[r][c] = '@';
  //       getH(r, c - 1, endr, endc, t - 1);
  //       pasture[r][c] = '.';
  //     }
  //   }
  //   //System.out.println(toString());
  // }

  public String toString(){
        String out = "";
        for(int[] each:pasture){
            out += Arrays.toString(each);
            out += "\n";
        }
        return out;
    }
  
}