import dao.HumanDao;
import dao.PassportDao;
import entity.Human;
import entity.PassportData;
import org.junit.Test;

public class DaoTest {

    @Test
    public void testHumanDaoSave() throws Exception{
        Human human = new Human("Bobrov", "Vasa", 27, 170.50, 84, 1);
        HumanDao humanDao = new HumanDao();
        humanDao.save(human);
    }

    @Test
    public void testPassportDaoSave() throws Exception{
        PassportData passportData = new PassportData("ME", 1244, 1);
        PassportDao passportDao = new PassportDao();
        passportDao.save(passportData);
    }
}
