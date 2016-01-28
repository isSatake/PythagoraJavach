import cc.arduino.Arduino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Thread.sleep;

/**
 * Created by stk on 16/01/17.
 */
public class JavachGui implements MouseListener {
    private Arduino arduino;
    private JFrame window;
    private GridLayout layout;
    private JPanel panel;
    private JButton[] jController;
    private JButton[] aController;
    private JButton[] vController;
    private JButton[] aaController;
    private ThreadIncrease increase;
    private ThreadDecrease decrease;
    private MyServo[] servos;

    public JavachGui(Arduino a, MyServo[] s) {
        arduino = a;
        window = new JFrame("PythagoraJavach");
        layout = new GridLayout(1, 9);
        panel = new JPanel(layout);

        jController = new JButton[2];
        jController[0] = new JButton("i");
        jController[1] = new JButton("d");
        aController = new JButton[2];
        aController[0] = new JButton("i");
        aController[1] = new JButton("d");
        vController = new JButton[2];
        vController[0] = new JButton("i");
        vController[1] = new JButton("d");
        aaController = new JButton[2];
        aaController[0] = new JButton("i");
        aaController[1] = new JButton("d");

        jController[0].addMouseListener(this);
        jController[0].setActionCommand("0_left");
        jController[1].addMouseListener(this);
        jController[1].setActionCommand("0_right");
        aController[0].addMouseListener(this);
        aController[0].setActionCommand("1_left");
        aController[1].addMouseListener(this);
        aController[1].setActionCommand("1_stop");
        vController[0].addMouseListener(this);
        vController[0].setActionCommand("2_left");
        jController[1].addMouseListener(this);
        vController[1].setActionCommand("2_right");
        aaController[0].addMouseListener(this);
        aaController[0].setActionCommand("3_left");
        aaController[1].addMouseListener(this);
        aaController[1].setActionCommand("3_right");

        panel.add(jController[0]);
        panel.add(jController[1]);
        panel.add(aController[0]);
        panel.add(aController[1]);
        panel.add(vController[0]);
        panel.add(vController[1]);
        panel.add(aaController[0]);
        panel.add(aaController[1]);

        window.add(panel);
        window.pack();
        window.setVisible(true);

        servos = s;
    }

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        String command = ((JButton) e.getSource()).getActionCommand();
        String commands[] = command.split("_");
        System.out.println(commands[0]);
        if (commands[1].equals("left")) {
            increase = new ThreadIncrease();
            increase.start(servos[Integer.parseInt(commands[0])]);
        } else if (commands[1].equals("right")) {
            decrease = new ThreadDecrease();
            decrease.start(servos[Integer.parseInt(commands[0])]);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
        String command = ((JButton) e.getSource()).getActionCommand();
        String commands[] = command.split("_");
        if (commands[1].equals("left")) {
            increase.stopRunning();
        } else if (commands[1].equals("right")) {
            decrease.stopRunning();
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
