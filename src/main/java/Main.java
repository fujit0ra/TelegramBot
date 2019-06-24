import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) {

        ApiContextInitializer.init();
        // Initialize Api Context

        TelegramBotsApi botsApi = new TelegramBotsApi();
        // Instantiate Telegram Bots API

        try {
            botsApi.registerBot(new UltraMeetBot());
            System.out.println("Bot Start!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        // Register our bot
    }
}
