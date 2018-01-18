import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Image;
import java.io.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class AccNum extends JFrame implements ActionListener
{
	public static void main(String ar[])
	{
		new AccNum();
	}
	JLabel bg=null;
	JButton next;
	JTextField text;
	Connection con;

	public AccNum()
	{
		setLayout(new BorderLayout());
	
		JLabel label=new JLabel("PLEASE ENTER YOUR ACCOUNT NUMBER!");
		text=new JTextField(10);
		next=new JButton("NEXT");
		
		Font f=new Font(Font.SANS_SERIF,Font.BOLD,50);
		label.setFont(f);
		
		try
		{
		bg=new JLabel(new ImageIcon(ImageIO.read(new File("photo (7).jpg"))));
		getContentPane().add(bg);	
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
		bg.setLayout(null);
		
		next.setFont(new Font(Font.SERIF,Font.BOLD,30));
		next.setBackground(Color.LIGHT_GRAY);

		
		label.setBounds(80,20,1200,250);
		text.setBounds(500,200,200,50);
		next.setBounds(520,350,150,70);

		bg.add(text);
		bg.add(next);
		bg.add(label);
		next.addActionListener(this);
		
		setSize(1600,800);
		setVisible(true);
			
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public Connection connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","thekites","thekites");
		}	
		catch(ClassNotFoundException ex)
		{
			System.err.println(ex);
		}
		catch(SQLException ex)
		{
			System.err.println(ex);
		}
		
		return con;
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==next)
		{
			String acc_num2=text.getText();
			 long long_acc=Long.parseLong(acc_num2);
			System.out.println(long_acc);
			try
			{
				con = connect();
				PreparedStatement pst=con.prepareStatement("select * from atm where account_num=?");
				pst.setLong(1,long_acc);
				ResultSet rst=pst.executeQuery();
				if(rst.next())
				{
					System.out.println("ACCOUNT NUMBER MATCHED");
					new Pin(long_acc);
					dispose();
				}
				else
				{
					System.out.println("INVALID ACCOUNT NUMBER!");
					JOptionPane pane=new JOptionPane();
					pane.showMessageDialog(this,"INVALID ACCOUNT NUMBER!");
				}
			}	
			catch(SQLException ex)
			{
				System.err.println(ex);
			}
			
		}
	
	}
}