package ba.unsa.etf.rpr;
import java.util.HashMap;

public class Board {
    private boolean bijeliUIgri, crniUIgri;
    private int brojBijelih, brojCrnih;
    private HashMap<String, ChessPiece> sahovskaPloca;


    Board(){
        sahovskaPloca = new HashMap<String, ChessPiece>();
        sahovskaPloca.put("e1", new King("E1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("e8", new King("E8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("d1", new Queen("D1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("d8", new Queen("D8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("a1" ,new Rook("A1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("h1" ,new Rook("H1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("a8" ,new Rook("A8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("h8" ,new Rook("H8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("c1" ,new Bishop("C1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("f1" ,new Bishop("F1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("c8" ,new Bishop("C8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("f8" ,new Bishop("F8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("b1" ,new Knight("B1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("g1" ,new Knight("G1", ChessPiece.Color.WHITE));
        sahovskaPloca.put("b8" ,new Knight("B8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("g8" ,new Knight("G8", ChessPiece.Color.BLACK));
        sahovskaPloca.put("a2" ,new Pawn("A2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("b2" ,new Pawn("B2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("c2" ,new Pawn("C2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("d2" ,new Pawn("D2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("e2" ,new Pawn("E2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("f2" ,new Pawn("F2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("g2" ,new Pawn("G2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("h2" ,new Pawn("H2", ChessPiece.Color.WHITE));
        sahovskaPloca.put("a7" ,new Pawn("A7", ChessPiece.Color.BLACK));
        sahovskaPloca.put("b7" ,new Pawn("B7", ChessPiece.Color.BLACK));
        sahovskaPloca.put("c7" ,new Pawn("C7", ChessPiece.Color.BLACK));
        sahovskaPloca.put("d7" ,new Pawn("D7", ChessPiece.Color.BLACK));
        sahovskaPloca.put("e7" ,new Pawn("E7", ChessPiece.Color.BLACK));
        sahovskaPloca.put("f7" ,new Pawn("F7", ChessPiece.Color.BLACK));
        sahovskaPloca.put("g7" ,new Pawn("G7", ChessPiece.Color.BLACK));
        sahovskaPloca.put("h7" ,new Pawn("H7", ChessPiece.Color.BLACK));
        brojBijelih=16;
        brojCrnih=16;
        bijeliUIgri=true;
        crniUIgri=true;
    }

    void move(Class type, ChessPiece.Color color, String position){
        String pozicija = new String();
        for (HashMap.Entry<String, ChessPiece> x : sahovskaPloca.entrySet())
            if(x.getValue().equals(new type("", color)))
                pozicija=x.getKey();

    }

    void move(String oldPosition, String newPosition){

    }

    boolean isCheck(ChessPiece.Color color){
        if(color==ChessPiece.Color.WHITE)
            return bijeliUIgri;
        return crniUIgri;
    }

}
