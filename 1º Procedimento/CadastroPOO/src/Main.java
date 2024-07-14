package cadastroPOO;

import model.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "João", "12345678900", 30));
            repo1.inserir(new PessoaFisica(2, "Maria", "98765432100", 25));
            repo1.persistir("pessoasFisicas.bin");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.bin");
            for (PessoaFisica pessoaFisica : repo2.obterTodos()) {
                pessoaFisica.exibir();
            }

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Empresa A", "12345678000100"));
            repo3.inserir(new PessoaJuridica(2, "Empresa B", "98765432000100"));
            repo3.persistir("pessoasJuridicas.bin");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.bin");
            for (PessoaJuridica pessoaJuridica : repo4.obterTodos()) {
                pessoaJuridica.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
