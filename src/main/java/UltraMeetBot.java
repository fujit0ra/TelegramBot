import model.Reservation;

import model.ReservationInfo;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class UltraMeetBot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new UltraMeetBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * Отправка сообщения
     *
     * @param message
     * @param text
     */

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ответ пользователю
     *
     * @param update
     */

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        User user = message.getFrom();
        String first_name = user.getFirstName();
        String last_name = user.getLastName();
        ReservationInfo reservationInfo = new ReservationInfo(message.getText());
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "Форма заполнения, для бронирования комнаты: \nHH:mm dd.MM.yyyy - начало бронирования /\n HH:mm dd.MM.yyyy - конец бронирования /\n Переговорка /\n Тема");
                    break;
                case "/start":
                    sendMsg(message, "Добро пожаловать " + last_name + " " + first_name);
                    break;
                default:
                    sendMsg(message, last_name + " " + first_name + ", Вы успешно забронировали \nпереговорную комнату: \n" + reservationInfo);
            }
            fillReservation(message);
        }
    }

    /**
     * 10:00 19.06.2019 / 10:30 19.06.2019 / Синяя / Очень длинная тема - Форма отправки
     *
     * @param message
     * @return
     */

    private Reservation fillReservation(Message message) {
        if (message != null) {
            Reservation reservation = new Reservation();
            User user = message.getFrom();
            String first_name = user.getFirstName();
            String last_name = user.getLastName();
            reservation.setBooker(first_name + " " + last_name);
            ReservationInfo reservationInfo = new ReservationInfo(message.getText());

            return reservation;
        }
        return null;
    }

    /**
     * @param updates
     */

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update : updates) {
            onUpdateReceived(update);
        }
    }

    public String getBotUsername() {
        return "UltraMeetingBot";
    }

    public String getBotToken() {
        return "711723472:AAFqZ7qY5Z2GbEyEcWhn0Q69p6nbBHOTJ_Y";
    }
}
