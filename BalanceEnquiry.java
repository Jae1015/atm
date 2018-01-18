// FRAME FOR BALANCE ENQUIRY (frame 5)

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


class BalanceEnquiry extends JFrame
{
	public static void main(String ar[])
	{
		//new BalanceEnquiry(account_num3);
	}
	JLabel l_state2;
	Connection con;
	Long account_num4;
	public BalanceEnquiry(Long account_num3)
	{
		setLayout(null);
		this.account_num4=account_num3;
		JLabel  l_title=new JLabel("BALANCE ENQUIRY!!");
		JLabel l_state1=new JLabel(" Available Balance In your Account Is :");
		l_state2= new JLabel(" ");

		Font f1=new Font(Font.SANS_SERIF,Font.BOLD,45);
		l_title.setFont(f1);
		l_title.setForeground(Color.BLUE);

		Font f2=new Font(Font.SANS_SERIF,Font.PLAIN,35);
		l_state1.setFont(f2);
		l_state1.setForeground(Color.BLUE);
		
		l_state2.setFont(f1);
		l_state2.setForeground(Color.BLACK);

		l_title.setBounds(450,80,500,270);
		l_state1.setBounds(350,300,800,60);
		l_state2.setBounds(400,330,480,100);
			
		add(l_title);
		add(l_state1);
		add(l_state2);
		
		try
		{
			con = connect();
			PreparedStatement pst=con.prepareStatement("select BALANCE from atm where account_num=?");
			pst.setLong(1,account_num4);
			ResultSet rst=pst.executeQuery();
			/*if(rst.next())
			{					
				l_state2.setText(Cursor.getstring(2));
				//l_state2.setText(Float.parseFloat(a));
				new ThankYou();
				dispose();
			}*/
			rst.next();
			l_state2.setText("" + rst.getFloat("BALANCE"));
			new ThankYou();
			dispose();

		
		}	
		catch(SQLException ex)
		{
			System.err.println(ex);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(1600,800);
		setVisible(true);
		setTitle("BALANCE ENQUIRY!");
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

}

