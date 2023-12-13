package TelaGrafica;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource;

public class TelaThread extends JDialog{

	//Criando a janela e importando as configurações da biblioteca//
	
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
	private JLabel descricaoHora = new JLabel("Hora");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Data");
	private JTextField mostraTempo2 = new JTextField();
	
	//classe para inserir os botões//
	private JButton jButton = new JButton("Start");
	private JButton jButton2 = new JButton("Stop");
	
	private Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			while(true){
				mostraTempo.setText(new SimpleDateFormat("hh:mm.ss").
					format(Calendar.getInstance().getTime()));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			
			}
		}
	};
	
private Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			while(true){
				mostraTempo2.setText(new SimpleDateFormat("dd-MM-yyyy").
					format(Calendar.getInstance().getTime()));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			
			}
		}
	};
	
	private Thread threadTime1;
	private Thread threadTime2;
	
	
	// Configurações de tamanho da janela//
	public TelaThread() {
		setTitle("Relógio");
		setSize(240, 240);
		setLocationRelativeTo(null);
		setResizable(false);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = gridBagConstraints.WEST;
		
		
		descricaoHora.setPreferredSize(new Dimension(200,25));
		jPanel.add(descricaoHora, gridBagConstraints);
		
	
		mostraTempo.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++;
		mostraTempo.setEditable(false);
		jPanel.add(mostraTempo, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy++;
		mostraTempo2.setEditable(false);
		jPanel.add(mostraTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButton, gridBagConstraints);
		
		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++;
		jPanel.add(jButton2, gridBagConstraints);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				threadTime1 = new Thread(thread1);
				threadTime1.start();
				
				threadTime2 = new Thread(thread2);
				threadTime2.start();
				
			//quando o tempo inicia o stop se torna clícavel//
				
				jButton.setEnabled(false);
				jButton2.setEnabled(true);
				
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				threadTime1.stop();
				threadTime2.stop();
			
		//quando o tempo inicia o stop se torna clícavel//
				
				jButton.setEnabled(true);
				jButton2.setEnabled(false);
			}
		});
		
		jButton2.setEnabled(false);
		
		add(jPanel, BorderLayout.WEST);
		// Janela se torna vísivel para o usuário.
		setVisible(true);
	}

}
