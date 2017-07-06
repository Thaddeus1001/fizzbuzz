//Homework 1, Computer Science 251, Summer 2017
//Victor Weinert, Student ID :991258566
public class Hwk1 {
	public static void main(String[] args){
		double[] f = {
				0.008976173, 0.015300936, 0.387302890, 0.654154670, 0.705971749, 1.307427486,
				1.071969875, 1.113588720, 1.688798266, 1.334709476, 2.404115760, 2.310886173,
				2.432582514, 2.174252365, 2.727890154, 3.222288922, 3.432658520, 3.823261752
				};
		double[] g1 = {0.25, 0.25, 0.5},
				 g2 = {0.1, 0.2, 0.3, 0.4};
	
		double[] cov1 = convolution(f, g1);
		double[] cov2 = convolution(f, g2);
		double[] cor1 = correlation(f, g1);
		double[] cor2 = correlation(f, g2);
		
		print(f, cov1, cor1);
		print(f, cov2, cor2);
		
		
	}
	private static double[] convolution (double[] f, double[] g){
		int N = f.length;
		int M = g.length;
	
		double[] cov = new double[N-M+1];
		for (int i = 0; i <cov.length; i++){
			double sum=0.0;
		
			for (int j = 0; j<g.length; j++){
				sum += f[i+(g.length-1)-j]*g[j];
					
			}
			cov[i]=sum;
		}
		return cov;
			
			
	}
	private static double[] correlation (double[] f, double[] g){
		int N = f.length;
		int M = g.length;
		
		double[] cor = new double[N-M+1];
		for (int i = 0; i < cor.length; i++){
			double sum=0.0;
		
			for (int j = 0; j<g.length; j++){
				sum += f[i + j]*g[j];
				
			}
			cor[i] = sum;
			
		}
		return cor;
	}

	private static void print(double[] f, double[] convolution, double[] correlation){
		
		for (int i = 0; i < f.length;i++){
			if(i<correlation.length)
		System.out.printf("%d: %.5f, %.5f, %.5f\n",i, f[i], convolution[i], correlation[i]);
			else
				System.out.printf("%d: %.5f, -------, -------\n",i, f[i]);

				
	}
	}
}