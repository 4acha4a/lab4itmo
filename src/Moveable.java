public interface Moveable {
    Type type = Type.MOVEMENT;
    void moveinroom();
    void setX();
    void setY();
    void setZ();
    double getZ();
    double getY();
    double getX();
    double checkboundsX();
    double checkboundsY();
    double checkboundsZ();
}
