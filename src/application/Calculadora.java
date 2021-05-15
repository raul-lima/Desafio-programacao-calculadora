
package application;

import java.util.Locale;
import java.util.Scanner;
import org.junit.*;

/**
 * Calculadora que recebe um input do usu�rio (valor investido em reais) e
 * retorna uma proje��o aproximada da quantidade m�xima de pessoas que
 * visualizar�o um mesmo an�ncio.
 * 
 * @author Raul Torres de Lima
 *
 */

public class Calculadora {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("============= Ag�ncia Divulga Tudo =============");
		System.out.println("== Calculadora de alcance de an�ncio online ==");
		System.out.print("Insira o valor que pretende investir na simula��o: R$ ");
		Double investimento = sc.nextDouble();

		Double visualizacoesOriginais = investimento * 30.0;

		Double visualizacoesNovas = calculo(visualizacoesOriginais);
		Double visualizacoesTotal = visualizacoesOriginais + visualizacoesNovas;

		for (int i = 0; i < 2; i++) {
			visualizacoesNovas = calculo(visualizacoesNovas);
			visualizacoesTotal += visualizacoesNovas;
		}

		System.out.printf(
				"A proje��o aproximada da quantidade m�xima de pessoas que visualizar�o o an�ncio � de: %.2f pessoas.",
				visualizacoesTotal);

		sc.close();

	}

	/**
	 * Calcula as visualiza��es novas com base nas visualiza��es que s�o passadas
	 * como par�metro.
	 * 
	 * @param visualizacoes que servir�o de base para o c�lculo
	 * @return as visualiza��es novas depois do c�lculo
	 */
	static double calculo(Double visualizacoes) {

		Double cliques = visualizacoes * 0.12;
		Double compartilhamentos = 3.0 / 20.0 * cliques;
		Double novasVisualizacoes = compartilhamentos * 40.0;
		return novasVisualizacoes;

	}

}
