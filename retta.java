import java.io.*;
/**
 * 
 * @author (Giammario Gallo) 
 * @version (1.0.0)
 */
public class retta
{
    private String eq;
    private float a;
    private float b;
    private float c;
    private float m;
    private float q;
    
    private String ctr(float n){
        String s="";
        if(n>0)
            s= "+"+doCustomFormat(n,1);
        if(n==0)
            s= "";
        if(n<0)
            s= ""+doCustomFormat(n,1);
        return s;
    }
    private String doCustomFormat(float f, int precision) {
        float intPart = Float.valueOf(f).intValue();
        String formatString = (intPart==f) ? "%.0f" : "%."+precision+"f";
        return String.format(formatString, f);
    }
    public retta(float x1, float y1, float x2, float y2)
    {
        m=(y2-y1)/(x2-x1);
        eq="y="+doCustomFormat(m,1)+"x"+ctr(((-1*x1)*m)+(y1));
        q=(x1*m)+(-1*y1);
        
    }
    public retta(float a1, float b1, float c1)
    {
        a=a1;
        b=b1;
        c=c1;
        eq=""+doCustomFormat(a,1)+"x+"+doCustomFormat(b,1)+"y+"+doCustomFormat(c,1)+"=0";
        m=(-1*(a/b));
        q=(-1*(c/b));
        
    }
    public void toImplicita(){
        eq=""+doCustomFormat((-1*m),1)+"x+y"+ctr(-1*q)+"=0";
    }
    public void toEsplicita(){
        eq="y="+doCustomFormat((-1*(a/b)),1)+"x"+ctr(-1*(c/b));
        m=(-1*(a/b));
        q=(-1*(c/b));
    }
    public boolean isParallele(retta r2){
        boolean is;
        if(r2.getCoef()==m)
            is=true;
        else
            is=false;
        return is;
    }
    public boolean isPerpendicolari(retta r2){
        boolean is;
        if((-1*r2.getCoef())==m)
            is=true;
        else
            is=false;
        return is;
    }
    
    public String getEQ()
    {
        return eq;
    }
    public float getCoef()
    {
        return m;
    }
    
    public static void main(String[] args){
        retta r1= new retta(2,-2,1,-4);
        System.out.println("r1: "+r1.getEQ()+"\n");
        retta r2= new retta(2,1,4);
        System.out.println("r2: "+r2.getEQ()+"\n");
        r2.toEsplicita();
        System.out.println("r2 esp: "+r2.getEQ()+"\n");
        if(r1.isParallele(r2)==true)
            System.out.println("r1 e r2 sono parallele"+"\n");
        else
            System.out.println("r1 e r2 non sono parallele"+"\n");
        if(r1.isPerpendicolari(r2)==true)
            System.out.println("r1 e r2 sono perpendicolari"+"\n");
        else
            System.out.println("r1 e r2 non sono perpendicolari"+"\n");    
        
    }
}
