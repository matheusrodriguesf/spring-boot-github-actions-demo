package br.com.arcelino.appinfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.appinfo.model.AppInfo;
import br.com.arcelino.appinfo.service.AppInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("app")
@RequiredArgsConstructor
public class AppInfoController {

    private final AppInfoService service;

    @GetMapping("/info")
    public ResponseEntity<AppInfo> getAppInfo() {
        return ResponseEntity.ok(service.getAppInfo());
    }
}
