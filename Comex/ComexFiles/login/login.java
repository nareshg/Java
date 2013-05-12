import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login extends Applet implements ActionListener
{
	TextField text1,text2;
	Label l1,l2,l3,l4,l5;
	Button SUBMIT;
        
	public void init()
	{
		    
			
		
		setBackground(Color.gray);
			Font f=new Font("Berlin Sans FB",Font.BOLD,32);
			Font f1=new Font("Arial",Font.BOLD,12);
			Font f2=new Font("Arial",Font.BOLD,8);
		l3=new Label("COMEX 1.0");
		l3.setFont(f);
		l3.setBackground(Color.gray);
		add(l3);
		
		l4=new Label("                                                                             A Simple Java Compiler and Executor(by Naresh & co.)                                                                           ");
		l4.setFont(f2);
		l4.setBackground(Color.gray);
		add(l4);
		
		l1=new Label("Username:");
		l1.setFont(f1);
		add(l1);
		l1.setBackground(Color.gray);
		text1=new TextField(10);
		text1.setBackground(Color.lightGray);
		add(text1);
		
		l2=new Label("PASSWORD:");
		l2.setFont(f1);
		add(l2);
		l2.setBackground(Color.gray);
		text2=new TextField(10);
		text2.setEchoChar('*');
		text2.setBackground(Color.lightGray);
		add(text2);
		
		l5=new Label("Error!!! Please check your login details!!!");
		l5.setFont(f2);
		l5.setBackground(Color.red);
		add(l5);
		l5.setVisible(false);

		
		SUBMIT=new Button("LOGIN");
		add(SUBMIT);
		SUBMIT.addActionListener(this);
		SUBMIT.setBackground(Color.lightGray);
		}
		  public void paint (Graphics g)
  {
 
   g.drawString("1010111010101011101010101111101000010101011110101010001010111101011101",8,15);
   g.drawString("0001010111011101101011101011010111101010111001011101010101111101000010",8,27);
	g.drawString("1010111010101011101010101111101000010101011110101010001010111101011101",8,39);
   g.drawString("0001010111011101101011101011010111101010111001011101010101111101000010",8,51);
	g.drawRect(5,3,497,50);
	g.drawRect(0,0,513,622);
	
  }
  
  public static String readTextFile(File fi) throws IOException{
		 FileReader rd = new FileReader(fi);
        char[] buf = new char[(int)fi.length()];
        rd.read(buf);
		String contents;
        contents= new String(buf);
		
			rd.close();	
			return contents;
			}
			
   public void actionPerformed(ActionEvent ae)
  {
  boolean b=false;
    String value1=text1.getText();
    String value2=text2.getText();
	Connection con = null;
  String url = "jdbc:mysql://localhost:3306/";
  String db = "login";
  String driver = "com.mysql.jdbc.Driver";
  String user = "root";
  String pass = "naresh";
  try{
  Class.forName(driver).newInstance();
  con = DriverManager.getConnection(url+db, user, pass);
  try{
  Statement st = con.createStatement();
  ResultSet res = st.executeQuery("SELECT * FROM  info;");
  System.out.println("user: " + "\t" + "pass: ");
  while (res.next()) {
  String s1 = res.getString("username");
  String s = res.getString("pass");
  System.out.println(s1 + "\t\t" + s);
 if (s1.equals(value1)&&s.equals(value2)) {
            setVisible(false);
    NextPage page=new NextPage();
    page.setVisible(true);
     }
    else{
     JOptionPane.showMessageDialog(null,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
     text1.setText("");
     text2.setText("");

  }}
  con.close();
  }
  catch (SQLException s){
  System.out.println("SQL code does not execute.");
  }  
  }
  catch (Exception e){
  e.printStackTrace();
  }
       
    }
    }

  

							
	
