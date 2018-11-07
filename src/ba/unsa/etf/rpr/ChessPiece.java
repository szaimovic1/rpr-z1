package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    ChessPiece() {}

    boolean nepostojecaPozicija(String position){                                       //default package private????
        if(position.length()<=1) return true;
        if(position.charAt(0) < 'A' || (position.charAt(0)  > 'H' && position.charAt(0) < 'a')
                || position.charAt(0) > 'h')
            return true;
        if(position.charAt(1)  < '1' || position.charAt(1) > '8')                       //moze i pozicija da se koristi
            return true;
        return false;
    }

    abstract boolean equals(ChessPiece f);

   // ChessPiece() throws IllegalChessMoveException {};                                //treba li??

    public static  enum Color{
        BLACK, WHITE

        /*private String boja;
        Colour(String boja){                                                          //razmotriti u nastavku po potrebi
            this.boja=boja;                                                           //i moze li ovako uopste???
        }

        public String dajBoju(){
            return boja;
        }*/                                                                           //sta sa upozorenjima???!!!!!!
    }
    public abstract String getPosition();
    public abstract Color getColor();
    public abstract void move(String position) throws IllegalChessMoveException;
}
