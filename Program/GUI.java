import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener{

	public static int num;
	public static String opt1, opt2;
	public static JLabel label1, label2, label3, label4, label5;
	public static JTextField textfield1, textfield2, textfield3, textfield4;
	public static JFrame frame;
	public static JButton submit;
	
	
	public GUI(){
		frame = new JFrame();
		frame.setTitle("Password Generator");
		
		label1 = new JLabel("New PW Length: ");
		label1.setBounds(10, 10, 120, 100);
		frame.add(label1);
		
		label2 = new JLabel("Include Alphabets? ");
		label2.setBounds(10, 50, 120, 100);
		frame.add(label2);
		
		label3 = new JLabel("Include Specials? ");
		label3.setBounds(10, 90, 120, 100);
		frame.add(label3);
		
		label4 = new JLabel();
		label4.setBounds(10, 200, 300, 100);
		frame.add(label4);
		
		label5 = new JLabel();
		label5.setBounds(10, 240, 300, 100);
		
		textfield1 = new JTextField("");
		textfield1.setBounds(130, 45, 130, 30);
		frame.add(textfield1);
		
		textfield2 = new JTextField("");
		textfield2.setBounds(130, 85, 130, 30);
		frame.add(textfield2);
		
		textfield3 = new JTextField("");
		textfield3.setBounds(130, 125, 130, 30);
		frame.add(textfield3);
		
		textfield4 = new JTextField("");
		textfield4.setBounds(130, 235, 130, 30);
		
		submit = new JButton("Generate");
		submit.setBounds(90, 170, 100, 40);
		frame.add(submit);
		submit.addActionListener(this);
		
		frame.setSize(300,400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		GUI Start = new GUI();
	}
	
	public static int getNum() { return num; }
	public static String getOpt1() { return opt1; }
	public static String getOpt2() { return opt2; }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		switch (clicked.getText()){
		
		case "Generate":
			num = Integer.parseInt(textfield1.getText());
			opt1 = textfield2.getText();
			opt2 = textfield3.getText();
			
			PWGen2 Start = new PWGen2();
			
			label5.setText("PW Length: " + num + ", Alphabets: " + opt1 + ", Specials: " + opt2);
			label4.setText("New Password: ");
			frame.add(textfield4);
			frame.add(label5);
				
			textfield4.setText(PWGen2.Final);
			textfield1.setText("");
			textfield2.setText("");
			textfield3.setText("");
				
			break;
		}
		
	}

}
