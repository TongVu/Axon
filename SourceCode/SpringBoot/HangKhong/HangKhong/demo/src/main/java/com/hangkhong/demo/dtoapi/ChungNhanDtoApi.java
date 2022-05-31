package com.hangkhong.demo.dtoapi;

import com.hangkhong.demo.dto.ChungNhanDto;
import com.hangkhong.demo.entity.ChungNhan;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.chungNhanService;
import com.hangkhong.demo.service.mayBayService;
import com.hangkhong.demo.service.nhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChungNhanDtoApi {
    @Autowired
    private chungNhanService chungNhanService;
    @Autowired
    private nhanVienService nhanVienService;
    @Autowired
    private mayBayService mayBayService;

    @GetMapping
    public List<ChungNhanDto> getAll() {
        return chungNhanService.toChungNhanDTO(chungNhanService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChungNhanDto> getById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        ChungNhan chungNhan = chungNhanService.getById(id).
                orElseThrow(() -> new ResourseNotFound("id not exist " + id));
        return ResponseEntity.ok(chungNhanService.toChungNhanDTO(chungNhan));
    }

    @PostMapping("/add")
    public ChungNhan create(@RequestBody ChungNhanDto chungNhanDto) {
        chungNhanService.save(chungNhanService.toChungNhanEntity(chungNhanDto));
        return chungNhanService.toChungNhanEntity(chungNhanDto);
    }

    @PutMapping("id")
    public ResponseEntity<ChungNhan> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody ChungNhanDto chungNhanDto) throws ResourseNotFound {
        ChungNhan chungNhan = chungNhanService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Id does not exist " + id));
        chungNhan.setNhanVien(nhanVienService.findNhanVienById(chungNhanDto.getNhanVien()).get());
        chungNhan.setMaybay(mayBayService.getById(chungNhanDto.getMayBay()).get());
        return ResponseEntity.ok(chungNhan);
    }

    @DeleteMapping("/delete")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id) throws Exception {
        ChungNhan chungNhan = chungNhanService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("ChungNhan not found: " + id));
        chungNhanService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
