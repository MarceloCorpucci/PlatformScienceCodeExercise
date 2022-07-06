package com.example.domain;

import com.example.helper.CustomLogger;

public class Driver {
	private String name;
	private int vowelAmount = 0;
	private int consonantAmount = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		CustomLogger.showInfo("Driver name " + name);
	}
	
	public void calculateNameAlgorithm() {
		String nameInLowerCase = name.toLowerCase();
		for(int i = 0; i < name.length(); i++) { 
			char ch = nameInLowerCase.charAt(i); 
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') { 
				vowelAmount++; 
			} else if((ch >= 'a'&& ch <= 'z')) {
				consonantAmount++;
			}	
        }
		CustomLogger.showInfo("Vowels: " + vowelAmount + " - Consontants: " + consonantAmount);
	}
	
	public int getVowelAmount() {
		return this.vowelAmount;
	}
	
	public int getConsonantAmount() {
		return this.consonantAmount;
	}
}
