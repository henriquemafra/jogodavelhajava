import java.util.Scanner;

public class Tabuleiro {

    private static char[][] tabuleiro;
    private static  Scanner scanner;

    public Tabuleiro() {
        tabuleiro = new char[3][3];
        scanner = new Scanner(System.in);
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            
        }
    }
}
        public static void exibirTabuleiro() {
            System.out.println("   1   2   3");
        System.out.println("  -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + tabuleiro[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("  -----------");
                }
        }

        public static boolean realizarJogada(int posicao, char jogador) {
            if (posicao < 1 || posicao > 9) {
                return false; // posição inválida.
            }

            int linha = (posicao - 1) / 3;
            int coluna = (posicao - 1) % 3;

            if (tabuleiro[linha][coluna] != ' ') {
                return false; // posição ocupada.
            }

            tabuleiro[linha][coluna] = jogador;
            return true;

        }

        public static int obterJogada() {
            int posicao;
                while (true) {
                System.out.print("Informe uma posição para jogar de 1-9:");
               
                posicao = scanner.nextInt();
                if (posicao >= 1 && posicao <= 9) {
                    int linha = (posicao - 1) / 3;
                    int coluna = (posicao - 1) % 3;
                    if (tabuleiro[linha][coluna] == ' ') {
                        break;
                    } else {
                        System.out.println("Posição ocupada. Tente outra.");
                    }
                } else {
                    System.out.println("Posição inválida. Tente novamente.");
                }
            }
            return posicao;
        }

        public static boolean verificarVitoria(char jogador) {
            // Verificar linhas
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                    return true;
                }
            }
    
            // Verificar colunas
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                    return true;
                }
            }
    
            // Verificar diagonais
            if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
                return true;
            }
            if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
                return true;
            }
    
            return false;
        }
        public static boolean verificarEmpate() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == ' ') {
                        return false; // Ainda existem células vazias, não é um empate
                    }
                }
            }
            return true; // Todas as células estão preenchidas, é um empate
        }
    
    }        

