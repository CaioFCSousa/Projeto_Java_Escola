package application;

public class Pessoa {
	// Atributos privados
    private String nome;
    private int idade;
   
    private String endereco;
    private String cpf;
    private String dataNascimento;
    private String senha;
    private String matricula;

    public Pessoa(String nome, int idade, String endereco, String cpf, String dataNascimento,String matricula,String senha) {
        this.nome = nome;
        this.senha = senha;
        this.matricula = matricula;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Métodos para definir os atributos (setters)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Métodos para obter os atributos (getters)
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSenha() {
		return senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    @Override
    public String toString() {
        return nome;
    }
}
