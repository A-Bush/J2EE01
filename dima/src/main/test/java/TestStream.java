import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 /*
 * �������� �������.
 * ���� ����, � ������� �������� ������ � ����������� - ���, �������, �������, ��������. ������ ��������� ����������, ��������:
 *
 * Dmitriy:Titov:23:1500
 * Denis:Bidnenko:27:2400
 * Slavik:Sokolov:23:1700
 * Denis:Bidnenko:27:2400
 *
 * � ����� ���� ������������� ������(���������). �������� JUnit ����, � ������� ���� ������ ���:
 * 1) �������� ���������� ����������;
 * 2) �������� List ���������� �������;
 * 3) �������� ��������� �������� ���� �����������, ������� ���������;
 * 4) �������� ���������� � ���������� ���������� � ����� ����.
 *
 * ���������� ��������� � ������� Java 8 Streams API.
 * ��������� � Streams API - https://habrahabr.ru/company/luxoft/blog/270383/
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
