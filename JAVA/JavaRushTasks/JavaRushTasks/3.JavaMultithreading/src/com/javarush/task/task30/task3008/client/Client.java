package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;
import com.javarush.task.task30.task3008.Message;
import java.io.*;
import java.net.*;

/*
Чат (12)

Приступим к написанию клиента. Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера, подсоединиться к указанному адресу, получить запрос имени от сервера, спросить имя у пользователя, отправить имя пользователя серверу, дождаться принятия имени сервером. После этого клиент может обмениваться текстовыми сообщениями с сервером. Обмен сообщениями будет происходить в двух параллельно работающих потоках. Один будет заниматься чтением из консоли и отправкой прочитанного серверу, а второй поток будет получать данные от сервера и выводить их в консоль.

Начнем реализацию клиента:
1) Создай пакет client. В дальнейшем все классы, отвечающие за реализацию клиентов, создавай в этом пакете.
2) Создай класс Client.
3) Создай внутренний класс SocketThread унаследованный от Thread в классе Client. Он будет отвечать за поток, устанавливающий сокетное соединение и читающий сообщения сервера. 
    Класс должен иметь публичный модификатор доступа.
4) Создай поле Connection connection в классе Client. Используй модификатор доступа, который позволит обращаться к этому полю из класса потомков, но запретит обращение 
    из других классов вне пакета.
5) Добавь приватное поле-флаг boolean clientConnected в класс Client. Проинициализируй его значением false. В дальнейшем оно будет устанавливаться в true, если клиент подсоединен 
    к серверу или в false в противном случае. При объявлении этого поля используй ключевое слово, которое позволит гарантировать что каждый поток, использующий поле 
    clientConnected, работает с актуальным, а не кэшированным его значением.

Требования:
    •    Класс Client должен быть создан в пакете client.
    •    В классе Client должен быть создан публичный класс SocketThread унаследованный от Thread.
    •    В классе Client должно быть создано protected поле connection типа Connection.
    •    В классе Client должно быть создано private volatile поле clientConnected типа boolean.

Чат (13)

Продолжаем реализацию вспомогательных методов класса Client.

Добавь в класс методы, которые будут доступны классам потомкам, но не доступны из других классов вне пакета:
1. String getServerAddress() - должен запросить ввод адреса сервера у пользователя и вернуть введенное значение. Адрес может быть строкой, содержащей ip, 
    если клиент и сервер запущен на разных машинах или 'localhost', если клиент и сервер работают на одной машине.
2. int getServerPort() - должен запрашивать ввод порта сервера и возвращать его.
3. String getUserName() - должен запрашивать и возвращать имя пользователя.
4. boolean shouldSendTextFromConsole() - в данной реализации клиента всегда должен возвращать true (мы всегда отправляем текст введенный в консоль). 
    Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент, унаследованный от нашего, который не должен отправлять введенный в консоль текст.
5. SocketThread getSocketThread() - должен создавать и возвращать новый объект класса SocketThread.
6. void sendTextMessage(String text) - создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection.
Если во время отправки произошло исключение IOException, то необходимо вывести
информацию об этом пользователю и присвоить false полю clientConnected.

Требования:

    •    Метод getServerAddress должен возвращать строку (адрес сервера), считанную с консоли.
    •    Метод getServerPort должен возвращать число (порт сервера), считанное с консоли.
    •    Метод getUserName должен возвращать строку (имя пользователя), считанную с консоли.
    •    Метод shouldSendTextFromConsole должен возвращать true.
    •    Метод sendTextMessage должен создавать и отправлять новое текстовое сообщение используя connection и устанавливать флаг clientConnected в false, если во время отправки или создания сообщения возникло исключение IOException.
    •    Метод getSocketThread должен возвращать новый объект типа SocketThread.

Чат (15)

Напишем реализацию класса SocketThread. Начнем с простых вспомогательных методов.

Добавь методы, которые будут доступны классам потомкам и не доступны остальным классам вне пакета:
1) void processIncomingMessage(String message) - должен выводить текст message в консоль.
2) void informAboutAddingNewUser(String userName) - должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату.
3) void informAboutDeletingNewUser(String userName) - должен выводить в консоль, что участник с именем userName покинул чат.
4) void notifyConnectionStatusChanged(boolean clientConnected) - этот метод должен:
а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
б) Оповещать (пробуждать ожидающий) основной поток класса Client.

Подсказка: используй синхронизацию на уровне текущего объекта внешнего класса и метод notify. Для класса SocketThread внешним классом является класс Client.
Требования:

    • Метод processIncomingMessage должен выводить на экран сообщение полученное в качестве параметра.
    • Метод informAboutAddingNewUser должен выводить на экран сообщение о том что пользователь подключился к чату.
    • Метод informAboutDeletingNewUser должен выводить на экран сообщение о том что пользователь покинул чат.
    • Метод notifyConnectionStatusChanged должен устанавливать значение поля clientConnected внешнего объекта Client равным полученному параметру.
    • Метод notifyConnectionStatusChanged должен вызвать метод notify на внешнем объекте Client.

Чат (16)

Теперь все готово, чтобы дописать необходимые методы класса SocketThread.

1) Добавь protected метод clientHandshake() throws IOException, ClassNotFoundException. Этот метод будет представлять клиента серверу.
Он должен:
а) В цикле получать сообщения, используя соединение connection.
б) Если тип полученного сообщения NAME_REQUEST (сервер запросил имя), запросить ввод имени пользователя с помощью метода getUserName(), создать новое сообщение с типом MessageType.USER_NAME и введенным именем, отправить сообщение серверу.
в) Если тип полученного сообщения MessageType.NAME_ACCEPTED (сервер принял имя), значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет. Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true. После этого выйди из метода.
г) Если пришло сообщение с каким-либо другим типом, кинь исключение IOException("Unexpected MessageType").

2) Добавь protected метод void clientMainLoop() throws IOException, ClassNotFoundException. Этот метод будет реализовывать главный цикл обработки сообщений сервера. Внутри метода:
а) Получи сообщение от сервера, используя соединение connection.
б) Если это текстовое сообщение (тип MessageType.TEXT), обработай его с помощью метода processIncomingMessage().
в) Если это сообщение с типом MessageType.USER_ADDED, обработай его с помощью метода informAboutAddingNewUser().
г) Если это сообщение с типом MessageType.USER_REMOVED, обработай его с помощью метода informAboutDeletingNewUser().
д) Если клиент получил сообщение какого-либо другого типа, брось исключение IOException("Unexpected MessageType").
е) Размести код из предыдущих пунктов внутри бесконечного цикла. Цикл будет завершен автоматически если произойдет ошибка (будет брошено исключение) или поток, в котором работает цикл, будет прерван.

Требования:
    •    Метод clientHandshake должен отправлять новое сообщение (MessageType.USER_NAME, getUserName()) используя connection, если тип принятого сообщения равен MessageType.NAME_REQUEST.
    •    Метод clientHandshake должен вызывать метод notifyConnectionStatusChanged(true) и завершаться, если тип принятого сообщения равен MessageType.NAME_ACCEPTED.
    •    Метод clientHandshake должен бросать исключение IOException, если тип принятого сообщения не MessageType.NAME_ACCEPTED или не MessageType.NAME_REQUEST.
    •    Метод clientHandshake должен принимать сообщения от сервера до тех пор, пока тип сообщения равен MessageType.NAME_REQUEST.
    •    Метод clientMainLoop должен принимать сообщения от сервера до тех пор, пока тип сообщения равен MessageType.TEXT, MessageType.USER_REMOVED или MessageType.USER_ADDED.
    •    Метод clientMainLoop должен обрабатывать полученное сообщение с помощью метода processIncomingMessage, если тип принятого сообщения равен MessageType.TEXT.
    •    Метод clientMainLoop должен обрабатывать полученное сообщение с помощью метода informAboutAddingNewUser, если тип принятого сообщения равен MessageType.USER_ADDED.
    •    Метод clientMainLoop должен обрабатывать полученное сообщение с помощью метода informAboutDeletingNewUser, если тип принятого сообщения равен MessageType.USER_REMOVED.
    •    Метод clientMainLoop должен бросать исключение IOException, если тип принятого сообщения не MessageType.TEXT, MessageType.USER_REMOVED или не MessageType.USER_ADDED.

Чат (17)

Последний, но самый главный метод класса SocketThread - это метод void run(). Добавь его. Его реализация с учетом уже созданных методов выглядит очень просто.

Давай напишем ее:
1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
3) Создай объект класса Connection, используя сокет из п.17.2.
4) Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false в качестве параметра.

Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.
Требования:
    •    В методе run должно быть установлено и сохранено в поле connection соединение с сервером (для получения адреса сервера и порта используй методы getServerAddress и getServerPort).
    •    В методе run должен быть вызван метод clientHandshake.
    •    В методе run должен быть вызван метод clientMainLoop.
    •    При возникновении исключений IOException или ClassNotFoundException в процессе работы метода run, должен быть вызван метод notifyConnectionStatusChanged с параметром false.
    •    Заголовок метода run должен соответствовать условию задачи.

*/

public class Client {
    
    public class SocketThread extends Thread {

    // должен выводить текст message в консоль.        
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }    
    // должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату.    
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник " + userName + "присоединился к чату");
        }    
    // должен выводить в консоль, что участник с именем userName покинул чат.
        protected void informAboutDeletingNewUser(String userName) { 
            ConsoleHelper.writeMessage("Участник " + userName + "покинул чат");
        }    
        
    //а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
    //б) Оповещать (пробуждать ожидающий) основной поток класса Client.
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized(Client.this) {
                Client.this.notify();
            }    
        }

// а) В цикле получать сообщения, используя соединение connection.
// б) Если тип полученного сообщения NAME_REQUEST (сервер запросил имя), запросить ввод имени пользователя с помощью метода getUserName(), 
//    создать новое сообщение с типом MessageType.USER_NAME и введенным именем, отправить сообщение серверу.
// в) Если тип полученного сообщения MessageType.NAME_ACCEPTED (сервер принял имя), значит сервер принял имя клиента, нужно об этом сообщить главному потоку, 
//    он этого очень ждет. Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true. После этого выйди из метода.
// г) Если пришло сообщение с каким-либо другим типом, кинь исключение IOException("Unexpected MessageType").
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message;
            String userName;
            do {
                message = connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST) {
                        userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                } else
                    if(message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                        break;
                    } else
                        throw new IOException("Unexpected MessageType");
            } while(true);
        }
    
//Этот метод будет реализовывать главный цикл обработки сообщений сервера. Внутри метода:
//а) Получи сообщение от сервера, используя соединение connection.
//б) Если это текстовое сообщение (тип MessageType.TEXT), обработай его с помощью метода processIncomingMessage().
//в) Если это сообщение с типом MessageType.USER_ADDED, обработай его с помощью метода informAboutAddingNewUser().
//г) Если это сообщение с типом MessageType.USER_REMOVED, обработай его с помощью метода informAboutDeletingNewUser().
//д) Если клиент получил сообщение какого-либо другого типа, брось исключение IOException("Unexpected MessageType").
//е) Размести код из предыдущих пунктов внутри бесконечного цикла. Цикл будет завершен автоматически если произойдет ошибка (будет брошено исключение) или поток, 
//   в котором работает цикл, будет прерван.
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;
            String userName;
            while(true) {
                message = connection.receive();
                if(message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                else
                    if(message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                    else
                        if(message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                        else    throw new IOException("Unexpected MessageType");
            } 
        }
        
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket socket = new Socket(serverAddress, serverPort);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch(IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

    } // end of SocketThread class

    protected Connection connection;
    private volatile boolean clientConnected;

//    должен запросить ввод адреса сервера у пользователя и вернуть введенное значение. Адрес может быть строкой, содержащей ip, 
//    если клиент и сервер запущен на разных машинах или 'localhost', если клиент и сервер работают на одной машине
    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера (IP/localhost): ");
        String serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }
    
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }
    
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    
//  Метод sendTextMessage должен создавать и отправлять новое текстовое сообщение используя connection и устанавливать флаг clientConnected в false, если 
// во время отправки или создания сообщения возникло исключение IOException.
    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка передачи сообщения");
            clientConnected = false;
        }
    }
    
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized(this) {
            try {
                wait();
            } catch (InterruptedException e) {
                    ConsoleHelper.writeMessage("Произошла ошибка при создании потока");
            }
        }
        if(clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        String msg;
        while(clientConnected && (!"exit".equals(msg = ConsoleHelper.readString())) ) 
            if(shouldSendTextFromConsole()) sendTextMessage(msg);
    }
    
    public static void main(String[] args) throws Exception {
        Client client = new Client();    
        client.run();
    }    

}