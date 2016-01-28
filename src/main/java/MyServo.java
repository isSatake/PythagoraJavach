import cc.arduino.Arduino;

/**
 * Created by stk on 16/01/21.
 */
public class MyServo {
    private Arduino arduino;
    private int pin;
    private int angle;

    public MyServo(Arduino a, int arduinoPin, int startAngle) {
        arduino = a;
        pin = arduinoPin;
        angle = startAngle;

        a.pinMode(arduinoPin, Arduino.SERVO);
        arduino.servoWrite(pin, angle);
    }

    public void increase(){
        if(angle >= 180){
            return;
        }
        arduino.servoWrite(pin, angle++);
        System.out.println("servo pin : " + pin + " angle : " + angle);
    }

    public void decrease(){
        if(angle <= 0){
            return;
        }
        arduino.servoWrite(pin, angle--);
        System.out.println("servo pin : " + pin + " angle : " + angle);
    }
}
