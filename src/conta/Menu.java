
package conta;

import java.util.Scanner;
import conta.model.ContaPoupanca;
import conta.model.ContaCorrente;
import conta.util.Cores;

public class Menu
{
	public static void main(String[] args)
	{
		Scanner readIn = new Scanner(System.in);
		int		option = 0;	
		
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
			System.out.print("Entre com a opção desejada: ");
			option = readIn.nextInt();
			readIn.nextLine();
			
			System.out.println(Cores.TEXT_WHITE_BOLD + "");
			switch (option)
			{
				case 1:
					System.out.println("\nCriar Conta");
					break;
				case 2:
					System.out.println("\nListar todas as Contas");
					break;
				case 3:
					System.out.println("\nConsultar dados da Conta - por número");
					break;
				case 4:
					System.out.println("\nAtualizar dados da Conta");
					break;
				case 5:
					System.out.println("\nApagar a Conta");
					break;
				case 6:
					System.out.println("\nSaque");
					break;
				case 7:
					System.out.println("\nDepósito");
					break;
				case 8:
					System.out.println("\nTransferência entre Contas");
					break;
				case 9:
					System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
					sobre();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!");
					break;			
			}
			
		}while (option != 9);

		readIn.close();
	}
	
	public static void sobre()
	{
		System.out.println(Cores.TEXT_BLUE_UNDERLINED + "");
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Ericles Piana da Silva");
		System.out.println("ericles.silva@genstudents.org");
		System.out.println("github.com/ericlespiana");
		System.out.println("*********************************************************" + Cores.TEXT_RESET);
	}
}


