package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Distro {
	public Distro() {
		super();
	}
	
	public void os() { 
		String sistema = System.getProperty("os.name");
		String versao = System.getProperty("os.version");
		if (sistema.contains("Linux")) {
			exibeDistro(sistema, versao);
		} else {
			JOptionPane.showMessageDialog(null,"Sistema operacional incompatível.\n"
					+ "Por favor, instale uma VM com Linux e execute "
					+ "novamente! :)");
		}
	}
	public void exibeDistro(String sistema, String versao) {
		System.out.println("Sistema: " +sistema+ "\nVersao: " + versao +"\n");
		String processo = "cat /etc/os-release";
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			int i = 0;
			
			while (i <= 1 ) {
				if (linha.contains("NAME")) {
					i = (i+1);
					String[] name = linha.split("=");
					System.out.println("Nome: " + name[1]);
				}
				if (linha.contains("VERSION")) {
					i = (i+1);
					String[] version = linha.split("=");
					System.out.println("Versao: " + version[1] + "\n");
				}
				linha = buffer.readLine();				
			}
			
			
		} catch (IOException e) {
			System.err.println(e);
		}

		
	}


}
