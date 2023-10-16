package ioop.lab4;

public class Coordinates {
    public final static Coordinates NORTH_VECTOR = new Coordinates(1, 0);
    public final static Coordinates SOUTH_VECTOR = new Coordinates(-1, 0);
    public final static Coordinates EAST_VECTOR = new Coordinates(0, 1);
    public final static Coordinates WEST_VECTOR = new Coordinates(0, -1);
    public final static Coordinates STATIONARY = new Coordinates(0, 0);

    private int x;
    private int y;

    // Task 1.1
    public Coordinates(int x, int y) { //Current coordinates?
        this.x = x;
        this.y = y;

    }

    // Task 1.1
    public void addCoordinates(Coordinates vector) {
        if(vector.getX()>0){
            this.x+=vector.getX();
        }                                       
        if(vector.getY()>0){
            this.y+=vector.getX();                  //Positive 
        }
        if(vector.getX()<0){                        //Negative
            this.x-=vector.getX();
        }
        if(vector.getY()<0){
            this.y-=vector.getY();
        }
    }

    // Task 1.1
    public Coordinates findSafeMove(World world) {
        int xbound = world.getxDimension();
        int ybound = world.getyDimension();

        if(x+1 < xbound){
            return NORTH_VECTOR;
        }
        if(y+1 < ybound){
            return EAST_VECTOR;
        }
        if(x-1 > xbound){
            return SOUTH_VECTOR;
        }
        if(y-1 > ybound){
            return  WEST_VECTOR;
        }
        return STATIONARY;
    }

    // Task 1.2
    public Coordinates getNextStepTo(Coordinates destination) {
        if(destination.getX()==x && destination.getY()==y){
            return STATIONARY;
        }
        int xdiff = Math.abs(destination.getX()-x);
        int ydiff = Math.abs(destination.getY()-y);

        if(xdiff > ydiff){
            return NORTH_VECTOR;
            }
        if(ydiff > xdiff){
            return EAST_VECTOR;
        }
        if(xdiff == ydiff){
            return NORTH_VECTOR;
        }
    return STATIONARY;
  
    }
    // Task 1.3
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        try {
            Coordinates check = (Coordinates)obj;
            if(check.getX()==x && check.getY()==y){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }

        
        

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
