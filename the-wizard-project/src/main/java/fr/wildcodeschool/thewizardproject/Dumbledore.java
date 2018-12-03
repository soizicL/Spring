package fr.wildcodeschool.thewizardproject;

public class Dumbledore implements WizardInterface {
	
	private Outfit outfit;
	
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
