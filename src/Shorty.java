
public class Shorty extends Entity {
    Type type = Type.SHORTY;
    public int hp = 100;
    protected static final int power = 20;

    public Shorty(String name) throws CountException {
        super(name);
        ShortyCount++;
        if (ShortyCount>MaxCount) {
            throw new CountException("Количество коротышек не может быть больше " + MaxCount);
        }
    }
    public Shorty(String name,double x, double y,double z) throws CoordinateOutOfBoundsException,CountException {
        super(name,x,y,z);
        ShortyCount++;
        if (ShortyCount>MaxCount) {
            throw new CountException("Количество коротышек не может быть больше " + MaxCount);
        }
    }
    private boolean isAngry = false;
    private final static int MaxCount = 10;
    private static int ShortyCount = 0;

    public void setAngry(boolean b) {
        isAngry = b;
        if (isAngry)
        System.out.println(this + " разозлился! Ему надо выплеснуть злость на что-то");
    }
    public int getHP(){
        return hp;
    }

    public boolean getAngry() {
        return isAngry;
    }

    @Override
    public void moveinroom(){
        x += Math.round(Math.random() * 20 - 10);
        checkboundsX();
        y += Math.round(Math.random() * 20 - 10);
        checkboundsY();
        z += Math.round(Math.random() * 20 - 10);
        checkboundsZ();
        System.out.println(this + " летит по комнате");
    }
    public void avoid (Entity e) {
        System.out.println("О нет, " + this + " слишком близко к " + e);
        System.out.println(this + " пытается избежать столкновения с " + e);
    }
    public void avoidFight(Shorty s){
        System.out.println(this + " пытается избежать стычки с " + s);
        System.out.println("Кажется, столкновение неизбежно");
    }
    public void approach(Shorty s){
        System.out.println(this + " приближается к " + s + " со словами: ");
        System.out.println("'Иди сюда, гадёныш!'");
        x += Math.round((s.getX()-getX())*0.5);
        checkboundsX();
        y += Math.round((s.getY()-getY())*0.5);
        checkboundsY();
        z += Math.round((s.getZ()-getZ())*0.5);
        checkboundsZ();
    }
    public void stop(){
        System.out.println(this + " застыл в воздухе");
        int x = (int)Math.round(Math.random()*3);
        switch (x) {
            case 0:
                System.out.println(this + " лежит вверх головой");
                break;
            case 1:
                System.out.println(this + " лежит вниз головой");
                break;
            case 2:
                System.out.println(this + " лежит в горизонтальном положении");
                break;
            case 3:
                System.out.println(this + " лежит в наклонном положении ");
                break;
        }
        if (getZ()>90)
            System.out.println(this + " лежит под потолком");
        if (getZ()<10)
            System.out.println(this + " лежит недалеко от пола");
    }
    public void spin(){
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
