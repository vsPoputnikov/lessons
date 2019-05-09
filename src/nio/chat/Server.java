package nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    public void start(){
        // запускаем один поток для обработки всех соединений
        new Thread(new NioThread()).start();

    }

    private class NioThread extends Worker{
        private static final int BUF_SIZE = 1024;

        private ByteBuffer byteBuffer;
        private ServerSocketChannel serverChannel;
        private Selector selector;

        @Override
        protected void init() throws IOException {
            // создаём буфер
            byteBuffer = ByteBuffer.allocate(BUF_SIZE);

            selector = Selector.open();

            // открываем канал сервера
            serverChannel = ServerSocketChannel.open();

            serverChannel.bind(new InetSocketAddress(12345));

            // перевод в неблокирующий режим
            serverChannel.configureBlocking(false);

            // регистрируем канал в селекторе на все допустимые события
            serverChannel.register(selector,serverChannel.validOps());


        }

        @Override
        protected void loop() throws IOException {
            // ожидание новых сообщений
            selector.select();

            // получаем ключи, на которые пришли события
            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();

            // обрабатываем все ключи
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                // флаг isAcceptable означает, что пришло входящее подключение
                // можно получать новый канал для этого соединения
                if(key.isAcceptable()){
                    // Получение канала
                    SocketChannel channel = serverChannel.accept();
                    // переводим в неблокируемый режим
                    channel.configureBlocking(false);
                    // регистрируем в селекторе
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Client connected " + channel.getRemoteAddress());
                }
                // флаг isReadable означает, что пришли данные для чтения
                else if (key.isReadable()){
                    // читаем входящие данные
                    System.out.println("читаем входящие данные...");
                    readData((SocketChannel)key.channel());
                }
                //isValid проверяет, что соединение открыто
                // isWritable проверяет, что в канал можно записывать данные
                else if (key.isValid()&&key.isWritable()){
                    // записываем данные в канал
                    System.out.println("запись данных в каналю...");
                    writeData((SocketChannel)key.channel(), key);

                }
                iterator.remove();
            }
        }

        @Override
        protected void stop() throws IOException {
            serverChannel.close();
            selector.close();
        }
        private void readData(SocketChannel channel){
            // готовим буфер для чтения данных
            byteBuffer.clear();

            try{
                int read = channel.read(byteBuffer);
                if(read!=-1) {
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position(), Charset.forName("utf-8")));

                } else {
                    System.out.println("client disconected " + channel.getRemoteAddress());
                    channel.close();
                }

                // готовим буфер для записи
                byteBuffer.flip();

                Set<SelectionKey> keys = selector.keys();
                for(SelectionKey key: keys){
                    if ((key.channel().validOps()&SelectionKey.OP_WRITE)>0){
                        key.interestOps(key.interestOps()|SelectionKey.OP_WRITE);
                    }
                }
            }catch (Exception e){
                System.out.println("client disconnected");
                byteBuffer.clear();
                try {
                    channel.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        private void writeData(SocketChannel channel, SelectionKey key) throws IOException {
            // записываем данные из буфера
            channel.write(byteBuffer);
            // готовим для следующей записи
            byteBuffer.rewind();
            key.interestOps(key.interestOps()&~SelectionKey.OP_WRITE);
        }
    }
}
