package container.advanced;

/**
 * @Author: shenge
 * @Date: 2020-04-19 10:08
 */
import java.util.NavigableMap;
import java.util.concurrent.*;

import static container.advanced.HTMLColors.*;


public class NavMap {
    public static final
    NavigableMap<Integer,String> COLORS =
            new ConcurrentSkipListMap<>(MAP);
    public static void main(String[] args) {
        show(COLORS.firstEntry());
        border();
        show(COLORS.lastEntry());
        border();
        NavigableMap<Integer, String> toLime =
                COLORS.headMap(rgb("Lime"), true);
        show(toLime);
        border();
        show(COLORS.ceilingEntry(rgb("DeepSkyBlue") - 1));
        border();
        show(COLORS.floorEntry(rgb("DeepSkyBlue") - 1));
        border();
        show(toLime.descendingMap());
        border();
        show(COLORS.tailMap(rgb("MistyRose"), true));
        border();
        show(COLORS.subMap(
                rgb("Orchid"), true,
                rgb("DarkSalmon"), false));
    }
}
