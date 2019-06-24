package model;

import java.sql.Timestamp;

/**
 * Сущность, соотвтествующая таблице reservation
 */
public class Reservation {

    private Long id;

    private Long idMeetRoom;

    private String booker;

    private Timestamp meetStart;

    private Timestamp meetFinish;

    private String theme;

    private MeetingRoom room;

    public Reservation() {
    }

    public Reservation(Long idMeetRoom, String booker, Timestamp meetStart, Timestamp meetFinish, String theme) {
        this.idMeetRoom = idMeetRoom;
        this.booker = booker;
        this.meetStart = meetStart;
        this.meetFinish = meetFinish;
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMeetRoom() {
        return idMeetRoom;
    }

    public void setIdMeetRoom(Long idMeetRoom) {
        this.idMeetRoom = idMeetRoom;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public Timestamp getMeetStart() {
        return meetStart;
    }

    public void setMeetStart(Timestamp meetStart) {
        this.meetStart = meetStart;
    }

    public Timestamp getMeetFinish() {
        return meetFinish;
    }

    public void setMeetFinish(Timestamp meetFinish) {
        this.meetFinish = meetFinish;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public void setRoom(MeetingRoom room) {
        this.room = room;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
