package Layout;

import javax.swing.*;
import application.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProfessorGUI extends JFrame {
    private Professor professor;
    private JComboBox<Disciplina> disciplinasMinistradasComboBox;
    private DefaultListModel<Disciplina> disciplinasAdicionadasListModel;
    private DefaultListModel<Aluno> alunosMatriculadosListModel;
    private JList<Disciplina> disciplinasAdicionadasList;
    private JList<Aluno> alunosMatriculadosList;

    public ProfessorGUI(Professor professor) {
        this.professor = professor;
        setTitle("Disciplinas do Professor");
        setSize(800, 400);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setResizable(false); // Impede a maximização
        setVisible(true);
        
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());

        
        
        
        disciplinasMinistradasComboBox = new JComboBox<>();
        disciplinasAdicionadasListModel = new DefaultListModel<>();
        disciplinasAdicionadasList = new JList<>(disciplinasAdicionadasListModel);
        alunosMatriculadosListModel = new DefaultListModel<>();
        alunosMatriculadosList = new JList<>(alunosMatriculadosListModel);

        JScrollPane disciplinasScrollPane = new JScrollPane(disciplinasAdicionadasList);
        JScrollPane alunosScrollPane = new JScrollPane(alunosMatriculadosList);

        leftPanel.add(disciplinasMinistradasComboBox, BorderLayout.NORTH);
        leftPanel.add(disciplinasScrollPane, BorderLayout.CENTER);

        rightPanel.add(alunosScrollPane, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400);

        jPanel1.add(splitPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton adicionarDisciplinaButton = new JButton("Adicionar");
        JButton removerDisciplinaButton = new JButton("Remover");
        JButton verificarCargaHorariaButton = new JButton("Carga Horária");
        JButton visualizarAlunosButton1 = new JButton("Alunos");
        JButton sairButton = new JButton("Sair");
        
        adicionarDisciplinaButton.addActionListener(e -> adicionarDisciplina());
        removerDisciplinaButton.addActionListener(e -> removerDisciplina());
        verificarCargaHorariaButton.addActionListener(e -> verificarCargaHoraria());
        visualizarAlunosButton1.addActionListener(e -> visualizarAlunosMatriculados());
        
      
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retornarTelaLogin();
            }
        });
     

        
        buttonPanel.add(visualizarAlunosButton1);

        rightPanel.add(buttonPanel, BorderLayout.WEST);
        buttonPanel.add(adicionarDisciplinaButton);
        buttonPanel.add(removerDisciplinaButton);
        buttonPanel.add(verificarCargaHorariaButton);
        
        alunosMatriculadosList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(disciplinasMinistradasComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(verificarCargaHorariaButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(removerDisciplinaButton)))
                            .addComponent(disciplinasAdicionadasList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adicionarDisciplinaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(alunosMatriculadosList, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(visualizarAlunosButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(386, 386, 386))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disciplinasMinistradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionarDisciplinaButton))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disciplinasAdicionadasList, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alunosMatriculadosList, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removerDisciplinaButton)
                    .addComponent(verificarCargaHorariaButton)
                    .addComponent(visualizarAlunosButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(sairButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        


        pack();

     
        atualizarComboBox();
    }

    private void retornarTelaLogin() {
        // Feche a janela atual
        dispose();

        // Crie e exiba a tela de login
        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI();
        });
    }
    private void visualizarAlunosMatriculados() {
        Disciplina disciplinaSelecionada = disciplinasAdicionadasList.getSelectedValue();
        if (disciplinaSelecionada != null) {
            alunosMatriculadosListModel.clear(); // Limpa a lista de alunos matriculados

            List<Aluno> alunosMatriculados = disciplinaSelecionada.getAlunosMatriculados();

            for (Aluno aluno : alunosMatriculados) {
                alunosMatriculadosListModel.addElement(aluno);
            }
        }
    }

    private void adicionarDisciplina() {
        Disciplina disciplina = (Disciplina) disciplinasMinistradasComboBox.getSelectedItem();
        if (disciplina != null) {
            professor.addDisciplina(disciplina);
            disciplinasAdicionadasListModel.addElement(disciplina);
            disciplinasMinistradasComboBox.removeItem(disciplina);
            visualizarAlunosMatriculados();
        }
    }

    private void removerDisciplina() {
        Disciplina disciplina = disciplinasAdicionadasList.getSelectedValue();
        if (disciplina != null) {
            professor.removerDisciplina(disciplina);
            disciplinasAdicionadasListModel.removeElement(disciplina);
            disciplinasMinistradasComboBox.addItem(disciplina);
            visualizarAlunosMatriculados();
        }
    }

    private void verificarCargaHoraria() {
        Disciplina disciplina = disciplinasAdicionadasList.getSelectedValue();
        if (disciplina != null) {
            String mensagem = "Carga Horária da Disciplina " + disciplina.getNomeDisciplina() + ": " + disciplina.getCargaHoraria() + " horas";
            JOptionPane.showMessageDialog(this, mensagem);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma disciplina para verificar a carga horária.");
        }
    }

    public void atualizarComboBox() {
        List<Disciplina> todasDisciplinas = obterTodasDisciplinas();

        disciplinasMinistradasComboBox.removeAllItems();

        for (Disciplina disciplina : todasDisciplinas) {
            if (!professor.getDisciplinasMinistradas().contains(disciplina)) {
                disciplinasMinistradasComboBox.addItem(disciplina);
            }
        }
    }

    private List<Disciplina> obterTodasDisciplinas() {
    //Estaciar um professor
   	 Professor professor = new Professor("Doido do Grau", 30, "Rua B", "987654321", "02/02/2002", "P123", "senha123", 98765, 8);
   	 
   	 
   	 
   //Estaciar um aluno
     
   	Aluno aluno1 = new Aluno("Alice", 20, "Endereço 1", "123456789", "01/01/2000", "12345", "senha1");
   	Aluno aluno2 = new Aluno("Bob", 21, "Endereço 2", "987654321", "02/02/2001", "67890", "senha2");
   	Aluno aluno3 = new Aluno("Carol", 19, "Endereço 3", "234567890", "03/03/2002", "54321", "senha3");
   	Aluno aluno4 = new Aluno("David", 22, "Endereço 4", "345678901", "04/04/2003", "43210", "senha4");
   	Aluno aluno5 = new Aluno("Eve", 23, "Endereço 5", "456789012", "05/05/2004", "32104", "senha5");
   	Aluno aluno6 = new Aluno("Frank", 20, "Endereço 6", "567890123", "06/06/2005", "21043", "senha6");
   	Aluno aluno7 = new Aluno("Grace", 21, "Endereço 7", "678901234", "07/07/2006", "10432", "senha7");
   	Aluno aluno8 = new Aluno("Hank", 19, "Endereço 8", "789012345", "08/08/2007", "04321", "senha8");
   	Aluno aluno9 = new Aluno("Ivy", 22, "Endereço 9", "890123456", "09/09/2008", "43210", "senha9");
   	Aluno aluno10 = new Aluno("Jack", 23, "Endereço 10", "901234567", "10/10/2009", "32104", "senha10");
   	
   


   	//Disciplinas que o professor irar adicionar 
   	Disciplina disciplina1 = new Disciplina("Matemática", professor, 30);
   	Disciplina disciplina2 = new Disciplina("Português", professor, 30);
   	Disciplina disciplina3 = new Disciplina("História", professor, 30);
   	Disciplina disciplina4 = new Disciplina("Geografia", professor, 30);
   	Disciplina disciplina5 = new Disciplina("Biologia", professor, 30);
   	Disciplina disciplina6 = new Disciplina("Química", professor, 30);
   	Disciplina disciplina7 = new Disciplina("Física", professor, 30);
   	Disciplina disciplina8 = new Disciplina("Inglês", professor, 30);
   	Disciplina disciplina9 = new Disciplina("Educação Física", professor, 30);
        
        

        
        
        List<Disciplina> todasDisciplinas = new ArrayList<>();
        
        //Adicionar diciplina na lista onde ele ira celecionar para add
        todasDisciplinas.add(disciplina1);
        todasDisciplinas.add(disciplina2);
        todasDisciplinas.add(disciplina3);
        todasDisciplinas.add(disciplina4);
        todasDisciplinas.add(disciplina5);
        todasDisciplinas.add(disciplina6);
        todasDisciplinas.add(disciplina7);
        todasDisciplinas.add(disciplina8);
        todasDisciplinas.add(disciplina9);
        
        
        
        //adicionar alunos em diciplinas
        
       aluno1.addDisciplina(disciplina1);
       aluno2.addDisciplina(disciplina1);
       aluno3.addDisciplina(disciplina1);
       aluno4.addDisciplina(disciplina1);
       aluno5.addDisciplina(disciplina1);
       aluno6.addDisciplina(disciplina1);
       aluno7.addDisciplina(disciplina1);
       aluno8.addDisciplina(disciplina1);
       aluno9.addDisciplina(disciplina1);
       aluno10.addDisciplina(disciplina1);
    
       
        
        return todasDisciplinas;
   }

    public static void main(String[] args) {
    	 try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
       
      
    }
}
