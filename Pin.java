// FRAME3 -PIN
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
	
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Image;
import java.io.File;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


class Pin extends JFrame implements ActionListener
{
	public static void main(String ar[])
	{
		//new Pin(account_num);
	}
	JLabel bg=null;
	JButton next;
	JTextField text;
	Connection con;
	long account_num2;
	public Pin(long account_num)
	{
		setLayout(new BorderLayout());
			
		this.account_num2=account_num;
		JLabel label=new JLabel("Please enter your PIN!");
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

		label.setBounds(300,20,1200,250);
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
			String s_pin=text.getText();
			int i_pin=Integer.parseInt(s_pin);
			System.out.println(i_pin);
			try
			{
				con = connect();
				PreparedStatement pst=con.prepareStatement("select pin from atm where pin=? and account_num=?");
				pst.setLong(1,i_pin);
				pst.setLong(2,account_num2);
				ResultSet rst=pst.executeQuery();
				if(rst.next())
				{
					System.out.println("PIN MATCHED");
					new Options(account_num2);
					dispose();
				}
				else
				{
					System.out.println("INVALID PIN!");
					JOptionPane pane=new JOptionPane();
					pane.showMessageDialog(this,"INVALID PIN!");
				}
			}	
			catch(SQLException ex)
			{
				System.err.println(ex);
			}
			
		}
	
	}

}