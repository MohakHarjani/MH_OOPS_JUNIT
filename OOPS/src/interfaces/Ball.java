package interfaces;

public class Ball implements Bounceable{
	String ballType;
	int bounceFactor;
	
	Ball(String ballType)
	{
		this.ballType = ballType;
		this.bounceFactor = Bounceable.baseBounceFactor * 10;
	}
	@Override
	public void bounce() {
		System.out.println(ballType + " ball bounces with bf = " + this.bounceFactor);
	}

	@Override
	public void setBounceFactor(int bounceFactor) {
		this.bounceFactor = bounceFactor;
		
	}

}
