import processing.core.PApplet;
import processing.serial.*;
import cc.arduino.*;



/**
 * Created by stk on 16/01/17.
 */
public class PythagoraJavach extends PApplet {

    public MyServo[] servos;
    private Arduino arduino;
    private JavachGui gui;

    @Override
    public void setup() {
        println(Arduino.list()[1]);
        frameRate(10);
        arduino = new Arduino(this, Arduino.list()[1], 57600);
        servos = new MyServo[4];
        gui = new JavachGui(arduino, servos);

        servos[0] = new MyServo(arduino, 4, 0);
        servos[1] = new MyServo(arduino, 7, 0);
        servos[2] = new MyServo(arduino, 8, 0);
        servos[3] = new MyServo(arduino, 12, 90);

        for(int i = 0; i < servos.length; i++) {
            arduino.pinMode(servos[i].getPinNum(), Arduino.SERVO);
        }
    }

    public static void main(String[] args) {
        PApplet.main("PythagoraJavach");
    }
}
