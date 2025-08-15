package TrabalhoLP2;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaUsuario  {
    private static Scanner scanner = new Scanner(System.in);
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public Usuario login(){
        String entradaLogin = scanner.nextLine().trim();
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(entradaLogin)) {
                System.out.println("Login realizado com sucesso");
                    u.setLogado(true);
                    return u;
            }
        }
            {
            System.out.println("Este usuário não consta na nossa lista de usuários cadastrados. Crie sua conta.");
            criarConta();
        } // Verificar
        return null;
    }

    public void menuInicial() {

        System.out.println("Seja bem-vindo ao LP2Reddit!");
        System.out.println("Para criar uma conta digite 'criar'");
        System.out.println("Já tem uma conta? Então digite 'login'");
        String resposta = scanner.nextLine().toLowerCase();

        if (resposta.equals("login")) {
            login();
        } else if (resposta.equals("criar")) {
            criarConta();
        } else {
            System.out.println("Opção inválida.");
            menuInicial();

        }
    }


    public List<Usuario> carregarUsuarios(String nomedoarquivo){
        usuarios.clear();

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomedoarquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                usuarios.add(new Usuario(linha.trim()));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de usuários.");
            return null;
        }
        return usuarios;
    }
    public void criarConta() {
        System.out.println("Digite um nome de usuário para criar a conta:");
        String novoNome = scanner.nextLine().trim();

        // Verifica duplicata usando a lista já carregada
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(novoNome)) {
                System.out.println("Nome de usuário já existe, tente novamente com outro nome.");
                criarConta();
                return;
            }
        }

        // Adiciona na lista
        usuarios.add(new Usuario(novoNome));

        // Adiciona também no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TrabalhoLP2/Usuario.txt", true))) {
            writer.write(novoNome + "\n");
            System.out.println("Conta criada com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de usuários.");
        }
    }
}

