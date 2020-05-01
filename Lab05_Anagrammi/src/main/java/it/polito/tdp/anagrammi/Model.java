package it.polito.tdp.anagrammi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.DAO.DizionarioDAO;

public class Model {
	
	DizionarioDAO dizionario = new DizionarioDAO();
	
	List<String> listaAnagrammi;
	
	public List<String> calcolaAnagrammi(String parola) {
		// TODO Auto-generated method stub
		
		listaAnagrammi = new ArrayList<String>();
		
		List<Character> listaCarDisp = new LinkedList<Character>();
		for(Character ch: parola.toCharArray()) {
			listaCarDisp.add(ch);
		}
		
		int n = parola.length();
		
		costruisciAnagramma("", listaCarDisp);
		
		return listaAnagrammi;
	}

	//ricorsione
	private void costruisciAnagramma(String parziale, List<Character> listaCarDisp) {
		// TODO Auto-generated method stub
		
		if(listaCarDisp.isEmpty()) {
			
			if(!listaAnagrammi.contains(parziale)) {
				
				listaAnagrammi.add(parziale);
			}
			return;
		}
		
		for(Character ch: listaCarDisp) {
			
			String parziale2 = parziale+ch.toString();
			List<Character> listaCarDisp2 = new LinkedList<Character>();
			listaCarDisp2.addAll(listaCarDisp);
			listaCarDisp2.remove(ch);
			
			costruisciAnagramma(parziale2, listaCarDisp2);
		}
	}

	public boolean parolaCorretta(String s) {
		// TODO Auto-generated method stub
		
		return dizionario.parolaCorretta(s);
	}

}
