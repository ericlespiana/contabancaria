package conta.model;

public abstract class Conta
{
	private			String	owner;
	private float	balance;
	private int		number;
	private int		agency;
	private int		type;
	
	public Conta(String owner, float balance, int number, int agency, int type)
	{
		this.owner = owner;
		this.balance = balance;
		this.number = number;
		this.agency = agency;
		this.type = type;
	}
	
	public void	setOwner(String owner){
		this.owner = owner;
	}
	public String getOwner(){
		return (owner);
	}
	
	public void	setBalance(float balance){
		this.balance = balance;
	}
	public float getBalance(){
		return (balance);
	}
	
	public void	setNumber(int number){
		this.number = number;
	}
	public int getNumber() {
		return (number);
	}
	
	public void	setAgency(int agency){
		this.agency = agency;
	}
	public int getAgency() {
		return (agency);
	}
	
	public void	setType(int type){
		this.type = type;
	}
	public int getType() {
		return (type);
	}
	
	public boolean remove(float value)
	{
		if (this.getBalance() == 0 || value > this.getBalance())
		{
			System.out.println("\nSaldo insuficiente!");
			return (false);
		}
		
		this.setBalance(this.getBalance() - value);
		return (true);
	}

	public void deposit (float	value){
		this.setBalance(this.getBalance() + value);
	}
	
	public void visualize()
	{
		String	type = "";
		
		switch(this.type)
		{
			case 1:
				type = "Conta Corrente";
				break ;
			case 2:
				type = "Conta Poupança";
				break ;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da Conta: " + this.number);
		System.out.println("Agência: " + this.agency);
		System.out.println("Tipo da Conta: " + type);
		System.out.println("Titular: " + this.owner);
		System.out.println("Saldo: " + this.balance);
	}
}
