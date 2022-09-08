package src;


public class App {
    public static void main(String[] args) throws Exception {
    AgendaCompromisso minhaAgenda = new AgendaCompromisso();

    minhaAgenda.adicionarCompromisso("11/11/2022", "Levar cachorro pra passear", 3, 5);
    minhaAgenda.adicionarCompromisso("10/11/2022", "Reuniao empresa", 1, 30);
    minhaAgenda.adicionarCompromisso("03/11/2022", "Corrida", 0, 0);
    
    String teste = minhaAgenda.gerarRelatorio();

    System.out.print(teste);
    }


    
}