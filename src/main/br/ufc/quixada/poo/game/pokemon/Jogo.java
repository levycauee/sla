package br.ufc.quixada.poo.game.pokemon;

import java.util.Scanner;

public class Jogo {

  private Mapa mapa;
  private Treinador treinador;

  public Jogo(String nome, int PokebolasIniciais) {
    treinador = new Treinador(nome);
    mapa = new Mapa(10, 10);
  }

  public void iniciar() {
    Scanner scanner = new Scanner(System.in);
    String opcao = "";
    do {
      mapa.exibirMapa(treinador.getX(), treinador.getY());
      System.out.println("Para onde quer ir? cima, baixo, esquerda, direita ou sair");
      opcao = scanner.nextLine();
      mapa.moverTreinador(treinador, opcao);
      if(mapa.encontrouPokemon(treinador.getX(), treinador.getX())){
        Pokemon encontrado = Encontro.getRandomPokemon();
        Batalha batalha = new Batalha(treinador, encontrado);
        batalha.iniciar();
      }
    } while(!opcao.equals("sair"));
  }
}
