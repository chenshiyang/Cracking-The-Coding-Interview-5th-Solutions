/**
* <p>Title: Question1_7.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 22, 2016
* @version jdk8.0
*/
package chapter1;

/**
 * <p>Title: Question1_7</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 22, 2016
 * @time 2:28:49 PM
 */
public class Question1_7 {
	public int[][] setZero(int[][] matrix){
		if(null == matrix || 0 == matrix.length){
			return matrix;
		}
		
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		boolean[] rows = new boolean[numRow];
		boolean[] cols = new boolean[numCol];
		
		for(int i = 0; i < numRow; i ++){
			for(int j = 0; j < numCol; j ++){
				if(0 == matrix[i][j]){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i = 0; i < numRow; i ++){
			for(int j = 0; j < numCol; j ++){
				if(rows[i] || cols[j]){
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
	}
	
	public int[][] setZero2(int[][] matrix){
		if(null == matrix || 0 == matrix.length){
			return matrix;
		}
		
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		boolean[] rows = new boolean[numRow];
		boolean[] cols = new boolean[numCol];
		
		for(int i = 0; i < numRow; i ++){
			for(int j = 0; j < numCol; j ++){
				if(0 == matrix[i][j]){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i = 0; i < rows.length; i ++){
			if(rows[i]){
				setRowToZero(matrix, i);
			}
		}
		
		for(int i = 0; i < cols.length; i ++){
			if(cols[i]){
				setColToZero(matrix, i);
			}
		}
		
		return matrix;
	}
	
	public void setRowToZero(int[][] matrix, int rowNum){
		for(int i = 0; i < matrix[rowNum].length; i ++){
			matrix[rowNum][i] = 0;
		}
	}
	
	public void setColToZero(int[][] matrix, int colNum){
		for(int i = 0; i < matrix.length; i ++){
			matrix[i][colNum] = 0;
		}
	}
	
	public String displawMatrix(int[][] matrix){
		if(null == matrix || 0 == matrix.length){
			return "| |";
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < matrix.length; i ++){
			sb.append("| ");
			for(int j = 0; j < matrix[0].length; j ++){
				sb.append(matrix[i][j]).append(" ");
			}
			sb.append("|\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		Question1_7 so = new Question1_7();
		int[][] test1 = {
				{1, 1, 1, 1, 0},
				{0, 1, 1, 1, 1},
				{0, 1, 1, 1, 1},
				{1, 1, 1, 1, 1}
		};
		
		System.out.println(so.displawMatrix(test1));
//		System.out.println(so.displawMatrix(so.setZero(test1)));
		System.out.println(so.displawMatrix(so.setZero2(test1)));
	}
}
