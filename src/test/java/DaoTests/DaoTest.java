package DaoTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import server.auth.Authentication;
import model.TestTemplate;
import model.dao.TestsDao;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Alex on 06.11.2016.
 */
public class DaoTest {
    private TestsDao testsDao = new TestsDao();
    private static final Logger log = LogManager.getLogger(Authentication.class);

    private TestTemplate Car;

    {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("1");
        temp.add("2");
        temp.add("3");
        temp.add("4");
        ArrayList<BufferedImage> img = new ArrayList<>();
        try {
            img.add(ImageIO.read(new File("temp.jpg")));
        }
        catch (IOException e){
        }


        Car = new TestTemplate()
                .SetImage(img)
                .SetVariants(temp, 3);

    }

    @Test
    public void insertCarTest() throws Exception {
        int before = testsDao.getAll().size();
        testsDao.insert(Car);
        assertEquals(before + 1, testsDao.getAll().size());
    }

    @Test
    public void getAllTest() throws Exception{
        int size = testsDao.getAll().size();

    }
}