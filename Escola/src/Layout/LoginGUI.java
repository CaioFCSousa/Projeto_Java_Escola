package Layout;

import javax.swing.*;

import application.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginGUI extends JFrame {
    private JTextField inputMaticula;
    private JPasswordField inputSenha;

    private Map<String, String> usuarios; // Mapeia matrículas para senhas
    private Map<String, Object> objetosUsuarios; // Mapeia matrículas para objetos de usuário

    public LoginGUI() {
        setTitle("Login");
  
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Iniciar em tela cheia
        
     
        usuarios = new HashMap<>();
        objetosUsuarios = new HashMap<>();

        // Crie alguns usuários de exemplo (Professor, Aluno e Gerente)
        Professor professor = new Professor("Professor", 35, "Endereço do Professor", "111111", "01/01/1987", "P123", "senhaProfessor", 5000,
        		40);
        Aluno aluno = new Aluno("Aluno", 20, "Endereço do Aluno", "222222", "02/02/2002", "A123", "senhaAluno");
        Gerente gerente = new Gerente("Gerente", 45, "Endereço do Gerente", "333333", "03/03/1977", "G123", "senhaGerente", 6000, 4);
        
        usuarios.put(professor.getMatricula(), "senhaProfessor");
        usuarios.put(aluno.getMatricula(), "senhaAluno");
        usuarios.put(gerente.getMatricula(), "senhaGerente");

        objetosUsuarios.put(professor.getMatricula(), professor);
        objetosUsuarios.put(aluno.getMatricula(), aluno);
        objetosUsuarios.put(gerente.getMatricula(), gerente);

        initComponents();

  
        pack(); // Empacotar componentes
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setResizable(false); // Impede a maximização
        setVisible(true);
    }

    
        private void initComponents() {

    	
        JPanel jPanel1 = new JPanel(new GridLayout());

        JLabel textMatricula = new JLabel("Matrícula:");
        inputMaticula = new JTextField();

        JLabel textSenha = new JLabel("Senha:");
        inputSenha = new JPasswordField();

        JButton entrarButao = new JButton("Login");

        jPanel1.add(textMatricula);
        jPanel1.add(inputMaticula);
        jPanel1.add(textSenha);
        jPanel1.add(inputSenha);
        jPanel1.add(new JLabel("")); // Espaço vazio para alinhar corretamente o botão
        jPanel1.add(entrarButao);
        add(jPanel1);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(entrarButao)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textSenha)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputSenha)
                            .addComponent(inputMaticula, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(textMatricula)))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(textMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputMaticula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entrarButao)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        entrarButao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        pack();
    }

    
    private void login() {

        String matricula = inputMaticula.getText();
        char[] senhaChars = inputSenha.getPassword();
        String senha = new String(senhaChars);

        if (usuarios.containsKey(matricula) && usuarios.get(matricula).equals(senha)) {
            if (objetosUsuarios.containsKey(matricula)) {
                Object usuario = objetosUsuarios.get(matricula);

                if (usuario instanceof Professor) {
                	dispose();
                    new ProfessorGUI((Professor)usuario);
                } else if (usuario instanceof Aluno) {
                    // Feche a janela de login antes de abrir a tela do Aluno
                    dispose();
                    new AlunoGUI((Aluno) usuario);
                } else if (usuario instanceof Gerente) {
                    // Feche a janela de login antes de abrir a tela do Gerente
                    dispose();
                    new GerenteGUI((Gerente) usuario);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Credenciais inválidas. Tente novamente.");
        }
    }

    
   
 public static void main(String[] args) {
	 try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     } catch (Exception e) {
         e.printStackTrace();
     }

        SwingUtilities.invokeLater(() -> {
            new LoginGUI();
        });
    }


}
