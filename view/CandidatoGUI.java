package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.controllerCandidato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class CandidatoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JRadioButton rdbtnProfessorEnsinoFundamental;
	private JRadioButton rdbtnProfessorEnsinoMédio;
	private JRadioButton rdbtnProfessorEnsinoSuperior;
	private JButton btnLimpar;
	private JButton btnEnviar;
	private JLabel lblInscrição;
	private ButtonGroup gb; 
	

	/**
	 * Create the frame.
	 */
	public CandidatoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Handler ouvinte = new Handler();
		
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(29, 85, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(29, 110, 181, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCPF.setBounds(29, 150, 46, 14);
		contentPane.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(29, 175, 181, 20);
		contentPane.add(txtCPF);
		
		rdbtnProfessorEnsinoFundamental = new JRadioButton("Professor Ensino Fundamental ");
		rdbtnProfessorEnsinoFundamental.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnProfessorEnsinoFundamental.setBounds(29, 276, 286, 23);
		contentPane.add(rdbtnProfessorEnsinoFundamental);
		
		rdbtnProfessorEnsinoMédio = new JRadioButton("Professor Ensino M\u00E9dio");
		rdbtnProfessorEnsinoMédio.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnProfessorEnsinoMédio.setBounds(29, 302, 181, 23);
		contentPane.add(rdbtnProfessorEnsinoMédio);
		
		rdbtnProfessorEnsinoSuperior = new JRadioButton("Professor Ensino Superior");
		rdbtnProfessorEnsinoSuperior.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnProfessorEnsinoSuperior.setBounds(29, 327, 181, 23);
		contentPane.add(rdbtnProfessorEnsinoSuperior);
		
		gb = new ButtonGroup();
		gb.add(rdbtnProfessorEnsinoFundamental);
		gb.add(rdbtnProfessorEnsinoMédio);
		gb.add(rdbtnProfessorEnsinoSuperior);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(29, 402, 89, 23);
		btnLimpar.addActionListener(ouvinte);
		contentPane.add(btnLimpar);
		
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setBounds(259, 402, 89, 23);
		btnEnviar.addActionListener(ouvinte);
		contentPane.add(btnEnviar);
		
		lblInscrição = new JLabel("INSCRI\u00C7\u00C3O DE CANDIDATO ");
		lblInscrição.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInscrição.setBounds(109, 41, 239, 14);
		contentPane.add(lblInscrição);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
		public void limpar() {
			txtCPF.setText("");
			txtNome.setText("");
			gb.clearSelection();
			
		}
	
		public class Handler implements ActionListener{
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLimpar) {
					limpar();
				}
else {
					if(e.getSource()==btnEnviar) {
						String Cpf = txtCPF.getText();
						String Nome = txtNome.getText();
						String cargoProfessor = null;
						
						if(rdbtnProfessorEnsinoFundamental.isSelected()) {
							cargoProfessor=rdbtnProfessorEnsinoFundamental.getText();
							
						}else if(rdbtnProfessorEnsinoMédio.isSelected()) {
							cargoProfessor=rdbtnProfessorEnsinoMédio.getText();
						}else {
							cargoProfessor = rdbtnProfessorEnsinoSuperior.getText();
						}
						 controllerCandidato ca = new controllerCandidato();
						 if((Nome.equals(""))|| (Cpf.equals("")) || ((rdbtnProfessorEnsinoFundamental.isSelected()==false) && (rdbtnProfessorEnsinoMédio.isSelected()==false)&&(rdbtnProfessorEnsinoSuperior.isSelected()==false))) {
								JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "ATENÇÃO!!", 2, null);
							} 
						
						
						
						else {
							if(ca.cadastrar(Nome, Cpf, cargoProfessor)==1) {
								JOptionPane.showMessageDialog(getContentPane(), "DADOS CADASTRADOS COM SUCESSO!", "Sucesso", 1, null);
								limpar();
						
						}}}}}}}
		
		
	
