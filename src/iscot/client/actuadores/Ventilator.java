package iscot.client.actuadores;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import iscot.client.gui.VentilatorIcon;
import iscot.enums.Areas;
import iscot.enums.Type;

public class Ventilator {

	/**
	 * 
	 * @param server address and port
	 * @param roomName: string
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws NumberFormatException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException, InterruptedException, ClassNotFoundException {
		if(args.length!=3) {
			System.err.println("Invalid arguments!");
		}
		else {
			// TODO connect to server
			
			// TODO register with the server
			Areas area=Areas.valueOf(args[2]);
			
			JFrame janela = new JFrame("Ventilador em "+area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
			
			// Criar os componentes gráficos
			JPanel painel = new JPanel(new BorderLayout(5, 5));
			painel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

			VentilatorIcon ventilator = new VentilatorIcon();
			painel.add(ventilator, BorderLayout.CENTER);

			// Histórico de Ações (Secção 1.3 do Enunciado)
			JTextArea historicoArea = new JTextArea(6, 25);
			historicoArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(historicoArea);
			scrollPane.setBorder(BorderFactory.createTitledBorder("Histórico de Ações"));
			painel.add(scrollPane, BorderLayout.SOUTH);

			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(new Dimension(300, 350));
			janela.pack();
			janela.setVisible(true);

			// Função auxiliar para registar ações com timestamp: "Ação - HH:MM:SS"
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			java.util.function.Consumer<String> registarAcao = acao -> {
				String timestamp = LocalTime.now().format(timeFormatter);
				SwingUtilities.invokeLater(() -> {
					historicoArea.append(acao + " - " + timestamp + "\n");
					historicoArea.setCaretPosition(historicoArea.getDocument().getLength());
				});
			};

			registarAcao.accept("Ventilador inicializado (Desligado)");

			// Teste de simulação local (Fase 1 e 3)
			Thread.sleep(4000);
			ventilator.setLigado(true);
			registarAcao.accept("Ventilador ligado");

			// TODO: receive and handle messages from server
			
			// TODO: for first phase: create an appropriate event hardcoded locally and change the GUI accordingly
		}
	}
}
