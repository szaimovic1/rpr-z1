package ba.unsa.etf.rpr;

public abstract class ChessPiece {
   // ChessPiece() throws IllegalChessMoveException {};                //treba li??

    public static  enum Color{
        BLACK, WHITE

        /*private String boja;
        Colour(String boja){                                           //razmotriti u nastavku po potrebi
            this.boja=boja;                                            //i moze li ovako uopste???
        }

        public String dajBoju(){
            return boja;
        }*/
    }
    public abstract String getPosition();
    public abstract Color getColour();
    public abstract void move(String position) throws IllegalChessMoveException;
}
