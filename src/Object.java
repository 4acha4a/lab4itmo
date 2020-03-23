public class Object extends Entity {
    Type type = Type.OBJECT;
    private static final int power = 20;
    public Object(String name) throws CountException{
        super(name);
        ObjectCount++;
        if (ObjectCount>MaxCount) {
            throw new CountException("Количество предметов мебели не может быть больше " + MaxCount);
        }
    }
    public Object(String name,double x, double y,double z) throws CoordinateOutOfBoundsException,CountException {
        super(name,x,y,z);
        ObjectCount++;
        if (ObjectCount>MaxCount) {
            throw new CountException("Количество предметов мебели не может быть больше " + MaxCount);
        }
    }
    private static int ObjectCount = 0;
    private final static int MaxCount = 10;
    @Override
    public void damageothers(Shorty s){
        if (s.getAngry()){
            System.out.println(s + " ударил о " + this);
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
    public static class PanOfPorridge extends Entity {
        public PanOfPorridge (String name) throws CountException{
            super(name);
            setX();
            setY();
            setZ();
            PanCount++;
            if (PanCount>MaxCount) {
                throw new CountException("Количество кастрюль с кашей не может быть больше " + MaxCount);
            }
        }
        static int PanCount = 0;
        static final int MaxCount = 1;
        private int amountOfPorridge = 0;
        private final int power = 20;
        public void putPorridge(Porridge p){
            p.x=getX();
            p.y=getY();
            p.z=getZ();
            countPorridgeplus();
            System.out.println(p + " положили в кастрюлю ");
            switch (amountOfPorridge) {
                case 1:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочек каши");
                    break;
                case 2:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочка каши");
                    break;
                case 3:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочка каши");
                    break;
                case 4:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочка каши");
                    break;
                default:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочков каши");
                    break;
            }
        }
        private int countPorridgeplus() {
            amountOfPorridge++;
            return amountOfPorridge;
        }
        private int countPorridgeminus() {
            amountOfPorridge--;
            return amountOfPorridge;
        }
        public void outPorridge(Porridge p){
            p.x = getX() + Math.round(Math.random()*5);
            p.y = getY() + Math.round(Math.random()*5);
            p.z = getZ() + Math.round(Math.random()*5);
            countPorridgeminus();
            System.out.println(p + " выпал из кастрюли");
            switch (amountOfPorridge) {
                case 1:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочек каши");
                    break;
                case 2:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочка каши");
                    break;
                case 3:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочка каши");
                    break;
                case 4:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочка каши");
                    break;
                default:
                    System.out.println("Теперь в кастрюле находится " + amountOfPorridge + " комочков каши");
                    break;
            }
        }
        @Override
        public void damageothers(Shorty s) {
            s.hp-=power;
            System.out.println(s + " столкнулся с " + this);
            if (amountOfPorridge>0) System.out.println(this + " выплеснулась в лицо " + s);
        }

        @Override
        public void moveinroom() {
            x += Math.round(Math.random() * 20 - 10);
            checkboundsX();
            y += Math.round(Math.random() * 20 - 10);
            checkboundsY();
            z += Math.round(Math.random() * 20 - 10);
            checkboundsZ();
            System.out.println(this + " летит по комнате ");
        }

    }
}
