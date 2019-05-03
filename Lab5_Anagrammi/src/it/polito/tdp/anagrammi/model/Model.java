package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private Anagramma anagrammi;
	
	public Anagramma cercaAnagrammi(String parola){
		anagrammi = new Anagramma();
		List<Integer> parziale = new ArrayList<Integer>();
		
		cerca(parziale,  0, parola);
		
		return anagrammi; 
	}

	private void cerca(List<Integer> parziale, int L, String parola) {
		String anagrammaStringa=null;
		// considero le lettere della parola come posizioni
		if(L==parola.length()) {
			
			if(parola.length()!=parziale.size()) {
					return;
			}
			anagrammaStringa = setAnagramma(parziale, parola); // non serve il clone
//			System.out.println(anagrammaStringa+"questo");
			anagrammi.add(anagrammaStringa); // perchè passo direttamente i valori del char in quel momento
//			System.out.println(anagrammaStringa+"questo");
			return;
		}
		
		// considero le lettere della parola come posizioni
		// e creo gli anagrammi con le combinazioni delle posizioni delle lettere
		// poi al salvataggio nella condizione di termine, salvo la stringa in base alle
		// posizioni delle lettere
		
		for(int i=0;i<parola.length();i++) {
//			System.out.println(parola.length()+"   "+i+"  "+L);
			if(!parziale.contains(i)) {
				parziale.add(i);
				cerca(parziale, L+1, parola);
				parziale.remove((Object)i);
			}
			
		}
	}

	private String setAnagramma(List<Integer> parziale, String parola) {
		String anagCurr="";
//		System.out.println(parziale.toString());
		for(Integer posizione : parziale) {
//			System.out.println(posizione);
			anagCurr = anagCurr + parola.charAt(posizione);
//			System.out.println(anagCurr);
		}
//		System.out.println(anagCurr.toString());
		return anagCurr;
	}
	
	public Anagramma getAnagrammi(String parola) {
		this.cercaAnagrammi(parola);
		return this.anagrammi;
	}
}
