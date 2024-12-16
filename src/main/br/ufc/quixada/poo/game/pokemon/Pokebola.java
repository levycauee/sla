package br.ufc.quixada.poo.game.pokemon;

public class Pokebola {
  private String nome;
  private double taxaBase;
  public Pokebola(String nome, double taxaBase) {
    this.nome = nome;
    this.taxaBase = taxaBase;
  }

  public String getNome() {
    return nome;
  }

  public double getTaxaBase() {
    return taxaBase;
  }

  public double getTaxaDeCaptura(Pokemon pokemon) {
    return Math.max(0, taxaBase - 0.1 * pokemon.getNivel());
  }

  public boolean capturar(Pokemon pokemon) {
    double chance = getTaxaDeCaptura(pokemon);
    double sorteio = Math.random();
    System.out.println("Chance de captura: " + chance + ", Sorteio: " + sorteio);
    return sorteio < chance;
  }
}

class PokebolaComum extends Pokebola {
  public PokebolaComum() {
    super("Pokébola", 0.3);
  }
}

class GreatBall extends Pokebola {
  public GreatBall() {
    super("Great Ball", 0.4);
  }
}

class UltraBall extends Pokebola {
  public UltraBall() {
    super("Ultra Ball", 0.6);
  }
}

class MasterBall extends Pokebola {
  public MasterBall() {
    super("Master Ball", 1.0);
  }

  @Override
  public boolean capturar(Pokemon pokemon) {
    System.out.println("Captura garantida com a Master Ball!");
    return true;
  }
}
