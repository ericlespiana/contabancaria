package conta.controller;

import java.util.ArrayList;
import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository
{
	private ArrayList<Conta> lstConta = new ArrayList<Conta>();
	private int number = 0;
	
	public int genNumber(){
		return (++number);
	}
	
	public Conta searchInCollection(int number)
	{
		for (var conta : lstConta)
			if (conta.getNumber() == number)
				return (conta);
		return (null);
	}
	
	@Override
	public void searchNumber(int number)
	{
		var conta = searchInCollection(number);
		
		if (conta != null)
			conta.visualize();
		else
			System.out.printf("\nA conta número %d não foi encontrada!\n", number);
	}

	@Override
	public void listAll()
	{
		lstConta.forEach(conta -> {
			conta.visualize();
		});
	}

	@Override
	public void register(Conta account)
	{
		lstConta.add(account);
		System.out.printf("\nA conta número %d foi cadastrada com sucesso!\n", account.getNumber());	
	}

	@Override
	public void update(Conta account)
	{
		var conta = searchInCollection(account.getNumber());
		
		lstConta.set(lstConta.indexOf(conta), account);
		System.out.printf("\nA conta número %d foi atualizada com sucesso!\n", conta.getNumber());
	}

	@Override
	public void delete(int number)
	{
		var conta = searchInCollection(number);
		
		if (conta != null)
		{
			if(lstConta.remove(conta))
				System.out.printf("\nA Conta numero %d foi deletada com sucesso!\n", number);
			else
				System.out.println("\nHouve um erro ao remover a conta!");
		}
		else
			System.out.printf("\nA conta número %d não foi encontrada!\n", number);
	}

	@Override
	public void remove(int number, float value)
	{
		var conta = searchInCollection(number);
		
		if(conta.remove(value))
			System.out.printf("\nO saque na conta %d foi realizado com sucesso!\n", number);
		else
			System.out.println("Não foi possível realizar o saque!");
	}

	@Override
	public void deposit(int number, float value)
	{
		var conta = searchInCollection(number);
		
		conta.deposit(value);
		System.out.printf("\nO depósito na conta %d foi realizado com sucesso!\n", number);
	}

	@Override
	public void transfer(int originNumber, int targetNumber, float value)
	{
		var contaOrigem = searchInCollection(originNumber);
		var contaDestino = searchInCollection(targetNumber);
		
		if (contaOrigem != null && contaDestino != null)
		{
			if (contaOrigem.remove(value))
			{
				contaDestino.deposit(value);
				System.out.println("\nA Transferência foi efetuada com sucesso!");
			}
			else
				System.out.println("Não foi possível realizar a transferência!");
		}
		else
			System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
	}

}
