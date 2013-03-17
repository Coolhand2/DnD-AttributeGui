package dnd.attributegui.classes;

public class Shaman extends BaseClass {

    /**
     *
     * @return
     */
    @Override
    public int[] getBonuses() {
        int[] local = {_bonuses[3], _bonuses[4], _bonuses[1], _bonuses[2], _bonuses[0], _bonuses[5]};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Shaman";
    }

    /**
     *
     * @return
     */
    @Override
    public int[] getRank() {
        int[] local = {4, 2, 3};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Leader";
    }
}
