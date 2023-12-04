import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileAlreadyExistsException;



import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception{
     
        Tabuleiro tabuleiro = new Tabuleiro();
        Baralho baralho = new Baralho();
        baralho.criarBaralho();
        
       


        Path diretorio = Paths.get(".\\resultados");
        Files.createDirectories(diretorio);

        Path arquivo = diretorio.resolve(Paths.get("jogo.txt"));
        if (!Files.exists(arquivo)) {
            Files.createFile(arquivo);
        }

        


    

        Jogador jogadores[] = tabuleiro.criarJogo();
        int quantJogadores = jogadores.length;

        tabuleiro.iniciarTabuleiro(baralho);
        tabuleiro.imprimirTabuleiro();



        
        for(int i = 0; i<quantJogadores; i++)
        {
            String nome = jogadores[i].getName();
            System.out.printf("nome do jogador %d: %s\n", i+1, nome);
            
            
        }
        baralho.criarBaralho();
        for(int i = 0; i<quantJogadores; i++)
        {
            
            jogadores[i].criarMao(baralho);
            
                
        }

        for(int rodadas =0; rodadas<12;rodadas++)
        {
            Par[] cartasJogadas = new Par[quantJogadores];
            int[] cartass = new int[quantJogadores];
            

            for(int i = 0; i<quantJogadores; i++)
            {
                int carta = jogadores[i].jogarCarta();
                Par par = new Par(jogadores[i], carta);
                cartasJogadas[i] = par;
                cartass[i] = par.getNum();                
            }
            //arrumar essas cartas
            Arrays.sort(cartass);

            for(int i = 0; i<quantJogadores; i++)
            {
                for(int d = 0; d<quantJogadores; d++)
                {
                    if(cartass[i] == cartasJogadas[d].getNum())
                    {
                        tabuleiro.jogarCarta(cartasJogadas[d].getNum(), cartasJogadas[d].getPlayer());
                        System.out.printf("jogador %s jogou carta n: %d\n",cartasJogadas[d].getPlayer().getName() ,cartasJogadas[d].getNum());
                        
                    }
                }
            }
            tabuleiro.imprimirTabuleiro();
        }
        System.out.printf("fim de jogo!!!!!!!\n");
            Jogador ganhador = jogadores[0];
            for(int i = 0; i<quantJogadores; i++)
            {
                    System.out.printf("jogador %s ficou com %d pontos;\n", jogadores[i].getName(), jogadores[i].getPontos());
                    
                    if(ganhador.getPontos() > jogadores[i].getPontos())
                    {
                        ganhador = jogadores[i];
                    }
                     if(ganhador.getPontos() == jogadores[i].getPontos())
                    {
                        if(ganhador.getName() != jogadores[i].getName())
                        System.out.printf("O jogador %s empatou com o %s tendo ambos %d pontos\n", ganhador.getName(),ganhador.getName(),jogadores[i].getPontos());
                    }
                    
            }
            for(int i = 0; i<quantJogadores; i++)
            {
                List<String> resultado =  Arrays.asList(new String[]{"jogador " + jogadores[i].getName()+ " ficou com " + (jogadores[i].getPontos()) + " pontos\n"});
                Files.write(arquivo, resultado, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

            }
            System.out.printf("O jogador %s foi o vencedor", ganhador.getName());
            List<String> ganhadorString =  Arrays.asList(new String[]{"jogador " + ganhador.getName()+ " ganhou o jogo ficando com " + (ganhador.getPontos()) + " pontos\n"});
            Files.write(arquivo, ganhadorString, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            System.out.println("");
    }
}

