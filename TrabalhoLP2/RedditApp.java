package TrabalhoLP2;

import java.util.List;
import java.util.Scanner;

public class RedditApp {

    private SistemaUsuario sistemaUsuario = new SistemaUsuario();
    private SistemaComunidade sistemaComunidades = new SistemaComunidade();
    private SistemaPosts sistemaPostseComent = new SistemaPosts();

    public void iniciarDados(){
        sistemaUsuario.carregarUsuarios("TrabalhoLP2/usuarios.txt");
        sistemaComunidades.carregarPost("TrabalhoLP2/post.txt");
        sistemaPostseComent.carregarComentarios("TrabalhoLP2/comentarios.txt");
        menuLogin();
//        menuPrincipal();
    }

    {
        for (Usuario u : sistemaUsuario.getUsuarios());



    }
    private void menuLogin(){
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n--- Bem-vindo ao RedditApp ---");
            System.out.println("1 - Login");
            System.out.println("2 - Criar nova conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                   sistemaUsuario.login();
                    break;
                case 2:
                    sistemaUsuario.criarConta();
                    break;
            }
        } while (  == null && opcao != 0);

        if (usuarioLogado == null) {
            System.out.println("Encerrando o programa...");
            System.exit(0);
        }
    }

}




