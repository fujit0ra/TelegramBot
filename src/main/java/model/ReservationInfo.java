package model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationInfo {

    private String meetStart;

    private String meetFinish;

    private String theme;

    private String room;

    /**
     * 10:00 19.06.2019 / 10:30 19.06.2019 / Синяя / Очень длинная тема - Форма отправки
     * @param textMessage
     */

    public ReservationInfo(String textMessage) {
        int count = 4;
        if (textMessage != null && !textMessage.isEmpty()) {
            String[] params = textMessage.split("/");
            if (params != null && params.length == count)
                for (int i = 0; i < count; i++) {
                    if (i == 0) {
                        this.meetStart = params[i].trim();
                    } else if (i == 1) {
                        this.meetFinish = params[i].trim();
                    } else if (i == 2) {
                        this.room = params[i].trim();
                    } else if (i == 3) {
                        this.theme = params[i].trim();
                    }
                }
        }

    }

    /**
     *
     * @param str_date
     * @return
     * //TODO Конвертация времени

    public static Timestamp convert(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("HH:mm MMM dd yyyy");
            Date date = formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }
     */



    @Override
    public String toString() {
        return "Информация о бронировании:\n" +
                "Начало собрания: '" + meetStart + "\',\n" +
                "Конец собрания: '" + meetFinish + "\',\n" +
                "Тема: '" + theme + "\',\n" +
                "Комната: '" + room + "\',\n"
                ;
    }
}
