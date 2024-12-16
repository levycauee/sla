package br.ufc.quixada.poo.game.pokemon;

public class Treinador {

  private String nome;
  private int x;
  private int y;
  private Pokemon[] pokemons;
  private Pokebola[] pokebolas;

  public Treinador(String nome) {
    this.nome = nome;
    this.x = 0;
    this.y = 0;
    this.pokemons = new Pokemon[3];
    this.pokebolas = new Pokebola[5];
    for (int i = 0; i < pokebolas.length; i++) {
      pokebolas[i] = new Pokebola("Master Ball", 0.4);
    }
  }

  public String getNome() {
    return nome;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setPosicao(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void listar() {
    System.out.println("Pokémons capturados:");
    boolean possuiPokemon = false;
    for (Pokemon pokemon : pokemons) {
      if (pokemon != null) {
        System.out.println("- " + pokemon.getNome());
        possuiPokemon = true;
      }
    }
    if (!possuiPokemon) {
      System.out.println("Nenhum Pokémon capturado ainda.");
    }
  }

  public boolean capturar(Pokemon pokemon) {
    for (int i = 0; i < pokemons.length; i++) {
      if (pokemons[i] == null) {
        pokemons[i] = pokemon;
        return true;
      }
    }
    System.out.println("Não é possível capturar. A equipe está cheia!");
    return false;
  }

  public boolean temPokebola() {
    for (Pokebola pokebola : pokebolas) {
      if (pokebola != null) return true;
    }
    return false;
  }

  // Método para arremessar uma Pokébola
  public boolean arremessarPokebola() {
    if (temPokebola()) {
      // Encontrar a primeira pokébola não nula
      for (int i = 0; i < pokebolas.length; i++) {
        if (pokebolas[i] != null) {
          pokebolas[i] = null;
          System.out.println("Pokébola lançada! Pokébolas restantes: " + contarPokebolas());
          return true;
        }
      }
    }
    System.out.println("Sem pokébolas restantes!");
    return false;
  }

  // Método para contar o número de Pokébolas restantes
  public int contarPokebolas() {
    int contador = 0;
    for (Pokebola pokebola : pokebolas) {
      if (pokebola != null) {
        contador++;
      }
    }
    return contador;
  }

  // Método para exibir as Pokébolas restantes
  public void exibirPokebolas() {
    System.out.println("Pokébolas disponíveis: " + contarPokebolas());
  }
}
