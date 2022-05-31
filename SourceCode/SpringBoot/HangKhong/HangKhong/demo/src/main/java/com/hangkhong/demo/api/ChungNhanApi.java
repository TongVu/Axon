package com.hangkhong.demo.api;

import com.hangkhong.demo.entity.ChungNhan;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.chungNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge =  3600)
@RequestMapping("/chungnhan")
public class ChungNhanApi {
    @Autowired
    private chungNhanService chungNhanService;

    @GetMapping
    private List<ChungNhan> getAll() {
        return chungNhanService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<ChungNhan> getNhanVienById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        ChungNhan chungNhan = chungNhanService.getById(id).orElseThrow(() -> new ResourseNotFound("Id not found" + id));
        return ResponseEntity.ok().body(chungNhan);
    }

    @PostMapping("/add")
    public void create(@RequestBody ChungNhan chungNhan) {
        chungNhanService.save(chungNhan);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ChungNhan> delete(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        ChungNhan chungNhan = chungNhanService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Id not found for nhan vien" + id));
        chungNhanService.getById(id);
        return ResponseEntity.ok(chungNhan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChungNhan> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody ChungNhan chungNhan) throws ResourseNotFound {
        ChungNhan chungNhan1 = chungNhanService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Nhan vien id does not exist" + id));
        chungNhan1.setNhanVien(chungNhan.getNhanVien());
        chungNhan1.setMaybay(chungNhan.getMaybay());
        return ResponseEntity.ok(chungNhan1);
    }
}

