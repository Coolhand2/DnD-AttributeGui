package dnd.attributegui.classes;

public class Druid extends BaseClass {

    /**
     *
     * @return
     */
    @Override
    public int[] getBonuses() {
        int[] local = {_bonuses[3], _bonuses[1], _bonuses[2], _bonuses[4], _bonuses[0], _bonuses[5]};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Druid";
    }

    /**
     *
     * @return
     */
    @Override
    public int[] getRank() {
        int[] local = {4, 1, 2};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Controller";
    }
}
