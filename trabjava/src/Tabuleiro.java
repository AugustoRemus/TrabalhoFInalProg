import java.util.*;
import java.util.Scanner;

import javax.swing.text.PlainDocument;

public class Tabuleiro {

    int[][] tabuleiro = new int[5][6];

    public void iniciarTabuleiro(Baralho baralho)
    {
        for(int l =0;l<5;l++)
        {
            for(int c =0;c<6;c++)
            {
                if(c==0)
                {
                    tabuleiro[l][c] = baralho.pescarCarta();
                }
                else{
                    tabuleiro[l][c] = 0;
                }
            } 
        }
    }

    public void imprimirTabuleiro()
    {
        for(int l =0;l<5;l++)
        {
            for(int c =0;c<5;c++)
            {
                
                System.out.printf("%d  ", tabuleiro[l][c]);
            } 
            System.out.printf("\n");
        }
    }

    
    public int jogarCarta(int carta, Jogador jogador)
    {
        

        int adicionar = 0;
        int maisAlto = tabuleiro[0][0];
        int cadd =1 ,ladd = 1,cmais =1, lmais = 1;

        for (int l = 0; l < 5; l++) {
            for (int c = 1; c < 6; c++) {
                
                if (tabuleiro[l][c] == 0) {
                    if (tabuleiro[l][c - 1] > maisAlto) {
                        maisAlto = tabuleiro[l][c - 1];
                        cmais = c;
                        lmais = l;
                    }
                    if (tabuleiro[l][c - 1] > adicionar && tabuleiro[l][c - 1] < carta) {
                        adicionar = tabuleiro[l][c - 1];
                        cadd = c;
                        ladd = l;
                    }
                    else if(tabuleiro[l][4] != 0)
                {
                     if (tabuleiro[l][c] > maisAlto) {
                        maisAlto = tabuleiro[l][c];
                        cmais = c;
                        lmais = l;
                    }
                    if (tabuleiro[l][c] > adicionar && tabuleiro[l][c] < carta) {
                        adicionar = tabuleiro[l][c];
                        cadd = c;
                        ladd = l;
                    }
                }
                    break; 
                }
            }
        }
        

        if(adicionar == 0)
        {
            adicionar = maisAlto;
            cadd = cmais;
            ladd = lmais;
            for(int i =0; i<5; i++)
            {
                jogador.addPonto(tabuleiro[ladd][i]);
                tabuleiro[ladd][i] = 0;
            
            }
            tabuleiro[ladd][0] = carta;
            System.out.printf("o jogador %s esta com %d pontos\n", jogador.getName(), jogador.getPontos());
            
        }

        
        else if(cadd == 5)
        {
            for(int i =0;i<5 ;i++)
            {
                System.out.printf("chegou\n");
                jogador.addPonto(tabuleiro[ladd][i]);
                tabuleiro[ladd][i] = 0;
                System.out.printf("o jogador %s esta com %d pontos\n", jogador.getName(), jogador.getPontos());
            }
            tabuleiro[ladd][0] = carta;
        }
        else{
            tabuleiro[ladd][cadd] = carta;
        }
            
           
            
        


        //System.out.printf("\nnumero aonde deve adicionar %d\n", adicionar);
        //System.out.printf("maior %d\n", maisAlto);

        return(adicionar);
    }

    public Jogador[] criarJogo()
    {
        Scanner scaner = new Scanner(System.in);

        int jogadoresQuantidade = 0;
        System.out.printf("Bem vindo digite o numero de jogadores(entre 3 a 6):\n");
        while(true)
        {
            jogadoresQuantidade =  Integer.parseInt(scaner.nextLine());
            if (jogadoresQuantidade > 6 || jogadoresQuantidade < 3)
            {
                System.out.printf("numero invalido, tente novamente\n");
            }
            else{
                break;
            }
        }
        

        Jogador jogadores[] = new Jogador[jogadoresQuantidade];
        for(int i =0; i<jogadoresQuantidade; i++)
        {
            Jogador player = new Jogador();
            System.out.printf("digite o nome do jogador %d:\n", i+1);
            String nome = scaner.nextLine();
            player.criarJogador(nome);
            jogadores[i] = player;
        }
        return(jogadores);
    }









   
}
