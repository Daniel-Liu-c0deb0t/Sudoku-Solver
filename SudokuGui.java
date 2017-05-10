import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SudokuGui {
	private static JTextField[][] fields;
	private static JTextArea area;
	private static JTabbedPane tab;
	private static JFrame frame;
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			System.out.println("Cannot get look and feel.");
		}
		
		frame = new JFrame("Sudoku Solver");
		JPanel root = new JPanel();
		frame.add(root);
		
		tab = new JTabbedPane();
		root.add(tab);
		tab.setFont(tab.getFont().deriveFont(40f));
		
		JPanel panel1 = new JPanel();
		tab.addTab("Grid", panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel grid = new JPanel();
		panel1.add(grid);
		grid.setLayout(new GridLayout(9, 9));
		fields = new JTextField[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fields[i][j] = new JTextField(2);
				fields[i][j].setFont(fields[i][j].getFont().deriveFont(60f));
				fields[i][j].setHorizontalAlignment(JTextField.CENTER);
				grid.add(fields[i][j]);
			}
		}
		
		JPanel panel2 = new JPanel();
		tab.addTab("Text", panel2);
		area = new JTextArea(9, 30);
		area.setFont(area.getFont().deriveFont(60f));
		panel2.add(area);
		
		JButton solveButton = new JButton("Solve!");
		solveButton.setFont(solveButton.getFont().deriveFont(60f));
		root.add(solveButton);
		solveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					int[][] mat = new int[9][9];
					if(tab.getSelectedIndex() == 0){
						for(int i = 0; i < 9; i++){
							for(int j = 0; j < 9; j++){
								if(fields[i][j].getText().length() > 1)
									throw new Exception();
								if(fields[i][j].getText().equals(".") || fields[i][j].getText().equals(" ") || fields[i][j].getText().equals(""))
									mat[i][j] = 0;
								else
									mat[i][j] = Integer.parseInt(fields[i][j].getText());
							}
						}
					}else{
						String[] linei = area.getText().split("\n");
						for(int i = 0; i < 9; i++){
							linei[i].trim();
							String[] linej = linei[i].split(" ");
							for(int j = 0; j < 9; j++){
								if(linej[j].equals(".") || linej[j].equals(""))
									mat[i][j] = 0;
								else
									mat[i][j] = Integer.parseInt(linej[j]);
							}
						}
					}
					SudokuSolve.solve(mat);
					StringBuilder b = new StringBuilder();
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							fields[i][j].setText(SudokuSolve.getResult()[i][j] + "");
							b.append(SudokuSolve.getResult()[i][j] + " ");
						}
						b.append('\n');
					}
					area.setText(b.toString());
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Input Sudoku not valid!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(clearButton.getFont().deriveFont(60f));
		root.add(clearButton);
		clearButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						fields[i][j].setText("");
					}
				}
				area.setText("");
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
