package application;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Funcionario {
    private List<Funcionario> listaFuncionarios;

    public Gerente(String nome, int idade, String endereco, String cpf, String dataNascimento, String matricula,
                   String senha, double salario, int cargaHoraria) {
        super(nome, idade, endereco, cpf, dataNascimento, matricula, senha);
        setEstado(true);
        setSalario(5000);
        listaFuncionarios = new ArrayList<>();
        listaFuncionarios.add(this); // Adicionar o gerente à lista de funcionários
    }
    // Método para dar aumento de salário a um funcionário
    public void aumentoSalario(Funcionario funcionario, double aumento) {
        if (funcionario.isEstado()) {
            double novoSalario = funcionario.getSalario() + aumento;
            funcionario.setSalario(novoSalario);
        } else {
            System.out.println("Não pode aumentar o salário porque o funcionário foi demitido");
        }
    }
    // Método para contratar um novo funcionário
    public void contratarFuncionario(Funcionario funcionario,double salario,int cargaHoraria,String setor) {
    	
        
        if (!funcionario.isEstado()) {
            funcionario.setCargaHoraria(cargaHoraria);
            funcionario.setSetor(setor);
            funcionario.setSalario(salario);
            funcionario.setEstado(true);
            listaFuncionarios.add(funcionario); // Adicionar o funcionário à lista de funcionários
            System.out.println(funcionario.getNome() + " foi contratado.");
        } else {
            System.out.println(funcionario.getNome() + " já está contratado.");
        }
    }

    // Método para demitir um funcionário
    public void demitirFuncionario(Funcionario funcionario) {
        funcionario.setEstado(false);
        funcionario.setSalario(0.0);
        funcionario.setCargaHoraria(0);
        System.out.println(funcionario.getNome() + " foi demitido.");
        listaFuncionarios.remove(funcionario); // Remover o funcionário da lista de funcionários
    }

    public void informacaoFuncionario(Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Idade: " + funcionario.getIdade());
        System.out.println("Endereço: " + funcionario.getEndereco());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
        System.out.println("Matrícula: " + funcionario.getMatricula());
        System.out.println("Salário: " + funcionario.getSalario());
        System.out.println("Carga Horária: " + funcionario.getCargaHoraria());
        System.out.println("Setor: " + funcionario.getSetor());
   
        System.out.println("Estado: " + (funcionario.isEstado() ? "Contratado" : "Inativo"));
    }
    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
}
