//AUTOMATED TILLER MACHINE(ATM)- FRAME5

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

class Options extends JFrame implements ActionListener
{
	public static void main(String ar[])
	{
		//new Options(account_num2);
	}
	JButton  bal_enq, withdrawl, pin_change; 
	long account_num3;
	
	public Options(Long account_num2)
	{
		setLayout(null);
		this.account_num3=account_num2;
		bal_enq=new JButton("BALANCE ENQUIRY");
		withdrawl= new JButton("CASH WITHDRAWL");
		pin_change= new JButton("PIN CHANGE");
	
		bal_enq.addActionListener(this);
		withdrawl.addActionListener(this);
		pin_change.addActionListener(this);
			
		bal_enq.setBounds(500,180,400,80);
		withdrawl.setBounds(500,380,400,80);
		pin_change.setBounds(500,580,380,80);

		Font f=new Font(Font.SANS_SERIF,Font.BOLD,35);
		bal_enq.setFont(f);
		bal_enq.setForeground(Color.BLACK);
		withdrawl.setFont(f);
		withdrawl.setForeground(Color.BLACK);
		pin_change.setFont(f);
		pin_change.setForeground(Color.BLACK);
			
		add(bal_enq);
		add(withdrawl);
		add(pin_change);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.out.println(account_num3);

		setSize(1600,800);
		setVisible(true);
		setTitle("DIFFERENT OPTIONS");
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bal_enq)
		{
			new BalanceEnquiry(account_num3);
			dispose();
		}
		else if(ae.getSource()==withdrawl)
		{
			new CashWithdrawl(account_num3);
			dispose();
		}
		else if(ae.getSource()==pin_change)
		{
			new PinChange(account_num3);
			dispose();
		}
	}

}

