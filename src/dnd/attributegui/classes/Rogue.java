package dnd.attributegui.classes;

public class Rogue extends BaseClass {

    /**
     *
     * @return
     */
    @Override
    public int[] getBonuses() {
        int[] local = {_bonuses[1], _bonuses[0], _bonuses[3], _bonuses[4], _bonuses[5], _bonuses[2]};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Rogue";
    }

    /**
     *
     * @return
     */
    @Override
    public int[] getRank() {
        int[] local = {1, 0, 5};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Striker";
    }
}
