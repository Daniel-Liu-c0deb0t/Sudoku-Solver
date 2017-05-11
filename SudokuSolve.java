import javax.swing.*;

public class SudokuSolve {
	private static int[][] mat = new int[9][9];
	private static int[][] result = new int[9][9];
	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int[][] input = new int[9][9];
//		
//		try{
//			for(int i = 0; i < 9; i++){
//				String[] linei = in.nextLine().split(" ");
//				for(int j = 0; j < 9; j++){
//					if(linei[j].equals(".")){
//						input[i][j] = 0;
//					}else{
//						input[i][j] = Integer.parseInt(linei[j]);
//					}
//				}
//			}
//		}catch(Exception e){
//			System.out.println("Bad input!");
//		}
//		
//		solve(input);
//		print(getResult());
//		
//		in.close();
//	}
	
	public static void solve(int[][] input){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				mat[i][j] = input[i][j];
			}
		}
		try{
			recurse(0, 0);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Solve failed!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static int[][] getResult(){
		return result;
	}
	
	public static void print(int[][] input){
		System.out.println("-------------------");
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(input[i][j] == 0){
					System.out.print(" .");
				}else{
					System.out.print(" " + input[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	private static void recurse(int r, int c) throws Exception{
		if(c >= 9){
			c = 0;
			r++;
			if(r >= 9){
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						result[i][j] = mat[i][j];
					}
				}
				return;
			}
		}
		
		if(mat[r][c] == 0){
			for(int i = 1; i <= 9; i++){
				if(legal(r, c, i)){
					mat[r][c] = i;
					recurse(r, c + 1);
					mat[r][c] = 0;
				}
			}
		}else{
			recurse(r, c + 1);
		}
	}
	
	private static boolean legal(int r, int c, int v) throws Exception{
		for(int i = 0; i < 9; i++){
			if(mat[r][i] == v){
				return false;
			}
		}
		for(int i = 0; i < 9; i++){
			if(mat[i][c] == v){
				return false;
			}
		}
		
		int bR = (r / 3) * 3;
		int bC = (c / 3) * 3;
		for(int i = bR; i < bR + 3; i++){
			for(int j = bC; j < bC + 3; j++){
				if(mat[i][j] == v){
					return false;
				}
			}
		}
		
		return true;
	}
}
