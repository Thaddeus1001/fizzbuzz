package homework;

import java.io.PrintStream;
import java.util.Scanner;

public class Hwk2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		 
		Range range1 = getRange("Range1", in, out); 
		Range range2 = getRange("Range2", in, out);
		
		out.printf("Range1 = %s\n", range1);
		out.printf("Range2 = %s\n", range2);
		
		out.println("Enter min value for Range1:");
		range1.setMin(Double.parseDouble(in.nextLine()));
		out.println("Enter max value for Range1:");
		range1.setMax(Double.parseDouble(in.nextLine()));
		
		Range tmp = getRange("Range2", in, out);
		range2.setRange(tmp.getMin(), tmp.getMax());
		
		out.printf("Range1 = %s\n", range1);
		out.printf("Range2 = %s\n", range2);
		
		out.println("Enter a point:");
		double point = Double.parseDouble(in.nextLine());
		
		out.printf("%s %s %.6f\n", range1, range1.contains(point)? "contains" : "does not contain", point);
		out.printf("%s %s %.6f\n", range2, range2.contains(point)? "contains" : "does not contain", point);
		
		out.printf("%s %s %s\n", range1, range1.contains(range2)? "contains" : "does not contain", range2);
		out.printf("%s %s %s\n", range2, range2.contains(range1)? "contains" : "does not contain", range1);
		
		out.printf("The union of %s and %s is %s\n", range1, range2, range1.union(range2));
		out.printf("The intersection of %s and %s %s\n", range1, range2, range1.intersects(range2)? "is "+range1.intersection(range2) : "does not exist");
		
		in.close();
	}
	
	private static Range getRange(String name, Scanner in, PrintStream out) {
		out.printf("Enter min and max values for %s:\n", name);
		String[] tmp = in.nextLine().split(" ");
		double min = Double.parseDouble(tmp[0]), max = Double.parseDouble(tmp[1]);
		return new Range(min, max);
	}
}

class Range {
	// TODO
}
