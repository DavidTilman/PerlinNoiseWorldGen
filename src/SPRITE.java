import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public enum SPRITE {
    AIR(0, 3, null, new SPRITEGROUP[] { SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.AIR }),
    RED(22,4,null, null),
    GREEN(21,4,null, null),
    BLUE(21,5,null, null),
    WHITE(22,5,null, null),

    GRASS_0(0,0, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_1(1,0, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_2(2,0, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_3(0,1, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_4(1,1, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_5(2,1, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_6(0,2, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_7(1,2, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    GRASS_8(2,2, SPRITEGROUP.GRASS, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),

    ROCK_0(0,0, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_1(1,0, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_2(2,0, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_3(0,1, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_4(1,1, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_5(2,1, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_6(0,2, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_7(1,2, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_8(2,2, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),

    WATER(8,11, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER}),
    DEEPWATER(23,11, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER}),
    TREE(1,8, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.TREE}),
    TREE_1(10,8, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1}),

    ROCK_TLO(0, 4, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK}),
    ROCK_T(1, 4, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_TRO(2,4, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS}),
    ROCK_L(0,5, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK}),
    ROCK_R(2,5, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS}),
    ROCK_BLO(0,6, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    ROCK_B(1,6, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    ROCK_BRO(2,6, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    ROCK_TLI(3, 4, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_TRI(4, 4, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK}),
    ROCK_BLI(3, 5, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK}),
    ROCK_BRI(4, 5, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS}),
    ROCK_BROTLO(3, 6, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.ROCK, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.ROCK}),
    ROCK_BLOTLO(4, 6, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.ROCK, SPRITEGROUP.ROCK, SPRITEGROUP.GRASS}),

    WATER_TLO(7, 10, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.WATER}),
    WATER_T(8, 10, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.WATER, SPRITEGROUP.WATER}),
    WATER_TRO(9,10, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.WATER, SPRITEGROUP.GRASS}),
    WATER_L(7,11, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.WATER, SPRITEGROUP.GRASS, SPRITEGROUP.WATER}),
    WATER_R(9,11, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.GRASS, SPRITEGROUP.WATER, SPRITEGROUP.GRASS}),
    WATER_BLO(7,12, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.WATER, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    WATER_B(8,12, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    WATER_BRO(9,12, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    WATER_TLI(10, 10, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER}),
    WATER_TRI(11, 10, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.GRASS, SPRITEGROUP.WATER, SPRITEGROUP.WATER}),
    WATER_BLI(10, 11, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.GRASS, SPRITEGROUP.WATER}),
    WATER_BRI(11, 11, SPRITEGROUP.WATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.GRASS}),

    TREE_TLO(0, 7, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE}),
    TREE_T(1, 7, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.TREE}),
    TREE_TRO(2,7, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.AIR}),
    TREE_L(0,8, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.TREE}),
    TREE_R(2,8, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.AIR}),
    TREE_BLO(0,9, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.AIR}),
    TREE_B(1,9, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.AIR}),
    TREE_BRO(2,9, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.AIR}),
    TREE_TLI(6, 7, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.TREE}),
    TREE_TRI(7, 7, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.TREE}),
    TREE_BLI(6, 8, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.TREE}),
    TREE_BRI(7, 8, SPRITEGROUP.TREE, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.AIR}),
    TREE_BROTLO(6, 9, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.TREE, SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE}),
    TREE_BLOTLO(7, 9, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE, SPRITEGROUP.TREE, SPRITEGROUP.AIR}),

    TREE_1_TLO(9, 7, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1}),
    TREE_1_T(10, 7, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1}),
    TREE_1_TRO(11,7, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR}),
    TREE_1_L(9,8, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1}),
    TREE_1_R(11,8, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR}),
    TREE_1_BLO(9,9, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.AIR}),
    TREE_1_B(10,9, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.AIR}),
    TREE_1_BRO(11,9, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.AIR}),
    TREE_1_TLI(15, 7, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1}),
    TREE_1_TRI(16, 7, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1}),
    TREE_1_BLI(15, 8, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1}),
    TREE_1_BRI(16, 8, SPRITEGROUP.TREE_1, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR}),
    TREE_1_BROTLO(15, 9, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.TREE_1, SPRITEGROUP.AIR, SPRITEGROUP.AIR, SPRITEGROUP.TREE_1}),
    TREE_1_BLOTLO(16, 9, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.AIR, SPRITEGROUP.TREE_1, SPRITEGROUP.TREE_1, SPRITEGROUP.AIR}),

    DEEPWATER_TLO(22, 10, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER}),
    DEEPWATER_T(23, 10, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER}),
    DEEPWATER_TRO(24,10, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER}),
    DEEPWATER_L(22,11, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER}),
    DEEPWATER_R(24,11, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER}),
    DEEPWATER_BLO(22,12, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER}),
    DEEPWATER_B(23,12, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER}),
    DEEPWATER_BRO(24,12, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER, SPRITEGROUP.WATER}),
    DEEPWATER_TLI(25, 10, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER}),
    DEEPWATER_TRI(26, 10, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER}),
    DEEPWATER_BLI(25, 11, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER, SPRITEGROUP.DEEPWATER}),
    DEEPWATER_BRI(26, 11, SPRITEGROUP.DEEPWATER, new SPRITEGROUP[] {SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.DEEPWATER, SPRITEGROUP.WATER}),

    DESERT_TLO(22, 0, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT}),
    DESERT_T(23, 0, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.DESERT}),
    DESERT_TRO(24,0, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS}),
    DESERT_L(22,1, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT}),
    DESERT_R(24,1, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS}),
    DESERT_BLO(22,2, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    DESERT_B(23,2, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.DESERT, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    DESERT_BRO(24,2, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS}),
    DESERT_TLI(25, 0, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.DESERT, SPRITEGROUP.DESERT}),
    DESERT_TRI(26, 0, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.DESERT}),
    DESERT_BLI(25, 1, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.DESERT, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT}),
    DESERT_BRI(26, 1, SPRITEGROUP.DESERT, new SPRITEGROUP[] {SPRITEGROUP.DESERT, SPRITEGROUP.DESERT, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS}),
    DESERT_BROTLO(25, 2, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.DESERT, SPRITEGROUP.GRASS, SPRITEGROUP.GRASS, SPRITEGROUP.DESERT}),
    DESERT_BLOTLO(26, 2, SPRITEGROUP.ROCK, new SPRITEGROUP[] {SPRITEGROUP.GRASS, SPRITEGROUP.DESERT, SPRITEGROUP.DESERT, SPRITEGROUP.GRASS}),
    ;

    public final int i;
    public final SPRITEGROUP g;
    public final SPRITEGROUP[] corners;

    SPRITE(int x, int y, SPRITEGROUP g, SPRITEGROUP[] corners) {
        this.i = y*27+x;
        this.g = g;
        this.corners = corners;
    }

    public static SPRITE fromGroup(Random rand, SPRITEGROUP g) {
        SPRITE[] sprites = Arrays.stream(values()).filter(x -> x.g == g).toArray(SPRITE[]::new);
        return sprites[rand.nextInt(sprites.length)];
    }

    public static SPRITE fromEdges(SPRITEGROUP[] corners, Random rand) {
        ArrayList<SPRITE> possibilities = new ArrayList<SPRITE>();
        for (SPRITE s : values()) {
            if (s.corners == null) continue;

            boolean found = true;
            for (int i = 0; i < s.corners.length; i++) {
                if (s.corners[i] != corners[i]) {
                    found = false;
                    break;
                }
            }

            if (found) {
                possibilities.add(s);
            }
        }
        if (possibilities.isEmpty()) return RED;

        return possibilities.get(rand.nextInt(possibilities.size()));
    }

    public SPRITEGROUP getGroup() {
        return g;
    }
}
