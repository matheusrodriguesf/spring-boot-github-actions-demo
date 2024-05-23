package br.com.arcelino.appinfo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppInfoTest {

    @Test
    public void testConstructorAndGetters() {
        var name = "MyApp";
        var version = "1.0";
        var javaVersion = "11.0.2";

        var appInfo = new AppInfo(name, version, javaVersion);

        Assertions.assertEquals(name, appInfo.name());
        Assertions.assertEquals(version, appInfo.version());
        Assertions.assertEquals(javaVersion, appInfo.javaVersion());
    }

    @Test
    public void testEqualsAndHashCode() {
        var appInfo1 = new AppInfo("MyApp", "1.0", "11.0.2");
        var appInfo2 = new AppInfo("MyApp", "1.0", "11.0.2");
        var appInfo3 = new AppInfo("OtherApp", "1.0", "11.0.2");

        Assertions.assertEquals(appInfo1, appInfo2);
        Assertions.assertNotEquals(appInfo1, appInfo3);

        Assertions.assertEquals(appInfo1.hashCode(), appInfo2.hashCode());
        Assertions.assertNotEquals(appInfo1.hashCode(), appInfo3.hashCode());
    }

    @Test
    public void testToString() {
        var appInfo = new AppInfo("MyApp", "1.0", "11.0.2");

        var expectedToString = "AppInfo[name=MyApp, version=1.0, javaVersion=11.0.2]";
        Assertions.assertEquals(expectedToString, appInfo.toString());
    }

}
