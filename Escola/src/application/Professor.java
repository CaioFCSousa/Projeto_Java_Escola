package application;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Funcionario {
	 // Atributos
  
	private List<Disciplina> disciplinasAdicionadas;
	private List<Disciplina> disciplinasMinistradas;
	
	 // Construtor
    public Professor(String nome, int idade, String endereco, String cpf, String dataNascimento, String matricula,
			String senha, double salario, int cargaHoraria) {
		super(nome, idade, endereco, cpf, dataNascimento, matricula, senha);
		this.disciplinasAdicionadas = new ArrayList<>();
		 this.disciplinasMinistradas = new ArrayList<>();
		 this.setEstado(true);
	}


    // Método para adicionar uma disciplina ao professor
	 public void addDisciplina(Disciplina disciplina) {
	        if (!disciplinasAdicionadas.contains(disciplina)) {
	            disciplinasAdicionadas.add(disciplina);
	        } else {
	            System.out.println(getNome() + " já está matriculado na disciplina " + disciplina.getNomeDisciplina());
	        }
	    }


	// Método para remover uma disciplina do professor
	 public void removerDisciplina(Disciplina disciplina) {
		    if (disciplinasAdicionadas.contains(disciplina)) {
		        disciplinasAdicionadas.remove(disciplina);
		        disciplina.getAlunosMatriculados().clear(); // Limpa a lista de alunos matriculados na disciplina
		    }
		}

    // Método para verificar a carga horária atual do professor
    public void verificarCargaHoraria(Disciplina disciplina) {
    	System.out.println("Disciplina: " + disciplina.getNomeDisciplina());
    	System.out.println("Carga horária: " + disciplina.getCargaHoraria());
    }
    public List<Disciplina> getDisciplinasAdicionadas() {
        return disciplinasAdicionadas;
    }
    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }
    
    
    public void visualizarAlunosMatriculados(Disciplina disciplina) {

        if (disciplina != null) {
            List<Aluno> alunosMatriculados = disciplina.getAlunosMatriculados();

            System.out.println("Alunos matriculados na disciplina " + disciplina.getNomeDisciplina() + ":");

            for (Aluno aluno : alunosMatriculados) {
                System.out.println("Alunos: "+aluno.getNome());
            }

           
    }}
}
