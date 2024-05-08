
package conta;

import conta.model.*;
import conta.controller.ContaController;
import conta.util.Cores;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.IOException;

public class Menu
{
	public static void main(String[] args)
	{
		ContaController contas = new ContaController();
		Scanner 		readIn = new Scanner(System.in);
		Conta 			conta = null;
		String			owner = "";
		float			balance = 0.0f, limit = 0.0f, value = 0.0f;
		int				option = 0, number = 0, agency = 0, type = 0, birthDay = 0;
		
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente("João da Silva", 1000f, contas.genNumber(), 123, 1, 100.0f);
		contas.register(cc1);
		
		ContaCorrente cc2 = new ContaCorrente("Maria da Silva", 2000f, contas.genNumber(), 124, 1, 100.0f);
		contas.register(cc2);
				
		ContaPoupanca cp1 = new ContaPoupanca("Mariana dos Santos", 4000f, contas.genNumber(), 125, 2, 12);
		contas.register(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca("Juliana Ramos", 8000f, contas.genNumber(), 126, 2, 15);
		contas.register(cp2);
		
		do
		{
			System.out.println();
			System.out.println(Cores.TEXT_YELLOW + "*****************************************************\n");
			System.out.println("                BANCO DO BRAZIL COM Z               \n");
			System.out.println("*****************************************************\n");
			
			System.out.println("\t 1 - Criar Conta");
			System.out.println("\t 2 - Listar todas as Contas");
			System.out.println("\t 3 - Buscar Conta por Numero");
			System.out.println("\t 4 - Atualizar Dados da Conta");
			System.out.println("\t 5 - Apagar Conta");
			System.out.println("\t 6 - Sacar");
			System.out.println("\t 7 - Depositar");
			System.out.println("\t 8 - Transferir valores entre Contas");
			System.out.println("\t 9 - Sair");
			System.out.println("                                                     ");
			System.out.println("*****************************************************" + Cores.TEXT_RESET);
			
			try
	        {
	            System.out.print("Entre com a opção desejada: ");
	            option = readIn.nextInt();
	            readIn.nextLine();
	        }
			catch(InputMismatchException e)
	        {
	            System.out.println("\nDigite um número inteiro dentro das opções do Menu!");
	            readIn.nextLine();
	            option = 0;
	        }
	        catch(NoSuchElementException e){
	        	keyPress();
	        }		
			
			System.out.println(Cores.TEXT_WHITE_BOLD + "");
	
			switch (option)
			{
				case 1:
					System.out.print("Digite o Numero da Agência: ");
					agency = readIn.nextInt();
					readIn.nextLine();
					
					System.out.print("Digite o Nome do Titular: ");
					owner = readIn.nextLine();
					
					System.out.print("Digite o Saldo da Conta (R$): ");
					balance = readIn.nextFloat();
					
					do
					{
						System.out.print("Digite o Tipo da Conta (1-CC ou 2-CP): ");
						type = readIn.nextInt();
						
						switch (type)
						{
							case 1:								
								System.out.print("Digite o Limite de Crédito (R$): ");
								limit = readIn.nextFloat();
								number = contas.genNumber();
								conta = new ContaCorrente(owner, balance, number, agency, type, limit);
								break;
							case 2:								
								System.out.print("Digite o dia do Aniversario da Conta: ");
								birthDay = readIn.nextInt();
								number = contas.genNumber();
								conta = new ContaPoupanca(owner, balance, number, agency, type, birthDay);
								break;
							default:
								System.out.println("Tipo incorreto! Tente Novamente");
						}
						
					}while (type != 2 && type != 1);
					
					contas.register(conta);
					keyPress();
					break;
				case 2:
					contas.listAll();
					keyPress();
					break;
				case 3:
					System.out.print("Digite o número da conta: ");
					contas.searchNumber(readIn.nextInt());
					keyPress();
					break;
				case 4:
					System.out.println("\nAtualizar dados da Conta\n");
					System.out.print("Digite o número da conta que deseja atualizar: ");
					number = readIn.nextInt();
					conta = contas.searchInCollection(number);
					
					if (conta != null)
					{
						type = conta.getType();
						
						System.out.print("\nDigite o novo Numero da Agência: ");
						agency = readIn.nextInt();
						readIn.nextLine();
						
						System.out.print("Digite o novo Nome do Titular: ");
						owner = readIn.nextLine();
						
						System.out.print("Digite o novo Saldo da Conta (R$): ");
						balance = readIn.nextFloat();
						
						switch(type)
						{
							case 1
							-> {								
								System.out.print("Digite o novo Limite de Crédito (R$): ");
								limit = readIn.nextFloat();
								conta = new ContaCorrente(owner, balance, number, agency, type, limit);
								contas.update(conta);
							}
							
							case 2
							-> {
								System.out.print("Digite o novo dia do Aniversario da Conta: ");
								birthDay = readIn.nextInt();
								conta = new ContaPoupanca(owner, balance, number, agency, type, birthDay);
								contas.update(conta);
							}
						}
					}
					else
						System.out.printf("\nA conta número %d não foi encontrada!\n", number);
					keyPress();
					break;
				case 5:
					System.out.print("Digite o número da conta que deseja excluir: ");
					contas.delete(readIn.nextInt());
					keyPress();
					break;
					
				case 6:		
					System.out.print("Digite o número da conta que deseja sacar: ");
					number = readIn.nextInt();
					
					conta = contas.searchInCollection(number);
					
					if (conta != null)
					{
						do
						{
							System.out.print("\nDigite o valor do Saque (R$): ");
							value = readIn.nextFloat();
						}while (value <= 0);
						contas.remove(number, value);
					}
					else
						System.out.printf("\nA conta número %d não foi encontrada!\n", number);
					
					keyPress();
					break;
				case 7:
					System.out.print("Digite o número da conta que deseja fazer o depósito: ");
					number = readIn.nextInt();
					
					conta = contas.searchInCollection(number);
					
					if (conta != null)
					{
						do
						{
							System.out.print("\nDigite o valor do Depósito (R$): ");
							value = readIn.nextFloat();
						}while (value <= 0);
						contas.deposit(number, value);
					}
					else
						System.out.printf("\nA conta número %d não foi encontrada!\n", number);
					keyPress();
					
					break;
				case 8:
					System.out.print("Digite o número da Conta de Origem: ");
					number = readIn.nextInt();
					System.out.print("Digite o número da Conta de Destino: ");
					type = readIn.nextInt();
					
					do
					{
						System.out.print("\nDigite o valor da Transferência (R$): ");
						value = readIn.nextFloat();
					}while (value <= 0);
					
					contas.transfer(number, type, value);
					keyPress();
					break;	
				case 9:
					System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
					about();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!");
					keyPress();
					break;			
			}			
		}while (option != 9);

		readIn.close();
	}
	
	public static void about()
	{
		System.out.println(Cores.TEXT_BLUE_UNDERLINED + "");
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Ericles Piana da Silva");
		System.out.println("ericles.silva@genstudents.org");
		System.out.println("github.com/ericlespiana");
		System.out.println("*********************************************************" + Cores.TEXT_RESET);
	}
	
	public static void keyPress()
	{
	    try
	    {
	    	System.out.println(Cores.TEXT_RESET + "\nPressione enter para continuar...");
	        if (System.in.read() == -1)
	        {
	        	System.out.println("\nO programa chegou no final! EOF\n");
	        	System.exit(1);
	        }
	        	
	    }
	    catch(IOException e){
	        System.out.println("Ocorreu um erro ao esperar pela entrada do usuário.");
	    }
	}
}