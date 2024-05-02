package model;

public class CurrentAccount extends Account
{
	private	float	limit;
	
	public CurrentAccount(String owner, float balance, int number, int agency, int type, float limit){
		super(owner, balance, number, agency, type);
		this.limit = limit;
		this.balance = 50f;
	}
	
	public float getLimit(){
		return (limit);
	}
	
	public void setLimit(float limit){
		this.limit = limit;
	}
	
	@Override
	public boolean remove(float value)
	{
		if (this.getBalance() + this.getLimit() <= 0)
		{
			System.out.println("\nSaldo insuficiente!");
			return (false);
		}		
		this.setBalance(this.getBalance() - value);
		return (true);
	}
		
	@Override
	public void visualize()
	{
		super.visualize();
		System.out.printf("Limite de Crédito accouunt Mae: %.2f\n", this.limit);
		System.out.println("-------------------------------------------------");
		System.out.println("\t\tSobrescrito");
	}
}
