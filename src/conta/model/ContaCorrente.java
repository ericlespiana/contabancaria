package conta.model;

public class ContaCorrente extends Conta
{
	private	float	limit;
	
	public ContaCorrente(String owner, float balance, int number, int agency, int type, float limit)
	{
		super(owner, balance, number, agency, type);
		this.limit = limit;
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
		if (this.getBalance() + this.getLimit() < value)
		{
			System.out.println("\nSaldo insuficiente!");
			return (false);
		}
		
		if (this.getBalance() >= value)
			this.setBalance(this.getBalance() - value);
		else if (this.getBalance() > 0)
		{
			limit -= (value - (this.getBalance()));
			this.setBalance(0);
		}
		else
			limit -= value;
		return (true);
	}
		
	@Override
	public void visualize()
	{
		super.visualize();
		System.out.printf("Limite de crédito: %.2f\n", this.getLimit());
	}
}
