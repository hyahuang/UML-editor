package button;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Basicbtn extends JButton {
	public Basicbtn(int x,int y,int width,int height, ArrayList<Basicbtn> btnlist) {
		this.setBounds(x, y, width, height);
		this.setBackground(Color.white);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	buttonaction(btnlist);
            	setcurrentmode();
            }
        });
	}
	
	public void buttonaction(ArrayList<Basicbtn> btnlist) {
        for (int x = 0; x < btnlist.size(); x++) {
            btnlist.get(x).setBackground(Color.white);
            this.setBackground(Color.gray);
        }
	}
	public void setcurrentmode() {}
	

}
