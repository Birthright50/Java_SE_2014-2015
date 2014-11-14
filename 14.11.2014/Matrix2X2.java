/**
 * Created by Birthright on 14.11.2014.
 */
public class Matrix2X2 {
    private double a1;
    private double a2;
    private double a3;
    private double a4;


    public Matrix2X2(double a1, double a2, double a3, double a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }

    public Matrix2X2() {
        this(0, 0, 0, 0);
    }
    public Matrix2X2(double x){
        this.a1 = x;
        this.a2 = x;
        this.a3 = x;
        this.a4 = x;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getA4() {
        return a4;
    }

    public void setA4(double a4) {
        this.a4 = a4;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }


    public boolean equals(Matrix2X2 h) {

       if(this.a1!=h.getA1()){
           return false;
       }
        else{
           if(this.a2!=h.getA2()){
               return false;
           }
           else{
               if(this.a3!=h.getA3()){
                   return false;
               }
               else {
                   if(this.a4!=h.getA4()){
                       return false;
                   }
               }
           }
       }
        return true;
    }

       public String toString() {
        String g = a1 + " " + a2+"\n"+a3+" "+a4;
        return g;
    }
    public Matrix2X2 mult(Matrix2X2 h){
        return new Matrix2X2(this.a1*h.getA1()+this.a2*h.getA2(), this.a1*h.getA2()+this.a2*h.getA4(), this.a3*h.getA1()+this.a4*h.getA3(), this.a3*h.getA2()+this.a4*h.getA4());
    }
    public Matrix2X2 add(Matrix2X2 h){
        return new Matrix2X2(this.a1+h.getA1(),this.a2+h.getA2(),this.a3+h.getA3(),this.a4+h.getA4());
    }
    public double det(Matrix2X2 h){
        double det = h.getA1()*h.getA4()-h.getA3()*h.getA2();
        return det; 
    }

}

