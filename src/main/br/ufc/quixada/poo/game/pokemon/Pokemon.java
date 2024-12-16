package br.ufc.quixada.poo.game.pokemon;

public class Pokemon {
  static int contador;
  String nome;
  int nivel;
  int pontosDeVida;
  int ataque;
  int defesa;
  int velocidade;


  public Pokemon(String nome) {
    contador++;
    this.nome = nome;
    this.nivel = 1;
    this.ataque = (int) (Math.random()*100);
  }

  public int getNivel(){
    return nivel;
  }
  public Pokemon(String nome, int nivel) {
    this(nome);
    this.nivel = nivel;
  }

  public Pokemon(String nome, int nivel, int pontosDeVida) {
    this(nome, nivel);
    this.pontosDeVida = pontosDeVida;
  }

  public String getNome() {
    return nome;
  }

  public String falar() {
    return nome + " " + nome;
  }

  public int curar(int pontosDeVida) {
    this.pontosDeVida += pontosDeVida;
    return this.pontosDeVida;
  }

  public void atacar(int movimento, Pokemon alvo) {
    if (taVivo()) {
      //ataque!
      System.out.println("Atacando o " + alvo + " com ataque" + movimento);
    } else {
      System.out.println("to morto :/");
    }
  }

  private boolean taVivo() {
    return this.pontosDeVida > 0;
  }

  @Override
  public String toString() {
    return "Pokemon{" +
            "nome='" + nome + "[" + nivel + "]" + '\'' +
            ", pontosDeVida=" + pontosDeVida +
            ", ataque=" + ataque +
            ", defesa=" + defesa +
            ", velocidade=" + velocidade  +
            '}';
  }
}
