package ud19_01_saludador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Saludable extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;

	//Clase SAludable
	public Saludable() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Saludador");

		// Codigo JLabel
		JLabel lblNewLabel = new JLabel("Escribe un nombre para saludar");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(107, 43, 229, 14);
		contentPane.add(lblNewLabel);

		// Codigo JTextField
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 88, 254, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		// Codigo JButton
		JButton btnSaludar = new JButton("¡Saludar!");
		btnSaludar.setBounds(188, 153, 92, 23);
		contentPane.add(btnSaludar);

		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "¡Hola " + txtNombre.getText() + "!", "Mensaje", 1);

			}
		});

		//Hace que se vea el JPane
		setVisible(true);
	}
}
