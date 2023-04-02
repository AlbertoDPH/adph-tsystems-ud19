package ud19_03_encuesta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MiniEncuesta extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bgSistema; // Agrupamos todos los JRadioButton
	private JRadioButton rbWindows, rbLinux, rbMac;
	private JCheckBox cbProgramacion, cbDiseno, cdAdministracion;
	private JSlider sldHoras;
	private int horas;

	/**
	 * Creamos el frame principal
	 */
	public MiniEncuesta() {

		// Creamos el contenedor principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 300);
		setTitle("Mini Encuesta");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta sitema
		JLabel lblSistema = new JLabel("Elije un sistema operativo");
		lblSistema.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSistema.setBounds(6, 11, 216, 36);
		contentPane.add(lblSistema);

		// JRadioButton Windows y lo marcamos por defecto
		rbWindows = new JRadioButton("Windows", true);
		rbWindows.setBounds(6, 54, 109, 23);
		contentPane.add(rbWindows);

		// JRadioButton Linuux
		rbLinux = new JRadioButton("Linux");
		rbLinux.setBounds(6, 76, 109, 23);
		contentPane.add(rbLinux);

		// JRadioButton Mac
		rbMac = new JRadioButton("Mac");
		rbMac.setBounds(6, 102, 109, 23);
		contentPane.add(rbMac);

		// ButtonGroup Sistema Lo usaremos para controlar el JRadioButton que se ha
		// pulsado
		bgSistema = new ButtonGroup();

		// Añadimos los JRadioButton al ButtonGroup
		bgSistema.add(rbWindows);
		bgSistema.add(rbLinux);
		bgSistema.add(rbMac);

		// Etiqueta especialidad
		JLabel lblEpecialidad = new JLabel("Elije tu especialidad");
		lblEpecialidad.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEpecialidad.setBounds(320, 11, 216, 36);
		contentPane.add(lblEpecialidad);

		// JCheckBox Programación
		cbProgramacion = new JCheckBox("Programación");
		cbProgramacion.setBounds(320, 53, 158, 23);
		contentPane.add(cbProgramacion);

		// JCheckBox Diseño gráfico
		cbDiseno = new JCheckBox("Diseño gráfico");
		cbDiseno.setBounds(320, 79, 158, 23);
		contentPane.add(cbDiseno);

		// JCheckBox Administración
		cdAdministracion = new JCheckBox("Administración");
		cdAdministracion.setBounds(320, 102, 158, 23);
		contentPane.add(cdAdministracion);

		// Etiqueta horas dedicadas
		JLabel lblHorasDedicadas = new JLabel("Horas dedicadas en el ordenador");
		lblHorasDedicadas.setFont(new Font("Verdana", Font.BOLD, 14));
		lblHorasDedicadas.setBounds(6, 132, 268, 36);
		contentPane.add(lblHorasDedicadas);

		/*
		 * JSlider para seleccionar las horas, usamos el contructor al cual le pasamos
		 * por parámetro el valor inicial, el valor final y en que valor tiene que
		 * situarse el slider
		 */
		sldHoras = new JSlider(0, 10, 0);
		sldHoras.setToolTipText("");
		sldHoras.setBounds(22, 179, 200, 45);
		sldHoras.setMajorTickSpacing(2); // Pinta los espacios mayores
		sldHoras.setMinorTickSpacing(1); // Pinta los espaciso menores
		sldHoras.setPaintTicks(true); // Mostramos los espacios
		sldHoras.setPaintLabels(true); // Motramos la numeración

		// Creamos una clase interna anónima para controlar el slider
		sldHoras.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				// Recogemos el valor que marca el Slider
				horas = sldHoras.getValue();

			}

		});

		contentPane.add(sldHoras);

		// Boton para enviar los datos
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(b1);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(320, 179, 89, 23);
		contentPane.add(btnNewButton);

		// Hacemos visible el frame
		setVisible(true);

	}

	// Controlamos los eventos del botón al pulsarlo
	ActionListener b1 = new ActionListener() {
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {

			String rbSelec = ""; // Recoger el RadioButton seleccionado y lo guarda
			String cbSelec = ""; // Recoge el CheckBox seleccionado y lo acomula
			if (rbWindows.isSelected())
				rbSelec = "Windows";
			if (rbLinux.isSelected())
				rbSelec = "Linux";
			if (rbMac.isSelected())
				rbSelec = "Mac";

			if (cbProgramacion.isSelected())
				cbSelec += "Programación ";
			if (cbDiseno.isSelected())
				cbSelec += "Diseño Gráfico ";
			if (cdAdministracion.isSelected())
				cbSelec += "Administración ";

			/*
			 * Abrimos un nuevo JFrame al pulsar el botón y le pasamos por parámetro el
			 * RadioButton, CheckBox y el valor del Slider
			 */
			MuestraDatos mr = new MuestraDatos(rbSelec, cbSelec, horas);

		}
	};

}
