package com.epam.rd.autotasks;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        Map <Character, Integer> field = new HashMap<Character, Integer>();
        field.put('A', 1);
        field.put('B', 2);
        field.put('C', 3);
        field.put('D', 4);
        field.put('E', 5);
        field.put('F', 6);
        field.put('G', 7);
        field.put('H', 8);

        int shotPos = field.get(shot.charAt(0)) -1 + (Integer.parseInt(String.valueOf(shot.charAt(1))) - 1) * 8;

        boolean is = false;
        StringBuilder mapShots = new StringBuilder(String.format("%64s",Long.toBinaryString(shots)).replace(' ', '0'));
        String mapShips = String.format("%64s",Long.toBinaryString(ships)).replace(' ', '0');

        if (mapShips.charAt(shotPos) == '1') {
            is = true;
        }

        shots = shots | (1L << (63 - shotPos));
        return is;
    }

    public String state() {
        String mapShips = String.format("%64s",Long.toBinaryString(ships)).replace(' ', '0');
        String mapShots = String.format("%64s",Long.toBinaryString(shots)).replace(' ', '0');

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (mapShots.charAt(i * 8 + j) == '0' && mapShips.charAt(i * 8 + j) == '0') {
                    stringBuilder.append('.');
                }
                else if (mapShots.charAt(i * 8 + j) == '0' && mapShips.charAt(i * 8 + j) == '1') {
                    stringBuilder.append('☐');
                }
                else if (mapShots.charAt(i * 8 + j) == '1' && mapShips.charAt(i * 8 + j) == '0') {
                    stringBuilder.append('×');
                }
                else if (mapShots.charAt(i * 8 + j) == '1' && mapShips.charAt(i * 8 + j) == '1') {
                    stringBuilder.append('☒');
                }
            }

            stringBuilder.append("\n");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
