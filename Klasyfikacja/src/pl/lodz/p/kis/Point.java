package pl.lodz.p.kis;

import java.util.Arrays;

/**
 * Klasa reprezentuje pojedynczy obiekt zaci¹gniety z pliku. Wykorzystywany
 * podczas klasyfikacji.
 */
public class Point implements Cloneable, Comparable<Point> {
	public static final int CLASS_A = 0;
	public static final int CLASS_B = 1;
	public static final int UNCLASSIFIED = -1;

	private double[] features; 			// wszystkie cechy obiektu
	private double[] selectedFeatures; 	// cechy wybrane na podstawie wspolczynnika Fishera
	private int classType;
	private int id; 					// numer obiektu
	private double distance;
	private Point centroid; 			// centroid do ktorego najblizej w KNM
	
	public Point(int numberOfFeatures) {
		features = new double[numberOfFeatures];
		id = -1;						//Punkt nie zwiazany z obiektami zaciagnietymi z pliku
	}

	public Point(double[] features, int type, int id) {
		this.features = Arrays.copyOf(features, features.length);
		this.classType = type;
		this.id = id;
	}

	public double[] getFeatures() {
		return features;
	}

	public void setFeatures(double[] features) {
		this.features = features;
	}

	/**
	 * Ustawia cechy na podstawie przekazanych indeksow cech otrzymanych ze wspo³czynnika Fishera 
	 */
	public void setSelectedFeatures(int[] featuresIndices) {
		selectedFeatures = new double[featuresIndices.length];

		for (int i = 0; i < featuresIndices.length; i++)
			selectedFeatures[i] = features[featuresIndices[i]];
	}

	public void setSelectedFeatures(double[] featuresVector) {
		selectedFeatures = featuresVector;
	}
	
	public double[] getSelectedFeatures() {
		return selectedFeatures;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[ID: ").append(id).append("][CLASS:").append(classType).append("]");
		return result.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Point result = (Point) super.clone();
		result.features = Arrays.copyOf(this.features, this.features.length);
		result.classType = this.classType;
		result.id = this.id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Point val = (Point) obj;
		double[] paramFeatures = val.getFeatures();
		for (int i = 0; i < features.length; i++) {
			if (features[i] != paramFeatures[i])
				return false;
		}
		return true;
	}

	@Override
	public int compareTo(Point o) {
		return this.classType - o.classType;
	}

	public void setCentroid(Point point) {
		this.centroid = point;
	}
	
	public Point getCentroid() {
		return centroid;
	}
}
