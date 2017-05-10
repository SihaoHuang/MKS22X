public class Driver{
    public static void main(String[] args){
        RunningMedian test = new RunningMedian();
        int[] data = {1,2,3,4,5,5,5,5,5,1241,0,-2,100,100,100};
        for(int each:data){
            test.add(each);
            System.out.println(test.getMedian());
            System.out.println(test.maxHeap);
            System.out.println(test.minHeap);
        }
    }
}