public abstract class Entity implements Moveable, Damage {
    public Entity(String name){
        this.name = name;
        setX();
        setY();
        setZ();
    }
    String name;
    protected double x;
    protected double y;
    protected double z;
    private final int size = 100;

    public void setX() {
        x = Math.round(Math.random()*100);
    }
    public double getX() {
        return x;
    }
    public double checkboundsX() {
        if (x > size - 1) {
            x = x - 20;
        }
        if (x < 0) {
            x = x + 20;
        }
        return x;
    }
    public double checkboundsY() {
        if (y > size - 1) {
            y = y - 20;
        }
        if (y < 0) {
            y = y + 20;
        }
        return y;
    }
    public double checkboundsZ() {
        if (z > size - 1) {
            z = z - 20;
        }
        if (z < 0) {
            z = z + 20;
        }
        return z;
    }
    public void setY () {
        y = Math.round(Math.random()*100);
    }
    public double getY () {
        return y;
    }
    public void setZ () {
        z = Math.round(Math.random()*100);
    }
    public double getZ () {
        return z;
    }
    public double distance (Object o){
        double distance = Math.sqrt(Math.pow((getX()-o.getX()),2)+Math.pow((getY()-o.getY()),2)+Math.pow((getZ()-o.getZ()),2));
        return distance;
    }
    public double distance (Shorty s){
        double distance = Math.sqrt(Math.pow((getX()-s.getX()),2)+Math.pow((getY()-s.getY()),2)+Math.pow((getZ()-s.getZ()),2));
        return distance;
    }
    public double distance (Porridge p){
        double distance = Math.sqrt(Math.pow((getX()-p.getX()),2)+Math.pow((getY()-p.getY()),2)+Math.pow((getZ()-p.getZ()),2));
        return distance;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public int hashCode (){
        int distance = (int)Math.sqrt(getX()*getX()+getY()*getY()+getZ()*getZ());
        return distance;
    }
    @Override
    public boolean equals(java.lang.Object o){
        if (name.equals(o.toString()))
            return true;
        else return false;
    }
}
