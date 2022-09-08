package src;

import java.util.*;
import java.util.Date;

public class Compromisso {
    private Date dataCompromisso;
    private String descricao;
    private int frequenciaRepeticao;
    private int quantidadeRepeticao;

    /**
     * @param data                Data do crompromisso : Date
     * @param descricao           Descricao do compromisso : String
     * @param frequenciaRepeticao De quantos em quantos dias ocorrerá a repetição do
     *                            compromisso : int
     * @param quantidadeRepeticao Quantas vezes a repetição ocorrerá : int
     */
    Compromisso(Date data, String desc, int freqRepeticao, int quantRepeticao) {

        this.dataCompromisso = data;
        this.descricao = desc;
        this.frequenciaRepeticao = freqRepeticao;
        this.quantidadeRepeticao = quantRepeticao;
    }

    /**
   * @return Descrição do compromisso com espaçamento
   */
    public String dadosCompromisso() {
        String dados = "\n";
        dados += this.descricao + "\n";

        return dados;
    }

   /**
   * @return Data do compromisso
   */
    public Date getDataCompromisso() {
        return this.dataCompromisso;
    }

}
