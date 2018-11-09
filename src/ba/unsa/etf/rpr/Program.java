package ba.unsa.etf.rpr;
import java.util.Scanner;

public class Program {
     public static void main(String[] args) {
         Board ploca = new Board();
         String potez = new String();
         boolean ponovniPotezBijelog=false, ponovniPotezCrnog=false;
         while(!potez.equals("X")){
             if(!ponovniPotezCrnog) {
                 ponovniPotezCrnog=false;
                 if(ploca.isCheck(ChessPiece.Color.WHITE))
                     System.out.println("CHECK!!!");
                 System.out.println("Potez bijelog igrača:");
                 Scanner ulaz = new Scanner(System.in);
                 potez = ulaz.nextLine();
                 potez=potez.toUpperCase();
                 if(potez.equals("X")){
                     System.out.println("Predaja!");
                     return;
                 }
                 try{
                     if(potez.charAt(1)>='1' && potez.charAt(1)<='8'){
                         ploca.move(Pawn.class, ChessPiece.Color.WHITE, potez);
                     }
                     else{
                         String pozicija = new String(Character.toChars(potez.charAt(1)));
                         pozicija += new String(Character.toChars(potez.charAt(2)));
                         char figura = potez.charAt(0);
                         if (figura == 'K')
                             ploca.move(King.class, ChessPiece.Color.WHITE, pozicija);
                         else if (figura == 'Q')
                             ploca.move(Queen.class, ChessPiece.Color.WHITE, pozicija);
                         else if (figura == 'R')
                             ploca.move(Rook.class, ChessPiece.Color.WHITE, pozicija);
                         else if (figura == 'B')
                             ploca.move(Bishop.class, ChessPiece.Color.WHITE, pozicija);
                         else if (figura == 'N')
                             ploca.move(Knight.class, ChessPiece.Color.WHITE, pozicija);

                     }
                 } catch (Exception e) {
                         System.out.println("Illegal move\nPonovite unos!");
                         ponovniPotezBijelog = true;
                     }
             }

             if(!ponovniPotezBijelog){
                 ponovniPotezBijelog=false;
                 if(ploca.isCheck(ChessPiece.Color.BLACK))
                     System.out.println("CHECK!!!");
                 System.out.println("Potez crnog igrača:");
                 Scanner ulaz = new Scanner(System.in);
                 potez = ulaz.nextLine();
                 potez=potez.toUpperCase();
                 if(potez.equals("X")){
                     System.out.println("Predaja!");
                     return;
                 }
                 try{
                     if(potez.charAt(1)>='1' && potez.charAt(1)<='8'){
                         ploca.move(Pawn.class, ChessPiece.Color.BLACK, potez);
                     }
                     else{
                         String pozicija = new String(Character.toChars(potez.charAt(1)));
                         pozicija += new String(Character.toChars(potez.charAt(2)));
                         char figura = potez.charAt(0);
                         if (figura == 'K')
                             ploca.move(King.class, ChessPiece.Color.BLACK, pozicija);
                         else if (figura == 'Q')
                             ploca.move(Queen.class, ChessPiece.Color.BLACK, pozicija);
                         else if (figura == 'R')
                             ploca.move(Rook.class, ChessPiece.Color.BLACK, pozicija);
                         else if (figura == 'B')
                             ploca.move(Bishop.class, ChessPiece.Color.BLACK, pozicija);
                         else if (figura == 'N')
                             ploca.move(Knight.class, ChessPiece.Color.BLACK, pozicija);

                     }
                 } catch (Exception e) {
                     System.out.println("Illegal move\nPonovite unos!");
                     ponovniPotezCrnog = true;
                 }
             }
         }
    }
}
