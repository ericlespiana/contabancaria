package conta.model;

public class ContaPoupanca extends Conta
{
	private	int	birthday;
	
	public ContaPoupanca(String owner, float balance, int number, int agency, int type, int birthday) {
		super(owner, balance, number, agency, type);
		this.birthday = birthday;
	}
	
	int getBirthday() {
		return (birthday);
	}
	void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public void visualize()
	{
		super.visualize();
		System.out.println("Aniversário da conta: " + this.birthday);
	}

}
