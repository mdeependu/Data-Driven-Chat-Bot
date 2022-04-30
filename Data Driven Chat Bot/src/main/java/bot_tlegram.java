import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot_tlegram extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Minor_telebot";
    }

    @Override
    public String getBotToken() {
        return "2056095550:AAH0cmr2206bJlcCt3_OVbYL4GTaRWvpKW8";
    }

    @Override
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables

            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

                SendMessage message = new SendMessage();
                reply_generate flag=new reply_generate();

            try {
                message.setText(flag.getReply(message_text));
            } catch (Exception e) {
                e.printStackTrace();
            }
            message.setChatId(String.valueOf(update.getMessage().getChatId()));

            try{
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}

