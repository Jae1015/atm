//AUTOMATED TILLER MACHINE(ATM)- FRAME1

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Image;
import java.io.File;
import java.awt.BorderLayout;
class Welcome extends JFrame implements ActionListener
{
	public static void main(String ar[])
	{
		new Welcome();
	}
	JButton next;
	JLabel bg = null;
	public Welcome()
	{
		
		JLabel wel=new JLabel("WELCOME!!!");
		JLabel l_state1=new JLabel("Thanks for supporting our initiative");
		JLabel l_state2=new JLabel(" towards paperless banking!");
		next=new JButton("NEXT");
		setLayout(new BorderLayout());
	
	try
	{
	bg=new JLabel(new ImageIcon(ImageIO.read(new File("5_biggest_AustinPixels.jpg"))));
	getContentPane().add(bg);	
	}
	catch(Exception ex)
	{
		System.err.println(ex);
	}
	bg.setLayout(null);

		
		next.addActionListener(this);
		
		Font f1=new Font(Font.SANS_SERIF,Font.BOLD,80);
		wel.setFont(f1);
		wel.setForeground(Color.BLACK);
		Font f2=new Font(Font.SERIF,Font.BOLD,40);
		l_state1.setFont(f2);
		l_state2.setFont(f2);
		
		l_state1.setForeground(Color.BLUE);
		l_state2.setForeground(Color.BLUE);
			
		next.setFont(new Font(Font.SERIF,Font.BOLD,30));
		next.setBackground(Color.LIGHT_GRAY);

		wel.setBounds(450,20,800,250);
		next.setBounds(500,300,200,70);
		l_state1.setBounds(5,590,5500,100);
		l_state2.setBounds(5,620,490,100);

			
		bg.add(wel);
		bg.add(next);
		bg.add(l_state1);
		bg.add(l_state2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(1600,800);
		setVisible(true);
		setTitle("ATM");
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==next)
		{
			new AccNum();
			dispose();
		}
	}

}

