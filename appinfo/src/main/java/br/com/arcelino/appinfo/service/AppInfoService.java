package br.com.arcelino.appinfo.service;

import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import br.com.arcelino.appinfo.model.AppInfo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppInfoService {

    private final BuildProperties buildProperties;

    public AppInfo getAppInfo() {
        return new AppInfo(
                buildProperties.getName(),
                buildProperties.getVersion(),
                System.getProperty("java.version"));

    }

}
