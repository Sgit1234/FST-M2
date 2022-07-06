package examples;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class Activity1 {

    static ArrayList<String> list;

    @BeforeEach
    public void setUp(){

        list = new ArrayList<String>();
        list.add("Alpha");
        list.add("Beta");
    }

    @Test
    public void insertTest(){
        Assert.assertEquals(2,list.size());
        list.add("Gamma");
        Assert.assertEquals(3,list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        Assert.assertEquals("Alpha",list.get(0));
        Assert.assertEquals("Beta",list.get(1));
        Assert.assertEquals("Gamma",list.get(2));

    }
    @Test
    public void replaceTest(){
        Assert.assertEquals(2,list.size());
        list.add("Lambda");
        System.out.println("Results after insert test");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        Assert.assertEquals(3,list.size());
        list.set(1,"Delta");
        System.out.println("Results after replace test");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        Assert.assertEquals("Alpha",list.get(0));
        Assert.assertEquals("Delta",list.get(1));
        Assert.assertEquals("Lambda",list.get(2));
    }
}
