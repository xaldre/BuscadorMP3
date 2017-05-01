package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.SwingUtilities;

import vista.UI;

public class ParaUI extends UI {
	Buscador buscador = new Buscador();
	
	public ParaUI() {
		btnBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				searchMp3();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchMp3();
			}
		});
	}

	protected void searchMp3() {
		txtOutput.setText("Buscando...");
		txtInput.setText(txtInput.getText().trim());
		setEnabledUserInput(false);
		txtOutput.setText("");
		if (!txtInput.getText().isEmpty()){
			txtOutput.setText(buscador.buscarMp3(new File(txtInput.getText())));
		} else {
			txtOutput.setText("Por favor, introduzca una ruta valida");
		}
		setEnabledUserInput(true);
		
	}

	private void setEnabledUserInput(Boolean bool) {
		txtInput.setEnabled(bool);
		btnBuscar.setEnabled(bool);
	}

}
