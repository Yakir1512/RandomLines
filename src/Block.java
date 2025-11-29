public class Block implements Collidable{
    @Override
    public Rectangle getCollisionRectangle() {
        return this;
        return null;
    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        return null;
    }
}
