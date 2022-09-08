package src;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;


public class CompromissoTest {
    
    @Test
    public void testeIniciarCompromisso(){
        Date data = new Date();
        Compromisso compromisso = new Compromisso(data, "Jogar bola", 1, 5);
        assertEquals(compromisso.dadosCompromisso(), "\nJogar bola\n");
    }
}
