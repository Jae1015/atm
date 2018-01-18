//AUTOMATED TILLER MACHINE(ATM)- LAST FRAME

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Image;
import java.io.File;

class ThankYou extends JFrame implements ActionListener
{
	public static void main(String ar[])
	{
		new ThankYou();
	}
	JButton end;
	JLabel bg = null;
	public ThankYou()
	{
		
		JLabel wel=new JLabel("Thank You For Using Out ATM!!!!");
		JLabel l_state1=new JLabel("Thanks for supporting our initiative");
		JLabel l_state2=new JLabel(" towards paperless banking!");
		end=new JButton("EXIT!!");
		setLayout(new BorderLayout());
	
	try
	{
	bg=new JLabel(new ImageIcon(ImageIO.read(new File("pic2.jpg"))));
	getContentPane().add(bg);	
	}
	catch(Exception ex)
	{
		System.err.println(ex);
	}
	bg.setLayout(null);

		
		end.addActionListener(this);
		
		Font f1=new Font(Font.SANS_SERIF,Font.BOLD,60);
		wel.setFont(f1);
		wel.setForeground(Color.BLACK);
		Font f2=new Font(Font.SERIF,Font.BOLD,30);
		l_state1.setFont(f2);
		l_state2.setFont(f2);
		
		l_state1.setForeground(Color.BLUE);
		l_state2.setForeground(Color.BLUE);

		wel.setBounds(200,100,1000,100);
		end.setBounds(500,300,300,70);
		l_state1.setBounds(5,590,490,100);
		l_state2.setBounds(5,620,370,100);
			
		bg.add(wel);
		bg.add(end);
		bg.add(l_state1);
		bg.add(l_state2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(1600,800);
		setVisible(true);
		setTitle("ATM");
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==end)
		{
			new Welcome();
			dispose();
		}
	}

}

