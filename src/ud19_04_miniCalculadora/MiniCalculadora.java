package ud19_04_miniCalculadora;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class MiniCalculadora extends JFrame {

	private JPanel contentPane;
	private JTextField txtOperador1;
	private JTextField txtOperador2;
	private JTextField txtResultado;
	private JButton btnSalir;
	private JLabel lblPrimerValor;
	private JLabel lblSegundoValor;
	private JLabel lblTotal;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMulti;
	private JButton btnDivi;
	private double operacion = 0;

	/**
	 * Create the frame.
	 */
	public MiniCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 267, 295);
		getContentPane().setLayout(null);

		lblPrimerValor = new JLabel("PRIMER VALOR");
		lblPrimerValor.setBounds(27, 29, 89, 14);
		getContentPane().add(lblPrimerValor);

		lblSegundoValor = new JLabel("SEGUNDO VALOR");
		lblSegundoValor.setBounds(27, 77, 89, 14);
		getContentPane().add(lblSegundoValor);

		lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(73, 121, 46, 14);
		getContentPane().add(lblTotal);

		txtOperador1 = new JTextField();
		txtOperador1.setBounds(132, 26, 86, 20);
		getContentPane().add(txtOperador1);
		txtOperador1.setColumns(10);

		// Usamos el objeto txtFoco1 para controlar el foco del txtOperador1
		ControlFoco txtFoco1 = new ControlFoco();

		// Lo usaremos para limpiar txtResultado
		txtOperador1.addFocusListener(txtFoco1);

		txtOperador2 = new JTextField();
		txtOperador2.setColumns(10);
		txtOperador2.setBounds(132, 74, 86, 20);
		getContentPane().add(txtOperador2);

		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		txtResultado.setBounds(132, 118, 86, 20);
		getContentPane().add(txtResultado);

		btnSuma = new JButton("+");
		btnSuma.addActionListener(operador); // Llamamos al método al pulsar el botón +

		btnSuma.setMinimumSize(new Dimension(0, 0));
		btnSuma.setMaximumSize(new Dimension(0, 0));
		btnSuma.setMargin(new Insets(0, 0, 0, 0));
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSuma.setBounds(50, 160, 30, 30);
		getContentPane().add(btnSuma);

		btnResta = new JButton("-");
		btnResta.addActionListener(operador);// Llamamos al método al pulsar el botón -

		btnResta.setMinimumSize(new Dimension(0, 0));
		btnResta.setMaximumSize(new Dimension(0, 0));
		btnResta.setMargin(new Insets(0, 0, 0, 0));
		btnResta.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnResta.setBounds(93, 160, 30, 30);
		getContentPane().add(btnResta);

		btnMulti = new JButton("*");
		btnMulti.addActionListener(operador);// Llamamos al método al pulsar el botón *

		btnMulti.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMulti.setMinimumSize(new Dimension(0, 0));
		btnMulti.setMaximumSize(new Dimension(0, 0));
		btnMulti.setMargin(new Insets(0, 0, 0, 0));
		btnMulti.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMulti.setBounds(134, 160, 30, 30);
		getContentPane().add(btnMulti);

		btnDivi = new JButton("/");
		btnDivi.addActionListener(operador);// Llamamos al método al pulsar el botón /

		btnDivi.setMinimumSize(new Dimension(0, 0));
		btnDivi.setMaximumSize(new Dimension(0, 0));
		btnDivi.setMargin(new Insets(0, 0, 0, 0));
		btnDivi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDivi.setBounds(174, 160, 30, 30);
		getContentPane().add(btnDivi);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(salir);// Llamamos al método al pulsar el botón SALIR

		btnSalir.setBounds(92, 216, 89, 23);
		getContentPane().add(btnSalir);

		setVisible(true);

	}

	// Responde a eventos de los botones + - * /
	ActionListener operador = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// Convierte a double los valores que hay en txtOperador1 y txtOperador2
			double operador1 = Double.parseDouble(txtOperador1.getText());
			double operador2 = Double.parseDouble(txtOperador2.getText());

			// Realilza las operaciones segun el botón pulsado
			if (e.getSource().equals(btnSuma))
				operacion = operador1 + operador2;

			if (e.getSource().equals(btnResta))
				operacion = operador1 - operador2;

			if (e.getSource().equals(btnMulti))
				operacion = operador1 * operador2;

			if (e.getSource().equals(btnDivi))

				// Controlamos la division entre 0
				try {
					operacion = operador1 / operador2;
				} catch (ArithmeticException e1) {
					e1.getMessage();
					JOptionPane.showMessageDialog(null, "No se puede dividir entre 0", "Error", 0);
				}
			// Limita el resultado a 5 decimales
			double resulDecimal = Math.round(operacion * 100000d) / 100000d;

			txtOperador1.setText("");// Limpia el TextField
			txtOperador2.setText("");// Limpia el TextField

			// Muestra el resultado en txtResultado
			txtResultado.setText("" + resulDecimal);
		}
	};

	// Responde a enventos cuando pulsamos btnSalir, hace que salga de la App
	ActionListener salir = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	/*
	 * Clase interna que usaremos para controlar el foco de txtOperador1, de esta
	 * forma cuando gane el foco borrará el contenido de textResultado
	 */
	private class ControlFoco implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			// Borra el contenido de txtResultado al ganar el foco
			txtResultado.setText("");
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
