package wangshangceshi;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class MyFrame extends JFrame {
	
 
	public MyFrame(final AppStudent f){
		setTitle("����һ����������ҹʳ�ã�");
		setSize(400, 500);
		setLayout(null);
		setLocation(300, 200);
		setVisible(true);
		ImageIcon image=new ImageIcon("imgs/bage.jpg");
		JLabel label=new JLabel(image);
		add(label);
		label.setBounds(0,30,400,500);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		Button btn =new Button("��ȷ��������������ҹʳ�ù���ϵͳ");
		btn.setBounds(50, 0, 250, 30);
		btn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
					f.setVisible(true);
					dispose();
					
			}
		});
		add(btn);
	}
}