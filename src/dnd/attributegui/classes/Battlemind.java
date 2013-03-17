package dnd.attributegui.classes;

public class Battlemind extends BaseClass {

    /**
     *
     * @return
     */
    @Override
    public int[] getBonuses() {
        int[] local = {_bonuses[3], _bonuses[4], _bonuses[0], _bonuses[5], _bonuses[1], _bonuses[2]};
        return local;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Battlemind";
    }

    /**
     *
     * @return
     */
    @Override
    public int[] getRank() {
        int[] local = {2, 4, 5};
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
