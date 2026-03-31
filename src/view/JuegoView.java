package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.JuegoController;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.ResultadoIntento;
import javax.swing.JTextArea;
import java.awt.Color;

public class JuegoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	private JuegoController controller;
	private JTextArea textResultado;
	private JLabel lblMensaje;

	public void setController(JuegoController controller) {
	    this.controller = controller;
	}

	public JuegoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textResultado = new JTextArea(10, 20);
		textResultado.setBackground(Color.LIGHT_GRAY);
		textResultado.setEditable(false);
		contentPane.add(textResultado);

		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField);

		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String intento = textField.getText();
				controller.ingresar(intento);
			}
		});
		contentPane.add(btnIngresar);
		
		lblMensaje = new JLabel("");
		contentPane.add(lblMensaje);
	}

	// ------------------------------- METODOS PARA EL CONTROLLER ---------------------------------

	public void mostrar() {
		this.setVisible(true);
	}

	public void mostrarResultado(ResultadoIntento resultado) {
		textResultado.append(resultado.toString() + "\n"); // se usa append para que se acumulen los resultados
		textField.setText("");							   // (FALTA EL TOSTRING DE ResultadoIntento.java) 
	}

	public void mostrarMensaje(String mensaje) {
		lblMensaje.setText(mensaje);
	}
}