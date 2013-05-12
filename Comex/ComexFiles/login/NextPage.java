//java program for applet that receives an integer in one field and computes its factorial value when comout button is clicked
//<applet code="FactorialApplet.class" width="300" height="500" > </applet>
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class  NextPage extends JApplet implements ActionListener
{
	JPanel p1,p2;
	JLabel label1,label2;
	JTextField input,result;
	JButton compute;

	public void init()
	{
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		label1=new JLabel("Enter the number : ");
		label2=new JLabel("Factorial is : ");
		input= new JTextField(5);
		result= new JTextField(5);
		compute =new JButton("Compute");
		compute.addActionListener(this);
		p1=new JPanel();
		p2=new JPanel();
		p1.setBackground(Color.pink);
		p2.setBackground(Color.green);
		p1.add(label1);
		p1.add(input);
		p1.add(label2);
		p1.add(result);
		p2.add(compute);
		con.add(p1,BorderLayout.NORTH);
		con.add(p2,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae)
	{
		int fact=1;
		int number=Integer.parseInt(input.getText());
		if (ae.getSource()==compute)
		{
			for (int i=1;i<=number;i++)
			{
				fact=fact*i;
			}
			result.setText(""+fact);
		}
	}
}
