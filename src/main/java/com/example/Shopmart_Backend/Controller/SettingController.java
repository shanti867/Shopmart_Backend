package com.example.Shopmart_Backend.Controller;

import com.example.Shopmart_Backend.Entity.Setting;
import com.example.Shopmart_Backend.Service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/setting")
@CrossOrigin("*")
public class SettingController {
    @Autowired
    private SettingService service;

    public Setting createSetting(@RequestBody Setting setting){
        return service.save(setting);
    }
    public List<Setting> getAll(){
        return service.getAll();
    }
    public Setting updateSetting(@RequestBody Setting setting){
        return service.update(setting);
    }
}
