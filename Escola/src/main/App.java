package main;


import application.*;



public class App {

	public static void main(String[] args) {
	
			Professor professor = new Professor("Professor", 35, "Endereço do Professor", "111111", "01/01/1987", "P123", "senhaProfessor", 5000, 40, "12345", 10);
			Funcionario funcionari = new Funcionario("Funcionario loco da cabeça", 20, "Rua A", "123456789", "01/01/2000", "M123","42342",12);
			Gerente gerente = new Gerente("Gerente", 45, "Endereço do Gerente", "333333", "03/03/1977", "G123", "senhaGerente", 6000, 40, 1);

		 
			System.out.println("o professor "+professor.getNome()+"esta contratado:"+professor.isEstado());
			gerente.demitirFuncionario(professor);
		  
			System.out.println("o professor "+professor.getNome()+"esta contratado:"+professor.isEstado());
			gerente.contratarFuncionario(professor,1500,10,"Limpeza");
		  
		 
		  
		



	     
	        
	        
	        
	}
}
