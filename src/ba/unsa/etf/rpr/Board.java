package ba.unsa.etf.rpr;
import java.util.HashMap;
import java.util.Map.Entry;

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

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException{
        if (sahovskaPloca.get(position.toLowerCase()) != null && sahovskaPloca.get(position.toLowerCase()).getColor()==color)
            throw new IllegalChessMoveException("Figura iste boje!\n");
        else{
            for (HashMap.Entry<String, ChessPiece> x : sahovskaPloca.entrySet())
                if(color==x.getValue().getColor() && x.getValue().getClass().equals(type)
                   && x.getValue().provjeriPutanju(position.toUpperCase())){
                    if(type==Pawn.class){
                        Pawn pjesak = new Pawn (x.getKey().toUpperCase(), x.getValue().getColor());
                        if(pjesak.kosoKupljenje(position)){
                            if(sahovskaPloca.get(position.toLowerCase()) != null)
                                sahovskaPloca.remove(position.toLowerCase());
                            x.getValue().move(position.toUpperCase());
                            sahovskaPloca.put(position.toLowerCase(), x.getValue());
                            sahovskaPloca.remove(x.getKey());
                            return;
                        }
                        else if(!x.getValue().nedozvoljenaPozicija(position)
                                && !x.getValue().nepostojecaPozicija(position)){
                            x.getValue().move(position.toUpperCase());
                            sahovskaPloca.put(position.toLowerCase(), x.getValue());
                            sahovskaPloca.remove(x.getKey());
                            return;
                        }
                    }
                    else if(!x.getValue().nedozvoljenaPozicija(position)
                            && !x.getValue().nepostojecaPozicija(position)){
                        if(sahovskaPloca.get(position.toLowerCase()) != null){
                            sahovskaPloca.remove(position.toLowerCase());
                                    /*if(color == ChessPiece.Color.WHITE)
                                        if(brojCrnih--==0)
                                            crniUIgri=false;
                                        else
                                            if(brojBijelih--==0)
                                                bijeliUIgri=false;*/
                        }
                        x.getValue().move(position.toUpperCase());
                        sahovskaPloca.put(position.toLowerCase(), x.getValue());
                        sahovskaPloca.remove(x.getKey());                                                 //problem sa hash zbog poretka..
                                /*if(color == ChessPiece.Color.WHITE)                                               //PROMIJENITI KEY POLJE I ZAKOMPLIKOVATI SEBI ZIVOT...
                                    brojBijelih++;                                                                //Moguć potez za figuru!!!!!
                                else brojCrnih++;*/                                                                 //Samo uhvatiti izuzetak iz move, glat..
                        return;
                    }
                }
            throw new IllegalChessMoveException("Nemoguć potez!\n");
        }
    }

    public void move(String oldPosition, String newPosition) throws IllegalChessMoveException {
        if(sahovskaPloca.get(oldPosition.toLowerCase()) == null)
            throw new IllegalArgumentException("Nema figure!\n");
        move(sahovskaPloca.get(oldPosition.toLowerCase()).getClass(), sahovskaPloca.get(oldPosition.toLowerCase()).getColor(), newPosition.toUpperCase());
    }

    boolean isCheck(ChessPiece.Color color){
        for (HashMap.Entry<String, ChessPiece> x : sahovskaPloca.entrySet())
        if(King.class==x.getValue().getClass() && x.getValue().getColor()==color){
            King k = new King(x.getKey().toUpperCase(), color);
            return k.provjeriSah();
        }
        return true;
    }

    public boolean praznaPozicija(String pozicija){
        return (sahovskaPloca.get(pozicija.toLowerCase()) == null);
    }
}
