public abstract class Entity implements Moveable, Damage {
    public Entity(String name) {
        this.name = name;
        setX();
        setY();
        setZ();
    }
    public Entity(String name,double x, double y,double z) throws CoordinateOutOfBoundsException {
        this.name = name;
        this.x = x;
        if (this.x>100)
            throw new CoordinateOutOfBoundsException("x не может быть больше " + size);
        if (this.x<0)
            throw new CoordinateOutOfBoundsException("x не может быть меньше 0");
        this.y = y;
        if (this.y>100)
            throw new CoordinateOutOfBoundsException("y не может быть больше " + size);
        if (this.y<0)
            throw new CoordinateOutOfBoundsException("y не может быть меньше 0");
        this.z = z;
        if (this.z>100)
            throw new CoordinateOutOfBoundsException("z не может быть больше " + size);
        if (this.z<0)
            throw new CoordinateOutOfBoundsException("z не может быть меньше 0");
    }

    String name;
    protected double x;
    protected double y;
    protected double z;
    protected final int size = 100;

    public void setX() {
        x = Math.round(Math.random() * 100);
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

    public void setY() {
        y = Math.round(Math.random() * 100);
    }

    public double getY() {
        return y;
    }

    public void setZ() {
        z = Math.round(Math.random() * 100);
    }

    public double getZ() {
        return z;
    }

    public double distance(Entity e) {
        return Math.sqrt(Math.pow((getX() - e.getX()), 2) + Math.pow((getY() - e.getY()), 2) + Math.pow((getZ() - e.getZ()), 2));
    }

    @Override
    public String toString() throws NullPointerException {
        if (name==null) throw new NullPointerException("Имя не может быть null");
        return name;
    }

    @Override
    public int hashCode() {
        return (int) Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
    }

    @Override
    public boolean equals(java.lang.Object o) {
        Entity one = (Entity) o;
        return name.equals(one.name)&&(this.hashCode() == o.hashCode()) && (o.getClass() == this.getClass());
    }
}
