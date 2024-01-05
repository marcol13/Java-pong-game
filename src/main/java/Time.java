public class Time {
    public static double startTime = System.nanoTime();

    public static double getTime(){
        return (startTime - System.nanoTime()) * 1E-9;
    }
}
