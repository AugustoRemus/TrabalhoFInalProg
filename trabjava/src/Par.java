public class Par {
    private Jogador jogador;
    private int numero;

    
    public Par(Jogador jogador, int carta)
    {
        this.jogador = jogador;
        numero = carta;
        
    }
    public Jogador getPlayer()
    {
        return(jogador);
    }

    public int getNum()
    {
        return numero;
    }

    
}
