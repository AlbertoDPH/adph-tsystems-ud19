package ud19_02_listaPeliculas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Peliculas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomPelicula;
	private JComboBox<String> cbListaPeliculas;

	/**
	 * Creando frame principal
	 */
	public Peliculas() {

		// Contenedor principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Peliculas");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JLabel titulo
		JLabel lblTitulo = new JLabel("Escribe el titulo de una pelicula");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitulo.setBounds(24, 37, 197, 14);
		contentPane.add(lblTitulo);

		// JTextField para pedir información de la película
		txtNomPelicula = new JTextField();
		txtNomPelicula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNomPelicula.setBounds(33, 79, 150, 20);
		contentPane.add(txtNomPelicula);
		txtNomPelicula.setColumns(10);

		// Botón para añadir películas al JComboBox
		JButton btnAnadir = new JButton("Añadir");

		// Acción que responde a eventos cad vez que pulsamos el botón añadir
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Añadimos el calor de textNomPeliculalos al Item de JComboBox
				// (cbListaPeliculas)
				cbListaPeliculas.addItem(txtNomPelicula.getText());
			}
		});

		// Boton añadir
		btnAnadir.setBounds(46, 127, 89, 23);
		contentPane.add(btnAnadir);

		// JLabel películas
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeliculas.setBounds(279, 37, 79, 14);
		contentPane.add(lblPeliculas);

		// Se guardara un listado de las películas
		cbListaPeliculas = new JComboBox<String>();
		cbListaPeliculas.setBounds(241, 79, 163, 22);
		contentPane.add(cbListaPeliculas);

		setVisible(true);
	}
}
