import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.nio.*;




public class comex extends Frame implements ActionListener,ItemListener
{
	
	TextField cntf,atf;
	TextArea pta,ota,bta;
	Label l1,l2,l3,l4,l5;
	Button compile,comex,save,backupb;
	Checkbox def,argu,bip;
        
		comex(){
		Frame fram;
		fram.setVisible(true);
		}
		
   public static void main (String args[]) {
final comex app;
app.init();
app.start();
fram = new Frame("Title");
fram.addWindowListener (
new WindowAdapter() {
public void windowClosing(WindowEvent e) {
app.stop();
app.destroy();
System.exit(0);
}
}
);
fram.setSize (513,622);
fram.add("Center", app);

}

		
    

   	
	 				
			

	public void init()
	{
		    
		fram.setVisible(true);
		
		setBackground(Color.gray);
			Font f=new Font("Berlin Sans FB",Font.BOLD,32);
			Font f1=new Font("Arial",Font.BOLD,12);
			Font f2=new Font("Arial",Font.BOLD,8);
		l3=new Label("COMEX 1.0");
		l3.setFont(f);
		l3.setBackground(Color.gray);
		fram.add(l3);
		
		l4=new Label("                                                                             A Simple Java Compiler and Executor(by Naresh & co.)                                                                           ");
		l4.setFont(f2);
		l4.setBackground(Color.gray);
		fram.add(l4);
		
		l1=new Label("MainClassName:");
		l1.setFont(f1);
		fram.add(l1);
		l1.setBackground(Color.gray);
		cntf=new TextField(52);
		cntf.setBackground(Color.lightGray);
		fram.add(cntf);
		
		l2=new Label("Program: --------------------------------------------------------------------------------------------------------------");
		l2.setFont(f1);
		l2.setBackground(Color.gray);
		fram.add(l2);
		pta=new TextArea(15,70);
		pta.setBackground(Color.lightGray);
		fram.add(pta);
		
		
		
 		
 		def=new Checkbox("  Default       ",null, true);
        fram.add(def);                                                          

		
		argu=new Checkbox("  With arguments: " );
		fram.add(argu);
		atf=new TextField(37);
		atf.setBackground(Color.lightGray);
		fram.add(atf);
		argu.addItemListener(this);
		
		bip=new Checkbox("  BufferedInput:");
		fram.add(bip);
		bta=new TextArea(2,53);
		bta.setBackground(Color.lightGray);
		fram.add(bta);
		bip.addItemListener(this);
		
		save=new Button("        Save        ");
		fram.add(save);
		save.addActionListener(this);
		save.setBackground(Color.lightGray);
		
		
		backupb=new Button("        Open Last Saved        ");
		fram.add(backupb);
		backupb.addActionListener(this);
		backupb.setBackground(Color.lightGray);
		
		compile=new Button("          COMPILE          ");
		fram.add(compile);
		compile.addActionListener(this);
		compile.setBackground(Color.lightGray);
		
		comex=new Button("          COMEX          ");
		fram.add(comex);
		comex.addActionListener(this);
		comex.setBackground(Color.lightGray);
		
		l5=new Label("Output: --------------------------------------------------------------------------------------------------------------");
		l5.setFont(f1);
		l5.setBackground(Color.gray);
		fram.add(l5);
		ota=new TextArea(5,70);
		ota.setBackground(Color.lightGray);
		fram.add(ota);
		
argu.addItemListener(this);
bip.addItemListener(this);
		
		
		
	
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
  
  
		
 
  
		
	
	
	
	public void itemStateChanged(ItemEvent ie){
	
	if(ie.getStateChange() == ItemEvent.SELECTED)
	   {
	   repaint();
	   }		}
	
	

	public void actionPerformed(ActionEvent ae)
	{

				String mainclass=cntf.getText();
				String mcjava=new String(mainclass+".java");
				String program=pta.getText();
				String arg=atf.getText();
				String bi=bta.getText();
				File txtc=new File("compile.txt");
				File txt=new File("comex.txt");
				String compilecode="javac "+ mainclass +".java 2> compile.txt";
				String comexcode="javac "+ mainclass+".java 2> compile.txt \njava "+ mainclass+ " >>comex.txt";
				
	File backup=new File("backup.txt");

	
	   

			try
		{
		
		if (ae.getSource()==save)
			{
			writeTextFile(program,backup);
			ota.setText("Saved!!!");
			}
			if(ae.getSource()==backupb)
			{
			
			String backup1=readTextFile(backup);
		pta.setText(backup1);
		ota.setText("Backup Retrieved!!!");
		
			}
			
			if (ae.getSource()==compile)
			{
				
			 if(mainclass.equals("")&&program.equals("")){
			JOptionPane.showMessageDialog(null,"Please enter the mainclass name and program!!");
			cntf.requestFocus();
			pta.requestFocus();
				}
			else if(mainclass.equals("")){
			JOptionPane.showMessageDialog(null,"Please enter the mainclass name!");
			cntf.requestFocus();
			}else if(program.equals("")){
			JOptionPane.showMessageDialog(null,"Please enter the Program!!");
			pta.requestFocus();
			}
			else{
			
				File f=new File(mcjava);
				File bat=new File("comex.bat");
				
				if (!f.exists()) {
				f.createNewFile();
				
				}
				if(f.exists()) {
				writeTextFile(program,f);
				writeTextFile(program,backup);
				
				
				writeTextFile(compilecode,bat);				
                			
				Runtime run = Runtime.getRuntime();
				Process pp=run.exec("comex.bat"); 
				pp.waitFor();
				String st5=readTextFile(txtc);
				if(st5.equals("")==true){ota.setText("No Errors!!!");}
				else{ota.setText(st5);}
				 
				 }
				 File clas=new File(mainclass+".class");
				 File compi=new File("compile.txt");
				 compi.delete();
				 f.delete();
				 clas.delete();
				 bat.delete();
				
				 
								}
								
			}
			
			
			if (ae.getSource()==comex)
			{
			
			
			if(mainclass.equals("")&&program.equals("")){
			JOptionPane.showMessageDialog(null,"Please enter the mainclass name and program!!");
			cntf.requestFocus();
			pta.requestFocus();
				}
			else if(mainclass.equals("")){
			JOptionPane.showMessageDialog(null,"Please enter the mainclass name!");
			cntf.requestFocus();
			}else if(program.equals("")){
			JOptionPane.showMessageDialog(null,"Please enter the Program!!");
			pta.requestFocus();
			}
				else{
				File f1 = new File(mcjava);
				File bat1=new File("comex.bat");
				if (!f1.exists()) {
				f1.createNewFile();
				
				}
				if(f1.exists()) {
				writeTextFile(program,f1);
				writeTextFile(program,backup);
				//Searching
 String substring1 = "args[0]";
 String substring2= ".readLine()";
        boolean found1 = false;
		boolean found2 = false;
        int max1 = program.length() - substring1.length();
		int max2 = program.length() - substring2.length();
test1:
        for (int i = 0; i <= max1; i++) {
            int n1 = substring1.length();
            int j1 = i;
            int k1 = 0;
            while (n1-- != 0) {
                if (program.charAt(j1++)
                        != substring1.charAt(k1++)) {
                    continue test1;
                }
            }
            found1 = true;
                 break test1;
				 
        }
test2:
        for (int i = 0; i <= max2; i++) {
            int n2 = substring2.length();
            int j2 = i;
            int k2 = 0;
            while (n2-- != 0) {
                if (program.charAt(j2++)
                        != substring2.charAt(k2++)) {
                    continue test2;
                }
            }
            found2 = true;
                 break test2;
				 
        }



if((found1==true)&&(argu.getState()==false)){
JOptionPane.showMessageDialog(null,"Please enter arguments(Comex detected that ur program contains arguments)!!");
			atf.requestFocus();
			} 
			else if((found2==true)&&(bip.getState()==false)){
			JOptionPane.showMessageDialog(null,"Please enter buffered input(Comex detected that ur program contains input)!!");
			bta.requestFocus();
			}
			
			else if((def.getState()==true)||((found2==true)&&(bip.getState()==true))||((found1==true)&&(argu.getState()==true))){

boolean mn=false;			
do{
		
	
		if(((argu.getState())==true)&&(bip.getState())==true){
		if((bi.equals(""))||(arg.equals(""))){JOptionPane.showMessageDialog(null,"Please enter arguments and/or buffered i/p!!");
			atf.requestFocus();
			break;
			}
			else{
			comexcode="javac "+ mcjava + " 2> compile.txt \njava "+ mainclass + " " + arg + " >> comex.txt < inputbi.txt >> comex.txt";
			mn=true;
			}}
			else if(argu.getState()==true){if(arg.equals("")){JOptionPane.showMessageDialog(null,"Please enter the arguments!");
			atf.requestFocus();
			break;
			}
			 else{
			 comexcode="javac "+ mainclass+".java 2> compile.txt \njava "+ mainclass + " " + arg +  " >> comex.txt";
			 mn=true;}}
			 else if(bip.getState()==true){
			 if(bi.equals("")){JOptionPane.showMessageDialog(null,"Please enter the Buffered Input!");
			bta.requestFocus();
			break;
			}
			 else{
			 comexcode="javac "+ mainclass+".java 2> compile.txt \njava "+ mainclass + " < inputbi.txt >> comex.txt";
			 mn=true;}
		}
		else{
		comexcode="javac "+ mainclass+".java 2> compile.txt \njava "+ mainclass+ " >>comex.txt";
		mn=true;
		}}while(mn==false);
		if(mn==true){
			File inputbi=new File("inputbi.txt");
				writeTextFile(bi,inputbi);

				
               

				writeTextFile(comexcode,bat1);
                								
				Runtime run1 = Runtime.getRuntime();
				Process pp1=run1.exec("comex.bat"); 
				pp1.waitFor();
				String st1=readTextFile(txtc);
				String st=readTextFile(txt);
				if(st1.equals("")==true){ota.setText("Compilation Errors:\nNo Errors!!!\nExecution:\n"+st);}
				else{
				String x="Compilation Errors:\n"+st1;
				String y="\nExecution:\n"+st;
				ota.setText(x+y);
				}
				inputbi.delete();
				
				File clas1=new File(mainclass+".class");
				File comp=new File("compile.txt");
				File come=new File("comex.txt");
				f1.delete();
				comp.delete();
				come.delete();
				clas1.delete();
				
				bat1.delete();
			
				}}
				else{JOptionPane.showMessageDialog(null,"Error!!!");
				}
				}
				}
				}
				
	
				
				
				

				
			
			
 
		}catch (Exception e)
		{
		JOptionPane.showMessageDialog(null,"Error!!!");
		}
			
	}		
	
			
			
			public static void writeTextFile(String contents, File fullPathFilename) throws IOException{
			BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathFilename));
			writer.write(contents);
			writer.flush();
			writer.close();	
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
			
			
		}		
                     

            








          