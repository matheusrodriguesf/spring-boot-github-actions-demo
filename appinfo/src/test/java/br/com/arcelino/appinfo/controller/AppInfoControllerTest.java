package br.com.arcelino.appinfo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import br.com.arcelino.appinfo.model.AppInfo;
import br.com.arcelino.appinfo.service.AppInfoService;

public class AppInfoControllerTest {

    @Mock
    private AppInfoService mockService;

    private AppInfoController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new AppInfoController(mockService);
    }

    @Test
    public void testGetAppInfo_ReturnsOkResponse() {
        var appInfo = new AppInfo("App Name", "1.0.0", "11.0.11");
        when(mockService.getAppInfo()).thenReturn(appInfo);

        var response = controller.getAppInfo();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(appInfo, response.getBody());
    }

    @Test
    public void testGetAppInfo_ReturnsCorrectAppInfo() {
        var appInfo = new AppInfo("App Name", "1.0.0", "11.0.11");
        when(mockService.getAppInfo()).thenReturn(appInfo);

        var response = controller.getAppInfo();

        assertEquals(appInfo, response.getBody());
    }

}
