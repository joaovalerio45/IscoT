package iscot.client.actuadores;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import iscot.client.gui.ACIcon;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.events.AreaTemperatureOrderEvent;

public class AC {
    
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
			
			JFrame janela = new JFrame("Ar Condicionado em "+area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
			
			// Criar os componentes gráficos
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			ACIcon ac = new ACIcon();
			painel.add(ac,BorderLayout.CENTER);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			

			// TODO: receive and handle messages from server
			
			Thread.sleep(3000);
			AreaTemperatureOrderEvent ordem = new AreaTemperatureOrderEvent(area, AirConditioningMode.Aquecimento, 20);
			System.out.println("Atuador a processar: " + ordem);
			ac.setModo(ordem.getMode());
			ac.setTemperatura(ordem.getTargetTemperature());

		}
			
    }
    
}
