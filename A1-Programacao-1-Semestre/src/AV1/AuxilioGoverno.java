package AV1;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
 * 
 * Avalia��o 1 - Programa��o de Solu��es Computacionais 
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
		System.out.println("Informe os valores de benef�cio: ");
		System.out.println("---------------------------------");
		do {
			System.out.println("Valor de benef�cio para empregado (R$:1000 - R$:1800): ");
			valorBenEmpregado = teclado.nextDouble();

			if(valorBenEmpregado < 1000 || valorBenEmpregado > 1800) {
				System.out.println("-------------------------------");
				System.out.println("Op��o inv�lida");
			}
			System.out.println("-------------------------------");
		}while(valorBenEmpregado < 1000 || valorBenEmpregado > 1800);
		
		do {
			System.out.println("Valor de benef�cio para desempregado (R$:1500 - R$:2300): ");
			valorBenDesempregado = teclado.nextDouble();

			if(valorBenDesempregado < 1500 || valorBenDesempregado > 2300) {
				System.out.println("-------------------------------");
				System.out.println("Op��o inv�lida");
			}
			System.out.println("-------------------------------");
		}while(valorBenDesempregado < 1500 || valorBenDesempregado > 2300);
		
		//Inicia o calculo de benefici�rios 
		do {
			Scanner teclado2 = new Scanner(System.in);
			
			//Adiciona um usu�rio a contagem
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
					System.out.println("� Aposentado?");
					System.out.println("-------------------------------");
					System.out.println("(S)im ou (N)�o?");
					aposentado = teclado2.next().charAt(0);
					categoria = "Empregado";
					
					//Verifica dse � aposentado
					if(aposentado == 'S' || aposentado == 's') {
						acrescimo += 30;
						mesesBeneficio = 6;
						descricao += "\nRecebe acr�scimo de 30% por 6 meses por ser aposentado";
					}

					//Define o beneficio para empregado 
					beneficio = valorBenEmpregado;
					
					break;
				}
				case 2: {
					System.out.println("Quantos funcion�rios?");
					qtdFuncionarios = teclado2.nextInt();
					categoria = "Empregador";

					//Verifica a qtd de funcionarios 
					if(qtdFuncionarios <= 50) {
						acrescimoTotal += 10;
						descricao += "\nRecebe acr�scimo de 10% sobre o valor total por ter at� 50 funcion�rios";
					}
					
					//Define o beneficio para empregador
					beneficio = qtdFuncionarios*200;
					
					break;
				}
				case 3: {
					System.out.println("H� quantos meses est� desempregado?");
					mesesDesempregado = teclado2.nextInt();
					categoria = "Desempregado";

				    //Meses para desempregados 
					mesesBeneficio = 6;
					descricao += "\nO Benef�cio ser� de 6 meses, pois est� desempregado";
					
					//Define o beneficio para desempregado 
					beneficio = valorBenDesempregado;
					
					break;
				}
				default:
					System.out.println("Op��o inv�lida");
					break;
				}
				System.out.println("-------------------------------");
				
			}while(opcao < 1 || opcao > 3);

			//Limpa o Scanner 
			teclado2.nextLine();

			System.out.println("Estado: ");
			String estado = teclado2.nextLine();
			System.out.println("-------------------------------");
			
			//Coloca a string em mai�sculo 
			estado = estado.toUpperCase();
			
			//Dados de Impress�o na tela 
			System.out.println("-------------------------------");
			System.out.println("Resultado:");
			System.out.println("-------------------------------");
			System.out.println("Nome: "+nome);
			System.out.println("Data de Nascimento: "+dataNascFormatada);
			System.out.println("Categoria: "+categoria);
			System.out.println("-------------------------------");
			
			//Aplica��o da verificacao de idade 
			if(idade >= 18) {
				
				//Verifica se o estado recebe acr�scimo 
				if(estado.equals("S�O PAULO")) {
					acrescimo += 10;
					descricao += "\nRecebe acr�scimo de 10% por morar em S�o Paulo";
				}else if(estado.equals("SANTA CATARINA")) {
					acrescimo += 5;
					descricao += "\nRecebe acr�scimo de 5% por morar em Santa Catarina";
				}
				
				//Adiciona um beneficiario
				beneficiarios++;
				
				//Verificacao de meses de benef�cio 
				if(mesesBeneficio < 2) {
					mesesBeneficio = 2;
				}
				
				//Calcula o valor do beneficio 
				valorBeneficio = (beneficio + (beneficio*acrescimo)/100);
				
				//Faz o acr�scimo ensina do valor total
				valorBeneficio = (valorBeneficio + (valorBeneficio*acrescimoTotal)/100);
				
				//Verifica se est� entre os maiores beneficios
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
				
				//Sabado � considarado dia �til 
				descricao += "\nS�bado � considarado dia �til para pagamento";
				
				//Mostra a descri��o detalhada 
				System.out.println(nome+ " Receber�: R$: "+valorBeneficio+" Por "+mesesBeneficio+" meses"+", Visto que: "+descricao);
			}else {
				descricao = nome+" por ter 18 anos n�o recebe benef�cio";
				System.out.println("Descri��o: "+descricao);
			}
			
			//Pergunta de continuidade do calculo de banef�cio 
			System.out.println("-------------------------------");
			System.out.println("Deseja informar novo benef�cio?");
			System.out.println("-------------------------------");
			System.out.println("(S)im ou (N)�o");
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
		System.out.println("Total de usu�rios lidos: "+totalUsuario);
		System.out.println("Total de benefici�rios: "+beneficiarios);
		System.out.println("Total de valor que ser� consedido: "+valorTotalBeneficio);
		System.out.println("-------------------------------");
		System.out.println("Maiores valores:");
		System.out.println("1�: "+maiorNome);
		System.out.println("2�: "+segundoMaiorNome);
		System.out.println("-------------------------------");
		System.out.println("Benefic�os com mais tempo:");
		System.out.println("1�: "+nomeMaiorMesesBen);
		System.out.println("2�: "+nomeSegundoMesesBen);
		System.out.println("-------------------------------");
		
		teclado.close();
	}
}
