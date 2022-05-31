package com.hangkhong.demo.dtoapi;

import com.hangkhong.demo.dto.ChuyenBayDto;
import com.hangkhong.demo.entity.ChuyenBay;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.chuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/chuyenbayDTO")
public class ChuyenBayDtoApi {
    @Autowired
    private chuyenBayService chuyenBayService;

    @GetMapping
    public List<ChuyenBayDto> getAll() {
        return chuyenBayService.toChuyenBayDTO(chuyenBayService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChuyenBayDto> getById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        ChuyenBay chuyenBay = chuyenBayService.getById(id).
                orElseThrow(() -> new ResourseNotFound("Id not exist " + id));
        return ResponseEntity.ok(chuyenBayService.toChuyenBayDTO(chuyenBay));
    }

    @PostMapping("/add")
    public ChuyenBay create(@RequestBody ChuyenBayDto chuyenBayDto) {
        chuyenBayService.save(chuyenBayService.toChuyenBayEntity(chuyenBayDto));
        return chuyenBayService.toChuyenBayEntity(chuyenBayDto);
    }

    @PutMapping("id")
    public ResponseEntity<ChuyenBay> update(@PathVariable(value = "id") Integer id,
                                           @RequestBody ChuyenBayDto chuyenBayDto) throws ResourseNotFound {
        ChuyenBay chuyenBay = chuyenBayService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Id does not exist " + id));
        chuyenBay.setMaCb(chuyenBayDto.getMaCb());
        chuyenBay.setGaDi(chuyenBayDto.getGaDi());
        return ResponseEntity.ok(chuyenBay);
    }

    @DeleteMapping("/delete")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id) throws Exception {
        ChuyenBay chuyenBay = chuyenBayService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("ChuyenBay not found: " + id));
        chuyenBayService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
