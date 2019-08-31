package com.jjcw.course.service.impl;

import com.jjcw.course.bean.SalaryInfo;
import com.jjcw.course.dao.ISalaryInfoDao;
import com.jjcw.course.service.ISalaryInfoService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/12 15:08
 * @Company jjcw
 */
@Service
@Transactional
public class SalaryInfoServiceImpl implements ISalaryInfoService {

    @Autowired
    private ISalaryInfoDao salaryInfoDao;

    public void add(SalaryInfo info) {
        salaryInfoDao.add(info);

    }

    public List<SalaryInfo> list(SalaryInfo info) {

        if (info != null) {
            if (info.getStaffName() != null && !info.getStaffName().equals("")) {
                info.setStaffName("%"+info.getStaffName()+"%");
            }
        }

        return salaryInfoDao.list(info);
    }

    public Long getcount(SalaryInfo info) {

        if (info != null) {
            if (info.getStaffName() != null && !info.getStaffName().equals("")) {
                info.setStaffName("%"+info.getStaffName()+"%");
            }
        }
        return salaryInfoDao.getcount(info);
    }

    public void addAll(InputStream is)throws Exception {

        Workbook book = Workbook.getWorkbook(is);
        Sheet sheet = book.getSheet(0);
        System.out.println(sheet.getColumns());
        System.out.println(sheet.getRows());

        for(int i=1;i<sheet.getRows();i++){
            SalaryInfo info = new SalaryInfo();

            //用户编号
            Cell idcell = sheet.getCell(0, i);
            Integer userId = Integer.parseInt(idcell.getContents());
            info.setStaffId(userId);

            //发放时间
            Cell timecell = sheet.getCell(2, i);
            String time = timecell.getContents();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date paymentTime = sdf.parse(time);
            info.setSalaryDate(paymentTime);

            //发放金额
            Cell moneycell = sheet.getCell(3, i);
            Double paymentMoney =  Double.parseDouble(moneycell.getContents());
            info.setSalaryBasic(paymentMoney);
            salaryInfoDao.add(info);


        }






    }
}
