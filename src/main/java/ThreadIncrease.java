/**
 * Created by stk on 16/01/21.
 */
public class ThreadIncrease extends Thread{
    private boolean running;
    private MyServo servo;

    public void start(MyServo s){
        running = true;
        servo = s;
        super.start();
        System.out.println("increase is running");
    }

    @Override
    public void run(){
        while(running){
            servo.increase();
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
