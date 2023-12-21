package Layout;

import application.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class GerenteGUI extends JFrame {
    private Gerente gerente;
    private DefaultListModel<Funcionario> funcionariosContratadosListModel;


    private JList<Funcionario> funcionariosContratadosList;
    private HashSet<Funcionario> funcionariosContratados = new HashSet<>();

    public GerenteGUI(Gerente gerente) {
       
        this.gerente = gerente;
        setTitle("Gerenciar Funcionários");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Iniciar em tela cheia
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setResizable(false); // Impede a maximização
        setVisible(true);
        setVisible(true);
    }
    
    private void initComponents() {
        JPanel jPanel1 = new JPanel(new BorderLayout());

        funcionariosContratadosListModel = new DefaultListModel<>();
        funcionariosContratadosList = new JList<>(funcionariosContratadosListModel);
        funcionariosContratadosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane funcionariosScrollPane = new JScrollPane(funcionariosContratadosList);

        jPanel1.add(funcionariosScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 0, 20)); // Adiciona espaçamento de 20 pixels entre os botões

        JButton contratarFuncionarioButton = new JButton("Contratar Funcionário");
        JButton demitirFuncionarioButton = new JButton("Demitir");
        JButton verInformacoesFuncionarioButton = new JButton("Informações do Funcionário");
        JButton aumentarSalarioButton = new JButton("Gerenciar salário");
        JButton sairButton = new JButton("Sair");
        
   

        contratarFuncionarioButton.addActionListener(e -> contratarFuncionario());
        demitirFuncionarioButton.addActionListener(e -> demitirFuncionario());
        verInformacoesFuncionarioButton.addActionListener(e -> verInformacoesFuncionario());
        aumentarSalarioButton.addActionListener(e -> aumentarSalarioFuncionario());
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retornarTelaLogin();
            }
        });

        buttonPanel.add(contratarFuncionarioButton);
        buttonPanel.add(demitirFuncionarioButton);
        buttonPanel.add(verInformacoesFuncionarioButton);
        buttonPanel.add(aumentarSalarioButton);

        jPanel1.add(buttonPanel, BorderLayout.WEST);

        jPanel1.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        add(jPanel1);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(demitirFuncionarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verInformacoesFuncionarioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aumentarSalarioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(sairButton))
                    .addComponent(contratarFuncionarioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(funcionariosContratadosList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(contratarFuncionarioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(funcionariosContratadosList, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verInformacoesFuncionarioButton)
                    .addComponent(demitirFuncionarioButton)
                    .addComponent(sairButton)
                    .addComponent(aumentarSalarioButton))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        atualizarListaFuncionariosContratados();
    }
    private void retornarTelaLogin() {
        // Feche a janela atual
        dispose();

        // Crie e exiba a tela de login
        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI();
        });
    }

    private void contratarFuncionario() {
        JTextField nomeField = new JTextField();
        JTextField idadeField = new JTextField();
        JTextField enderecoField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField dataNascimentoField = new JTextField();
        JTextField matriculaField = new JTextField();
        JTextField senhaField = new JTextField();
        JTextField cargaHorariaField = new JTextField();
        JTextField salarioField = new JTextField();
        JTextField setorField = new JTextField();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(11, 2));
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Idade:"));
        inputPanel.add(idadeField);
        inputPanel.add(new JLabel("Endereço:"));
        inputPanel.add(enderecoField);
        inputPanel.add(new JLabel("CPF:"));
        inputPanel.add(cpfField);
        inputPanel.add(new JLabel("Data de Nascimento:"));
        inputPanel.add(dataNascimentoField);
        inputPanel.add(new JLabel("Matrícula:"));
        inputPanel.add(matriculaField);
        inputPanel.add(new JLabel("Senha:"));
        inputPanel.add(senhaField);
        inputPanel.add(new JLabel("Carga Horária:"));
        inputPanel.add(cargaHorariaField);
        inputPanel.add(new JLabel("Salário:"));
        inputPanel.add(salarioField);
        inputPanel.add(new JLabel("Setor:"));
        inputPanel.add(setorField);

        int result = JOptionPane.showConfirmDialog(this, inputPanel,
                "Informe os dados do novo funcionário", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String endereco = enderecoField.getText();
                String cpf = cpfField.getText();
                String dataNascimento = dataNascimentoField.getText();
                String matricula = matriculaField.getText();
                String senha = senhaField.getText();
                int cargaHoraria = Integer.parseInt(cargaHorariaField.getText());
                double salario = Double.parseDouble(salarioField.getText());
                String setor = setorField.getText();

                Funcionario novoFuncionario = new Funcionario(nome, idade, endereco, cpf, dataNascimento,
                        matricula, senha);

                gerente.contratarFuncionario(novoFuncionario,salario,cargaHoraria,setor);
                funcionariosContratados.add(novoFuncionario);
                atualizarListaFuncionariosContratados();
                JOptionPane.showMessageDialog(this, novoFuncionario.getNome() + " foi contratado com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente.");
            }
        }
    }

    private void demitirFuncionario() {
        Funcionario funcionarioSelecionado = funcionariosContratadosList.getSelectedValue();
        if (funcionarioSelecionado != null) {
            int opcao = JOptionPane.showConfirmDialog(this,
                    "Tem certeza de que deseja demitir " + funcionarioSelecionado.getNome() + "?",
                    "Confirmação de Demissão", JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                // Remova o funcionário da lista de contratados
                funcionariosContratados.remove(funcionarioSelecionado);

                // Realize a demissão
                gerente.demitirFuncionario(funcionarioSelecionado);
                atualizarListaFuncionariosContratados();
                JOptionPane.showMessageDialog(this, "Funcionário demitido com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para demitir.");
        }
    }
    private void aumentarSalarioFuncionario() {
        Funcionario funcionarioSelecionado = funcionariosContratadosList.getSelectedValue();
        if (funcionarioSelecionado != null) {
            JTextField novoSalarioField = new JTextField();

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(1, 2));
            inputPanel.add(new JLabel("Novo Salário:"));
            inputPanel.add(novoSalarioField);

            int result = JOptionPane.showConfirmDialog(this, inputPanel,
                    "Informe o novo salário para " + funcionarioSelecionado.getNome(), JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                double novoSalario = 0;

                try {
                    novoSalario = Double.parseDouble(novoSalarioField.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Informe um valor válido para o novo salário.");
                    return;
                }

                funcionarioSelecionado.setSalario(novoSalario);
                atualizarListaFuncionariosContratados();
                JOptionPane.showMessageDialog(this, "Salário de " + funcionarioSelecionado.getNome() + " aumentado para R$" + novoSalario);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para aumentar o salário.");
        }
    }

    public class InformacoesFuncionarioDialog extends JDialog {
        public InformacoesFuncionarioDialog(Funcionario funcionario) {
            setTitle("Informações do Funcionário: " + funcionario.getNome());
            setSize(400, 300);
            setLocationRelativeTo(null); // Centralizar a janela na tela
            setResizable(false); // Impede a maximização
            setVisible(true);
            setVisible(true);
            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            
            JLabel nameLabel = new JLabel("Nome:");
            JLabel ageLabel = new JLabel("Idade:");
            JLabel addressLabel = new JLabel("Endereço:");
            JLabel cpfLabel = new JLabel("CPF:");
            JLabel dobLabel = new JLabel("Data de Nascimento:");
            JLabel matriculaLabel = new JLabel("Matrícula:");
            JLabel salaryLabel = new JLabel("Salário:");
            JLabel cargaHorariaLabel = new JLabel("Carga Horária:");
            JLabel setorLabel = new JLabel("Setor:");
            
            JLabel nameValueLabel = new JLabel(funcionario.getNome());
            JLabel ageValueLabel = new JLabel(String.valueOf(funcionario.getIdade()));
            JLabel addressValueLabel = new JLabel(funcionario.getEndereco());
            JLabel cpfValueLabel = new JLabel(funcionario.getCpf());
            JLabel dobValueLabel = new JLabel(funcionario.getDataNascimento());
            JLabel matriculaValueLabel = new JLabel(funcionario.getMatricula());
            JLabel salaryValueLabel = new JLabel(String.valueOf(funcionario.getSalario()));
            JLabel cargaHorariaValueLabel = new JLabel(String.valueOf(funcionario.getCargaHoraria()));
            JLabel setorValueLabel = new JLabel(funcionario.getSetor());
            
            GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
            hGroup.addGroup(layout.createParallelGroup()
                    .addComponent(nameLabel)
                    .addComponent(ageLabel)
                    .addComponent(addressLabel)
                    .addComponent(cpfLabel)
                    .addComponent(dobLabel)
                    .addComponent(matriculaLabel)
                    .addComponent(salaryLabel)
                    .addComponent(cargaHorariaLabel)
                    .addComponent(setorLabel));
            hGroup.addGroup(layout.createParallelGroup()
                    .addComponent(nameValueLabel)
                    .addComponent(ageValueLabel)
                    .addComponent(addressValueLabel)
                    .addComponent(cpfValueLabel)
                    .addComponent(dobValueLabel)
                    .addComponent(matriculaValueLabel)
                    .addComponent(salaryValueLabel)
                    .addComponent(cargaHorariaValueLabel)
                    .addComponent(setorValueLabel));
            layout.setHorizontalGroup(hGroup);
            
            GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(cpfValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(dobLabel)
                    .addComponent(dobValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(matriculaLabel)
                    .addComponent(matriculaValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(salaryLabel)
                    .addComponent(salaryValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(cargaHorariaLabel)
                    .addComponent(cargaHorariaValueLabel));
            vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(setorLabel)
                    .addComponent(setorValueLabel));
            layout.setVerticalGroup(vGroup);
        }
    }

    private void verInformacoesFuncionario() {
        Funcionario funcionarioSelecionado = funcionariosContratadosList.getSelectedValue();
        if (funcionarioSelecionado != null) {
            InformacoesFuncionarioDialog dialog = new InformacoesFuncionarioDialog(funcionarioSelecionado);
            dialog.setModal(true);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para ver informações.");
        }
    }


    public void atualizarListaFuncionariosContratados() {
        List<Funcionario> funcionarios = gerente.getListaFuncionarios();
        funcionariosContratadosListModel.clear();

        for (Funcionario funcionario : funcionarios) {
            if (!(funcionario instanceof Gerente) && funcionariosContratados.contains(funcionario)) {
                funcionariosContratadosListModel.addElement(funcionario);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Inicialize o gerente e outros funcionários aqui
        	  try {
                  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
              } catch (Exception e) {
                  e.printStackTrace();
              }
          
        });
    }
}
