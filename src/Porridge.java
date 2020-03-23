public class Porridge extends Entity {
    public Porridge(String name) throws CountException{
        super(name);
        PorridgeCount++;
        if (PorridgeCount>MaxCount) {
            throw new CountException("Количество комочков каши не может быть больше " + MaxCount);
        }
    }
    public Porridge(String name,double x, double y,double z) throws CoordinateOutOfBoundsException,CountException {
        super(name,x,y,z);
        PorridgeCount++;
        if (PorridgeCount>MaxCount) {
            throw new CountException("Количество комочков каши не может быть больше " + MaxCount);
        }
    }

    private static int PorridgeCount = 0;
    private final static int MaxCount = 10;
    Type type = Type.FOOD;
    private static final int power = 100;
    @Override
    public void damageothers(Shorty s){
        s.hp-=power;
        System.out.println(s + " столкнулся с "+ this);
    }
    @Override
    public void moveinroom(){
        x+=Math.round(Math.random()*20-10);
        checkboundsX();
        y+=Math.round(Math.random()*20-10);
        checkboundsY();
        z+=Math.round(Math.random()*20-10);
        checkboundsZ();
        System.out.println(this + " плывёт по воздуху");
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public int hashCode (){
        return super.hashCode();
    }
    @Override
    public boolean equals(java.lang.Object o){
        return super.equals(o);
    }

}
