// FRAME FOR BALANCE ENQUIRY (frame 5)

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


class PinChange extends JFrame implements ActionListener
{
	public static void main(String ar[])
	{
		//new PinChange(140001234567891L);
	}
	JLabel l_state2;
	Connection con;
	Long account_num4;
	JTextField t;
	JButton dispense;
	public PinChange(Long account_num3)
	{
		setLayout(null);
		this.account_num4=account_num3;
		JLabel  l_title=new JLabel("PIN CHANGE!!");
		JLabel l_state1=new JLabel(" Enter Your New Pin:");
		l_state2= new JLabel(" ");
		t=new JTextField(10);
		dispense=new JButton("CHANGE");
		
		dispense.addActionListener(this);

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
		dispense.setBounds(500,470,250,50);
		t.setBounds(500,400,200,50);
			
		add(l_title);
		add(l_state1);
		add(l_state2);
		add(dispense);
		add(t);
		
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
	public void actionPerformed(ActionEvent ae)
	{

		String pin=t.getText();
		 int i_pin=Integer.parseInt(pin);
		try
		{
			con = connect();
			JOptionPane pane=new JOptionPane();
			PreparedStatement pst2=con.prepareStatement("update atm set PIN=? where account_num=?");
			pst2.setFloat(1,i_pin);
			pst2.setLong(2,account_num4);					pst2.execute();
			pane.showMessageDialog(this,"Please PIN Has Been Updated!"); 
		
			new ThankYou();
			dispose();

		
		}	
		catch(SQLException ex)
		{
			System.err.println(ex);
		}
	}
}
		
