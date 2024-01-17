package com.kihan.appstore.service;

import com.kihan.appstore.dto.AppDTO;
import com.kihan.appstore.entity.App;
import com.kihan.appstore.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {
    @Autowired
    AppRepository appRepository;

    public List<App> getAll() {
        return appRepository.findAll();
    }

    public App insert(AppDTO appDTO){
        App app = new App(appDTO);
        appRepository.insert(app);
        return app;
    }

    public App update(String id, AppDTO appDTO){
        Optional<App> appFound = findById(id);
        if(appFound.isPresent()){
            App appAtt = appFound.get();
            appAtt.setName(appDTO.name() != null ? appDTO.name() : appAtt.getName());
            appAtt.setPublished(appDTO.published() != null ? appDTO.published() : appAtt.getPublished());
            appAtt.setSize(appDTO.size() != null ? appDTO.size() : appAtt.getSize());
            appRepository.save(appFound.get());
            return appFound.get();
        }
        return null;
    }

    public App remove(String id){
        Optional<App> app = findById(id);
        if(app.isPresent()){
            app.ifPresent( value -> appRepository.delete(value) );
//          if(app.isPresent()) appRepository.delete(app.get());
//          if(app.isPresent()){
//              appRepository.delete(app.get());
//          }
            return app.get();
        }
        return null;
    }

    public Optional<App> findById(String id){
        return appRepository.findById(id);
    }
}
