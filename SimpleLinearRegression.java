package slr;

import java.util.Scanner;

public class SimpleLinearRegression{
  public static void main(String args[]){

   Scanner in = new Scanner(System.in);

   //Entrada de valor n, cantidad de observaciones
   System.out.println(""); 
   int n = 0;
   System.out.print("Please enter qty of observations: "); 
   n = in.nextInt();
   System.out.println(""); 

   //Variables para sumatorias
   float sum_x = 0;
   float sum_y = 0;
   float sum_xcuad = 0;
   float sum_xy = 0;

   //Entrada de valores de las observaciones
   float obs[][] = new float[n][2];
   for (int i = 0; i < n; i++){
     System.out.print("Please enter X value of observation #" + (i+1) + ": "); 
     obs[i][0] = in.nextFloat();
     System.out.print("Please enter Y value of observation #" + (i+1) + ": "); 
     obs[i][1] = in.nextFloat();
     
     //Calculando sumatorias necesarias dentro del ciclo
     sum_x += obs[i][0];
     sum_y += obs[i][1];
     sum_xcuad += (obs[i][0]*obs[i][0]);
     sum_xy += (obs[i][0]*obs[i][1]);       
   }

   //Aplicando fórmula para cálculo de Beta1
   float beta_1 = ((n*sum_xy)-(sum_x*sum_y))/((n*sum_xcuad)-(sum_x*sum_x));

   //Aplicando fórmula para cálculo de Beta0
   float beta_0 = (sum_y - beta_1*sum_x)/n;

   //Solicitando valor de x para predecir y
   System.out.println(""); 
   float x = 0, y = 0;
   System.out.print("Please enter X value to predict Y: ");
   x = in.nextFloat();
   
   //Aplicando ecuación de regresión para obtener y
   y = beta_0 + beta_1*x;   

   //Imprimiendo resultados
   System.out.println("Y = " + y);
   System.out.println("Regression equation (Y = B0 + B1x): " + y + " = " + beta_0 + " + " + beta_1 + " * " + x);
 }
}