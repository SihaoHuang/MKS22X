public class USACO{

  public USACO(){}

  public static int bronze(String filename){
    Bronze b = new Bronze(filename);
    b.makeLake();
    return b.volume();
  }

  public static int silver(String filename){
    Silver b = new Silver(filename);
    return b.get();
  }

  public static void main(String[] args){
    USACO x = new USACO();
    for(int i = 1; i < 11; i ++){
      System.out.println(silver("ctravel." + i + ".in"));
    }
    for(int i = 1; i < 11; i ++){
      System.out.println(bronze("makelake." + i + ".in"));
    }
  }

}