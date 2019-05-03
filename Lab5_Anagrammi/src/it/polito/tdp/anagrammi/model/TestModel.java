package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		Anagramma anagramma = new Anagramma();
		String parola = "pezzo";
		anagramma = model.cercaAnagrammi(parola);
		System.out.println(anagramma.toString());

	}

}
