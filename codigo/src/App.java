package src;


public class App {
    public static void main(String[] args) throws Exception {
    AgendaCompromisso minhaAgenda = new AgendaCompromisso();

    minhaAgenda.adicionarCompromisso("11/11/2022", "teste", 5, 5);
    minhaAgenda.adicionarCompromisso("16/11/2022", "teste2", 0, 0);
    minhaAgenda.adicionarCompromisso("03/11/2022", "teste3", 0, 0);
    
    String teste = minhaAgenda.gerarRelatorio();

    System.out.print(teste);
    }


    
}