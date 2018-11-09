package ba.unsa.etf.rpr;

public class Program {
     public static void main(String[] args) {
         int k=-1, j=1;
         String i = new String("E1");
         String s = new String("B4");
         int a = 0, b=0;
         while(!i.equals(s)){
             a = i.charAt(0);
             a+=k;
             b=i.charAt(1);
             b+=j;
             i = new String(Character.toChars(a));
             i += new String(Character.toChars(b));
             System.out.println(i);
         }
    }
}
