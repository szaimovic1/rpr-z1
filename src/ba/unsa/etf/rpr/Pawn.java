package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece{
    private Color boja;
    private String pozicija;

    @Override
    public boolean nedozvoljenaPozicija(String pozicija){
        if(this.pozicija.charAt(0)!=pozicija.charAt(0))
            return true;
        if((this.pozicija.charAt(1)=='2' && boja==Color.WHITE) &&
                 this.pozicija.charAt(1)+2==pozicija.charAt(1))
            return false;
        if((this.pozicija.charAt(1)=='7' && boja==Color.BLACK) &&
                 this.pozicija.charAt(1)-2==pozicija.charAt(1))
            return false;
        if((this.pozicija.charAt(1)+1==pozicija.charAt(1) && boja==Color.WHITE)
           || (this.pozicija.charAt(1)-1==pozicija.charAt(1) && boja==Color.BLACK))
            return false;
        return true;                                                          //zanemarena mogucnost vracanja figure!!!!
    }

    public boolean kosoKupljenje(String pozicija){
        if((this.pozicija.charAt(0)+1==pozicija.charAt(0) || (this.pozicija.charAt(0)-1==pozicija.charAt(0))) &&
                this.pozicija.charAt(1)+1==pozicija.charAt(1))
            return true;
        return false;
    }

    Pawn(String pozicija, Color boja){
        if(nepostojecaPozicija(pozicija))
            throw new IllegalArgumentException("Nepostojeća pozicija!\n");
        this.boja=boja;
        this.pozicija=pozicija;
    }

    @Override
    public Color getColor() {
        return boja;
    }

    @Override
    public String getPosition() {
        return pozicija;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException{
        if(nepostojecaPozicija(position))
            throw new IllegalArgumentException("Nepostojeća pozicija!\n");
        if(this.nedozvoljenaPozicija(position) && !this.kosoKupljenje(position))
            throw new IllegalChessMoveException("Nedozvoljena pozicija!\n");
        pozicija=position;
    }

    @Override
    public boolean equals(Object o){
        Pawn figura = (Pawn)o;
        return (boja==figura.getColor());
    }

    @Override
    public boolean provjeriPutanju(String s){
        return true;
    }
}
