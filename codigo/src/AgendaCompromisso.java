package src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AgendaCompromisso {

    private ArrayList<Data> datas = new ArrayList<>();

    public void adicionarCompromisso(String data, String descricao, int frequenciaRepeticao, int quantidadeRepeticao) {
        Data date = new Data(data);
        Data date = acharEmDatas()
        Compromisso novoCompromisso = new Compromisso(date.getData(), descricao, frequenciaRepeticao, quantidadeRepeticao);

        acionarRepeticao(date.getData(), frequenciaRepeticao, quantidadeRepeticao);

        compromissos.add(novoCompromisso);
    }

    private void acionarRepeticao(Date dataInicial, int freq, int quantid){

        for(int i = 0; i<quantid; i++){
            

        }

    }

    private Data acharEmDatas(String data){
        Data novaData = new Data(data);

        for(int i = 0; i< datas.size(); i++){
            if(datas.get(i).getData().equals(converterStringParaDate(data))){
                return datas.get(i);
            }
        }

        return novaData;
    }

    private int diasParaMilisegundos(int dias){
        return 1000 * 60 * 60 * 24 * dias;
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

    private ArrayList<Compromisso> organizaPorData(ArrayList<Compromisso> arrayCompromissos) {
        int n = arrayCompromissos.size();
        for (int i = 0; i < n - 1; i++) {

            int min_element = i;
            for (int j = i + 1; j < n; j++)
                if (ehMaisAntiga(arrayCompromissos.get(j).getDataCompromisso(),arrayCompromissos.get(min_element).getDataCompromisso()) )
                    min_element = j;

            Compromisso temp = arrayCompromissos.get(min_element);
            arrayCompromissos.set(min_element, arrayCompromissos.get(i));
            arrayCompromissos.set(i, temp);
        }

        return arrayCompromissos;
    }

    private boolean ehMaisAntiga(Date data1, Date data2) {
        return data1.before(data2);
    }

}