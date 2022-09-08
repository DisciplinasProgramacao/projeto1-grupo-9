package src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class AgendaCompromisso {

    private ArrayList<Data> datas = new ArrayList<>();

    /**
     * Adiciona um novo compromisso à agenda
     * @param data Data do crompromisso no formato "DD/MM/AAAA". Caso passada no formato
     * errado, sera setada a data de hoje
     * @param descricao Descricao do compromisso : String
     * @param frequenciaRepeticao De quantos em quantos dias ocorrerá a repetição do compromisso : int
     * @param quantidadeRepeticao Quantas vezes a repetição ocorrerá : int
     */
    public void adicionarCompromisso(String data, String descricao, int frequenciaRepeticao, int quantidadeRepeticao) {
        Date dataFormadatada = converterStringParaDate(data);
        Data date = acharEmDatas(dataFormadatada);
        Compromisso novoCompromisso = new Compromisso(date.getData(), descricao, frequenciaRepeticao,
                quantidadeRepeticao);
        date.novoCompromissoData(novoCompromisso);

        if (frequenciaRepeticao > 0 && quantidadeRepeticao > 0)
            acionarRepeticao(date.getData(), frequenciaRepeticao, quantidadeRepeticao, novoCompromisso);

    }

    /**
     * Gera o relatório com os respectivos compromissos ordenados cronologicamente por data
     * @return relatorio : String
     */
    public String gerarRelatorio() {
        ArrayList<Data> temp = datas;
        temp.sort((d1, d2) -> d1.compareTo(d2));

        String relatorio = "";

        for (int i = 0; i < temp.size(); i++) {
            relatorio += ("\n----------------------------- \n" +
                    "\nDia " + converterDateParaString(datas.get(i).getData()) + "\n");
            for (int j = 0; j < datas.get(i).getCompromissos().size(); j++) {
                Compromisso comp = datas.get(i).getCompromissos().get(j);
                relatorio += comp.dadosCompromisso();

            }
        }

        return relatorio;
    }

    /**
     * Adiciona os compromissos às datas de acordo com a repetição
     * e frequência desejada.
     * @param dataInicial data de início em Date
     * @param freq frquencia de execução : int
     * @param quantid quantidade de repetições : int
     * @param compromisso compromisso a ser repetido : Compromisso
     */
    private void acionarRepeticao(Date dataInicial, int freq, int quantid, Compromisso compromisso) {
        Date dataRepeticao = dataInicial;
        for (int i = 0; i < quantid; i++) {
            dataRepeticao = new Date(dataRepeticao.getTime() + diasParaMilisegundos(freq));

            Data data = acharEmDatas(dataRepeticao);

            data.novoCompromissoData(compromisso);

        }

    }

    /**
     * Pesquisa se a data já existe na agenda. 
     * Caso exista, retorna-a.
     * Senão, cria uma nova data, adiciona-a ao array e retorna-a
     * @param data data em Date
     */
    private Data acharEmDatas(Date data) {
        Data novaData = new Data(data);

        for (int i = 0; i < this.datas.size(); i++) {
            if (this.datas.get(i).getData().equals(data)) {
                return this.datas.get(i);
            }
        }

        this.datas.add(novaData);
        return this.datas.get(this.datas.size() - 1);
    }

    private int diasParaMilisegundos(int dias) {
        return 1000 * 60 * 60 * 24 * dias;
    }

    /**
     * Converte a data em String para Date
     * 
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

    /**
     * Converte a data em double para String
     * 
     * @param data Data em Date
     * @return Data em String
     */
    private String converterDateParaString(Date data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String dataFormatada = formatter.format(data);

        return dataFormatada;
    }

}