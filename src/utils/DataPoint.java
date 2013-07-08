package utils;

/**
 * <br>DataPoint is a column vector/Matrix</br>
 * 
 * @author puaykai
 * */
public class DataPoint {
	
	private Matrix data;
	
	public DataPoint(double[] data){
		
		double[][] vector = new double[1][data.length];
		
		vector[0] = data;
		
		this.setData(new Matrix(vector));
	}

	public Matrix getData() {
		return data;
	}

	public void setData(Matrix data) {
		this.data = data;
	}
	
	@Override
	public String toString(){
		
		String string = "{";
		
		for(double d : this.getData().getRepresentation()[0]){
			
			string += (d+",\t");
		}
		
		string += "}";
		
		return string;
	}
}
