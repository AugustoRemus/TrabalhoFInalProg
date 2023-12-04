import java.util.*;
import javax.management.ValueExp;


public class Baralho {
    
    //iniciando o baralho
    private int[] baralho = new int[110];
    //tratar o 0 sempre

    //botando os numeros
    public void criarBaralho()
    {
        
        for(int i = 0; i<110; i++)
        {
            baralho[i] = i;
        }
        
    }

    //pegar carta
    public int pescarCarta()
    {
        Random random = new Random();
        int numero = 0;
        int maxTentativas = 120;
    
        for (int tentativa = 0; tentativa < maxTentativas; tentativa++) {
            numero = random.nextInt(109 - 1);
            if (baralho[numero] == 0) {
                continue;
            } else {
                baralho[numero] = 0;
                return numero;
            }
        }
        
        //erro
        throw new RuntimeException("baralho vazio ou nao iniciado");
    }
    

    public void printBaralho()
    {
        for (int i = 0; i<110; i++)
        {
            System.out.printf("%d\n", baralho[i]);
        }
    }
   

}
