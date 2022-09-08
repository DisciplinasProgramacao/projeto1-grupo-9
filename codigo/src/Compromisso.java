package src;
import java.util.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compromisso {
    private Date dataCompromisso;
    private String descricao;
    private int frequenciaRepeticao;
    private int quantidadeRepeticao;   

    Compromisso(Date data, String desc, int freqRepeticao, int quantRepeticao){

        this.dataCompromisso = data;
        this.descricao = desc;
        this.frequenciaRepeticao = freqRepeticao;
        this.quantidadeRepeticao = quantRepeticao;
    }

    public Date getDataCompromisso(){
        return this.dataCompromisso;
    }


     /**
     * Converte a data em Date para String    
     * @param data Data em Date
     * @return Data em String
     */
    private String converterDateParaString(Date data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String dataFormatada = formatter.format(data);

        return dataFormatada;
    }

    
}
