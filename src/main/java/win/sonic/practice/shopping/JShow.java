package win.sonic.practice.shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JShow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JShow window = new JShow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JShow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 521, 761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrGfg = new JTextArea();
		txtrGfg.setText("\u5E93\u5B58\u5C55\u793A:");
		txtrGfg.setBounds(10, 10, 485, 578);
		frame.getContentPane().add(txtrGfg);
		
		JButton btnNewButton = new JButton("\u5C55\u793A\u8D2D\u7269\u8F66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestShopping.addGoods();
				
			}
		});
		btnNewButton.setBounds(377, 657, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
