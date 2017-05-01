package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;

public class UI extends JFrame {

	private JPanel contentPane;
	protected JTextField txtInput;
	protected JButton btnBuscar;
	protected JTextArea txtOutput;

	/**
	 * Create the frame.
	 */
	public UI() {
		setForeground(Color.LIGHT_GRAY);
		this.setTitle("Mp3 Finder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtInput = new JTextField();
		txtInput.setToolTipText("Introduce una ruta v\u00E1lida");
		txtInput.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtInput = new GridBagConstraints();
		gbc_txtInput.insets = new Insets(0, 0, 5, 5);
		gbc_txtInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInput.gridx = 0;
		gbc_txtInput.gridy = 0;
		contentPane.add(txtInput, gbc_txtInput);
		txtInput.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		contentPane.add(btnBuscar, gbc_btnBuscar);
		
		txtOutput = new JTextArea();
		GridBagConstraints gbc_txtOutput = new GridBagConstraints();
		gbc_txtOutput.gridwidth = 2;
		gbc_txtOutput.fill = GridBagConstraints.BOTH;
		gbc_txtOutput.gridx = 0;
		gbc_txtOutput.gridy = 1;
		contentPane.add(txtOutput, gbc_txtOutput);
	}

}
