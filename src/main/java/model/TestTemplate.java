package model;

import java.awt.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.*;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import model.TestTemplate;
/**
 * Created by pashe on 14-Nov-16.
 */

@Entity
@Table(name = "tests")
public class TestTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private ArrayList<Image> images;
    @Column
    private ArrayList<String> variants;
    @Column
    private int correctVariant;

    private static Gson gson = new GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static String writeJSON(ArrayList<TestTemplate> toConvert){
        return gson.toJson(toConvert);
    }

    public static ArrayList<TestTemplate> parseJSON(String rawJSON) {
        return gson.fromJson(rawJSON, new TypeToken<ArrayList<TestTemplate>>(){}.getType());
    }
}
