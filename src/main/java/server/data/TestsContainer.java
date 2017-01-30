package server.data;

/**
 * Created by pashe on 14-Nov-16.
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.TestTemplate;
import model.dao.TestsDao;
import server.auth.Authentication;

import java.util.ArrayList;
import java.util.*;
public class TestsContainer {

    private static final Logger log = LogManager.getLogger(Authentication.class);
    private static TestsDao testsDao = new TestsDao();

    public static ArrayList<TestTemplate> getTests(int N){
        List<TestTemplate> allTests = testsDao.getAll();
        return new ArrayList<TestTemplate>(allTests);
    }
    public static TestTemplate GetRandomOne(){
        List<TestTemplate> allTests = testsDao.getAll();
        Random random = new Random();
        return allTests.get(random.nextInt(allTests.size()));
    }
}
