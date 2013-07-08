package utils;

import java.util.*;

public class Matrix {
	
	double[][] representation;
	
	int N;
	
	int M;
	
	public Matrix(double[][] mat){
		
		this.N = mat.length;
		
		this.M = mat[0].length;
		
		this.representation = mat;
	}
	
	public Matrix(int N, int M) throws Exception{
		
		if(N<1 || M<1) throw new Exception("rows and columns must be at least 1"); 
		
		this.N = N;
		
		this.M = M;
		
		representation = new double[N][M];
	}

	public double get(int row, int col){
		
		return representation[row][col];
	}
	/**
	<br>This method multiplies this matrix by a scalar</br>
	*/
	public Matrix mul(double scalar){
		
		double[][] result_rep = new double[this.N][this.M];
		
		for(int i=0; i<this.N; i++){
			
			for(int j=0; j<this.M; j++){
				
				result_rep[i][j] = this.representation[i][j] * scalar;
			}
		}
		
		return new Matrix(result_rep);
	}
	
	public void setMat(double[][] matrix_representation){

		this.representation = matrix_representation;
	}
	
	/**
	 * <br>returns the transpose of the matrix</br>
	 * @return the transpose of the matrix
	 * */
	public Matrix tranpose(){
		
		double[][] temporary_representation = new double[this.M][this.N];
		
		for(int i=0; i<this.M; i++){
			
			for(int j=0; j<this.N; j++){
				
				temporary_representation[i][j] = this.representation[j][i];
			}
		}
		
		return new Matrix(temporary_representation);
		
	}
	
	/**
	 * <br>Takes this matrix * A</br>
	 * <br>Does simple multiplication</br>
	 * @returns the resulting matrix
	 * */
	public Matrix mul(Matrix A) throws Exception{
		
		if(this.M != A.N) throw new Exception("Dimensions are different");
		
		double[][] temporary_representation = new double[this.N][A.M];
		
		for(int i=0; i<this.N; i++){
			
			for(int j=0; j<A.M; j++){
				
				double sum = 0.0;
				
				for(int k=0; k<A.N; k++){
					
					sum += (this.representation[i][k] * A.representation[k][j]);
				}
				
				temporary_representation[i][j] = sum;
			}
		}
		
		return new Matrix(temporary_representation);
	}
	
	@Override
	public String toString(){
		String to_return = "";
		
		for( double[] row : this.representation){
			
			for(double entry : row){
				
				to_return += entry+"\t";
			}
			to_return+="\n";
		}
		
		return to_return;
	}

	/**
	 * <br>Gets a list of rows</br>
	 * @return a list of rows
	 * */
	public ArrayList<Matrix> getListOfRows(){
		
		ArrayList<Matrix> listOfRows = new ArrayList<Matrix>();
		
		for(double[]  row : this.representation){
			
			double[][] to_add = new double[1][row.length];
			
			to_add[0] = row;
			
			listOfRows.add(new Matrix(to_add));
		}
		
		return listOfRows;
	}
	
	/**
	 * <br>Generates a matrix of size row X col with random entries</br>
	 * <br>Uniform distribution(given by java) from 0 to 1</br>
	 * @param row - number of rows
	 * @param col -  number of columns
	 * @return a matrix with random entries with size row X col
	 * */
	public static Matrix getRandomMatrix(int row, int col){
		
		double[][] temp_rep = new double[row][col];
		
		Random rand = new Random();
		
		for(int i=0 ; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				temp_rep[i][j] = rand.nextDouble();
			}
		}
		
		return new Matrix(temp_rep);
	}
	
	public double[][] getRepresentation(){
		
		return representation;
	}
	
	public static void main(String[] args) throws Exception{
		
		double[][] A_m = {{1,0,0},{0,1,0},{0,0,1}};
		double[][] B_m = {{1,0,0},{0,1,0},{0,0,1}};
		
		Matrix A = new Matrix(A_m);
		Matrix B = new Matrix(B_m);
		
		System.out.println(A.toString());
		System.out.println(B.toString());
		
		Matrix C = A.mul(B);
		
		System.out.println(C.toString());
		
		Matrix D =  Matrix.getRandomMatrix(3, 3);
		
		System.out.println(D.toString());
	}
}
