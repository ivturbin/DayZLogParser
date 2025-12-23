package dev.turbin.dayzlogparser.model;

import java.time.LocalTime;

public class PlayerLog extends Log {

    private final String nickname;
    private final String id;
    private final Position position;
    private final ActionType actionType;
    private final String action;

    public PlayerLog(LocalTime time, String nickname, String id, Position position, ActionType actionType, String action) {
        super(time);
        this.nickname = nickname;
        this.id = id;
        this.position = position;
        this.actionType = actionType;
        this.action = action;
    }

    public String getNickname() {
        return nickname;
    }

    public String getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public String toString() {
        return "PlayerLog{" +
                "time: " + this.getTime() + ", " +
                "nickname='" + nickname + '\'' +
                ", id='" + id + '\'' +
                ", position=" + position +
                ", actionType=" + actionType +
                '}';
    }

    public String getAction() {
        return action;
    }
}
