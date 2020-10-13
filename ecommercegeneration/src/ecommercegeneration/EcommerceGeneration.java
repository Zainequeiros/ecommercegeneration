package ecommercegeneration;

import java.util.Scanner;

public class EcommerceGeneration {
	
	//Scanner do programa
	public static Scanner leia = new Scanner(System.in);

	//Catálogo
	public static String produtos[] = {"Camiseta Woody", "Camiseta Buzz Lightyear", "Camiseta Sid", "Camiseta Betty", "Camiseta Aliens", "Camiseta Andy", "Camiseta Slinky", "Camiseta Rex", "Camiseta Sr. Cabeça de Batata", "Camiseta Porquinho", "Camiseta Jessie", "Camiseta Ao Infinito e Além", "Camiseta Bala no Alvo", "Camiseta Tem Uma Cobra na Minha Bota"};
	public static int codigoProdutos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	public static double valorProdutos[] = {81, 50, 75, 60, 40, 175, 35, 200, 150, 15, 100, 30, 80, 10};
	public static int estoque[] = {40, 10, 15, 25, 35, 30, 10, 20, 10, 50, 30, 50, 30, 80};
	public static final int QUANTIDADE_PRODUTOS = 14;

	//Cadastro
	public static final int LIMITE_USUARIOS = 50;
	public static String nomeUsuarios[] = new String[LIMITE_USUARIOS];
	public static String senhaUsuarios[] = new String[LIMITE_USUARIOS];
	public static char sexoUsuarios[] = new char[LIMITE_USUARIOS];
	public static int carrinhoCodigoUsuarios[] = new int[LIMITE_USUARIOS * QUANTIDADE_PRODUTOS];
	public static int carrinhoQuantidadeUsuarios[] = new int[LIMITE_USUARIOS * QUANTIDADE_PRODUTOS];
	public static int contadorNovoProdutoUsuarios[] = new int[LIMITE_USUARIOS];
	public static int historicoComprasUsuarios[] = new int[LIMITE_USUARIOS * QUANTIDADE_PRODUTOS];
	public static int contadorNovoUsuario = 0;
	public static String senhaUsuario;
	
	//Carrinho - Área de compras - Finalização
	public static int carrinhoQuantidade[] = new int [QUANTIDADE_PRODUTOS];
	public static int carrinhoCodigo[] = new int [QUANTIDADE_PRODUTOS];
	public static int indiceProdutosMaisComprados[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	public static int quantidadeProdutosMaisComprados[] = new int[QUANTIDADE_PRODUTOS];
	public static int contadorNovoProduto;
	public static double somaCarrinho;
	public static String nomeUsuario;
	public static char sexoUsuario;
	public static int indiceUsuario;
	public static int sugestaoCompraram, sugestaoTambemCompraram;

	public static void main(String[] args)throws InterruptedException {
	
		char opcaoCadastro = ' ';
		int opcaoEntrada;
	
		mensagemEntrada();
		Thread.sleep(5000);
		
		do {
			limpaTela();

			opcaoEntrada = menuPrincipal(); //1 - Cadastro / 2 - Login / 3 - Sair

			if (opcaoEntrada == 1) {
				
				System.out.print("\nA opção escolhida foi: " + opcaoEntrada + " - Cadastro!");
				Thread.sleep(3500);
				limpaTela();
				
				do {

					cadastraUsuario();
					
					if (contadorNovoUsuario < LIMITE_USUARIOS) {

						System.out.print("\n\nDeseja cadastrar outra pessoa?\nOpções (Sim/Não)");
						opcaoCadastro = cadastrarOutroUsuario(); //S ou N
					}

				} while(opcaoCadastro != 'N' && contadorNovoUsuario < LIMITE_USUARIOS);

				System.out.print("\nVocê será direcionade para o Login da aplicação");
				Thread.sleep(3500);
				limpaTela();
			
				System.out.print("Digite seu nome de usuário: ");
				nomeUsuario = leia.next();
				
				logaUsuario(nomeUsuario);
				Thread.sleep(2000);
			} else if (opcaoEntrada == 2) {

				System.out.print("Digite seu nome de usuário: ");
				nomeUsuario = leia.next();
				
				logaUsuario(nomeUsuario);
				Thread.sleep(2000);
			} else if (opcaoEntrada == 3) {
				System.out.println("Encerrando E-commerce...");
				break;
			} else {
				System.out.println("Opção inválida!");
			}

		} while (true);
		
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
		for (int x = 0; x < 50; x++) System.out.println();
	}
	
	public static int menuPrincipal() {

		System.out.println("O que deseja fazer?");
		System.out.println("1 - Cadastro");
		System.out.println("2 - Login");
		System.out.println("3 - Sair");
		System.out.print("Opção: ");

		return leia.nextInt();
	}

	//Procura nome do usuário no cadastro, se encontrar retorna seu índice, senão retorna -1
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
				System.out.printf("Digite o seu nome de usuário: ");
				nomeUsuario = leia.next();
				indiceUsuario = procuraCadastro(nomeUsuario);
				
				if (indiceUsuario < 0) {
					nomeUsuarios[contadorNovoUsuario] = nomeUsuario;
					break;
				} else {
					System.out.println("Já existe um usuário com este nome. Tente outro nome");
				}
			} while (true);
			
			System.out.printf("Digite a sua senha de usuário: ");
			senhaUsuarios[contadorNovoUsuario] = leia.next();
			
			System.out.printf("Digite o seu sexo \nM - Masculino \nF - Feminino \nOutra letra, é sua escolha, que melhor te represente!): ");
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
		System.out.printf("\nO Nome de usuário é: %s", nomeUsuarios[contadorNovoUsuario]);
		System.out.printf("\nA senha cadastrada foi: %s", senhaUsuarios[contadorNovoUsuario]);
		System.out.printf("\nO sexo do usuário %s é: %s", nomeUsuarios[contadorNovoUsuario], sexoUsuarios[contadorNovoUsuario]);
	}
	
	public static char cadastrarOutroUsuario() {
		char opcaoCadastro;
		do {
			opcaoCadastro = leia.next().toUpperCase().charAt(0);
			
			if (opcaoCadastro != 'S' && opcaoCadastro != 'N') {
				System.out.print("Opção inválida. \nDigite S para Cadastrar outra pessoa ou N para ir para o Login: ");
			} else {
				return opcaoCadastro;
			}
	
		} while (true);
	}
	

	public static void logaUsuario(String usuario) {
		
		int indice;

		indice = procuraCadastro(usuario);

		if (indice >= 0) {
			
			if (senhaValida(indice, usuario)) {

				nomeUsuario = usuario;
				sexoUsuario = sexoUsuarios[indice];
				indiceUsuario = indice;
				System.out.printf("\nSeja Bem-Vinde %s!", nomeUsuario);
				iniciaCompra();
			
			} else {
				System.out.print("Limite de tentativas alcançado. Tente novamente depois! ");
			}
		
		} else {
			System.out.println("Usuário não cadastrado. Tente novamente! ");
		}
		try {
			Thread.sleep(3500);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.println();
		
	}
	
	public static boolean senhaValida(int indiceUsuario, String usuario) {
		int numeroTentativa = 3;
		
		do {
				
			System.out.print("\nVocê tem " + numeroTentativa + " tentativas!\n");
			System.out.print("\nDigite a senha do usuário: " + usuario);
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
		
		inicializaCarrinho();
		
		encontraSugestao();

		int codigoProduto, opcaoCatalogo;

		do {
			
			listaProdutos();

			imprimiSugestao();
			
			listaCarrinho();
			
			opcaoCatalogo = menuCompra();
			
			if (opcaoCatalogo == 1) {
				
				System.out.print("\nDigite o código do item que você deseja: ");
				codigoProduto = leia.nextInt();
				
				if (codigoValido(codigoProduto)) {
					
					if (procuraProduto(codigoProduto) >= 0) {
						alteraProduto(codigoProduto);
					} else {
						adicionaProduto(codigoProduto);
					}

				} else {
					System.out.println("Código de produto inválido");
				}
			
			} else if (opcaoCatalogo == 2) {	
				
				System.out.print("\nDigite o código do item que você deseja remover: ");
				codigoProduto = leia.nextInt();
				
				if (codigoValido(codigoProduto)) {
					removeProduto(codigoProduto);
				} else {
					System.out.println("Código de produto inválido");
				}
			
			} else if (opcaoCatalogo == 3) {

				System.out.print("\nDigite o código do item que você deseja alterar: ");
				codigoProduto = leia.nextInt();
				
				if (codigoValido(codigoProduto)) {
					alteraProduto(codigoProduto);
				} else {
					System.out.println("Código de produto inválido");
				}
			
			} else if (opcaoCatalogo == 4) {
				
				if (contadorNovoProduto != 0) {
					if (finalizaCompra()) {
						break;
					}
				} else {
					System.out.println("Coloque pelo menos 1 produto no carrinho para finalizar a compra");
				}
			
			} else if (opcaoCatalogo == 5) {
				
				System.out.print("Deseja mesmo sair? S - Sim ou N - Não : ");
				char cancelar = leia.next().toUpperCase().charAt(0);
				
				if(cancelar == 'S') {
					
					salvaCarrinho();
					
					System.out.println("\nVolte sempre!");
					contadorNovoProduto = 0;
					break;
				}
				
			} else {
				System.out.println("Opção inválida! ");
			}
		try {
				Thread.sleep(3500);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		} while (true);
		
	}

	public static void encontraSugestao() {
		
		int quemComprouTambemComprou[] = new int[QUANTIDADE_PRODUTOS * QUANTIDADE_PRODUTOS];
		int anulaSugestaoJaComprada[] = new int[QUANTIDADE_PRODUTOS];
		int indiceCadaUsuario, indiceVetorContagem; 
		int indice = indiceUsuario * QUANTIDADE_PRODUTOS;
		
		for (int i = 0; i < QUANTIDADE_PRODUTOS; i++, indice++) {
			
			if (historicoComprasUsuarios[indice] == 1) {
				
				for (int j = 0; j < LIMITE_USUARIOS; j++) {
				
					indiceCadaUsuario = j * QUANTIDADE_PRODUTOS;
					
					if (historicoComprasUsuarios[indiceCadaUsuario + i] == 1) {
						
						indiceVetorContagem = i * QUANTIDADE_PRODUTOS;

						for (int k = 0; k < QUANTIDADE_PRODUTOS; k++, indiceCadaUsuario++, indiceVetorContagem++) {
							
							if (historicoComprasUsuarios[indiceCadaUsuario] == 1) {
								quemComprouTambemComprou[indiceVetorContagem]++;
							}
						}

					}
					
				}

			} else {
				anulaSugestaoJaComprada[i] = 1;
			}
		}

		sugestaoCompraram = -1;
		sugestaoTambemCompraram = -1;
		int indiceProdutoCompraram = -1;
		int indiceProdutoTambemCompraram = -1;
		int indiceAuxiliar, maisComprado = 0;
		for (int i = 0; i < QUANTIDADE_PRODUTOS; i++) {
			
			indiceAuxiliar = i * QUANTIDADE_PRODUTOS;
			for (int j = 0; j < QUANTIDADE_PRODUTOS; j++, indiceAuxiliar++) {
				
				quemComprouTambemComprou[indiceAuxiliar] = quemComprouTambemComprou[indiceAuxiliar] * anulaSugestaoJaComprada[j];
				
				if (quemComprouTambemComprou[indiceAuxiliar] > maisComprado) {
					maisComprado = quemComprouTambemComprou[indiceAuxiliar];
					indiceProdutoCompraram = i;
					indiceProdutoTambemCompraram = j;
				}
			}
		}

		if (indiceProdutoCompraram != -1) {
			sugestaoCompraram = indiceProdutoCompraram;
			sugestaoTambemCompraram = indiceProdutoTambemCompraram;
		}

	}

	public static void imprimiSugestao() {
		
		if (sugestaoCompraram != -1) {
			System.out.println("\nSUGESTÃO");
			System.out.printf("Outras pessoas que compraram %s também compraram %s\n", produtos[sugestaoCompraram], produtos[sugestaoTambemCompraram]);
		}
	}

	public static void listaProdutos() {
				
		System.out.println("\n\nLISTA DE PRODUTOS\n");
	
		int aux;
		for (int i = 0; i < QUANTIDADE_PRODUTOS; i++) {
			aux = indiceProdutosMaisComprados[i]; 
			System.out.printf("Código: %d\t Em estoque: %d\t Valor: R$ %.2f\t %s\n", codigoProdutos[aux], estoque[aux], valorProdutos[aux], produtos[aux]);	
		}
		
	}

	public static void listaCarrinho() {
		
		System.out.println("\nSTATUS DO CARRINHO");
			
		if (contadorNovoProduto == 0) {
			System.out.println("Seu carrinho está vazio");
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
		System.out.println("1 - Adicionar ao carrinho");
		System.out.println("2 - Remover item do carrinho");
		System.out.println("3 - Editar compra");
		System.out.println("4 - Finalizar compra");
		System.out.println("5 - Sair da minha conta");
		System.out.print("Opção: ");
		
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
					System.out.println("Quantidade indisponível! Tente novamente");
				} else if (quantidadeProduto <= 0) {
					System.out.println("Quantidade inválida! Tente novamente");
				} else {

					System.out.println("Adicionando ao carrinho...");
					imprimiPersonagem(codigoProduto);

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
			System.out.println("Este produto não consta no seu carrinho");
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
			System.out.println("O produto não está no seu carrinho");
		} else {

			int quantidadeProduto;

			do {

				System.out.printf("Em estoque: %d\t no carrinho: %d\n", estoque[carrinhoCodigo[indiceProduto]-1], carrinhoQuantidade[indiceProduto]);
				System.out.print("\nDigite a quantidade desejada: ");
				quantidadeProduto= leia.nextInt();
				
				if (quantidadeProduto > estoque [codigoProduto - 1]) {
					System.out.println("Quantidade indisponível! Tente novamente");
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

			atualizaListaMaisComprados();

			atualizaHistoricoComprasUsuario();

			contadorNovoProdutoUsuarios[indiceUsuario] = 0;

			System.out.println("Agradecemos a sua visita! E não esqueça: Amigue estou aqui!");
			return true;
		
		} else if (opcaoFinaliza == 2) {
			
			System.out.println("Voltando pro carrinho...");
			return false;
		} else {
		
			salvaCarrinho();
			System.out.println("\nAgradecemos a sua visita! E não esqueça: Amigue estou aqui!");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			return true;
		}
	}

	public static int menuPagamento() {
		int opcaoPagamento;
		
		do {

			System.out.println("\nEscolha a opção de pagamento: ");
			System.out.println("1 - Dinheiro ou Débito com 10% de desconto");
			System.out.println("2 - Crédito à vista sem juros");
			System.out.println("3 - Crédito em 2 vezes sem juros");
			System.out.println("4 - Crédito em 3 vezes sem juros");
			System.out.print("Opção: ");
			opcaoPagamento = leia.nextInt();
			
			if (opcaoPagamento < 1 || opcaoPagamento > 4) {
				System.out.println("\nVocê digitou uma opção inválida! Tente novamente!\n");
			} else {
				break;
			}

		} while (true);

		return opcaoPagamento;
	}

	public static void imprimiPagamento(int opcaoPagamento) {
		
		if (opcaoPagamento == 1) {
			somaCarrinho = (somaCarrinho * 0.9);
			System.out.printf("\nO valor total da compra é R$ %.2f", somaCarrinho);
		} else if (opcaoPagamento == 2) {
			System.out.printf("\nO valor total da compra é R$ %.2f", somaCarrinho);
		} else if (opcaoPagamento == 3) {
			double valorParcela = (somaCarrinho / 2);
			System.out.printf("\nO valor total da compra é R$ %.2f. E o valor de cada parcela é R$ %.2f", somaCarrinho, valorParcela);
		} else {
			double valorParcela = (somaCarrinho / 3);
			System.out.printf("\nO valor total da compra é R$ %.2f. E o valor de cada parcela é R$ %.2f", somaCarrinho, valorParcela);
		}
	}

	public static int menuFinaliza() {
		int continua;

		do {

			System.out.println("\n\nEscolha uma opção para continuar: ");
			System.out.println("1 - Finalizar a compra");
			System.out.println("2 - Alterar carrinho");
			System.out.println("3 - Desistir da compra");
			System.out.println("Opção: ");
			continua = leia.nextInt();
			
			if (continua < 1 || continua > 3) {
				System.out.println("Você digitou uma opção inválida! Tente novamente!\n");
			}

		} while (continua < 1 || continua > 3);

		return continua;
	}

	public static void imprimiNotaFiscal() {

		System.out.println("\n***** Essa é a nota fiscal da sua compra: *****\n" + "Nome: " + nomeUsuario );
		for(int i = 0; i < contadorNovoProduto; i++) {
			System.out.printf("Produtos: %s -  R$ %.2f %d\n", produtos[carrinhoCodigo[i]-1], valorProdutos[carrinhoCodigo[i]-1], carrinhoQuantidade[i]);
		}
		
		double valorIcms = somaCarrinho * 0.09;
		System.out.printf("O valor total da sua compra é: R$%.2f \nO valor do ICSM nessa compra é: R$%.2f \nObrigade pela sua compra! Vamos ao Infinito e Além!", somaCarrinho, valorIcms);
		try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
	}

	public static void atualizaEstoque() {
		for(int i = 0; i < contadorNovoProduto; i++) {
			estoque[carrinhoCodigo[i]-1] = estoque[carrinhoCodigo[i]-1] - carrinhoQuantidade[i];
		}
	}

	public static void atualizaListaMaisComprados() {
		
		for (int i = 0; i < contadorNovoProduto; i++) {
			quantidadeProdutosMaisComprados[carrinhoCodigo[i] - 1] += carrinhoQuantidade[i];
		}
		
		int listaAuxiliar[] = new int[QUANTIDADE_PRODUTOS];

		for (int i = 0; i < QUANTIDADE_PRODUTOS; i++) {
			listaAuxiliar[i] = quantidadeProdutosMaisComprados[i];
		}

		int indiceMaisVendido;
		for (int i = 0; i < QUANTIDADE_PRODUTOS; i++) {

			indiceMaisVendido = 0;
			for (int j = 0; j < QUANTIDADE_PRODUTOS; j++) {
				if (listaAuxiliar[indiceMaisVendido] < listaAuxiliar[j]) {
					indiceMaisVendido = j;
				}
			}
			listaAuxiliar[indiceMaisVendido] = -1; //"Excluindo" item do lista para ele não ser mais vendido que zero
			indiceProdutosMaisComprados[i] = indiceMaisVendido;
		}

	}

	public static void atualizaHistoricoComprasUsuario() {
		
		int indice = indiceUsuario * QUANTIDADE_PRODUTOS;
		int indiceProduto;
		for (int i = 0; i < contadorNovoProduto; i++) {
			indiceProduto = carrinhoCodigo[i] - 1;
			historicoComprasUsuarios[indice + indiceProduto] = 1;
		}
	}

	public static void inicializaCarrinho() {
		
		if (contadorNovoProdutoUsuarios[indiceUsuario] > 0) {
			
			contadorNovoProduto = contadorNovoProdutoUsuarios[indiceUsuario];
			
			int indice = indiceUsuario * QUANTIDADE_PRODUTOS; //Iniciar no carrinho do usuário - Matriz linear
			for (int i = 0; i < contadorNovoProduto; i++, indice++) {

				if (carrinhoQuantidadeUsuarios[indice] > estoque[carrinhoCodigoUsuarios[indice] - 1]) {
					
					carrinhoCodigo[i] = carrinhoCodigoUsuarios[indice];
					carrinhoQuantidade[i] = estoque[carrinhoCodigoUsuarios[indice] - 1];

				} else {
					
					carrinhoCodigo[i] = carrinhoCodigoUsuarios[indice];
					carrinhoQuantidade[i] = carrinhoQuantidadeUsuarios[indice];
				}
			}

			for (int i = 0; i < contadorNovoProduto; i++) {
				if (carrinhoQuantidade[i] == 0) {
					removeProduto(carrinhoCodigo[i]);
				}
			}

		} else {
			contadorNovoProduto = 0;
		}
	}

	public static void salvaCarrinho() {

		System.out.print("Deseja salvar este carrinho? S - Sim ou N - Não: ");
		char salvar = leia.next().toUpperCase().charAt(0);

		if (salvar == 'S') {

			contadorNovoProdutoUsuarios[indiceUsuario] = contadorNovoProduto;
			
			int indice = indiceUsuario * QUANTIDADE_PRODUTOS; //Iniciar no carrinho do usuário - Matriz linear
			for (int i = 0; i < contadorNovoProduto; i++, indice++) {
				carrinhoCodigoUsuarios[indice] = carrinhoCodigo[i];
				carrinhoQuantidadeUsuarios[indice] = carrinhoQuantidade[i];
			}
			
			System.out.println("Seu carrinho foi salvo");
		} else {
			contadorNovoProdutoUsuarios[indiceUsuario] = 0;
		}

	}

	// Easter Eggs
	public static void imprimiPersonagem(int codigoProduto) {
		
		switch (codigoProduto) {
			case 1:
				imprimiWoody();
				break;
			case 2:
				imprimiBuzz();
				break;
			case 5:
				imprimiAlien();
				break;
			default:
				return;
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public static void imprimiWoody() {	
		System.out.println("             .-'\"\"\"'-.");
		System.out.println("        ,____|_______|____,");
		System.out.println("         '._____________.'");
		System.out.println("             |.-- --.|");
		System.out.println("             |(o) (o)|");
		System.out.println("            (|       |)");
		System.out.println("             |   U   |");
		System.out.println("   __        | .___. |");
		System.out.println("  /|||       |       |");
		System.out.println("  ||||       :       :");
		System.out.println("  |  |/)      `.___.'");
		System.out.println("   \\  /       __) (__");
		System.out.println("    \\/\\      /\\ \\ / /\\");
		System.out.println("     \\ \\    /\\ \\ ^ / /\\");
		System.out.println("      \\ \\  / |  |0_/\\_ \\");
		System.out.println("       \\ \\/ /|  | \\  /\\ \\");
		System.out.println("        \\  / |  |0//\\\\ \\ \\");
		System.out.println("         \\/  | /   \\ |  \\ \\");
		System.out.println("             |/ .-. \\|  / /");
		System.out.println("          .-'|-( ~ )-| / /");
		System.out.println("          \\  |--`-'--|/ /");
		System.out.println("           \\ |       | /");
		System.out.println("            \\|   |   |/");
		System.out.println("             |   |   |");
		System.out.println("             |   |   |");
		System.out.println("             |   |   |");
		System.out.println("             |   |   |");
		System.out.println("             |   |   |");
		System.out.println("             |___|___|");
		System.out.println("            `|---|---|'");
		System.out.println("            *|   |   |*");
		System.out.println("             |_._|_._|");
		System.out.println("            /'  /|\\  '\\");
		System.out.println("           /   /^ ^\\   \\");
		System.out.println("          /__.'     `.__\\");
	}
	
	public static void imprimiBuzz() {
		System.out.println("            _._                           _._");
		System.out.println("           ||||                           ||||");
		System.out.println("           ||||_           ___           _||||");
		System.out.println("           |  ||        .-'___`-.        ||  |");
		System.out.println("           \\   /      .' .'_ _'. '.      \\   /");
		System.out.println("           /~~|       | (| b d |) |       |~~\\");
		System.out.println("          /'  |       |  |  '  |  |       |  `\\");
		System.out.println(",        /__.-:      ,|  | `-' |  |,      :-.__\\       ,");
		System.out.println("|'-------(    \\-''\"\"/.|  /\\___/\\  |.\\\"\"''-/    )------'|");
		System.out.println("|         \\_.-'\\   /   '-._____.-'   \\   /'-._/        |");
		System.out.println("|.---------\\   /'._| _    .---. ===  |_.'\\   /--------.|");
		System.out.println("'           \\ /  | |\\_\\ _ \\=v=/  _   | |  \\ /          '");
		System.out.println("             `.  | | \\_\\_\\ ~~~  (_)  | |  .'");
		System.out.println("               `'\"'|`'--.__.^.__.--'`|'\"'`");
		System.out.println("                   \\                 /");
		System.out.println("                    `,..---'\"'---..,'");
		System.out.println("                      :--..___..--:");
		System.out.println("                       \\         /");
		System.out.println("                       |`.     .'|");
		System.out.println("                       |  :___:  |");
		System.out.println("                       |   | |   |");
		System.out.println("                       |   | |   |");
		System.out.println("                       |.-.| |.-.|");
		System.out.println("                       |`-'| |`-'|");
		System.out.println("                       |   | |   |");
		System.out.println("                      /    | |    \\");
		System.out.println("                     |_____| |_____|");
		System.out.println("                     ':---:-'-:---:'");
		System.out.println("                     /    |   |    \\");
		System.out.println("                    /.---.|   |.---.\\");
		System.out.println("                    `.____;   :____.'");
		
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			System.out.println();
		}
	}

	public static void imprimiAlien() {
		System.out.println("                   ()");
		System.out.println("                 __/\\__");
		System.out.println("        |\\   .-\"`      `\"-.   /|");
		System.out.println("        | \\.'( ') (' ) (. )`./ |");
		System.out.println("         \\_                  _/");
		System.out.println("           \\  `~\"'=::='\"~`  /");
		System.out.println("    ,       `-.__      __.-'       ,");
		System.out.println(".---'\\________( `\"\"~~\"\"` )________/'---.");
		System.out.println(" >   )       / `\"\"~~~~\"\"` \\       (   <");
		System.out.println("'----`--..__/        -(-)- \\__..--`----'");
		System.out.println("            |_____ __ _____|");
		System.out.println("            [_____[##]_____]");
		System.out.println("            |              |");
		System.out.println("            \\      ||      /");
		System.out.println("             \\     ||     /");
		System.out.println("          .-\"~`--._||_.--'~\"-.");
		System.out.println("         (_____,.--\"\"--.,_____)");		
	}
}