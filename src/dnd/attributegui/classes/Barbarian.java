package dnd.attributegui.classes;

public class Barbarian extends BaseClass {

    /**
     *
     * @return
     */
    @Override
    public int[] getBonuses() {
        int[] local = {_bonuses[0], _bonuses[3], _bonuses[1], _bonuses[4], _bonuses[5], _bonuses[2]};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Barbarian";
    }

    /**
     *
     * @return
     */
    @Override
    public int[] getRank() {
        int[] local = {0, 2, 5};
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
