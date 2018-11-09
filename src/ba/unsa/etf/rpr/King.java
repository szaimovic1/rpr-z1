package ba.unsa.etf.rpr;

public class King extends ChessPiece {
    private Color boja;
    private String pozicija;

    @Override
    public boolean nedozvoljenaPozicija(String pozicija){
        int k=0, j;
        if(this.pozicija.charAt(0)<pozicija.charAt(0))
            k=1;
        else if(this.pozicija.charAt(0)>pozicija.charAt(0))
            k=-1;
        if(this.pozicija.charAt(1)<pozicija.charAt(1))
            j=1;
        else j=-1;

        if(this.pozicija.charAt(0)+k==pozicija.charAt(0) && this.pozicija.charAt(1)+j==pozicija.charAt(1))
            return false;
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
        if(this.nedozvoljenaPozicija(position))
            throw new IllegalChessMoveException("Nedozvoljena pozicija!\n");
        pozicija=position;
    }

    @Override
    public boolean equals(Object o){
        King figura = (King)o;
        return (boja==figura.getColor());
    }

    /*@Override
    public boolean provjeriPutanju(String s){
        return true;
    }*/

    public boolean provjeriSah(){
        //pozivati sve provjeri putanju za sve figure..

        return true;
    }
}
