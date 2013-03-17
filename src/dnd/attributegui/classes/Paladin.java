package dnd.attributegui.classes;

public class Paladin extends BaseClass {

    /**
     *
     * @return
     */
    @Override
    public int[] getBonuses() {
        int[] local = {_bonuses[0], _bonuses[4], _bonuses[3], _bonuses[5], _bonuses[2], _bonuses[1]};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Paladin";
    }

    /**
     *
     * @return
     */
    @Override
    public int[] getRank() {
        int[] local = {0, 5, 4};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getRole() {
        return "Defender";
    }
}
