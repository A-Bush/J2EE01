import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 /*
 * Домашнее задание.
 * Есть файл, в котором записаны данные о сотрудниках - имя, фамилия, возраст, зарплата. Данные разделены двоеточием, например:
 *
 * Dmitriy:Titov:23:1500
 * Denis:Bidnenko:27:2400
 * Slavik:Sokolov:23:1700
 * Denis:Bidnenko:27:2400
 *
 * В файле есть повторяющийся записи(дубликаты). Написать JUnit тест, в котором есть методы для:
 * 1) подсчета количества дубликатов;
 * 2) возврата List уникальных записей;
 * 3) подсчета суммарной зарплаты всех сотрудников, включая дубликаты;
 * 4) удаления дубликатов и перезаписи результата в новый файл.
 *
 * Желательно выполнить с помощью Java 8 Streams API.
 * Подробнее о Streams API - https://habrahabr.ru/company/luxoft/blog/270383/
 */

public class TestStream {

    @Test
    public void uniqList() {
        try {
            Stream<String> stringStream = Files.lines(Paths.get("TempSQl"));
            //List<String> list = Stream<String>(Files.lines(Paths.get("TempSQL"))).distinct().collect(Collectors.toList());
            List<String> list = stringStream.distinct().collect(Collectors.toList());
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sumDubl() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
