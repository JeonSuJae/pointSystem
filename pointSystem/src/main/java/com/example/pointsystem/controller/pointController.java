package com.example.pointsystem.controller;

import com.example.pointsystem.model.Point;
import com.example.pointsystem.service.pointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class pointController {

    @Autowired
    pointService pointService;
    @Value("${point.min}")
    int pointMin;
    @Value("${point.max}")
    int pointMax;

    @GetMapping("/point")
    public Map<String,Object> getAllPoint() {
        List<Point> result = pointService.getAllPoint();

        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("result", result);

        return returnMap;
    }

    @GetMapping("/save")
    public Map<String,Object> getSavePoint() {
        List<Point> result = pointService.getPoint();

        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("result", result);

        return returnMap;
    }

    @PostMapping("/save")
    public Map<String,Object> setSavePoint(@RequestParam Integer savePoint, @RequestParam Boolean manual, @RequestParam Integer pointEndDate) {
        int result = pointService.savePoint(savePoint, manual, pointEndDate);

        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("result", result);

        return returnMap;
    }

    @DeleteMapping("/save")
    public Map<String, Object> deleteSavePoint(@RequestParam Integer pointKey) {
        int result = pointService.deleteSavePoint(pointKey);

        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("result", result);

        return returnMap;
    }

    @PostMapping("/use")
    public Map<String, Object> useSavePoint(@RequestParam Integer usePoint) {
        int result = pointService.useSavePoint(usePoint);

        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("result", result);

        return returnMap;
    }

    @PutMapping("/use")
    public Map<String, Object> cancelUsePoint(@RequestParam Integer cancelPoint) {
        int result = pointService.cancelUsePoint(cancelPoint);

        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("result", result);

        return returnMap;
    }

    @GetMapping("/minMax")
    public Map<String, Object> getMinMax() {
        List<Integer> result = new ArrayList<>();
        result.add(pointMin);
        result.add(pointMax);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("result", result);

        return returnMap;
    }
}
