package console;
import java.awt.*;
import javax.swing.*;

public class Frame{

        public JFrame frame = new JFrame();
        public Buttonpanel buttonpanel = new Buttonpanel();
        public static Menubar menubar = new Menubar();
        public Frame(int height,int width) {
        this.frame.setSize(height, width);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(null);
        this.buttonpanel.setBounds(5, 5,100, buttonpanel.panelheight());
        UMLcanvas.getInstance().setBounds(105, 5, 800, buttonpanel.panelheight());
        this.frame.add(buttonpanel);
        this.frame.add(UMLcanvas.getInstance());
        this.frame.setJMenuBar(menubar);
        this.frame.setVisible(true);
        }

}
