package com.example.pointsystem.repository;

import com.example.pointsystem.model.Point;
import com.example.pointsystem.model.UseHistory;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface pointMapper {
    int insertPointSave(Integer point, String manual, LocalDate endDate);
    List<Point> selectAllPoint();
    List<Point> selectPoint();
    int deleteSavePoint(Integer pointKey);
    List<Point> selectUsePoint();
    int updatePoint(Integer pointKey, Integer point);
    int insertUseHistory(Integer orderNum, Integer point, Integer pointKey);
    int countOrderNum();
    List<UseHistory> selectUesHistory();
    Point selectLastPoint(Integer pointKey);
    int updateUseHistory(Integer historyNum, Integer point);
    int deletePointHistory(Integer pointKey);
}
