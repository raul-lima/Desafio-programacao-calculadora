
package application;

import java.util.Locale;
import java.util.Scanner;
import org.junit.*;

/**
 * Calculadora que recebe um input do usuário (valor investido em reais) e
 * retorna uma projeção aproximada da quantidade máxima de pessoas que
 * visualizarão um mesmo anúncio.
 * 
 * @author Raul Torres de Lima
 *
 */

public class Calculadora {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("============= Agência Divulga Tudo =============");
		System.out.println("== Calculadora de alcance de anúncio online ==");
		System.out.print("Insira o valor que pretende investir na simulação: R$ ");
		Double investimento = sc.nextDouble();

		Double visualizacoesOriginais = investimento * 30.0;

		Double visualizacoesNovas = calculo(visualizacoesOriginais);
		Double visualizacoesTotal = visualizacoesOriginais + visualizacoesNovas;

		for (int i = 0; i < 2; i++) {
			visualizacoesNovas = calculo(visualizacoesNovas);
			visualizacoesTotal += visualizacoesNovas;
		}

		System.out.printf(
				"A projeção aproximada da quantidade máxima de pessoas que visualizarão o anúncio é de: %.2f pessoas.",
				visualizacoesTotal);

		sc.close();

	}

	/**
	 * Calcula as visualizações novas com base nas visualizações que são passadas
	 * como parâmetro.
	 * 
	 * @param visualizacoes que servirão de base para o cálculo
	 * @return as visualizações novas depois do cálculo
	 */
	static double calculo(Double visualizacoes) {

		Double cliques = visualizacoes * 0.12;
		Double compartilhamentos = 3.0 / 20.0 * cliques;
		Double novasVisualizacoes = compartilhamentos * 40.0;
		return novasVisualizacoes;

	}

}
