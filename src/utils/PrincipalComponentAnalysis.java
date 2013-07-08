package utils;

/**
 * @author puaykai
 *
 *<br>This class does principal component analysis</br>
 *<br>Based on "A Tutorial on Principal Component Analysis" by Jonathan Shiens</br>
 *<br>Assumes that the input matrix's colums are the signals</br>
 */
public class PrincipalComponentAnalysis {
	
	Matrix mat;
	
	Matrix covariance_matrix;
	
	public PrincipalComponentAnalysis(Matrix mat) throws Exception{
		
		this.mat = mat;
		
		getCovarianceMatrix();
	}
	
	private void getCovarianceMatrix() throws Exception{
		
		covariance_matrix = (mat.mul(mat.tranpose())).mul(1.0/mat.M);
	}

	public static void main(String[] args) throws Exception{
		
		DataSampleGenerator generator = new DataSampleGenerator(4,20);
		
		PrincipalComponentAnalysis pca = new PrincipalComponentAnalysis(generator.getMatrixRepresentation());
		
		System.out.println(pca.covariance_matrix.toString());
	}
}
