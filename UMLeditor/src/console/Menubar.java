package console;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menubar extends JMenuBar {
	JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    public JMenuItem groupMenuItem = new JMenuItem("Group");
    public JMenuItem ungroupMenuItem = new JMenuItem("Ungroup");
    public JMenuItem changenameMenuItem = new JMenuItem("Change object name");
	public Menubar()
	{
		this.add(fileMenu);
        this.add(editMenu);
        editMenu.add(groupMenuItem);
        editMenu.add(ungroupMenuItem);
        editMenu.add(changenameMenuItem);
        groupMenuItem.setEnabled(false);
        ungroupMenuItem.setEnabled(false);
        changenameMenuItem.setEnabled(false);
        groupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	UMLcanvas.getInstance().addgroup();
            }
        });
        ungroupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	UMLcanvas.getInstance().removegroup();
            }
        });
        changenameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	UMLcanvas.getInstance().changeObjectName();
                System.out.println("change object name is clicked");
            }
        });
	}

}
