package ud19_03_encuesta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class MuestraDatos extends JFrame {

	private JPanel contentPane;

	/**
	 * Creamos el JFrame que muestra los resultados de la encuesta
	 */
	public MuestraDatos(String rbSis, String cbEsp, int horas) {
		// Con DISPOSE_ON_CLOSE hacemos que no se cierren todos los JFrame sino este
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Muestra datos encuesta");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Datos seleccionados");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(136, 39, 160, 26);
		contentPane.add(lblNewLabel);

		// Creamos un JTextArea para introducir los datos
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 13));
		textArea.setBounds(54, 76, 322, 152);

		// Introducimos los datos
		textArea.setText("Sistema: " + rbSis + "\n" + "Especialidad: " + cbEsp + "\n" + "Horas: " + horas);

		// Hacemos que baja ela palabra entera y no se corte, sino cabe en la linea
		textArea.setWrapStyleWord(true);
		// Hace que baje la palabra al terminar la linea, sino cabe en ella
		textArea.setLineWrap(true);
		contentPane.add(textArea);

		setVisible(true);

	}

}
