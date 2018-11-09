package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.Board;

public class Queen extends ChessPiece {
    private Color boja;
    private String pozicija;

    @Override
    public boolean nedozvoljenaPozicija(String pozicija){
        String i = this.pozicija;
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
        int a = i.charAt(0), b = i.charAt(1);
        a+=k;
        b+=j;
        i = new String(Character.toChars(a));
        i += new String(Character.toChars(b));
        int brojac=1;
        while (!i.equals(pozicija)) {
            if(brojac>8)
                return true;
            a = i.charAt(0);
            a+=k;
            b = i.charAt(1);
            b+=j;
            i = new String(Character.toChars(a));
            i += new String(Character.toChars(b));
            brojac++;
        }
        return false;
    }

    Queen(String pozicija, Color boja){
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
        if(this.nedozvoljenaPozicija(position))
            throw new IllegalChessMoveException("Nedozvoljena pozicija!\n");
        pozicija=position;
    }

    @Override
    public boolean equals(Object o){
        Queen figura = (Queen)o;
        return (boja==figura.getColor());
    }

    /*@Override
    public boolean provjeriPutanju(String s) {
        char i;
        if (pozicija.charAt(0) == s.charAt(0))
            for (i = (char)(pozicija.charAt(1) + 1); i < s.charAt(1); i++)
                if (Board::praznaPozicija(pozicija.charAt(0)+Character.toString(i)))
        return false;
        //if()
        return true;
    }*/
}
