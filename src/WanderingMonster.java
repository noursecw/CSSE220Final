public class WanderingMonster extends Monster {
    private GameWorld world;
    /**
     * Constructs a abstract bouncer in the given world.
     *
     * @param world Gameworld
     */
    public WanderingMonster(GameWorld world) {
        super(world);
        this.world = world;
        super.setCenterPoint(randomPos(world.getSize().getWidth(),world.getSize().getHeight(),3));
    }


    @Override
    public void updateSize() {

    }

    @Override
    public void updateColor() {

    }
}
