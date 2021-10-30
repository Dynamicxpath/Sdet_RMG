package genericutility;

import java.util.Random;

public class Javautillity {
	/**
	 * 
	 * 
	 * 
	 */
public int getRandomNumber()
{
	Random ran = new Random();
	int random=ran.nextInt(100);
	return random;
}
}
