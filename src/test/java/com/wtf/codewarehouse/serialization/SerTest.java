package com.wtf.codewarehouse.serialization;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author wangtengfei
 * @since 2020/8/4 14:00
 */
public class SerTest {
    @Test
    public void serializeToDisk()
    {
        try
        {
            Person ted = new Person("Ted", "Neward", 39,Gender.MALE);
            Person charl = new Person("Charlotte",
                    "Neward", 38,Gender.FEMALE);

            ted.setSpouse(charl);
            charl.setSpouse(ted);

            FileOutputStream fos = new FileOutputStream("D:\\tempdata.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ted);
            oos.close();
        }
        catch (Exception ex)
        {
            fail("Exception thrown during test: " + ex.toString());
        }

        try
        {
            FileInputStream fis = new FileInputStream("D:\\tempdata.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person ted = (Person) ois.readObject();
            ois.close();

            assertEquals(ted.getFirstName(), "Ted");
            assertEquals(ted.getSpouse().getFirstName(), "Charlotte");

            // Clean up the file
            new File("tempdata.ser").delete();
        }
        catch (Exception ex)
        {
            fail("Exception thrown during test: " + ex.toString());
        }
    }
}
