/**
 * Created by stk on 16/01/21.
 */
public class ThreadDecrease extends Thread{
    private boolean running;
    private MyServo servo;

    public void start(MyServo s){
        running = true;
        servo = s;
        super.start();
        System.out.println("decrease is running");
    }

    @Override
    public void run(){
        while(running){
            servo.decrease();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopRunning(){
        running = false;
    }
}
