package utils;

import java.util.*;


/**
 * <br>This class is to generate random data for stimulation</br>
 * 
 * @author puaykai
 *
 */
public class DataSampleGenerator {
	
	int dimension;
	
	int number_of_datapoints;
	
	ArrayList<DataPoint> datapoints;
	
	public DataSampleGenerator(int dimension, int number_of_datapoints){
		
		this.dimension = dimension;
		
		this.number_of_datapoints = number_of_datapoints;
		
		this.generateRandomPoints();
	}
	/**
	<br>Changes the list of datapoints to a matrix representation</br>
	*/
	public Matrix getMatrixRepresentation(){
		
		double[][] matrix_rep = new double[dimension][datapoints.size()];
		
		for(int i=0; i< datapoints.size(); i++){
			
			for(int j=0; j<dimension; j++){
				
				matrix_rep[j][i] = datapoints.get(i).getData().get(0, j);
			}
		}
		
		return new Matrix(matrix_rep);
	}
	
	/**
	 * <br>Clears the datapoints and generates new ones</br>
	 * <br>Uses java's rand to generate Uniform(0,1) </br>
	 * */
	public void generateRandomPoints(){
		
		datapoints = new ArrayList<DataPoint>();
		
		Random rand = new Random();
		
		for(int i=0; i<number_of_datapoints; i++){
			
			double[] data = new double[dimension];
			
			for(int j=0;j<dimension; j++){
				
				data[j] = rand.nextDouble();
			}
			
			datapoints.add(new DataPoint(data));
		}
	}

	/**
	 * <br>This gives the datapoints</br>
	 * */
	public ArrayList<DataPoint> getDataPoints(){
		
		return datapoints;
	}
	
	public void printDataPoints(){
		
		System.out.println("****************DATA********************");
		for(DataPoint data : datapoints){
			
			System.out.println(data.toString());
		}
		System.out.println("*****************************************");
	}

	
	/**
	 * For testing
	 * @param args
	 */
	public static void main(String[] args) {
		
		DataSampleGenerator generator = new DataSampleGenerator(4,50);
		
		generator.printDataPoints();
		
		System.out.println(generator.getMatrixRepresentation().toString());
	}

}
