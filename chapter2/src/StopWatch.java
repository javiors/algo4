public class StopWatch {
    private long start;


    public StopWatch() {
        this.start = System.nanoTime();
    }

    public void reset(){
        this.start = System.nanoTime();
    }

    public void elapsedTime(){
        System.out.println(System.nanoTime() - this.start);
    }
}
