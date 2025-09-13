package flightsearch;

import java.util.Scanner;
import java.text.Normalizer;

public class Main {

	public static void main(String[] args) {
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		String origen = null;
		String destino = null;
		
		while (true) { //Validar origen
			System.out.print("Introduce tu ciudad de origen: ");
			origen = teclado.nextLine();
			origen = normalizar(origen);
			
			if (origen.isEmpty()) {
				System.out.println("No has introducido ciudad de origen");
				continue;
			}
			
			break;
			
		}
			
		while (true) { //Validar destino
			System.out.print("Introduce tu ciudad destino: ");
			destino = teclado.nextLine();
			destino = normalizar(destino);
			
			if (destino.isEmpty()) {
				System.out.println("No has introducido ciudad destino");
				continue;
			}

			break;
			
		}
		
		teclado.close();
		System.out.printf("Buscando vuelos %s >> %s...\n", origen.toUpperCase(), destino.toUpperCase());
	
		Main.buscador(origen,destino);
		
	}
	
	private static String normalizar(String s) {
		//Quitar tildes y diacriticos
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("\\p{M}", ""); // elimina marcas de acentos
	    return s.toLowerCase().replaceAll("\\s+", ""); 
	}

	//BUSCAR VUELOS
	private static int buscador(String origen, String destino) {
		
		boolean origen_encontrado = false;
		int origen_id = -1;
		boolean directo_encontrado = false;
		
		String[][] conexiones = { //El elemento [0] de cada array es el aeropuerto de origen
				 // Grandes hubs
			    {"madrid", "barcelona", "paris", "londres", "frankfurt", "roma", "newyork", "miami", "mexico", "buenosaires", "tokyo", "doha"},
			    {"paris", "londres", "madrid", "barcelona", "frankfurt", "amsterdam", "roma", "lisboa", "dubai", "newyork", "montreal", "singapur"},
			    {"londres", "paris", "madrid", "newyork", "losangeles", "dubai", "hongkong", "tokyo", "singapur", "berlin", "barcelona"},
			    {"frankfurt", "madrid", "paris", "londres", "roma", "viena", "zurich", "istanbul", "dubai", "hongkong", "newyork"},
			    {"istanbul", "madrid", "frankfurt", "paris", "roma", "dubai", "doha", "moscu", "ankara", "newyork", "tokyo"},

			    // Hubs medianos
			    {"barcelona", "madrid", "paris", "roma", "londres", "lisboa", "atenas", "berlin", "munich", "amsterdam"},
			    {"roma", "madrid", "paris", "londres", "atenas", "estambul", "frankfurt", "barcelona"},
			    {"amsterdam", "paris", "madrid", "londres", "bruselas", "berlin", "viena"},
			    {"munich", "frankfurt", "paris", "madrid", "roma", "viena", "zurich"},
			    {"lisboa", "madrid", "barcelona", "paris", "londres", "roma"},

			    // Aeropuertos pequeños
			    {"bilbao", "madrid", "barcelona", "paris"},
			    {"malaga", "madrid", "barcelona", "londres"},
			    {"sevilla", "madrid", "barcelona"},
			    {"alicante", "madrid", "londres"},
			    {"santander", "madrid", "barcelona"},
			    {"oviedo", "madrid", "barcelona"},
			    {"coruna", "madrid", "lisboa"},
			    {"murcia", "madrid"},
			    {"zaragoza", "barcelona", "paris"}
			};
		
		//System.out.println(conexiones.length);
		for (int i = 0; i < conexiones.length; i++) {
			//System.out.println("i = " + i); //debugear busqueda
			//System.out.println(conexiones[i][0]); //debugear busqueda
			if (origen.equals(conexiones[i][0])) {
				//BarSystem.out.printf("Encontrado aeropuerto en %s...\n", origen.toUpperCase()); //Debugear origen
				origen_id = i;
				origen_encontrado = true;
				
				for(int j = 1; j < conexiones[i].length; j++) { //Buscar destino desde origen
					if (destino.equals(conexiones[i][j])) {
						System.out.printf("Encontrado vuelo directo de %s a %s.\n", origen.toUpperCase(), destino.toUpperCase());
						directo_encontrado = true;
					}
				}
			} 
		}
		
		//System.out.printf("ID del origen: %s %d", origen, origen_id);
		if (!origen_encontrado) {
			System.out.println("No se han encontrado vuelos desde "+ origen.toUpperCase());
		}
		if (origen_encontrado && !directo_encontrado) { //Origen encontrado sin vuelos directos a destino
			Main.buscador_escalas(origen, destino, conexiones, origen_id);
			} 
			
		return -1;
	}
	
	private static void buscador_escalas(String origen, String destino, String[][]conexiones, int origen_id) {
		boolean escala_encontrada = false;
		String origen2 = "";
		
		System.out.println("Sin vuelos directos, buscando escalas...");
		for (int i = 1; i < conexiones[origen_id].length; i++) { //BUSCA CANDIDATAS EN ORIGEN
			//System.out.println(conexiones[origen_id][i]); //Debugear recorrido array
			String candidata = conexiones[origen_id][i]; 
			//System.out.println(candidata + " candidata"); //Debugear candidatas
			for (int j = 0; j < conexiones.length; j++) { //BUSCA CANDIDATAS EN DESTINO
				if (candidata.equals(conexiones[j][0])) {
					for (int k = 1; k < conexiones[j].length; k++) //VALIDA CANDIDATAS COMO ESCALA
						if (destino.equals(conexiones[j][k])) {
							origen2 = candidata;
							System.out.printf("Vuelo con escala encontrado: %s >> %s >> %s \n", origen.toUpperCase(), origen2.toUpperCase(), destino.toUpperCase());
							escala_encontrada = true;
						}
					
					
				} 
			}
		}
		if (!escala_encontrada) {
			System.out.println("Lo sentimos, no hay vuelos disponibles con conexión directa o con una sola escala");

		} 
	}
		
	
}
