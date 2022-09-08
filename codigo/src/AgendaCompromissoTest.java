package src;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import org.junit.Test;


public class AgendaCompromissoTest {

    @Test
    public void testaAdicionaCompromisso(){
        AgendaCompromisso agenda = new AgendaCompromisso();
        agenda.adicionarCompromisso("10/10/2022", "Jogar bola", 5, 1);
    
        Compromisso compromisso = agenda.getDatas().get(0).getCompromissos().get(0);
        assertEquals(compromisso.dadosCompromisso(), "\nJogar bola\n");
    }

    @Test
    public void testaRepeticaoCompromisso(){
        AgendaCompromisso agenda = new AgendaCompromisso();
        agenda.adicionarCompromisso("05/05/2022", "Médico", 5, 3);
        
        
        // teste dia 10/05
        Date data = agenda.converterStringParaDate("10/05/2022");
        Compromisso compromisso = agenda.acharEmDatas(data).getCompromissos().get(0);
        assertEquals(compromisso.dadosCompromisso(), "\nMédico\n");

        // teste dia 15/05
        data = agenda.converterStringParaDate("15/05/2022");
        compromisso = agenda.acharEmDatas(data).getCompromissos().get(0);
        assertEquals(compromisso.dadosCompromisso(), "\nMédico\n");

        // teste dia 20/05
        data = agenda.converterStringParaDate("20/05/2022");
        compromisso = agenda.acharEmDatas(data).getCompromissos().get(0);
        assertEquals(compromisso.dadosCompromisso(), "\nMédico\n");


    }

}