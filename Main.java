import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    ArrayList<Tarefa> listaDeTarefas = new ArrayList<Tarefa>(); //criando a lista chamada listadetarefas
    Scanner scanner = new Scanner(System.in); //criando o scnanner

    public static void main(String[] args) {
        Main app = new Main();
        app.executar();
    }

    public void executar(){
        //fazendo um loop infinito para rodar a aplicação
        while (true){
            //"menu"
            System.out.println("=== Tarefas Legais :D ===\n1. Ler tarefas\n2. Adicionar Tarefa nova\n3. Concluir Tarefa");

            // coletar a decisão do usuário
            System.out.print("Sua decisão: ");
            int decisao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("===========");

            if (decisao == 1){
                lerTarefas(); // se a variavel foi 1 ele vai ler aas tarefas
            }

            else if(decisao == 2){ //se for 2 ele vai pedir o nome da tarefa e adicionar ela na lista
                System.out.print("Nome da tarefa: ");
                String nomeTarefa = scanner.nextLine();
                addTarefa(nomeTarefa);
                System.out.println("tarefa adicionada com sucesso!");
            }

            else if(decisao == 3){ //se for 3 ele vai lar e pedir um numero pra completar
                lerTarefas();
                System.out.print("número da tarefa: ");
                int numeroDaTarefa = scanner.nextInt();
                concluirTarefas(numeroDaTarefa);
            }
        }
    }


    private void addTarefa(String nome){
        Tarefa novaterefa = new Tarefa();
        novaterefa.setNome(nome);
        novaterefa.setCompleta(false);
        listaDeTarefas.add(novaterefa);
    }

    private void lerTarefas(){
        for (int i = 0; i < listaDeTarefas.size(); i++){
            if (listaDeTarefas.get(i).getCompleta() == false) {
                System.out.println(i + ". " + listaDeTarefas.get(i).getNome());
            }
            else {
                System.out.println(i + ". " + listaDeTarefas.get(i).getNome() + " (completa)");
            }
        }
    }

    private void concluirTarefas(int numeroDaTarefa){
        listaDeTarefas.get(numeroDaTarefa).setCompleta(true);
        System.out.println("tarefa marcada como completa");
    }

}