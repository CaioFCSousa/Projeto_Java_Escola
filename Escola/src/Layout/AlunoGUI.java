package Layout;

import javax.swing.*;
import application.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import  java.awt.Color;

class DisciplinaItem {
    private Disciplina disciplina;

    public DisciplinaItem(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return disciplina.getNomeDisciplina();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}

public class AlunoGUI extends JFrame {
    private Aluno aluno;
    private JComboBox<DisciplinaItem> disciplinasDisponiveisComboBox;
    private DefaultListModel<DisciplinaItem> disciplinasAdicionadasListModel;
    private JList<DisciplinaItem> disciplinasAdicionadasList;

    public AlunoGUI(Aluno aluno) {
        this.aluno = aluno;
        setTitle("Disciplinas do Aluno");
        setSize(600, 400);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        initComponents();
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setResizable(false); // Impede a maximização
        setVisible(true);
    }

    private void initComponents() {
        JPanel jPanel2 = new JPanel(new BorderLayout());

        disciplinasDisponiveisComboBox = new JComboBox<>();
        disciplinasAdicionadasListModel = new DefaultListModel<>();
        disciplinasAdicionadasList = new JList<>(disciplinasAdicionadasListModel);

        jPanel2.add(disciplinasDisponiveisComboBox, BorderLayout.NORTH);
        jPanel2.add(new JScrollPane(disciplinasAdicionadasList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton adicionarDisciplinaButton = new JButton("Adicionar");
        JButton removerDisciplinaButton = new JButton("Remover");
        JButton avaliarDisciplinaButton = new JButton("Realizar Avaliação");
        JButton mostrarInformacoesButton = new JButton("Mostrar Informações");
        JButton mostrarNotasEMediaButton = new JButton("Mostrar Notas e Média");
        JButton sairButton = new JButton("Sair");
       
        

        adicionarDisciplinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarDisciplina();
            }
        });

        removerDisciplinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerDisciplina();
            }
        });

        avaliarDisciplinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliarDisciplina();
            }
        });

        mostrarInformacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacoesDisciplina();
            }
        });

        mostrarNotasEMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarNotasEMediaDisciplina();
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retornarTelaLogin();
            }
        });
        
 
      
        
        buttonPanel.add(adicionarDisciplinaButton);
        buttonPanel.add(removerDisciplinaButton);
        buttonPanel.add(avaliarDisciplinaButton);
        buttonPanel.add(mostrarInformacoesButton);
        buttonPanel.add(mostrarNotasEMediaButton);
        buttonPanel.add(sairButton);
        jPanel2.add(buttonPanel, BorderLayout.WEST);
        

        jPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(jPanel2);
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sairButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(disciplinasAdicionadasList, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                            .addComponent(disciplinasDisponiveisComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mostrarInformacoesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(avaliarDisciplinaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removerDisciplinaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mostrarNotasEMediaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adicionarDisciplinaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disciplinasDisponiveisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionarDisciplinaButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disciplinasAdicionadasList, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(removerDisciplinaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avaliarDisciplinaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrarInformacoesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrarNotasEMediaButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(sairButton)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        atualizarComboBox(); // Atualize o ComboBox no início
    }

    private void retornarTelaLogin() {
        // Feche a janela atual
        dispose();

        // Crie e exiba a tela de login
        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI();
        });
    }

    private void adicionarDisciplina() {
        DisciplinaItem disciplinaItem = (DisciplinaItem) disciplinasDisponiveisComboBox.getSelectedItem();
        if (disciplinaItem != null) {
            Disciplina disciplinaSelecionada = disciplinaItem.getDisciplina();
            if (!aluno.getDisciplinasAdicionadas().contains(disciplinaSelecionada)) {
                aluno.addDisciplina(disciplinaSelecionada);
                disciplinasAdicionadasListModel.addElement(new DisciplinaItem(disciplinaSelecionada));
                disciplinasDisponiveisComboBox.removeItem(disciplinaItem);
            } else {
                JOptionPane.showMessageDialog(this, "Você já adicionou esta disciplina.");
            }
        }
    }

    private void removerDisciplina() {
        DisciplinaItem disciplinaItem = disciplinasAdicionadasList.getSelectedValue();
        if (disciplinaItem != null) {
            Disciplina disciplinaSelecionada = disciplinaItem.getDisciplina();
            aluno.removerDisciplina(disciplinaSelecionada);
            disciplinasAdicionadasListModel.removeElement(disciplinaItem);
            disciplinasDisponiveisComboBox.addItem(disciplinaItem);
        }
    }

    private void avaliarDisciplina() {
        DisciplinaItem disciplinaItem = disciplinasAdicionadasList.getSelectedValue();
        if (disciplinaItem != null) {
            Disciplina disciplinaSelecionada = disciplinaItem.getDisciplina();
            double nota = aluno.realizarAvaliacao(disciplinaSelecionada);
            DecimalFormat df = new DecimalFormat("#.##");
            String mensagem = "Avaliação em " + disciplinaSelecionada.getNomeDisciplina() + ": " + df.format(nota);
            JOptionPane.showMessageDialog(this, mensagem);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma disciplina para avaliar.");
        }
    }

    private void mostrarInformacoesDisciplina() {
        DisciplinaItem disciplinaItem = disciplinasAdicionadasList.getSelectedValue();
        if (disciplinaItem != null) {
            Disciplina disciplinaSelecionada = disciplinaItem.getDisciplina();
            String informacoes = "Nome da Disciplina: " + disciplinaSelecionada.getNomeDisciplina() + "\n" +
                    "Carga Horária: " + disciplinaSelecionada.getCargaHoraria() + " horas\n" +
                    "Professor Associado: " + disciplinaSelecionada.getNomeProfessor();
            JOptionPane.showMessageDialog(this, informacoes, "Informações da Disciplina", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma disciplina para mostrar informações.");
        }
    }

    private void mostrarNotasEMediaDisciplina() {
        DisciplinaItem disciplinaItem = disciplinasAdicionadasList.getSelectedValue();
        if (disciplinaItem != null) {
            Disciplina disciplinaSelecionada = disciplinaItem.getDisciplina();
            List<Double> notas = aluno.getNotasDisciplina(disciplinaSelecionada);
            if (!notas.isEmpty()) {
                double soma = 0;
                for (Double nota : notas) {
                    soma += nota;
                }
                double media = soma / notas.size();

                StringBuilder mensagem = new StringBuilder();
                mensagem.append("Notas do Aluno em ").append(disciplinaSelecionada.getNomeDisciplina()).append(":\n");
                DecimalFormat df = new DecimalFormat("#.##");
                for (int i = 0; i < notas.size(); i++) {
                    mensagem.append("Nota ").append(i + 1).append(": ").append(df.format(notas.get(i))).append("\n");
                }
                mensagem.append("Média: ").append(new DecimalFormat("#.##").format(media));

                JOptionPane.showMessageDialog(this, mensagem.toString());
            } else {
                JOptionPane.showMessageDialog(this, "O aluno ainda não possui notas nessa disciplina.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma disciplina para mostrar as notas e a média.");
        }
    }

    public static void main(String[] args) {
    	 try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
             e.printStackTrace();
         }
      
        
    }

    public void atualizarComboBox() {
        List<Disciplina> todasDisciplinas = obterTodasDisciplinas();

        disciplinasDisponiveisComboBox.removeAllItems();

        for (Disciplina disciplina : todasDisciplinas) {
            if (!aluno.getDisciplinasAdicionadas().contains(disciplina)) {
                disciplinasDisponiveisComboBox.addItem(new DisciplinaItem(disciplina));
            }
        }
    }

    private List<Disciplina> obterTodasDisciplinas() {
        Professor professor = new Professor("Doido do Grau", 30, "Rua B", "987654321", "02/02/2002", "P123", "senha123", 98765, 8);

        Disciplina disciplina1 = new Disciplina("Matemática", professor, 30);
        Disciplina disciplina2 = new Disciplina("Português", professor, 30);

        List<Disciplina> todasDisciplinas = new ArrayList<>();
        todasDisciplinas.add(disciplina1);
        todasDisciplinas.add(disciplina2);

        return todasDisciplinas;
    }
}
