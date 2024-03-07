package view;
import javax.swing.JOptionPane;

import controller.Distro;

public class Main3 {
	public static void main (String [] args) {
		Distro d = new Distro();
		int b = 0;
		
		while (b !=9) {				
		b = Integer.parseInt(JOptionPane.showInputDialog("1 - Verificar detalhes sobre"
				+ " a distribuicao\n9 - Finalizar"));
		switch (b) {
		case 1: d.os();
			break;
		case 9: System.out.println("========================================");
			break;
		default: JOptionPane.showMessageDialog(null,"Opcao Invalida.");
			break;
		}
		
		}
	}

}
