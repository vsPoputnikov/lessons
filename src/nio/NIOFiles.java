package nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class NIOFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("nio.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 60; i++) {
            stringBuilder.append(i).append("\n");

        }
        writeToFile(file.toPath(), stringBuilder.toString());
        readFromFile(file.toPath());
    }

    public static void writeToFile(Path path, String string) throws IOException {
      Files.write(path, string.getBytes(), StandardOpenOption.WRITE);
       /* try(FileChannel channel =
                    (FileChannel) Files.newByteChannel(path, StandardOpenOption.WRITE)){
            ByteBuffer byteBuffer = ByteBuffer.allocate(string.getBytes().length);
            byteBuffer.put(string.getBytes(Charset.forName("utf-8")));
            byteBuffer.flip();
            int written = channel.write(byteBuffer);
            System.out.println("written: " + written + " bytes to file: " + path.getFileName());
        }*/

    }

    public static void readFromFile(Path path) throws IOException {
         try (FileChannel channel =
                     (FileChannel) Files.newByteChannel(path)){
            int count = 0;
            ByteBuffer buffer = ByteBuffer.allocate(10);
            do {
                count = channel.read(buffer);

                if (count!=-1) {
                    System.out.println("Прочитано " + count);
                    buffer.rewind();
                    StringBuilder builder = new StringBuilder();

                    builder.append(new String(buffer.array(),0,buffer.remaining()));
                    System.out.println(builder.toString());
                }
            } while (count != -1);

        }

     /*   List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String str: lines){
            System.out.println(str);
        }*/
     // Files.lines(path,StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
