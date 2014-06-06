package pl.lodz.p.kis;

import java.util.Comparator;

public class FileObjectComparator implements Comparator<Point> {
	@Override
	public int compare(Point a, Point b) {
		double distance = a.getDistance() - b.getDistance();
		if (distance < 0)
			return -1;
		else if (distance > 0)
			return 1;
		return 0;
	}
}
