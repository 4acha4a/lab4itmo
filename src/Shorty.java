
public class Shorty extends Entity {
    Type type = Type.SHORTY;
    public int hp = 100;
    private final int power = 20;

    public Shorty(String name) {
        super(name);
    }
    public Shorty(String name,double x, double y,double z) {
        super(name);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private boolean isAngry = false;

    public void setAngry() {
        isAngry = true;
    }
    public int getHP(){
        return hp;
    }

    public boolean getAngry() {
        return isAngry;
    }

    public void moveinroom() {
        x += Math.round(Math.random() * 20 - 10);
        checkboundsX();
        y += Math.round(Math.random() * 20 - 10);
        checkboundsY();
        z += Math.round(Math.random() * 20 - 10);
        checkboundsZ();
        System.out.println(this + " машет руками и ногами ");
    }
    public void avoid (Shorty s) {
        System.out.println("О нет, "+ this + " слишком близко к " + s);
        System.out.println(this + " пытается избежать столкновения с " + s);
    }
    public void avoid (Porridge p) {
        System.out.println("О нет, "+ this + " слишком близко к " + p);
        System.out.println(this + " пытается избежать столкновения с " + p);
    }
    public void avoid (Object o) {
        System.out.println("О нет, "+ this + " слишком близко к " + o);
        System.out.println(this + " пытается избежать столкновения с " + o);
    }
    protected void spin() {
        System.out.println(this + " перевернулся в воздухе");
    }
    
    @Override
    public void damageothers(Shorty s) {
        hp -= power;
        s.hp -= power;
        System.out.println(this + " столкнулся с " + s);
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
