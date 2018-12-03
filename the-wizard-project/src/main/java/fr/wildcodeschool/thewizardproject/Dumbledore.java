package fr.wildcodeschool.thewizardproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dumbledoreId")
public class Dumbledore implements WizardInterface {
	
	private Outfit outfit;
	
	@Autowired
	public Dumbledore(Outfit theOutfit) {
		outfit = theOutfit;
	}
	
	@Override
	public String changeDress() {
		return this.outfit.sendOutfit();
	}
	
	@Override
	public String giveAdvice() {
		return "Be careful Harry !";
	}

}
