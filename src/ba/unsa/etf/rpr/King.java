package ba.unsa.etf.rpr;

public class King extends ChessPiece {
    private Color boja;
    private String pozicija;

    private boolean nedozvoljenaPozicija(String pozicija){
        if(this.pozicija.charAt(0)+1==pozicija.charAt(0)
               || this.pozicija.charAt(0)-1==pozicija.charAt(0)
               || this.pozicija.charAt(1)+1==pozicija.charAt(1)
               || this.pozicija.charAt(1)-1==pozicija.charAt(1))
            return false;                                                                 //nesto pametnije?
        return true;
    }

    King(String pozicija, Color boja){
        if(nepostojecaPozicija(pozicija))
            throw new IllegalArgumentException("Nepostojeća pozicija!\n");

        //if(nedozvoljenaPozicija(pozicija))
            //throw new IllegalChessMoveException("Nedozvoljena pozicija!\n");            //nedozvoljeno?????

        this.boja=boja;
        this.pozicija=pozicija;
    }

    @Override
    public Color getColour() {
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
        if(nedozvoljenaPozicija(position))
            throw new IllegalChessMoveException("Nedozvoljena pozicija!\n");
        pozicija=position;
    }

    @Override
    public boolean equals(King figura){
        return (boja==figura.boja);
    }
}
