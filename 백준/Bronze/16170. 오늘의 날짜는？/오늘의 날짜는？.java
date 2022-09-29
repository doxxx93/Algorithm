import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy\nMM\ndd"));
        System.out.println(format);
    }
}
