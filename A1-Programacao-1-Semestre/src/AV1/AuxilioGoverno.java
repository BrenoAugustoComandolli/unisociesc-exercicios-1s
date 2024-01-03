package AV1;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
 * 
 * Avaliação 1 - Programação de Soluções Computacionais 
 *
 * Autor: Breno
 * Data: 20 de abr. de 2021
 *
 */
public class AuxilioGoverno {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException {
		
		char opcaoSair;
		int totalUsuario = 0;
		double valorBenEmpregado;
		double valorBenDesempregado;
		int mesesBeneficio = 0;
		int beneficiarios = 0;
		double valorTotalBeneficio = 0;
		double maiorBeneficio = 0;
		double segundoMaior = 0;
		String maiorNome = "";
		String segundoMaiorNome = "";
		int maiorMesesBen = 0;
		int segundoMesesBen = 0;
		String nomeMaiorMesesBen = "";
		String nomeSegundoMesesBen = "";
		
		Scanner teclado = new Scanner(System.in);

		//Informa os valores de beneficio 
		System.out.println("---------------------------------");
		System.out.println("Informe os valores de benefício: ");
		System.out.println("---------------------------------");
		do {
			System.out.println("Valor de benefício para empregado (R$:1000 - R$:1800): ");
			valorBenEmpregado = teclado.nextDouble();

			if(valorBenEmpregado < 1000 || valorBenEmpregado > 1800) {
				System.out.println("-------------------------------");
				System.out.println("Opção inválida");
			}
			System.out.println("-------------------------------");
		}while(valorBenEmpregado < 1000 || valorBenEmpregado > 1800);
		
		do {
			System.out.println("Valor de benefício para desempregado (R$:1500 - R$:2300): ");
			valorBenDesempregado = teclado.nextDouble();

			if(valorBenDesempregado < 1500 || valorBenDesempregado > 2300) {
				System.out.println("-------------------------------");
				System.out.println("Opção inválida");
			}
			System.out.println("-------------------------------");
		}while(valorBenDesempregado < 1500 || valorBenDesempregado > 2300);
		
		//Inicia o calculo de beneficiários 
		do {
			Scanner teclado2 = new Scanner(System.in);
			
			//Adiciona um usuário a contagem
			totalUsuario++;
			
			System.out.println("-------------------------------");
			System.out.println("Cadastro:");
			System.out.println("-------------------------------");
			System.out.println("Nome Completo:");
			String nome = teclado2.nextLine();
			System.out.println("-------------------------------");
			
			//Pede e valida a idade digitada 
			int idade;
			LocalDate dataNascFormatada;
			do {
				idade = 0;
				System.out.println("Data de Nascimento (DD/MM/AAAA): ");
				String dataNasc = teclado2.next();
				System.out.println("-------------------------------");
				
				//Data atual
				LocalDate dataAtual = LocalDate.now();
				
				//Formatando String para LocalDate 
				dataNascFormatada = LocalDate.parse(dataNasc,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				//Calculo da data de nascimento 
				if(dataNascFormatada.getMonthValue() == dataAtual.getMonthValue()) {
					if(dataAtual.getDayOfMonth() < dataNascFormatada.getDayOfMonth()) {
						idade--;
					}
				}else if(dataNascFormatada.getMonthValue() > dataAtual.getMonthValue()) {
					idade--;
				}
				
				idade += (dataAtual.getYear()-dataNascFormatada.getYear());
			}while(idade < 0);

			int opcao;
			char aposentado = 'N';
			int qtdFuncionarios;
			int mesesDesempregado;
			double acrescimo = 0;
			double acrescimoTotal = 0;
			String categoria = "";
			double beneficio = 0;
			double valorBeneficio = 0;
			String descricao = "";
			
			//Pergunta e verifica a categoria
			do {
				System.out.println("Categoria: ");
				System.out.println("-------------------------------");
				System.out.println("1- Empregado");
				System.out.println("2- Empregador");
				System.out.println("3- Desempregado");
				System.out.println("-------------------------------");
				opcao = teclado2.nextInt();
				System.out.println("-------------------------------");
				
				switch (opcao) {
				case 1: {
					System.out.println("É Aposentado?");
					System.out.println("-------------------------------");
					System.out.println("(S)im ou (N)ão?");
					aposentado = teclado2.next().charAt(0);
					categoria = "Empregado";
					
					//Verifica dse é aposentado
					if(aposentado == 'S' || aposentado == 's') {
						acrescimo += 30;
						mesesBeneficio = 6;
						descricao += "\nRecebe acréscimo de 30% por 6 meses por ser aposentado";
					}

					//Define o beneficio para empregado 
					beneficio = valorBenEmpregado;
					
					break;
				}
				case 2: {
					System.out.println("Quantos funcionários?");
					qtdFuncionarios = teclado2.nextInt();
					categoria = "Empregador";

					//Verifica a qtd de funcionarios 
					if(qtdFuncionarios <= 50) {
						acrescimoTotal += 10;
						descricao += "\nRecebe acréscimo de 10% sobre o valor total por ter até 50 funcionários";
					}
					
					//Define o beneficio para empregador
					beneficio = qtdFuncionarios*200;
					
					break;
				}
				case 3: {
					System.out.println("Há quantos meses está desempregado?");
					mesesDesempregado = teclado2.nextInt();
					categoria = "Desempregado";

				    //Meses para desempregados 
					mesesBeneficio = 6;
					descricao += "\nO Benefício será de 6 meses, pois está desempregado";
					
					//Define o beneficio para desempregado 
					beneficio = valorBenDesempregado;
					
					break;
				}
				default:
					System.out.println("Opção inválida");
					break;
				}
				System.out.println("-------------------------------");
				
			}while(opcao < 1 || opcao > 3);

			//Limpa o Scanner 
			teclado2.nextLine();

			System.out.println("Estado: ");
			String estado = teclado2.nextLine();
			System.out.println("-------------------------------");
			
			//Coloca a string em maiúsculo 
			estado = estado.toUpperCase();
			
			//Dados de Impressão na tela 
			System.out.println("-------------------------------");
			System.out.println("Resultado:");
			System.out.println("-------------------------------");
			System.out.println("Nome: "+nome);
			System.out.println("Data de Nascimento: "+dataNascFormatada);
			System.out.println("Categoria: "+categoria);
			System.out.println("-------------------------------");
			
			//Aplicação da verificacao de idade 
			if(idade >= 18) {
				
				//Verifica se o estado recebe acréscimo 
				if(estado.equals("SÃO PAULO")) {
					acrescimo += 10;
					descricao += "\nRecebe acréscimo de 10% por morar em São Paulo";
				}else if(estado.equals("SANTA CATARINA")) {
					acrescimo += 5;
					descricao += "\nRecebe acréscimo de 5% por morar em Santa Catarina";
				}
				
				//Adiciona um beneficiario
				beneficiarios++;
				
				//Verificacao de meses de benefício 
				if(mesesBeneficio < 2) {
					mesesBeneficio = 2;
				}
				
				//Calcula o valor do beneficio 
				valorBeneficio = (beneficio + (beneficio*acrescimo)/100);
				
				//Faz o acréscimo ensina do valor total
				valorBeneficio = (valorBeneficio + (valorBeneficio*acrescimoTotal)/100);
				
				//Verifica se está entre os maiores beneficios
				if(valorBeneficio > maiorBeneficio) {
					
					//Joga o primeiro no segundo
					segundoMaior = maiorBeneficio;
					segundoMaiorNome = maiorNome;
					
					//Salva o maior valor
					maiorBeneficio = valorBeneficio;
					maiorNome = nome;
					
				}else if(valorBeneficio > segundoMaior) {
					segundoMaior = valorBeneficio;
					segundoMaiorNome = nome; 
				}
				
				//Verifica o maior mes de beneficio 
				if(mesesBeneficio > maiorMesesBen) {
					
					//Joga o primeiro no segundo
					segundoMesesBen = maiorMesesBen;
					nomeSegundoMesesBen = nomeMaiorMesesBen;

					//Salva o maior tempo 
					maiorMesesBen = mesesBeneficio;
					nomeMaiorMesesBen = nome;
					
				}else if(mesesBeneficio > segundoMesesBen){
					segundoMesesBen = mesesBeneficio;
					nomeSegundoMesesBen = nome;
				}
				
				//Adiciona ao valor total 
				valorTotalBeneficio += valorBeneficio * mesesBeneficio;
				
				//Sabado é considarado dia útil 
				descricao += "\nSábado é considarado dia útil para pagamento";
				
				//Mostra a descrição detalhada 
				System.out.println(nome+ " Receberá: R$: "+valorBeneficio+" Por "+mesesBeneficio+" meses"+", Visto que: "+descricao);
			}else {
				descricao = nome+" por ter 18 anos não recebe benefício";
				System.out.println("Descrição: "+descricao);
			}
			
			//Pergunta de continuidade do calculo de banefício 
			System.out.println("-------------------------------");
			System.out.println("Deseja informar novo benefício?");
			System.out.println("-------------------------------");
			System.out.println("(S)im ou (N)ão");
			opcaoSair = teclado2.next().charAt(0);
			
			//Fechamento do Scanner
			if(opcaoSair == 'N' || opcaoSair == 'n') {
				teclado2.close();
			}
			
		}while(opcaoSair != 'N' && opcaoSair != 'n');
		
		//Resultados de todos os calculos de baneficio 
		System.out.println("-------------------------------");
		System.out.println("Resultado final: ");
		System.out.println("-------------------------------");
		System.out.println("Total de usuários lidos: "+totalUsuario);
		System.out.println("Total de beneficiários: "+beneficiarios);
		System.out.println("Total de valor que será consedido: "+valorTotalBeneficio);
		System.out.println("-------------------------------");
		System.out.println("Maiores valores:");
		System.out.println("1°: "+maiorNome);
		System.out.println("2°: "+segundoMaiorNome);
		System.out.println("-------------------------------");
		System.out.println("Beneficíos com mais tempo:");
		System.out.println("1°: "+nomeMaiorMesesBen);
		System.out.println("2°: "+nomeSegundoMesesBen);
		System.out.println("-------------------------------");
		
		teclado.close();
	}
}
