package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Kill {
	public Kill() {
		super();
	}
	
public void listaProcessos(String sistema) {
	String processo = "";
	if (sistema.contains("Windows")){
		processo = "tasklist /fo table";		
	} else if (sistema.contains("Linux")){
		processo = "ps -ef";
	} else {
		JOptionPane.showMessageDialog(null,"Sistema Operacional Incompatível");
	}
	try {
		Process p = Runtime.getRuntime().exec(processo);
		InputStream fluxo = p.getInputStream();
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		
		while (linha != null) {
			System.out.println(linha);
			linha = buffer.readLine();
		}
		System.out.println("");
		
	} catch (IOException e) {
		System.err.println(e);
	}	
}
public void mataPid (String sistema, int pid) {
	String processo = "";
	if (sistema.contains("Windows")) {
		processo = "taskkill /pid ";
	} else if (sistema.contains("Linux")) {
		processo = "kill -9 ";
	} else {
		JOptionPane.showMessageDialog(null,"Sistema Operacional Incompatível");
	}
	StringBuffer buffer = new StringBuffer();
	buffer.append(processo);
	buffer.append(pid);
	try {
		Runtime.getRuntime().exec(buffer.toString());
		JOptionPane.showMessageDialog(null,"Processo " + pid + " finalizado.");
	} catch (IOException e) {
		System.err.println(e);
	}
	
}
public void mataNome (String sistema, String nome) {
	String processo = "";
	if (sistema.contains("Windows")) {
		processo = "taskkill /im ";
	} else if (sistema.contains("Linux")) {
		processo = "pkill -f ";
	} else {
		JOptionPane.showMessageDialog(null,"Sistema Operacional Incompatível");
	}
	StringBuffer buffer = new StringBuffer();
	buffer.append(processo);
	buffer.append(nome);
	if (sistema.contains("Windows")) {
		buffer.append(".exe");
	}
	try {
		Runtime.getRuntime().exec(buffer.toString());
		JOptionPane.showMessageDialog(null,"Processo " + nome + " finalizado.");
	} catch (IOException e) {
		System.err.println(e);
	}
	
}
}
