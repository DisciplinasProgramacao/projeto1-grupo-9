package src;
import java.util.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Data
 */
public class Data {
    private Date data;
    private ArrayList<Compromisso> compromissos = new ArrayList<>();

    Data(String date){
        this.data = converterStringParaDate(date);
    }

    public Date getData(){
        return this.data;
    }

     /**
     * Converte a data em String para Date    
     * @param data Data em String
     * @return Data em Date
     */
    private Date converterStringParaDate(String data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada;

        try {
            dataFormatada = formatter.parse(data);
        } catch (ParseException e) {
            dataFormatada = new Date();
        }

        return dataFormatada;
    }


    
}