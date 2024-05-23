package br.com.arcelino.appinfo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.info.BuildProperties;

public class AppInfoServiceTest {

    @Mock
    private BuildProperties buildProperties;

    private AppInfoService appInfoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        appInfoService = new AppInfoService(buildProperties);
    }

    @Test
    public void testGetAppInfo() {
        var appName = "MyApp";
        var appVersion = "1.0.0";
        var javaVersion = "11.0.1";

        when(buildProperties.getName()).thenReturn(appName);
        when(buildProperties.getVersion()).thenReturn(appVersion);
        System.setProperty("java.version", javaVersion);

        var appInfo = appInfoService.getAppInfo();

        assertEquals(appName, appInfo.name());
        assertEquals(appVersion, appInfo.version());
        assertEquals(javaVersion, appInfo.javaVersion());
    }

    @Test
    public void testGetAppInfo_NullAppName() {

        var appVersion = "1.0.0";
        var javaVersion = "11.0.1";

        when(buildProperties.getName()).thenReturn(null);
        when(buildProperties.getVersion()).thenReturn(appVersion);
        System.setProperty("java.version", javaVersion);

        var appInfo = appInfoService.getAppInfo();

        assertEquals(null, appInfo.name());
        assertEquals(appVersion, appInfo.version());
        assertEquals(javaVersion, appInfo.javaVersion());
    }

    @Test
    public void testGetAppInfo_NullAppVersion() {
        var appName = "MyApp";
        var javaVersion = "11.0.1";

        when(buildProperties.getName()).thenReturn(appName);
        when(buildProperties.getVersion()).thenReturn(null);
        System.setProperty("java.version", javaVersion);

        var appInfo = appInfoService.getAppInfo();

        assertEquals(appName, appInfo.name());
        assertEquals(null, appInfo.version());
        assertEquals(javaVersion, appInfo.javaVersion());
    }
}
