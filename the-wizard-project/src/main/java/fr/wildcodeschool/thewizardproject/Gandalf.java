package fr.wildcodeschool.thewizardproject;

public class Gandalf implements WizardInterface {
	
	private Outfit outfit;
	
	public Gandalf(Outfit theOutfit) {
		outfit = theOutfit;
	}
	
	@Override
	public String changeDress() {
		return this.outfit.sendOutfit();
	}
	
	@Override
	public String giveAdvice() {
		return"Be careful little Hobbit !";
	}

	
}
