package br.ufc.quixada.poo.game.pokemon;

import java.util.Scanner;

public class Batalha {
  private Treinador treinador;
  private Pokemon pokemon;
  private boolean terminou;

  public Batalha(Treinador treinador, Pokemon pokemon) {
    this.treinador = treinador;
    this.pokemon = pokemon;
    this.terminou = false;
  }

  public void iniciar() {
    System.out.println("Você encontrou um " + pokemon.getNome() + "!");
    while (!terminou) {
      proximoTurno();
    }
  }

  public boolean terminou() {
    return terminou;
  }

  public void proximoTurno() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEscolha uma ação:");
    System.out.println("1. Tentar capturar");
    System.out.println("2. Fugir");

    String escolha = scanner.nextLine();

    switch (escolha) {
      case "1":
        if (treinador.temPokebola()) {
          boolean capturado = tentarCaptura();
          if (capturado) {
            terminou = true;
          }
        } else {
          System.out.println("Você não tem mais pokébolas!");
        }
        break;
      case "2":
        System.out.println("Você fugiu da batalha!");
        terminou = true;
        break;
      default:
        System.out.println("Escolha inválida.");
        break;
    }
  }

  private boolean tentarCaptura() {
    treinador.arremessarPokebola();
    System.out.println("Tentando capturar " + pokemon.getNome() + "...");

    boolean capturado = Math.random() < 0.5;

    if (capturado) {
      boolean adicionado = treinador.capturar(pokemon);
      if (adicionado) {
        System.out.println("Parabéns! Você capturou " + pokemon.getNome() + "!");
        return true;
      } else {
        System.out.println("Você não tem espaço suficiente para capturar mais Pokémons.");
        return false;
      }
    } else {
      System.out.println("A captura falhou! O Pokémon escapou.");
    }
    return false;
  }
}
