import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
public class TextFieldTest {
static String initStr = "�������û���:";
public static void main(String[] args) {
	JTextField text = new JTextField(initStr);
	text.setForeground(Color.LIGHT_GRAY);
	
	text.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {
		JTextField src = (JTextField)e.getSource();
		src.setForeground(Color.blue);
			if(src.getText().equals(initStr)){
				src.setText(null);
			}
		}
	public void focusLost(FocusEvent e)
	{
		JTextField src = (JTextField)e.getSource();
		if(src.getText().trim().isEmpty()){
			src.setText(initStr);
			src.setForeground(Color.LIGHT_GRAY);
		}
	}});

JFrame f= new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(180,90);
f.add("North",new JTextField("�������,���ŵ�㿴~~"));
f.add(text);
f.setLocationRelativeTo(null);
f.setVisible(true);
}
}