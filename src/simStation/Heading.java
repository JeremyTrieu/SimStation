package simStation;

import mvc.Utilities;

public enum Heading
{
    NORTH, EAST, SOUTH, WEST;

    public static Heading random() {
        int h = Utilities.rng.nextInt(4);
        if( h==0 ) return NORTH;
        if( h==1 ) return EAST;
        if( h==2 ) return SOUTH;
        if( h==3 ) return WEST;
        return null;
    }

    public static Heading parse(String str) {
        if( str.equalsIgnoreCase("north") ) return NORTH;
        if( str.equalsIgnoreCase("east") )  return EAST;
        if( str.equalsIgnoreCase("south") ) return SOUTH;
        if( str.equalsIgnoreCase("west") )  return WEST;
        Utilities.error("invalid heading " + str);
        return null;
    }

    public static int[] diff(Heading h) {
        if( h==NORTH ) return new int[] {0, -1};
        if( h==EAST )  return new int[] {1, 0};
        if( h==SOUTH ) return new int[] {0, 1};
        if( h==WEST )  return new int[] {-1, 0};
        Utilities.error("invalid heading");
        return null;
    }
}