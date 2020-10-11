package ecommercegeneration;

import java.util.Scanner;

public class EcommerceGeneration {
	
	public static void entradaPrograma() {
		
		System.out.println("======================== ");
		System.out.println(" Bem-Vinde à Toy Store");
		System.out.println("======================== ");
	}
	
	public static void limpaTela() {
		for(int x = 0;x < 50;x++) {
		System.out.println();
		}
	}
	
	public static void catalogo(String nomeUsuario, String produtos[], double valorProdutos[], int estoque[], int codigoProdutos[]) {
		
		Scanner leia = new Scanner(System.in);
		
		//carrinho
		final int QUANTIDADE_PRODUTOS = 14;
		int carrinhoQuantidade[] = new int [QUANTIDADE_PRODUTOS];
		int carrinhoCodigo[] = new int [QUANTIDADE_PRODUTOS];
		char opcaoCatalogo;
		int codigoProduto;
		int quantidadeProduto;
		int contadorNovoProduto = 0;
		double somaCarrinho = 0;
		int indiceProduto = -1;
		char cancelar;
		//finalização
		double valorIcms = 0, valorTotal = 500, valorParcela = 0;
		int  opcaoPagamento, continua;
		
		do 
		{
			
			System.out.println("\n\nLISTA DE PRODUTOS\n");
			
			for (int x = 0; x < QUANTIDADE_PRODUTOS; x++ )	
			{
				
				System.out.printf("Código: %d\t Em estoque: %d\t Valor: R$ %.2f\t %s\n", codigoProdutos[x], estoque[x], valorProdutos[x], produtos[x]);
				
			}
			
			System.out.println("\nSTATUS DO CARRINHO");
			
			if (contadorNovoProduto ==0) 
			{
				System.out.println("Seu carrinho está vazio");
			}
			
			else 
			{
				somaCarrinho =0;
				
				for (int x = 0; x < contadorNovoProduto; x++) 
				{
					System.out.printf("\nCodigo: %d\t Quantidade: %d\t Valor R$%.2f\t %s\n", carrinhoCodigo[x],carrinhoQuantidade[x], valorProdutos[carrinhoCodigo[x]-1], produtos[carrinhoCodigo[x]-1]);
					
					somaCarrinho = somaCarrinho +(carrinhoQuantidade[x]*valorProdutos[carrinhoCodigo[x]-1]);
					
				}
					System.out.printf("\nValor atual da compra: R$ %.2f\n",somaCarrinho);
			}
				
			System.out.println("\nMENU\n");
			
			System.out.println("Adicionar ao carrinho - Opção 1");
			
			System.out.println("Remover item do carrinho - Opção 2");
			
			System.out.println("Editar compra - Opção 3");
			
			System.out.println("Finalizar compra - Opção 4");
			
			System.out.println("Cancelar compra - Opção 5");
			
			
			
			opcaoCatalogo = leia.next().charAt(0);
			
			if (opcaoCatalogo == '1') 
			{
				System.out.print("\nDigite o código do item que você deseja: ");
				
				codigoProduto = leia.nextInt();
				
				if (estoque [codigoProduto -1]== 0)
				{
					System.out.println("O produto está em falta" );
				}
				
				else 
				{
					System.out.print("\nDigite a quantidade desejada: ");
					
					quantidadeProduto= leia.nextInt();
					
					if (quantidadeProduto > estoque [codigoProduto-1]) 
					{
						System.out.println("Quantidade indisponível! Tente novamente: ");
					}
					
					else 
					{
						System.out.println("Adicionando ao carrinho...");
						
						carrinhoCodigo[contadorNovoProduto]= codigoProduto;
						carrinhoQuantidade[contadorNovoProduto]=quantidadeProduto;
						
						contadorNovoProduto++;
					}
				}
			
			}
			
			else if (opcaoCatalogo == '2') 
			{	
				
				System.out.print("\nDigite o código do item que você deseja remover: ");
				
				codigoProduto = leia.nextInt();
				
				System.out.println("Removendo item...");
				
				indiceProduto = -1;
				for (int x = 0; x < contadorNovoProduto; x++) 
				{
					if (carrinhoCodigo[x] == codigoProduto) 
					{
						indiceProduto = x;
						break;
					}
				}
				
				if (indiceProduto == -1) 
				{
					System.out.println("Este produto não consta no seu carrinho");
				}
				
				else 
				{
					for (int x = indiceProduto; x < contadorNovoProduto-1;x++) 
					{
						carrinhoCodigo[x]= carrinhoCodigo[x +1];
						carrinhoQuantidade[x]= carrinhoQuantidade[x +1];	
					}
					
					contadorNovoProduto--;
				}
			}
			
			
			else if (opcaoCatalogo=='3') 
			{
				System.out.print("\nDigite o código do item que você deseja alterar: ");
				
				codigoProduto = leia.nextInt();
				
				indiceProduto = -1;
				for (int x = 0; x < contadorNovoProduto; x++) 
				{
					if (carrinhoCodigo[x] == codigoProduto) 
					{
						indiceProduto = x;
						break;
					}
				}
				
				if (indiceProduto == -1)
				{
					System.out.println("O produto não está no seu carrinho");
				}
				
				else 
				{
					System.out.printf("Em estoque: %d\t no carrinho: %d\n",estoque[carrinhoCodigo[indiceProduto]-1],carrinhoQuantidade[indiceProduto]);
					
					System.out.print("\nDigite a quantidade desejada: ");
					
					quantidadeProduto= leia.nextInt();
					
					if (quantidadeProduto > estoque [codigoProduto -1]) 
					{
						System.out.println("Quantidade indisponível! Tente novamente: ");
					}
					
					else 
					{
						System.out.println("Alterando compra...");
						carrinhoQuantidade[indiceProduto] = quantidadeProduto;
					}
				}
			
			}
				
			
			else if (opcaoCatalogo == '4') 
			{
				
				do {
					System.out.println("\nEscolha a opção de pagamento: ");
					System.out.println("1 - Dinheiro ou Débito com 10% de desconto");
					System.out.println("2 - Crédito à vista sem juros");
					System.out.println("3 - Crédito em 2 vezes sem juros");
					System.out.println("4 - Crédito em 3 vezes sem juros");
					System.out.print("Opção: ");
					opcaoPagamento = leia.nextInt();
					if (opcaoPagamento < 1 || opcaoPagamento > 4) 
					{
						System.out.println("\nVocê digitou uma opção inválida! Tente novamente!\n");
					}
				} while (opcaoPagamento < 1 || opcaoPagamento > 4);
				
				if (opcaoPagamento == 1)
				{
					somaCarrinho = (somaCarrinho * 0.9);
					System.out.printf("\nO valor total da compra é R$ %.2f", somaCarrinho);
				}
				else if (opcaoPagamento == 2)
				{
					System.out.printf("\nO valor total da compra é R$ %.2f", somaCarrinho);
				}
				else if (opcaoPagamento == 3)
				{
					valorParcela = (somaCarrinho/2);
					System.out.printf("\nO valor total da compra é R$ %.2f. E o valor de cada parcela é R$ %.2f",somaCarrinho, valorParcela);
				}
				else
				{
					valorParcela = (somaCarrinho/3);
					System.out.printf("\nO valor total da compra é R$ %.2f. E o valor de cada parcela é R$ %.2f",somaCarrinho, valorParcela);
				}
				
				do {
				System.out.println("\n\nEscolha uma opção para continuar: ");
				System.out.println("1 - Finalizar a compra");
				System.out.println("2 - Alterar carrinho");
				System.out.println("3 - Desistir da compra");
				System.out.println("Opção: ");
				continua = leia.nextInt();
				
				if (continua < 1 || continua > 3)
				{
					System.out.println("Você digitou uma opção inválida! Tente novamente!\n");
				}
				} while (continua < 1 || continua > 3);
				
				if (continua == 1)
				{
					System.out.println("\n***** Essa é a nota fiscal da sua compra: *****\n" + "Nome: " + nomeUsuario );
					for(int i = 0; i < contadorNovoProduto; i++) {
						System.out.printf("Produtos: %s -  R$ %.2f\n", produtos[carrinhoCodigo[i]-1], valorProdutos[carrinhoCodigo[i]-1]);
					}
					valorIcms = somaCarrinho*0.09;
					System.out.printf("O valor total da sua compra é: R$%.2f \nO valor do ICSM nessa compra é: R$%.2f \nObrigade pela sua compra! Vamos ao Infinito e Além!", somaCarrinho, valorIcms);

						for(int i = 0; i < contadorNovoProduto; i++)
					{
						estoque[carrinhoCodigo[i]-1] = estoque[carrinhoCodigo[i]-1] - carrinhoQuantidade[i];
					}
				}
				else if(continua == 2)
				{
					System.out.println("Voltando pro carrinho...");
				}
				else
				{
					System.out.println("Agradecemos a sua visita! E não esqueça: Amigue estou aqui!");
				}
				
				break; 
			}
		
 
			else if (opcaoCatalogo == '5') 
			{
				System.out.println("Deseja mesmo cancelar? S - Sim ou N - Não : ");
				cancelar = leia.next().toUpperCase().charAt(0);
				
				if(cancelar == 'S') 
				{
					System.out.println("\nVocê cancelou a compra ");
					contadorNovoProduto = 0;
					break;
				}
				
				
			}
			
			else 
			{
				System.out.println("Opção inválida! ");
			}
		
		} while (true);
		
	}
	
	
	public static void main(String[] args)throws InterruptedException {
		
		Scanner leia = new Scanner(System.in);
		
		//catalogo
		String produtos[] = {"Camiseta Woody", "Camiseta Buzz Lightyear", "Camiseta Sid", "Camiseta Betty", "Camiseta Aliens", "Camiseta Andy", "Camiseta Slinky", "Camiseta Rex", "Camiseta Sr. Cabeça de Batata", "Camiseta Porquinho", "Camiseta Jessie", "Camiseta Ao Infinito e Além", "Camiseta Bala no Alvo", "Camiseta Tem Uma Cobra na Minha Bota"};
		int codigoProdutos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		double valorProdutos[] = {81, 50, 75, 60, 40, 175, 35, 200, 150, 15, 100, 30, 80, 10};
		int estoque[] = {40, 10, 15, 25, 35, 30, 10, 20, 10, 50, 30, 50, 30, 80};
		
		//cadastro e login
		final int LIMITE = 100;
		String nomeUsuarios[] = new String[LIMITE];
		String igrejaUsuarios[] = new String[LIMITE];
		String senhaUsuarios[] = new String[LIMITE];
		String nomeUsuario = " ", senhaUsuario;
		char sexoUsuarios[] = new char[LIMITE];
		char opcaoEntrar,opcaoCadastro = ' ',opcaoRetorno = ' ';
		int contadorNovoUsuario = 0,numeroTentativa = 3,x = 0;
		
		do {		
		/*
		 * Cadastro e Login de usuário
		 */
		entradaPrograma();
		Thread.sleep(5000);
		limpaTela();
		
		System.out.print("Você deseja fazer L - Login ou C - Cadastro? ");
		opcaoEntrar = leia.next().toUpperCase().charAt(0);

		switch (opcaoEntrar) {
		case 'C': {
			System.out.print("\nA opção escolhida foi: " + opcaoEntrar + " - Cadastro!");
			Thread.sleep(3500);
			limpaTela();
			
			do {
				System.out.printf("Digite o seu nome de usuário: ");
				nomeUsuarios[contadorNovoUsuario] = leia.next();
				
				System.out.printf("Digite a sua senha do usuário: ");
				senhaUsuarios[contadorNovoUsuario] = leia.next();
				
				System.out.printf("Digite o seu sexo \nM - Masculino \nF - Feminino \nOutra letra, à sua escolha, que melhor te represente!): ");
				sexoUsuarios[contadorNovoUsuario] = leia.next().toUpperCase().charAt(0);
				
				limpaTela();
				
				System.out.println("\nDados Cadastrados: ");
				
				System.out.printf("\nO Nome de usuário é: %s",nomeUsuarios[contadorNovoUsuario]);
				
				System.out.printf("\nA senha cadastrada foi: %s",senhaUsuarios[contadorNovoUsuario]);
				
				System.out.printf("\nO sexo do usuário %s é: %s",nomeUsuarios[contadorNovoUsuario],sexoUsuarios[contadorNovoUsuario]);
				
				System.out.print("\n\nDeseja cadastrar outra pessoa?\nOpções (Sim/Não)");
				opcaoCadastro = leia.next().toUpperCase().charAt(0);
				if(opcaoCadastro != 'S' && opcaoCadastro != 'N') {
					do {
						System.out.print("Opção inválida. \nDigite S para Cadastrar outra pessoa ou N para ir para o Login: ");
						opcaoCadastro = leia.next().toUpperCase().charAt(0);
					}while(opcaoCadastro != 'S' && opcaoEntrar != 'N');
				}
				contadorNovoUsuario++;
			}while(opcaoCadastro != 'N');
			
		}
		case 'L':{
			System.out.print("\nVocê será direcionade para o Login da aplicação");
			Thread.sleep(3500);
			limpaTela();
			
		
			System.out.print("Digite seu nome de usuário: ");
			nomeUsuario = leia.next();
			for(x = 0;x < nomeUsuarios.length;x++) {

				if(nomeUsuario.equals(nomeUsuarios[x])) {
					break;
				}
			
				
			}
			if(nomeUsuario.equals(nomeUsuarios[x])) {
				do
				{
					System.out.print("\nVocê tem " + numeroTentativa + " tentativas!\n");
					System.out.print("\nDigite a senha do usuário: " + nomeUsuario);
					System.out.print("\nDigite a sua senha: ");
					senhaUsuario = leia.next();
					if(senhaUsuario.equals(senhaUsuarios[x])){
						numeroTentativa = 0;
					}else{
						numeroTentativa = numeroTentativa - 1;
					}
					
				} while(numeroTentativa > 0);
				if(senhaUsuario.equals(senhaUsuarios[x])){
					System.out.print("\nSeja Bem-Vinde "+nomeUsuario+"!");
					catalogo(nomeUsuario,produtos,valorProdutos,estoque,codigoProdutos);
					
				}else if(numeroTentativa == 0){
					System.out.print("Limite de tentativas alcançado. Tente novamente depois! ");
				}else {
					System.out.println("Usuário não cadastrado. Tente novamente! ");
				}
			
			}
			
			break;
		
		}
		default:
			do {
				System.out.print("Opção inválida. Digite L para Login ou C para Cadastro: ");
				opcaoEntrar = leia.next().toUpperCase().charAt(0);
			}while(opcaoEntrar != 'L' && opcaoEntrar != 'C');
			break;
		}
		
		System.out.println("\n\nDeseja continuar? S - Sim / N - Não ");
		opcaoRetorno = leia.next().toUpperCase().charAt(0);
		
		}while(opcaoRetorno != 'N');		
	}
}