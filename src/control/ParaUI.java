package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.StringTokenizer;

import javax.swing.SwingUtilities;

import jdk.nashorn.internal.parser.Token;
import modelo.Recorder;
import vista.UI;

public class ParaUI extends UI {
	Buscador buscador = new Buscador();
	Recorder recorder = new Recorder();

	public ParaUI() {
		btnBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				getMp3();
			}
		});

		txtInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getMp3();
			}
		});
	}

	protected void getMp3() {
		setText();
		setEnabledUserInput(false);
		if (!txtInput.getText().isEmpty()) {
			txtOutput.setText("");
			String path = txtInput.getText();
			String list = buscador.buscarMp3(new File(path));
			txtOutput.append(list);
			recorder.save(list, path);
			
			

		} else {
			txtOutput.setText("Por favor, introduzca una ruta valida");
		}
		setEnabledUserInput(true);

	}

	private void setText() {
		txtInput.setText(txtInput.getText().trim());
		txtOutput.setText("Buscando...");
	}

	private void setEnabledUserInput(Boolean bool) {
		txtInput.setEnabled(bool);
		btnBuscar.setEnabled(bool);
	}

}
