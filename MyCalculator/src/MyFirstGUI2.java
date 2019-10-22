import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFirstGUI2 extends JFrame implements ActionListener, MouseListener 
{
	JButton xButton, yButton;
	JLabel label1;
	JPanel myPanel;
	
	public MyFirstGUI2() 
	{
		xButton = new JButton("X");
		yButton = new JButton("Y");
		label1 = new JLabel("Leave me alone!!!");
		myPanel = new JPanel();
		
		myPanel.add(xButton, BorderLayout.WEST);
		myPanel.add(yButton, BorderLayout.CENTER);
		myPanel.add(label1, BorderLayout.EAST);
		
		add(myPanel, BorderLayout.CENTER);
		xButton.addActionListener(this);
		yButton.addActionListener(this);
		xButton.addMouseListener(this);
		yButton.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == xButton)
		{
			label1.setText("xButton");
		}
		else if (e.getSource() == yButton)
		{
			label1.setText("yButton");
		}
	}
	
	public void mouseClicked (MouseEvent e)
	{
		
	}
	
	public void mousePressed (MouseEvent e)
	{
		if(e.getSource() == xButton)
		{
			label1.setText("xButton is hurting");
		}
		else if (e.getSource() == yButton)
		{
			label1.setText("yButton is crying");
		}
	}
	
	public void mouseEntered (MouseEvent e)
	{
		if(e.getSource() == xButton)
		{
			label1.setText("Hovering on X");
		}
		else if (e.getSource() == yButton)
		{
			label1.setText("Hovering on Y");
		}
	}
	
	public void mouseExited (MouseEvent e)
	{
		if(e.getSource() == xButton)
		{
			label1.setText("Mouse left X");
		}
		else if (e.getSource() == yButton)
		{
			label1.setText("Mouse left Y");
		}
	}
	
	public void mouseReleased (MouseEvent e)
	{
		if(e.getSource() == xButton)
		{
			label1.setText("Thanks!");
		}
		else if (e.getSource() == yButton)
		{
			label1.setText("Don't ever do that again!!!");
		}
	}
}
