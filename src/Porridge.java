public class Porridge extends Entity {
    public Porridge(String name){
        super(name);
    }
    Type type = Type.FOOD;
    private final int power = 100;
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
