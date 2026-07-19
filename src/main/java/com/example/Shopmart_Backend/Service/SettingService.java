package com.example.Shopmart_Backend.Service;

import com.example.Shopmart_Backend.Entity.Setting;
import com.example.Shopmart_Backend.Repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {
    @Autowired
    private SettingRepository repository;

    public Setting save(Setting setting){
        return repository.save(setting);
    }
    public List<Setting> getAll(){
        return repository.findAll();
    }
    public Setting update(Setting setting){

        return repository.save(setting);
    }
}
