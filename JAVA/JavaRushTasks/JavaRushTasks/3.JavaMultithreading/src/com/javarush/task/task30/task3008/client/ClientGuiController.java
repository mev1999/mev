package com.javarush.task.task30.task3008.client;


public class ClientGuiController extends Client{
    
    public class GuiSocketThread extends Client.SocketThread {
        @Override
        //должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }    
        
    // должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.   
        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }    
    // должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
        @Override
        protected void informAboutDeletingNewUser(String userName) { 
            model.deleteUser(userName);
            view.refreshUsers();
        }
        
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    
    }
    
    private ClientGuiModel model;
    private ClientGuiView view;
    
    public ClientGuiController() {
        this.model = new ClientGuiModel();
        this.view = new ClientGuiView(this);
    }
    
    @Override
    // должен создавать и возвращать объект типа GuiSocketThread
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    // должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run()
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    @Override
    //  getServerAddress(), getServerPort(), getUserName() Они должны вызывать одноименные методы из представления (view).
    protected String getServerAddress() {
        return view.getServerAddress();
    }
    
    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }
    
    public ClientGuiModel getModel() {
        return model;
    }

    public static void main(String[] args) throws Exception {
        ClientGuiController controller = new ClientGuiController();    
        controller.run();
    }    
}