package com.hangkhong.demo.dtoapi;

import com.hangkhong.demo.dto.MayBayDto;
import com.hangkhong.demo.entity.MayBay;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.mayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/maybayDTO")
public class mayBayDtoApi {
    @Autowired
    private mayBayService mayBayService;

    @GetMapping
    public List<MayBayDto> getAll() {
        return mayBayService.toMayBayDTO(mayBayService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MayBayDto> getMayBayById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        MayBay mayBay = mayBayService.getById(id).
                orElseThrow(() -> new ResourseNotFound( "id not exist " + id));
        return ResponseEntity.ok(mayBayService.toMayBayDTO(mayBay));
    }

    @PostMapping("/add")
    public  MayBay create(@RequestBody MayBayDto mayBayDto){
        mayBayService.save(mayBayService.toMayBayEntity(mayBayDto));
        return mayBayService.toMayBayEntity(mayBayDto);
    }
    @PutMapping("id")
    public ResponseEntity<MayBay> update(@PathVariable(value = "id")Integer id,
                                           @RequestBody MayBayDto mayBayDto)throws ResourseNotFound{
        MayBay mayBay=mayBayService.getById(id)
                .orElseThrow(()->new ResourseNotFound("Id does not exist "+id));
        mayBay.setLoaiMayBay(mayBayDto.getLoaiMayBay());
        mayBay.setTamBay(mayBayDto.getTamBay());
        mayBay.setMamb(mayBayDto.getMamb());
        return ResponseEntity.ok(mayBay);
    }
    @DeleteMapping("/delete")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id) throws Exception {
        MayBay mayBay =mayBayService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("MayBay not found: " + id));
        mayBayService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
