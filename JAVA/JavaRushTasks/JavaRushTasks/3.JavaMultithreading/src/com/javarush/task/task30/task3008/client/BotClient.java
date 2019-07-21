package com.javarush.task.task30.task3008.client;

import java.lang.Math.*;
import java.util.*;
import java.io.*;
import com.javarush.task.task30.task3008.*;
import com.javarush.task.task30.task3008.Message;
import java.text.SimpleDateFormat;

/*
Чат (18)

Иногда бывают моменты, что не находится достойного собеседника. Не общаться же с самим собой :). Давай напишем бота, который будет представлять собой клиента, который 
автоматически будет отвечать на некоторые команды. Проще всего реализовать бота, который сможет отправлять текущее время или дату, когда его кто-то об этом попросит.

С него и начнем:
1) Создай новый класс BotClient в пакете client. Он должен быть унаследован от Client.
2) В классе BotClient создай внутренний класс BotSocketThread унаследованный от SocketThread. Класс BotSocketThread должен быть публичным.
3) Переопредели методы:
а) getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
б) shouldSendTextFromConsole(). Он должен всегда возвращать false. Мы не хотим, чтобы бот отправлял текст введенный в консоль.
в) getUserName(), метод должен генерировать новое имя бота, например: date_bot_X, где X - любое число от 0 до 99. Для генерации X используй метод Math.random().
4) Добавь метод main. Он должен создавать новый объект BotClient и вызывать у него метод run().

Требования:
    •    В пакете client должен быть создан класс BotClient являющийся потомком класса Client.
    •    В классе BotClient должен быть создан внутренний публичный класс BotSocketThread являющийся потомком класса SocketThread.
    •    В классе BotClient должен быть переопределен метод getSocketThread возвращающий новый объект класса BotSocketThread.
    •    В классе BotClient должен быть переопределен метод shouldSendTextFromConsole всегда возвращающий false.
    •    В классе BotClient должен быть переопределен метод getUserName возвращающий имя бота по формату указанному в условии задачи.
    •    В методе main класса BotClient должен быть создан новый объект класса BotClient и у него должен быть вызван метод run.
*/
public class BotClient extends Client {
    
    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;
            String userName;
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    
        @Override
        // должен выводить текст message в консоль.        
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
    //        if(message.getType() == MessageType.TEXT) { // рассматриваем только текстовые сообщения
            if (message != null && message.contains(": ")) {
                String[] data = message.split(": "); // разбили строку на имя и текст
                if(data.length == 2) { // массив - 0 - имя, 1 - запрос
                        String dateFormat = "";
                        if("дата".equals(data[1])) dateFormat = "d.MM.YYYY";
                        if("день".equals(data[1])) dateFormat = "d";
                        if("месяц".equals(data[1])) dateFormat = "MMMM";
                        if("год".equals(data[1])) dateFormat = "YYYY";
                        if("время".equals(data[1])) dateFormat = "H:mm:ss";
                        if("час".equals(data[1])) dateFormat = "H";
                        if("минуты".equals(data[1])) dateFormat = "m";
                        if("секунды".equals(data[1])) dateFormat = "s";
                        
                        if(!dateFormat.isEmpty()) {
                            GregorianCalendar calendar = new GregorianCalendar();
                            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
                            String dateText = formatter.format(calendar.getTime());
                            sendTextMessage("Информация для " + data[0] + ": "+ dateText);
                        }    
                }
            }    
        }    
 
    }
    
    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }
    
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        StringBuilder botName = new StringBuilder("date_bot_");
        int botNum = (int)(Math.random()*100);
        return botName + Integer.toString(botNum);
    }   



    public static void main(String[] args) throws Exception {
        BotClient client = new BotClient();    
        client.run();
    }    

}

