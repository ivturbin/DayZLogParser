package dev.turbin.dayzlogparser;

import dev.turbin.dayzlogparser.model.ActionType;
import dev.turbin.dayzlogparser.model.Log;
import dev.turbin.dayzlogparser.model.PlayerListLog;
import dev.turbin.dayzlogparser.model.PlayerLog;
import dev.turbin.dayzlogparser.model.Position;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Arrays;

public class Parser {
    public static Log parse(String line) {
        String[] split = line.split("[\\s|\"()=<>,]+");
        if (split.length < 6 || split[0].equals("AdminLog")) {
            return null;
        }

        LocalTime time = LocalTime.parse(split[0]);

        if (split[2].equals("PlayerList")) {
            return new PlayerListLog(time, Integer.parseInt(split[4]));
        }

        String nickname = split[2];
        String id = split[4];

        if (split[split.length-1].equals("connected")) {
            return new PlayerLog(time, nickname, id, null, ActionType.connected, null);
        }

        if (split[split.length-1].equals("disconnected")) {
            return new PlayerLog(time, nickname, id, null, ActionType.disconnected, null);
        }

        ActionType actionType = ActionType.no;
        String action = "";

        if (split.length > 9) {
            if (split[9].equals("[HP:")) {
                actionType = ActionType.hit;

            } else if (split[9].equals("placed")) {
                actionType = ActionType.placed;
            }

            action = String.join(" ", Arrays.asList(split).subList(9, split.length));
        }



        return new PlayerLog(time,
                nickname,
                id,
                new Position(new BigDecimal(split[6]),
                        new BigDecimal(split[7]),
                        new BigDecimal(split[8])),
                actionType,
                action);
    }
}
