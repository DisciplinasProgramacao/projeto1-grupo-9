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

    Compromisso(Date data, String desc, int freqRepeticao, int quantRepeticao) {

        this.dataCompromisso = data;
        this.descricao = desc;
        this.frequenciaRepeticao = freqRepeticao;
        this.quantidadeRepeticao = quantRepeticao;
    }

    public String dadosCompromisso() {
        String dados = "\n";
        dados += this.descricao + "\n";

        if (this.frequenciaRepeticao > 0 && this.quantidadeRepeticao > 0) {
            dados += "Repetindo de " + this.frequenciaRepeticao +
                    " em " + this.frequenciaRepeticao + " dias, por " +
                    this.quantidadeRepeticao + " vezes \n";
        }

        return dados;
    }

    public Date getDataCompromisso() {
        return this.dataCompromisso;
    }

}
