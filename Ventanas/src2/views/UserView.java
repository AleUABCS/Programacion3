package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.UserController;
import models.UserModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;

public class UserView {

	private JFrame frame;
	private DefaultTableModel table_model_users = new DefaultTableModel();
	private JTable table_users = new JTable(table_model_users);
	private UserModel userModel;
	private UserController userController;
	JButton btnVolver = new JButton("Volver");
	
	public UserView(AuthView authView) {
		initialize();
		userModel = new UserModel();
		userController = new UserController(UserView.this, userModel, authView);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(650, 531);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(new EmptyBorder(20,0,20,0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane(table_users);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnVolver.setBackground(new Color(240, 240, 240));
		panel_2.add(btnVolver);
		
		table_model_users.setColumnIdentifiers(new Object[]{"Id", "Name", "Email", "Role", "Phone", "Create at", "Update at"});
		
	}

	public DefaultTableModel getTable_model_users() {
		return table_model_users;
	}
	
	public JButton getBtnVolver() {
			return btnVolver;
	}
	
	public void setVisible (boolean bool) {
		this.frame.setVisible(bool);
	}

public static void main(String[] args) {
	UserView userView = new UserView(null);
	}
}

