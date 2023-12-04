import java.util.Scanner;


public class Jogador {

    private String nomeDoJogador;
    private int[] mao = new int[12];
    private int pontos = 0;

    public int getPontos()
    {
        return(pontos);
    }

    public String getName()
    {
        return nomeDoJogador;
    }

    public void criarJogador(String nome)
    {
        nomeDoJogador = nome;
    }


    public void criarMao(Baralho baralho)
    {
        for(int i=0; i<12; i++)
        {
            
            mao[i] = baralho.pescarCarta();
            
        }
        //imprimirMao();
    }

    public void imprimirMao()
    {
        System.out.printf("cartas do jogador %s:\n", nomeDoJogador);
        //imprime o primero numero
        System.out.printf("%d ", mao[0]);
        //imprime o resto
        for(int i =1; i<mao.length; i++)
        {
            System.out.printf(", %d ", mao[i]);
        }
        //pula a linha
        System.out.printf("\n");
    }

    public int jogarCarta()
    {
        imprimirMao();
        System.out.printf("escolha a carta que queira jogar pelo index (1 para a primeira...) jogador %s:\n", nomeDoJogador);
        Scanner scaner = new Scanner(System.in);
        while(true)
        {
            int index;
            System.out.printf("\n");
            index = scaner.nextInt();
            if(index>12 || index <=0)
            {
                System.out.printf("index invalido, insira novamente\n");
                continue;
            }
            else{
                if(mao[index-1] == 0)
                {
                    System.out.printf("carta ja jogada, tente novamente\n");
                    continue;
                }
                index--;
                int n = mao[index];
                mao[index] = 0;
                System.out.printf("numero: %d\n", n);
                
                return(n);
            }
            
        }

    }

    public void addPonto(int n)
    {
            if(n != 0)
            {
                pontos++;

                if(n%5 == 0 && n%2 != 0)
                {
                    pontos++;
                }

                if(n%10 == 0)
                {
                    pontos = pontos +2;
                }
                if(n%11 == 0)
                {
                    pontos = pontos + 4;
                }

        }
        
    }

}
