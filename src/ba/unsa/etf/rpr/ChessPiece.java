package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    public static  enum Colour{
        BLACK("BLACK"), WHITE("WHITE");

        private String boja;
        Colour(String boja){
            this.boja=boja;
        }

        public String dajBoju(){
            return boja;
        }
    }
    public abstract String getPosition();
    public abstract Colour getColour();
    public abstract void move(String position);
}
