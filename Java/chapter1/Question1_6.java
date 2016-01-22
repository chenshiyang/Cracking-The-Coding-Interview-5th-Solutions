/**
* <p>Title: Question1_6.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 22, 2016
* @version jdk8.0
*/
package chapter1;

/**
 * <p>Title: Question1_6</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 22, 2016
 * @time 10:37:35 AM
 */
public class Question1_6 {
	/**
	* <p>Description: Rotate clockwise 90 degree.</p>
	* @param matrix
	* @return
	*/
	public int[][] rotateMatrix(int[][] matrix){
		if(null == matrix || matrix.length < 2){
			return matrix;
		}
		
		int len = matrix.length;
		for(int i = 0; i < len / 2; i ++){
			//save this strip of matrix.
			int[] temps = new int[len - 1 - 2 * i];
			int idx = 0;
			for(int j = i; j < len - 1 - i; j ++){
				temps[idx ++] = matrix[i][j];
			}
			//start to rotate.
			idx = 0;
			for(int j = i; j < len - 1 - i; j ++){
				int k = i, l = j;
				for(int t = 0; t < 3; t ++){
					matrix[k][l] = matrix[len - 1 - l][k];
					int temp = k;
					k = len - 1 - l;
					l = temp;
				}
				matrix[k][l] = temps[idx ++];
			}
		}
		
		return matrix;
	}
	
	/**
	* <p>Description: Rotate clockwise 90 degree, more space efficient.</p>
	* @param matrix
	* @return
	*/
	public int[][] rotateMatrix2(int[][] matrix){
		if(null == matrix || matrix.length < 2){
			return matrix;
		}
		
		int len = matrix.length;
		for(int layer = 0; layer < len / 2; layer ++){
			int begin = layer, end = len - 1 - layer;
			for(int i = begin; i < end; i ++){
				int top = matrix[layer][i];
				//left to top
				matrix[layer][i] = matrix[len - 1 - i][layer];
				
				//bottom to left
				matrix[len - 1 - i][layer] = matrix[len - 1 - layer][len - 1 - i];
				
				//right to bottom
				matrix[len - 1 - layer][len - 1 - i] = matrix[i][len - 1 - layer];
				
				//top to right
				matrix[i][len - 1 - layer] = top;
			}
		}
		
		return matrix;
	}
	
	public String displawMatrix(int[][] matrix){
		if(null == matrix || 0 == matrix.length){
			return "| |";
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < matrix.length; i ++){
			sb.append("| ");
			for(int j = 0; j < matrix[0].length; j ++){
				sb.append(matrix[i][j]).append("\t");
			}
			sb.append("|\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		Question1_6 so = new Question1_6();
		int[][] test1 = {
				{1, 2},
				{3, 4}
		};
		int[][] test2 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int[][] test3 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		System.out.println("===============");
		System.out.println(so.displawMatrix(null));
		System.out.println("---------------");
		System.out.println(so.displawMatrix(so.rotateMatrix2(null)));
		System.out.println("===============");
		
		System.out.println("===============");
		System.out.println(so.displawMatrix(test1));
		System.out.println("---------------");
		System.out.println(so.displawMatrix(so.rotateMatrix2(test1)));
		System.out.println("===============");
		
		System.out.println("===============");
		System.out.println(so.displawMatrix(test2));
		System.out.println("---------------");
		System.out.println(so.displawMatrix(so.rotateMatrix2(test2)));
		System.out.println("===============");
		
		System.out.println("===============");
		System.out.println(so.displawMatrix(test3));
		System.out.println("---------------");
		System.out.println(so.displawMatrix(so.rotateMatrix2(test3)));
		System.out.println("===============");
	}
}
