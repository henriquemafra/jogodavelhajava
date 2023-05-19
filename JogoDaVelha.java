import java.util.Scanner;

public class JogoDaVelha {
    private Tabuleiro tabuleiro;

    public JogoDaVelha() {
        tabuleiro = new Tabuleiro();
    }

    public void exibirTabuleiro() {
        Tabuleiro.exibirTabuleiro();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.exibirTabuleiro();

        char jogador = 'X';
        boolean fimDoJogo = false;
        
        while (!fimDoJogo) {
            int jogada = Tabuleiro.obterJogada();
            boolean jogadaValida = Tabuleiro.realizarJogada(jogada, jogador);

            if (jogadaValida) {
                jogo.exibirTabuleiro();

                if (Tabuleiro.verificarVitoria(jogador)) {
                    System.out.println("O jogador " + jogador + " venceu!");
                    fimDoJogo = true;
                } else if (Tabuleiro.verificarEmpate()) {
                    System.out.println("O jogo terminou em empate!");
                    fimDoJogo = true;
                } else {
                    jogador = jogador == 'X' ? 'O' : 'X';
                }
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }

        System.out.println("Fim do jogo.");
    }
}
