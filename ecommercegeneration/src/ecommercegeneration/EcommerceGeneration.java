package ecommercegeneration;

import java.util.Scanner;

public class EcommerceGeneration {
	
	//Scanner do programa
	public static Scanner leia = new Scanner(System.in);

	//Catálogo
	public static String produtos[] = {"Camiseta Woody", "Camiseta Buzz Lightyear", "Camiseta Sid", "Camiseta Betty", "Camiseta Aliens", "Camiseta Andy", "Camiseta Slinky", "Camiseta Rex", "Camiseta Sr. Cabe�a de Batata", "Camiseta Porquinho", "Camiseta Jessie", "Camiseta Ao Infinito e Al�m", "Camiseta Bala no Alvo", "Camiseta Tem Uma Cobra na Minha Bota"};
	public static int codigoProdutos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	public static double valorProdutos[] = {81, 50, 75, 60, 40, 175, 35, 200, 150, 15, 100, 30, 80, 10};
	public static int estoque[] = {40, 10, 15, 25, 35, 30, 10, 20, 10, 50, 30, 50, 30, 80};
	public static final int QUANTIDADE_PRODUTOS = 14;

	//Cadastro
	public static final int LIMITE_USUARIOS = 3;
	public static String nomeUsuarios[] = new String[LIMITE_USUARIOS];
	public static String senhaUsuarios[] = new String[LIMITE_USUARIOS];
	public static char sexoUsuarios[] = new char[LIMITE_USUARIOS];
	public static int contadorNovoUsuario = 0;
	public static String senhaUsuario;
	
	//Carrinho - Área de compras - Finalização
	public static int carrinhoQuantidade[] = new int [QUANTIDADE_PRODUTOS];
	public static int carrinhoCodigo[] = new int [QUANTIDADE_PRODUTOS];
	public static int contadorNovoProduto;
	public static double somaCarrinho;
	public static String nomeUsuario = " ";
	public static char sexoUsuario;

	public static void main(String[] args)throws InterruptedException {
	
		//cadastro login
		char opcaoEntrar, opcaoCadastro = ' ';
	
		mensagemEntrada();
		Thread.sleep(5000);

		do {
			limpaTela();

			System.out.print("Voc� deseja fazer L - Login, C - Cadastro ou S - Sair? ");
			opcaoEntrar = leia.next().toUpperCase().charAt(0);

			switch (opcaoEntrar) {
			case 'C': {
				
				System.out.print("\nA op��o escolhida foi: " + opcaoEntrar + " - Cadastro!");
				Thread.sleep(3500);
				limpaTela();
				
				do {

					cadastraUsuario();
					
					if (contadorNovoUsuario < LIMITE_USUARIOS) {

						System.out.print("\n\nDeseja cadastrar outra pessoa?\nOp��es (Sim/N�o)");
						opcaoCadastro = cadastrarOutroUsuario(); //S ou N
					}

				} while(opcaoCadastro != 'N' && contadorNovoUsuario < LIMITE_USUARIOS);
				
			}
			case 'L':{

				System.out.print("\nVoc� ser� direcionade para o Login da aplica��o");
				Thread.sleep(3500);
				limpaTela();
			
				System.out.print("Digite seu nome de usu�rio: ");
				nomeUsuario = leia.next();
				
				logaUsuario(nomeUsuario);

				break;
			}
			case 'S': {
				System.out.println("Encerrando E-commerce...");
				break;
			}
			default:
				System.out.print("Op��o inv�lida. Digite L para Login ou C para Cadastro: ");
			}

		} while (opcaoEntrar != 'L' && opcaoEntrar != 'C' && opcaoEntrar != 'S');
		
		leia.close();
	}

	public static void mensagemEntrada() {
		System.out.println(" .----------------. .----------------. .----------------. ");
		System.out.println("| .--------------. | .--------------. | .--------------. |");
		System.out.println("| |  _________   | | |     ____     | | |  ____  ____  | |");
		System.out.println("| | |  _   _  |  | | |   .'    `.   | | | |_  _||_  _| | |");
		System.out.println("| | |_/ | | \\_|  | | |  /  .--.  \\  | | |   \\ \\  / /   | |");
		System.out.println("| |     | |      | | |  | |    | |  | | |    \\ \\/ /    | |");
		System.out.println("| |    _| |_     | | |  \\  `--'  /  | | |    _|  |_    | |");
		System.out.println("| |   |_____|    | | |   `.____.'   | | |   |______|   | |");
		System.out.println("| |              | | |              | | |              | |");
		System.out.println("| '--------------' | '--------------' | '--------------' |");
		System.out.println(" '----------------' '----------------' '----------------' ");
		
		System.out.println(".----------------. .----------------. .----------------. .----------------. .----------------.  ");
		System.out.println("| .--------------. | .--------------. | .--------------. | .--------------. | .--------------. |");
		System.out.println("| |    _______   | | |  _________   | | |     ____     | | |  _______     | | |  _________   | |");
		System.out.println("| |   /  ___  |  | | | |  _   _  |  | | |   .'    `.   | | | |_   __ \\    | | | |_   ___  |  | |");
		System.out.println("| |  |  (__ \\_|  | | | |_/ | | \\_|  | | |  /  .--.  \\  | | |   | |__) |   | | |   | |_  \\_|  | |");
		System.out.println("| |   '.___`-.   | | |     | |      | | |  | |    | |  | | |   |  __ /    | | |   |  _|  _   | |");
		System.out.println("| |  |`\\____) |  | | |    _| |_     | | |  \\  `--'  /  | | |  _| |  \\ \\_  | | |  _| |___/ |  | |");
		System.out.println("| |  |_______.'  | | |   |_____|    | | |   `.____.'   | | | |____| |___| | | | |_________|  | |");
		System.out.println("| |              | | |              | | |              | | |              | | |              | |");
		System.out.println("| '--------------' | '--------------' | '--------------' | '--------------' | '--------------' |");
		System.out.println(" '----------------' '----------------' '----------------' '----------------' '----------------' ");
		//System.out.println("======================== ");
		//System.out.println(" Bem-Vinde � Toy Store");
		//System.out.println("======================== ");
	}
	
	public static void limpaTela() {
		for(int x = 0;x < 50;x++) {
		System.out.println();
		}
	}
	
	// Procura nome do usuário no cadastro, se encontrar retorna seu índice, senão retorna -1
	public static int procuraCadastro(String usuario) {
		
		for (int i = 0; i < contadorNovoUsuario; i++) {
			if (nomeUsuarios[i].equals(usuario)) {
				return i;
			}
		}

		return -1;
	}

	public static void cadastraUsuario() {

		int indiceUsuario;

		if (contadorNovoUsuario < LIMITE_USUARIOS) {
		
			do {
				System.out.printf("Digite o seu nome de usu�rio: ");
				nomeUsuario = leia.next();
				indiceUsuario = procuraCadastro(nomeUsuario);
				
				if (indiceUsuario < 0) {
					nomeUsuarios[contadorNovoUsuario] = nomeUsuario;
					break;
				} else {
					System.out.println("Já existe um usuário com este nome. Tente outro nome");
				}
			} while (true);
			
			System.out.printf("Digite a sua senha de usu�rio: ");
			senhaUsuarios[contadorNovoUsuario] = leia.next();
			
			System.out.printf("Digite o seu sexo \nM - Masculino \nF - Feminino \nOutra letra, � sua escolha, que melhor te represente!): ");
			sexoUsuarios[contadorNovoUsuario] = leia.next().toUpperCase().charAt(0);

			limpaTela();

			imprimiDadosCadastrais();

			contadorNovoUsuario++;
		} else {
			System.out.println("O banco de dados alcançou o limite de usuários cadastrados");
		}

	}
	
	public static void imprimiDadosCadastrais() {
		System.out.println("\nDados Cadastrados: ");
		
		System.out.printf("\nO Nome de usu�rio �: %s",nomeUsuarios[contadorNovoUsuario]);
		
		System.out.printf("\nA senha cadastrada foi: %s",senhaUsuarios[contadorNovoUsuario]);
		
		System.out.printf("\nO sexo do usu�rio %s �: %s",nomeUsuarios[contadorNovoUsuario],sexoUsuarios[contadorNovoUsuario]);
	}
	
	public static char cadastrarOutroUsuario() {
		char opcaoCadastro;
		do {
			opcaoCadastro = leia.next().toUpperCase().charAt(0);
			
			if (opcaoCadastro != 'S' && opcaoCadastro != 'N') {
				System.out.print("Op��o inv�lida. \nDigite S para Cadastrar outra pessoa ou N para ir para o Login: ");
			} else {
				return opcaoCadastro;
			}
	
		} while (true);
	}
	

	public static void logaUsuario(String usuario) {
		
		int indiceUsuario;

		indiceUsuario = procuraCadastro(usuario);

		if (indiceUsuario >= 0) {
			
			if (senhaValida(indiceUsuario, usuario)) {

				nomeUsuario = usuario;
				sexoUsuario = sexoUsuarios[indiceUsuario];

				System.out.printf("\nSeja Bem-Vinde %s!", nomeUsuario);
				iniciaCompra();
			
			} else {
				System.out.print("Limite de tentativas alcan�ado. Tente novamente depois! ");
			}
		
		} else {
			System.out.println("Usu�rio n�o cadastrado. Tente novamente! ");
		}
		
	}
	
	public static boolean senhaValida(int indiceUsuario, String usuario) {
		int numeroTentativa = 3;
		
		do {
				
			System.out.print("\nVoc� tem " + numeroTentativa + " tentativas!\n");
			System.out.print("\nDigite a senha do usu�rio: " + usuario);
			System.out.print("\nDigite a sua senha: ");
			senhaUsuario = leia.next();
			
			if (senhaUsuario.equals(senhaUsuarios[indiceUsuario])){
				return true;
			} else {
				numeroTentativa--;
			}
			
		} while(numeroTentativa > 0);

		return false;
	}

	public static void iniciaCompra() {
		
		//Inicializa carrinho
		contadorNovoProduto = 0;
		somaCarrinho = 0;
		
		int codigoProduto, opcaoCatalogo;

		do {
			
			listaProdutos();
			
			listaCarrinho();
			
			opcaoCatalogo = menuCompra();
			
			if (opcaoCatalogo == 1) {
				
				System.out.print("\nDigite o c�digo do item que voc� deseja: ");
				codigoProduto = leia.nextInt();
				
				if (codigoValido(codigoProduto)) {
					adicionaProduto(codigoProduto);
				} else {
					System.out.println("Código de produto inválido");
				}
			
			} else if (opcaoCatalogo == 2) {	
				
				System.out.print("\nDigite o c�digo do item que voc� deseja remover: ");
				codigoProduto = leia.nextInt();
				
				if (codigoValido(codigoProduto)) {
					removeProduto(codigoProduto);
				} else {
					System.out.println("Código de produto inválido");
				}
			
			} else if (opcaoCatalogo == 3) {

				System.out.print("\nDigite o c�digo do item que voc� deseja alterar: ");
				codigoProduto = leia.nextInt();
				
				if (codigoValido(codigoProduto)) {
					alteraProduto(codigoProduto);
				} else {
					System.out.println("Código de produto inválido");
				}
			
			} else if (opcaoCatalogo == 4) {
				
				if (finalizaCompra()) {
					break;
				}
			
			} else if (opcaoCatalogo == 5) {
				
				System.out.println("Deseja mesmo cancelar? S - Sim ou N - N�o : ");
				char cancelar = leia.next().toUpperCase().charAt(0);
				
				if(cancelar == 'S') {
					System.out.println("\nVoc� cancelou a compra ");
					contadorNovoProduto = 0;
					break;
				}
				
				
			} else {
				System.out.println("Op��o inv�lida! ");
			}
		
		} while (true);
		
	}

	public static void listaProdutos() {
				
		System.out.println("\n\nLISTA DE PRODUTOS\n");
	
		for (int x = 0; x < QUANTIDADE_PRODUTOS; x++) {
			System.out.printf("C�digo: %d\t Em estoque: %d\t Valor: R$ %.2f\t %s\n", codigoProdutos[x], estoque[x], valorProdutos[x], produtos[x]);	
		}
		
	}

	public static void listaCarrinho() {
		
		System.out.println("\nSTATUS DO CARRINHO");
			
		if (contadorNovoProduto == 0) {
			System.out.println("Seu carrinho est� vazio");
		} else {
			somaCarrinho = 0;
			
			for (int x = 0; x < contadorNovoProduto; x++) {

				System.out.printf("\nCodigo: %d\t Quantidade: %d\t Valor R$%.2f\t %s\n", carrinhoCodigo[x],carrinhoQuantidade[x], valorProdutos[carrinhoCodigo[x]-1], produtos[carrinhoCodigo[x]-1]);
				somaCarrinho = somaCarrinho +(carrinhoQuantidade[x]*valorProdutos[carrinhoCodigo[x]-1]);	
			
			}
			System.out.printf("\nValor atual da compra: R$ %.2f\n",somaCarrinho);
		}
	}

	public static int menuCompra() {
		
		System.out.println("\nMENU\n");
			
		System.out.println("Adicionar ao carrinho - Op��o 1");
		
		System.out.println("Remover item do carrinho - Op��o 2");
		
		System.out.println("Editar compra - Op��o 3");
		
		System.out.println("Finalizar compra - Op��o 4");
		
		System.out.println("Cancelar compra - Op��o 5");
		
		return leia.nextInt();
	}

	public static boolean codigoValido(int codigoProduto) {
		return !(codigoProduto < 1 || codigoProduto > QUANTIDADE_PRODUTOS);
	}

	public static void adicionaProduto(int codigoProduto) {
		
		if (estoque[codigoProduto - 1] == 0) {
			System.out.println("O produto est� em falta" );
		} else {

			int quantidadeProduto;
			
			do {
				
				System.out.print("\nDigite a quantidade desejada: ");
				quantidadeProduto = leia.nextInt();

				if (quantidadeProduto > estoque [codigoProduto - 1]) {
					System.out.println("Quantidade indispon�vel! Tente novamente");
				} else if (quantidadeProduto <= 0) {
					System.out.println("Quantidade inválida! Tente novamente");
				} else {
	
					System.out.println("Adicionando ao carrinho...");
					carrinhoCodigo[contadorNovoProduto] = codigoProduto;
					carrinhoQuantidade[contadorNovoProduto] = quantidadeProduto;
					
					contadorNovoProduto++;

					break;
				}

			} while (true);
		}
	}

	public static void removeProduto(int codigoProduto) {

		int indiceProduto = procuraProduto(codigoProduto);
		
		if (indiceProduto == -1) {
			System.out.println("Este produto n�o consta no seu carrinho");
		} else {
			
			System.out.println("Removendo item...");

			for (int x = indiceProduto; x < contadorNovoProduto - 1; x++) {
				carrinhoCodigo[x] = carrinhoCodigo[x + 1];
				carrinhoQuantidade[x] = carrinhoQuantidade[x + 1];	
			}
			
			contadorNovoProduto--;
		}
	}

	public static void alteraProduto(int codigoProduto) {
		
		int indiceProduto = procuraProduto(codigoProduto);
		
		if (indiceProduto == -1) {
			System.out.println("O produto n�o est� no seu carrinho");
		} else {

			int quantidadeProduto;

			do {

				System.out.printf("Em estoque: %d\t no carrinho: %d\n", estoque[carrinhoCodigo[indiceProduto]-1], carrinhoQuantidade[indiceProduto]);
				System.out.print("\nDigite a quantidade desejada: ");
				quantidadeProduto= leia.nextInt();
				
				if (quantidadeProduto > estoque [codigoProduto - 1]) {
					System.out.println("Quantidade indispon�vel! Tente novamente");
				} else if (quantidadeProduto <= 0) {
					System.out.println("Quantidade inválida! Tente novamente");
				} else {
					System.out.println("Alterando compra...");
					carrinhoQuantidade[indiceProduto] = quantidadeProduto;
					break;
				}

			} while (true);
		}
	}

	public static int procuraProduto(int codigoProduto) {

		for (int x = 0; x < contadorNovoProduto; x++) {
			if (carrinhoCodigo[x] == codigoProduto) {
				return x;
			}
		}

		return -1;
	}

	public static boolean finalizaCompra() {
		
		int opcaoPagamento = menuPagamento();
		
		imprimiPagamento(opcaoPagamento);

		int opcaoFinaliza = menuFinaliza();
		
		if (opcaoFinaliza == 1) {
			
			imprimiNotaFiscal();

			atualizaEstoque();

			System.out.println("Agradecemos a sua visita! E n�o esque�a: Amigue estou aqui!");
			return true;
		
		} else if (opcaoFinaliza == 2) {
			
			System.out.println("Voltando pro carrinho...");
			return false;
		} else {
		
			System.out.println("Agradecemos a sua visita! E n�o esque�a: Amigue estou aqui!");
			return true;
		}
	}

	public static int menuPagamento() {
		int opcaoPagamento;
		
		do {

			System.out.println("\nEscolha a op��o de pagamento: ");
			System.out.println("1 - Dinheiro ou D�bito com 10% de desconto");
			System.out.println("2 - Cr�dito � vista sem juros");
			System.out.println("3 - Cr�dito em 2 vezes sem juros");
			System.out.println("4 - Cr�dito em 3 vezes sem juros");
			System.out.print("Op��o: ");
			opcaoPagamento = leia.nextInt();
			
			if (opcaoPagamento < 1 || opcaoPagamento > 4) {
				System.out.println("\nVoc� digitou uma op��o inv�lida! Tente novamente!\n");
			} else {
				break;
			}

		} while (true);

		return opcaoPagamento;
	}

	public static void imprimiPagamento(int opcaoPagamento) {
		
		if (opcaoPagamento == 1) {
			somaCarrinho = (somaCarrinho * 0.9);
			System.out.printf("\nO valor total da compra � R$ %.2f", somaCarrinho);
		} else if (opcaoPagamento == 2) {
			System.out.printf("\nO valor total da compra � R$ %.2f", somaCarrinho);
		} else if (opcaoPagamento == 3) {
			double valorParcela = (somaCarrinho / 2);
			System.out.printf("\nO valor total da compra � R$ %.2f. E o valor de cada parcela � R$ %.2f", somaCarrinho, valorParcela);
		} else {
			double valorParcela = (somaCarrinho / 3);
			System.out.printf("\nO valor total da compra � R$ %.2f. E o valor de cada parcela � R$ %.2f", somaCarrinho, valorParcela);
		}
	}

	public static int menuFinaliza() {
		int continua;

		do {

			System.out.println("\n\nEscolha uma op��o para continuar: ");
			System.out.println("1 - Finalizar a compra");
			System.out.println("2 - Alterar carrinho");
			System.out.println("3 - Desistir da compra");
			System.out.println("Op��o: ");
			continua = leia.nextInt();
			
			if (continua < 1 || continua > 3) {
				System.out.println("Voc� digitou uma op��o inv�lida! Tente novamente!\n");
			}

		} while (continua < 1 || continua > 3);

		return continua;
	}

	public static void imprimiNotaFiscal() {

		System.out.println("\n***** Essa � a nota fiscal da sua compra: *****\n" + "Nome: " + nomeUsuario );
		for(int i = 0; i < contadorNovoProduto; i++) {
			System.out.printf("Produtos: %s -  R$ %.2f\n", produtos[carrinhoCodigo[i]-1], valorProdutos[carrinhoCodigo[i]-1]);
		}
		
		double valorIcms = somaCarrinho * 0.09;
		System.out.printf("O valor total da sua compra �: R$%.2f \nO valor do ICSM nessa compra �: R$%.2f \nObrigade pela sua compra! Vamos ao Infinito e Al�m!", somaCarrinho, valorIcms);
	}

	public static void atualizaEstoque() {
		for(int i = 0; i < contadorNovoProduto; i++) {
			estoque[carrinhoCodigo[i]-1] = estoque[carrinhoCodigo[i]-1] - carrinhoQuantidade[i];
		}
	}
}
