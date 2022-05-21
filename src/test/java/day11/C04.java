package day11;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04 {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));
        String sahsiKisim=System.getProperty("user.home");
        String ortakKisimKisim="\\Downloads\\dummy.txt";

        String tamDosyaYolu=sahsiKisim+ortakKisimKisim;
        System.out.println(tamDosyaYolu);


        System.out.println(Files.exists(Paths.get(tamDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(tamDosyaYolu)));
    }
}
