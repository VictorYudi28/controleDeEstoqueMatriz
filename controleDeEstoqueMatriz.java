package matrizLista3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class controleDeEstoqueMatriz {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		DecimalFormat formataMoeda = new DecimalFormat("R$ #,##0.00");

		double estoqueProdArmazem[][] = new double[5][3];
		double somaArmazem[] = new double[4];
		double maiorArmazem = 0, menorArmazem = 0;
		int indiceMaior = 0, indiceMenor = 0;
		double somaProduto[] = new double[3];
		double ProdFinal = 0;

		for (int i = 0; i < 4; i++) {

			System.out.println("--- Estoque no armazém ( " + (i + 1) + " ) ---");

			for (int j = 0; j < 3; j++) {

				System.out.println("Informe a quantidade " + "em estoque do Produto ( " + (j + 1) + " ) ---");
				estoqueProdArmazem[i][j] = entrada.nextDouble();

			}

			System.out.println();

		} // For recebe a quantidade de estoque

		for (int i = 0; i < 3; i++) {
			System.out.println();
		} // pula linha

		System.out.println("----- Custo de cada produto -----");
		System.out.println("");

		for (int i = 0; i < 3; i++) {

			System.out.println("--- Informe o custo do produto ( " + (i + 1) + " )");
			estoqueProdArmazem[4][i] = entrada.nextDouble();

		} // For recebe o custo

		for (int i = 0; i < 3; i++) {
			System.out.println();
		} // pula linha

		System.out.println("----- Quantidade de itens em cada armazém -----");
		System.out.println();

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 3; j++) {

				// Soma armazem
				somaArmazem[i] += estoqueProdArmazem[i][j];

			}

			System.out.println();
			System.out.println("--- Estoque no armazém ( " + (i + 1) + " ) : " + somaArmazem[i]);

		} // For soma armazem

		for (int i = 0; i < 3; i++) {
			System.out.println();
		} // pula linha

		for (int i = 0; i < 4; i++) {

			if (estoqueProdArmazem[i][1] > maiorArmazem) {
				maiorArmazem = estoqueProdArmazem[i][1];
				indiceMaior = i;
			}

		} // For pega o maior estoque do produto 2

		System.out.println("----- Armazém com maior estoque do produto 2 -----");
		System.out.println();
		System.out.println("--- Armazém ( " + (indiceMaior + 1) + " " + ") - Quantidade em estoque: " + maiorArmazem);

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 3; j++) {

				if (i == 0 && j == 0) {

					menorArmazem = estoqueProdArmazem[i][j];

				} else {
					if (menorArmazem > estoqueProdArmazem[i][j]) {

						menorArmazem = estoqueProdArmazem[i][j];
						indiceMenor = i;

					}
				}

			}

		} // For pega o menor estoque

		for (int i = 0; i < 3; i++) {
			System.out.println();
		} // pula linha

		System.out.println("----- Armazém com menor estoque -----");
		System.out.println();
		System.out.println("--- Armazém ( " + (indiceMenor + 1) + " " + ") - Quantidade em estoque: " + menorArmazem);

		for (int i = 0; i < 3; i++) {
			System.out.println();
		} // pula linha

		System.out.println("----- Custo total de cada armazém -----");
		System.out.println();

		for (int j = 0; j < 3; j++) {

			for (int i = 0; i < 4; i++) {

				somaProduto[j] += estoqueProdArmazem[i][j];

			} // Linhas

			System.out.println("Custo total do produto " + "( " + (j + 1) + " ): "
					+ formataMoeda.format(somaProduto[j] * estoqueProdArmazem[4][j]));

		} // Colunas

		for (int i = 0; i < 3; i++) {
			System.out.println();
		} // pula linha

		System.out.println("----- Custo total de cada armazém -----");
		System.out.println();

		for (int i = 0; i < 4; i++) {

			ProdFinal = 0;

			for (int j = 0; j < 3; j++) {

				ProdFinal += estoqueProdArmazem[i][j] * estoqueProdArmazem[4][j];

			} // Colunas

			System.out.println("Custo total no armazém ( " + (i + 1) + " ): " + formataMoeda.format(ProdFinal));

		} // Linhas

	}// public static void main

}// public class