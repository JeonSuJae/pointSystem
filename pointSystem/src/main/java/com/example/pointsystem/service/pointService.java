package com.example.pointsystem.service;

import com.example.pointsystem.model.Point;
import com.example.pointsystem.model.UseHistory;
import com.example.pointsystem.repository.pointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class pointService {
    @Autowired
    private pointMapper pointMapper;

    public List<Point> getAllPoint() {
        return pointMapper.selectAllPoint();
    }

    public List<Point> getPoint() {
        return pointMapper.selectPoint();
    }

    public int savePoint(Integer savePoint, Boolean manual, Integer pointEndDate) {
        String yn = "N";
        if(manual) { yn = "Y";}
        LocalDate now = LocalDate.now();
        LocalDate endDate = now.plusDays(pointEndDate);
        return pointMapper.insertPointSave(savePoint, yn, endDate);
    }

    @Transactional
    public int deleteSavePoint(Integer pointKey) {
        pointMapper.deletePointHistory(pointKey);
        return pointMapper.deleteSavePoint(pointKey);
    }

    @Transactional
    public int useSavePoint(Integer usePoint) {
        int result = 0;
        int orderNum = pointMapper.countOrderNum();
        orderNum++;
        List<Point> pointList = pointMapper.selectUsePoint();
        for(Point point: pointList) {
            if (point.getPoint() - usePoint < 0) {
                result = pointMapper.updatePoint(point.getPointKey(), 0);
                if (result > 0) {
                    result = pointMapper.insertUseHistory(orderNum, point.getPoint(), point.getPointKey());
                    usePoint = usePoint - point.getPoint();
                } else {
                    return  -1;
                }
            } else {
                result = pointMapper.updatePoint(point.getPointKey(), point.getPoint() - usePoint);
                if (result > 0) {
                    result = pointMapper.insertUseHistory(orderNum, usePoint, point.getPointKey());
                    return result;
                } else {
                    return -1;
                }
            }
        }
        return result;
    }

    @Transactional
    public int cancelUsePoint(Integer cancelPoint) {
        int result = 0;
        List<UseHistory> useHitoryList = pointMapper.selectUesHistory();
        for(UseHistory useHistory: useHitoryList) {
            if (useHistory.getPoint() - cancelPoint < 0) {
                result = pointMapper.updateUseHistory(useHistory.getHistoryNum(), 0);
                if(result > 0) {
                    Point point = pointMapper.selectLastPoint(useHistory.getPointKey());
                    LocalDate now = LocalDate.now();
                    if( now.isAfter(point.getEndDate()) ) {
                        result = pointMapper.insertPointSave(point.getPoint(), point.getManual(), now.plusDays(365));
                    } else {
                        result = pointMapper.updatePoint(useHistory.getPointKey(), point.getPoint() + useHistory.getPoint());
                    }
                    cancelPoint = cancelPoint - useHistory.getPoint();
                } else {
                    return -1;
                }
            } else {
                result = pointMapper.updateUseHistory(useHistory.getHistoryNum(), useHistory.getPoint() - cancelPoint);
                if(result > 0) {
                    Point point = pointMapper.selectLastPoint(useHistory.getPointKey());
                    result = pointMapper.updatePoint(useHistory.getPointKey(), point.getPoint() + cancelPoint);
                } else {
                    return -1;
                }
                break;
            }
        }
        return result;
    }
}
