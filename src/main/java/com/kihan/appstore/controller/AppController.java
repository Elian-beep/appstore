package com.kihan.appstore.controller;

import com.kihan.appstore.dto.AppDTO;
import com.kihan.appstore.entity.App;
import com.kihan.appstore.service.AppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/app")
public class AppController {
    @Autowired
    AppService appService;

    @GetMapping("find")
    public ResponseEntity<List<App>> getAll(){
        List<App> apps = appService.getAll();
        return ResponseEntity.ok().body(apps);
    }

    @PostMapping("insert")
    public ResponseEntity<App> insert(@RequestBody @Valid AppDTO appDTO){
        App app = appService.insert(appDTO);
        return ResponseEntity.created(null).body(app);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<App> update(@RequestBody @Valid AppDTO appDTO, @PathVariable String id){
        App appAtt = appService.update(id, appDTO);
        if(appAtt != null){
            return ResponseEntity.ok().body(appAtt);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<App> remove(@PathVariable String id){
        App appFound = appService.remove(id);
        if(appFound != null){
            return ResponseEntity.ok().body(appFound);
        }
        return ResponseEntity.notFound().build();
    }
}
