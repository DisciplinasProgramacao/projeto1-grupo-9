package src;

import java.util.*;
import java.util.Date;

public class Data implements Comparable<Data> {
  private Date data;
  private ArrayList<Compromisso> compromissos = new ArrayList<>();

  Data(Date date) {
    this.data = date;
  }


  /**
   * @return Data da instância : Date
   */
  public Date getData() {
    return this.data;
  }

  /**
   * @return Lista de compromissos da Data
   */
  public ArrayList<Compromisso> getCompromissos() {
    return this.compromissos;
  }

  /**
   * Adiciona novo compromisso à Data
   * @param compromisso Compromisso a ser adicionado : Compromisso
   */
  public void novoCompromissoData(Compromisso compromisso) {
    this.compromissos.add(compromisso);
  }

  /**
   * Override do método compareTo para organizar
   * as datas cronologicamente
   */
  @Override
  public int compareTo(Data o) {
    if (getData() == null || o.getData() == null)
      return 0;
    return getData().compareTo(o.getData());
  }

}