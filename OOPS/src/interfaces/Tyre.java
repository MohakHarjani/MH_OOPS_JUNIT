package interfaces;

public class Tyre implements Bounceable, Rollable{
	String tyreType;
	int bounceFactor;
	
	Tyre(String tyreType)
	{
		this.tyreType = tyreType;
		this.bounceFactor = Bounceable.baseBounceFactor * 5;
	}
	@Override
	public void bounce() {
		System.out.println(this.tyreType + "'s tyre bounces with bf = " + this.bounceFactor);
		
	}

	@Override
	public void setBounceFactor(int bounceFactor) {
		this.bounceFactor = bounceFactor;
	}
	@Override
	public void roll() {
		System.out.println("Tyre is rolling");
		
	}
	@Override
	public void sayOut()  //ADD A COMMON IMPLEMENTATION
	{
		Bounceable.super.sayOut();
		Rollable.super.sayOut();
	}

}