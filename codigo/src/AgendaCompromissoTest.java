package src;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AgendaCompromissoTest {

    private static AgendaCompromisso agenda;

    @BeforeEach
    public void setup() {
      agenda = new AgendaCompromisso();
    }

    @Test
    public void testaAdicionaCompromisso(){
        agenda.adicionarCompromisso("10/10/2022", "Jogar bola", 5, 1);
    
        Compromisso compromisso = agenda.getDatas().get(0).getCompromissos().get(0);
        assertEquals(compromisso.dadosCompromisso(), "\nJogar bola\n");
    }

    @Test
    public void testaRepeticaoCompromisso(){
        agenda.adicionarCompromisso("05/05/2022", "Médico", 5, 3);
        
        
        // teste dia 10/05
        Date data = agenda.converterStringParaDate("10/05/2022");
        Date dataCompromisso = agenda.acharEmDatas(data).getCompromissos().get(0).getDataCompromisso();
        assertEquals(data, dataCompromisso);

        // teste dia 15/05
        data = agenda.converterStringParaDate("15/05/2022");
        dataCompromisso = agenda.acharEmDatas(data).getCompromissos().get(0).getDataCompromisso();
        assertEquals(data, dataCompromisso);

        // teste dia 20/05
        data = agenda.converterStringParaDate("20/05/2022");
        dataCompromisso = agenda.acharEmDatas(data).getCompromissos().get(0).getDataCompromisso();
        assertEquals(data, dataCompromisso);

    }

}