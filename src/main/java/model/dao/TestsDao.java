package model.dao;

import jersey.repackaged.com.google.common.base.Joiner;
import model.TestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pashe on 14-Nov-16.
 */
public class TestsDao implements Dao<TestTemplate>{
    @Override
    public List<TestTemplate> getAll() {
        return Database.selectTransactional(session -> session.createQuery("from TestTemplate").list());
    }

    @Override
    public List<TestTemplate> getAllWhere(String... hqlConditions) {
        String totalCondition = Joiner.on(" and ").join(Arrays.asList(hqlConditions));
        return Database.selectTransactional(session ->session.createQuery("from TetsTemplate where " + totalCondition).list());
    }

    @Override
    public void insert (TestTemplate test) { Database.doTransactional(session -> session.save(test));}

    public void delete (TestTemplate test) {
        Database.delete(test);
    }

    public void update(TestTemplate test){
        Database.update(test);
    }
}
