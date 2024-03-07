package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Redes {
		public Redes() {
			super();
		}
		
		public String os() {
			String sistema = System.getProperty("os.name");			
			System.out.println("Sistema: "+sistema);	
			System.out.println("Por algum motivo o nome dos meus adaptadores de rede nao estao aparecendo");
			System.out.println("");
			return sistema;		
		}
		
		public void ip(String sistema) {
			String processo = "";
			String a = "";
			String b = "";
			if (sistema.contains("Windows")) {
				processo = "ipconfig";
				a = "Adaptador";
				b = "IPv4";
			}
			if (sistema.contains("Linux")) {
				processo = "ifconfig";
				a = "flags";
				b = "inet";
			}
			
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				while (linha != null) {
					
				if (linha.contains(a)){
					System.out.println(linha);
					linha = buffer.readLine();				
				} 
				
				
				if (linha.contains(b)){
					System.out.println(linha);
					linha = buffer.readLine();				
				} 
				linha = buffer.readLine();
					
				}				
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {				
				String erro = e.getMessage();
				System.err.println(erro);
			}
			System.out.println();
		}
		public void ping(String sistema) throws IOException {
			String processo = "";
			if (sistema.contains("Windows")) {
				processo = "ping -n 10 www.google.com.br";				
			}
			if (sistema.contains("Linux")) {
				processo = "ping -c 10 www.google.com.br";				
			}
				try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains("dia =") || linha.contains("avg")) {
						String media = split(linha, sistema);
						System.out.println("Tempo medio de ping em www.google.com.br = " + media);
					}	
					linha = buffer.readLine();

				}
				} catch (IOException e) {
					String erro = e.getMessage();
					System.err.println(erro);
				}
				System.out.println(	);
			}
		
		public String split (String frase, String sistema) {
			
			if (sistema.contains("Windows")) {
			String[] palavras = frase.split("dia =");	
			return palavras[1];
			}
			if (sistema.contains("Linux")) {
				String[] palavras = frase.split("/");	
				return palavras[4];
				}	
			return "Sistema desconhecido, tente novamente.";
		}
		}
		



