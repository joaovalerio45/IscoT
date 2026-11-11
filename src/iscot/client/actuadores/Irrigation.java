package iscot.client.actuadores;

import java.awt.BorderLayout;
import java.awt.geom.Area;
import java.io.IOException;

import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.IrrigationIcon;
import iscot.client.sensores.GroundMoistureSensor;
import iscot.enums.Areas;
import iscot.events.AreaIrrigationOrderEvent;

public class Irrigation {
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
			
			JFrame janela = new JFrame("Rega em "+area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
			
			// Criar os componentes gráficos
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			IrrigationIcon rega = new IrrigationIcon();
            rega.setZona(1);
            rega.setDuracao(10);
			painel.add(rega,BorderLayout.CENTER);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
			Thread.sleep(5000);
			AreaIrrigationOrderEvent evento = new AreaIrrigationOrderEvent(area, true,1,10);
			System.out.println(evento);
			rega.setZona(evento.getZona());
			rega.setDuracao(evento.getDuracao());
			rega.setAtiva(evento.getState());

			// TODO: receive and handle messages from server
			
			// TODO: for first phase: create an appropriate event hardcoded locally and change the GUI accordingly

		}
	}
}
