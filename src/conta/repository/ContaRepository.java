package conta.repository;

import conta.model.Conta;

public interface ContaRepository
{
	//Account CRUD
	public void searchNumber(int number);
	public void listAll();
	public void	register(Conta account);
	public void update(Conta account);
	public void delete(int number);
	
	//Account Methods
	public void	remove(int number, float value);
	public void deposit(int number, float value);
	public void transfer(int originNumber, int targetNumber, float value);
}
