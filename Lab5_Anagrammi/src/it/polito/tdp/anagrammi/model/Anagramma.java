package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.dao.ParolaDAO;

public class Anagramma {

	private List<String> validi;
	private List<String> nonValidi;
	
	public Anagramma() {
		this.validi = new ArrayList<String>();
		this.nonValidi = new ArrayList<String>();
	}

	public List<String> getValidi() {
		return validi;
	}

	public void setValidi(List<String> validi) {
		this.validi = validi;
	}

	public List<String> getNonValidi() {
		return nonValidi;
	}

	public void setNonValidi(List<String> nonValidi) {
		this.nonValidi = nonValidi;
	}

	public void add(String parziale) {
//		System.out.println(parziale);
		
		if(isValido(parziale)) {
			if(!this.validi.contains(parziale)) {
//				System.out.println(parziale);
				this.validi.add(parziale);
			}
		}
		else {
			if(!this.nonValidi.contains(parziale)) {
//				System.out.println(parziale);
				this.nonValidi.add(parziale);
			}
		}

		
	}

	private boolean isValido(String parziale) {
		ParolaDAO dao = new ParolaDAO();
		return dao.verificaEsistenza(parziale);
	}

	@Override
	public String toString() {
		return "Anagramma\nVALIDI=" + validi + "\nNON VALIDI=" + nonValidi;
	}

//	@Override
//	public Anagramma clone() {
//		Anagramma a = new Anagramma();
//		a.nonValidi = new ArrayList(this.nonValidi);
//		a.validi = new ArrayList(this.validi);
//		return a;
//	}
	
	public String validiToString() {
		String ritorno="";
		for(String s : validi) {
			ritorno = ritorno +s+"\n";
		}
		return ritorno;
		
	}
	
	public String nonValidiToString() {
		String ritorno="";
		for(String s : nonValidi) {
			ritorno = ritorno +s+"\n";
		}
		return ritorno;
		
	}
	
}
