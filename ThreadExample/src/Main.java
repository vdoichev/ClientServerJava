public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        for (int t = 0; t < 5; t++)
            new Thread(worker).start();
    }
}
