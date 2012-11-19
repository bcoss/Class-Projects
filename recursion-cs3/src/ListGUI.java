import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ListGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtDob;
	private JTextField txtSearch;
	private JTextField txtTotalAddresses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListGUI frame = new ListGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane addressPane = new JScrollPane();
		addressPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		addressPane.setViewportBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addressPane.setBounds(240, 74, 185, 208);
		contentPane.add(addressPane);

		JLabel title = new JLabel("Address List");
		title.setFont(new Font("Monospaced", Font.PLAIN, 23));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 11, 415, 36);
		contentPane.add(title);

		txtName = new JTextField();
		txtName.setBounds(19, 74, 196, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(20, 58, 61, 14);
		contentPane.add(lblNewLabel);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(19, 121, 196, 20);
		contentPane.add(txtPhone);

		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setBounds(20, 105, 84, 14);
		contentPane.add(lblPhoneNumber);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(19, 168, 196, 20);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(20, 152, 61, 14);
		contentPane.add(lblEmail);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(19, 215, 196, 20);
		contentPane.add(txtAddress);

		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(20, 199, 61, 14);
		contentPane.add(lblAddress);

		txtDob = new JTextField();
		txtDob.setColumns(10);
		txtDob.setBounds(19, 262, 196, 20);
		contentPane.add(txtDob);

		JLabel lblDateOfBirth = new JLabel("Date of Birth: ");
		lblDateOfBirth.setBounds(20, 246, 84, 14);
		contentPane.add(lblDateOfBirth);

		JButton btnAddToFront = new JButton("Add to Front");
		btnAddToFront.setBounds(19, 293, 93, 36);
		contentPane.add(btnAddToFront);

		JButton btnReverseNames = new JButton("Reverse Names");
		btnReverseNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReverseNames.setBounds(19, 408, 196, 46);
		contentPane.add(btnReverseNames);

		JButton btnAddToBack = new JButton("Add to Back");
		btnAddToBack.setBounds(122, 293, 93, 36);
		contentPane.add(btnAddToBack);

		JButton btnReverseList = new JButton("Reverse List");
		btnReverseList.setBounds(19, 351, 196, 46);
		contentPane.add(btnReverseList);

		txtSearch = new JTextField();
		txtSearch.setText("search...");
		txtSearch.setBounds(240, 434, 185, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnNewButton = new JButton("Email by Name");
		btnNewButton.setBounds(240, 353, 185, 23);
		contentPane.add(btnNewButton);

		JButton btnDateOfBirth = new JButton("Date of Birth by Name");
		btnDateOfBirth.setBounds(240, 376, 185, 23);
		contentPane.add(btnDateOfBirth);

		JButton btnNameByPhone = new JButton("Name by Phone Number");
		btnNameByPhone.setBounds(240, 400, 185, 23);
		contentPane.add(btnNameByPhone);

		txtTotalAddresses = new JTextField();
		txtTotalAddresses.setText("Total Addresses: ");
		txtTotalAddresses.setEditable(false);
		txtTotalAddresses.setBounds(240, 293, 185, 20);
		contentPane.add(txtTotalAddresses);
		txtTotalAddresses.setColumns(10);

		JButton btnPhoneByName = new JButton("Phone by Name");
		btnPhoneByName.setBounds(240, 329, 185, 23);
		contentPane.add(btnPhoneByName);
	}
}
