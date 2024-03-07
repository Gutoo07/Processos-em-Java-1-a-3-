package view;

import controller.Redes;
import controller.Kill;
import java.io.IOException;

import javax.swing.JOptionPane;
public class Main1e2 {
	public static void main (String[] args) throws IOException {
		Redes r = new Redes();
		Kill k = new Kill();
		String sistema = r.os();
		int a = 0;
		while (a !=9) {
			a = Integer.parseInt(JOptionPane.showInputDialog("1 - Executar configuração de IP\n"
					+ "2 - Executar chamada de ping\n3 - Exibir lista de processos\n"
					+ "4 - Matar processo usando PID\n5 - Matar processo usando Nome\n9 - Finalizar"));

			switch (a) {
			case 1: r.ip(sistema);
				break;
			case 2: r.ping(sistema);
				break;
			case 3: k.listaProcessos(sistema);
				break;
			case 4: k.mataPid(sistema, Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo a matar: ")));
				break;
			case 5: k.mataNome(sistema, JOptionPane.showInputDialog("Digite o Nome do processo a matar: "));
				break;
			case 9:System.out.println("=============================================================================");
				break;
			default: JOptionPane.showMessageDialog(null, "Opção Inválida.");
				break;				
		}
		
	}
	}
}
