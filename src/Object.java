public class Object extends Entity {
    Type type = Type.OBJECT;
    private final int power = 20;
    public Object(String name){
        super(name);
    }
    public Object(String name,double x, double y,double z) {
        super(name);
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public void damageothers(Shorty s){
        if (s.getAngry()){
            System.out.println(s + " рассердился и ударил о " + this);
            s.spin();
        }
            s.hp-=power;
            System.out.println(s + " ушибся о " + this);
    }
    @Override
    public void moveinroom(){
        x++;
        checkboundsX();
        y++;
        checkboundsY();
        z++;
        checkboundsZ();
        System.out.println(name + " летает в пространстве ");
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
