package com.sunvalley.dop.finance.center.utils;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.ExcelExportServer;
import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @program: my-workspace
 * @description: ${description}
 * @author: jackyu
 * @create: 2020-05-13 20:15
 **/
public class ExcelExportUtilsFinal {


    public static void main(String[] args) throws Exception {
        try {
            List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();


            ExcelExportEntity whEntity = new ExcelExportEntity("仓库", "whId");
            whEntity.setNeedMerge(true);
            colList.add(whEntity);

            ExcelExportEntity skuEntity = new ExcelExportEntity("SKU", "sku");
            skuEntity.setNeedMerge(true);
            colList.add(skuEntity);



            colList.add(new ExcelExportEntity("期初结存数量合计", "qcjcQty"));
            colList.add(new ExcelExportEntity("期初在库数量", "qczkQty"));
            colList.add(new ExcelExportEntity("期初在途数量", "qcztQty"));




            ExcelExportEntity  bqrkQtyEntity =    new ExcelExportEntity("本期入库数量合计", "bqrkQty");
            ExcelExportEntity  byztQtyEntity =    new ExcelExportEntity("本月在途数量", "byztQty");
            ExcelExportEntity  qcztbyjsQtyEntity =    new ExcelExportEntity("期初在途本月接收数量", "qcztbyjsQty");
            ExcelExportEntity  byjsQtyEntity =    new ExcelExportEntity("本月接收数量", "byjsQty");
            ExcelExportEntity  gylToErpQtyEntity =    new ExcelExportEntity("供应链调拨到ERP数", "gylToErpQty");
            ExcelExportEntity  rmasjQtyEntityGroup  =   new ExcelExportEntity("RMA上架数量", "rmasjQty");
            ExcelExportEntity  xxkhthQtyEntityGroup  =   new ExcelExportEntity("线下客户退回", "xxkhthQty");
            ExcelExportEntity  fbaToHWQtyEntityGroup  =   new ExcelExportEntity("FBA退回到海外仓数量", "fbaToHWQty");
            ExcelExportEntity  pykQtyEntity  =   new ExcelExportEntity("盘盈亏数量", "pykQty");

            colList.add(bqrkQtyEntity);
            colList.add(byztQtyEntity);
            colList.add(qcztbyjsQtyEntity);
            colList.add(byjsQtyEntity);
            colList.add(gylToErpQtyEntity);
            colList.add(rmasjQtyEntityGroup);
            colList.add(xxkhthQtyEntityGroup);
            colList.add(fbaToHWQtyEntityGroup);
            colList.add(pykQtyEntity);



            ExcelExportEntity  bqckQtyEntity  =   new ExcelExportEntity("本期出库数量合计", "bqckQty");
            ExcelExportEntity  erpToGylQtyEntity  =   new ExcelExportEntity("ERP调拨到供应链数量", "erpToGylQty");
            ExcelExportEntity  unfbaSaleQtyEntityGroup  =   new ExcelExportEntity("非FBA销售出库数量", "unfbaSaleQty");
            ExcelExportEntity  hwToFbaQtyEntityGroup  =   new ExcelExportEntity("海外仓发到FBA数量", "hwToFbaQty");
            colList.add(bqckQtyEntity);
            colList.add(erpToGylQtyEntity);
            colList.add(unfbaSaleQtyEntityGroup);
            colList.add(hwToFbaQtyEntityGroup);


            ExcelExportEntity  qmjcQtyEntity  =   new ExcelExportEntity("期末结存数量合计", "qmjcQty");
            ExcelExportEntity  qmzkQtyEntity  =   new ExcelExportEntity("期末在库数量", "qmzkQty");
            ExcelExportEntity  qmztQtyEntity  =   new ExcelExportEntity("期末在途数量", "qmztQty");
            colList.add(qmjcQtyEntity);
            colList.add(qmzkQtyEntity);
            colList.add(qmztQtyEntity);


            ExcelExportEntity gReportqmzkEntity = new ExcelExportEntity("Ag报表期末在库数量", "gReportqmzkHeader");
            gReportqmzkEntity.setNeedMerge(true);
            colList.add(gReportqmzkEntity);

            ExcelExportEntity gReportqmztEntity = new ExcelExportEntity("Ag报表期末在途数量", "gReportqmztHeader");
            gReportqmztEntity.setNeedMerge(true);
            colList.add(gReportqmztEntity);



            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            List<ExcelExportEntity> rmasjQtyEntityGroupList = new ArrayList<ExcelExportEntity>();
            List<ExcelExportEntity> xxkhthQtyEntityGroupList = new ArrayList<ExcelExportEntity>();
            List<ExcelExportEntity> fbaToHWQtyEntityGroupList = new ArrayList<ExcelExportEntity>();
            List<ExcelExportEntity> unfbaSaleQtyEntityGroupList = new ArrayList<ExcelExportEntity>();
            List<ExcelExportEntity> hwToFbaQtyEntityGroupList = new ArrayList<ExcelExportEntity>();
            for (int i = 0; i < 10; i++) {
                rmasjQtyEntityGroupList.add(new ExcelExportEntity("FBA1"+i, "FBA1"+i));
                xxkhthQtyEntityGroupList.add(new ExcelExportEntity("FBA1"+i, "FBA1"+i));
                fbaToHWQtyEntityGroupList.add(new ExcelExportEntity("FBA1"+i, "FBA1"+i));
                unfbaSaleQtyEntityGroupList.add(new ExcelExportEntity("FBA1"+i, "FBA1"+i));
                hwToFbaQtyEntityGroupList.add(new ExcelExportEntity("FBA1"+i, "FBA1"+i));
            }
            rmasjQtyEntityGroup.setList(rmasjQtyEntityGroupList);
            xxkhthQtyEntityGroup.setList(xxkhthQtyEntityGroupList);
            fbaToHWQtyEntityGroup.setList(fbaToHWQtyEntityGroupList);
            unfbaSaleQtyEntityGroup.setList(unfbaSaleQtyEntityGroupList);
            hwToFbaQtyEntityGroup.setList(hwToFbaQtyEntityGroupList);


            Map<String, Object> sheetMap = new HashMap<>();
            ExportParams exportParams = new ExportParams(null, "海外仓进销存报表");
            sheetMap.put("title",exportParams);
            sheetMap.put("entity",colList);
            sheetMap.put("data",list);

            Map<String, Object> sheetMap1 = new HashMap<>();
            ExportParams exportParams1 = new ExportParams(null, "海外仓进销存报表111");
            sheetMap1.put("title",exportParams1);
            sheetMap1.put("entity",colList);
            sheetMap1.put("data",list);

            List<Map<String, Object>> res = Lists.newArrayList();
            res.add(sheetMap);
            res.add(sheetMap1);
//            Workbook workbook = ExcelExportUtil.exportExcel(res,ExcelType.HSSF);
//            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "海外仓进销存报表"), colList, list);

            Workbook workbook = exportExcel(res,ExcelType.HSSF);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\jackyu.yu\\Desktop\\emp11.xls");
            workbook.write(fos);

            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一个excel 创建多个sheet
     *
     * @param list
     *            多个Map key title 对应表格Title key entity 对应表格对应实体 key data
     *            Collection 数据
     * @return
     */
    public static Workbook exportExcel(List<Map<String, Object>> list, ExcelType type) {
        Workbook workbook = getWorkbook(type,0);
        for (Map<String, Object> map : list) {
            ExcelExportServer service = new ExcelExportServer();
            service.createSheetForMap(workbook, (ExportParams)map.get("title"), (List<ExcelExportEntity>)map.get("entity"), (Collection<?>)map.get("data"));
        }
        return workbook;
    }

    private static Workbook getWorkbook(ExcelType type, int size) {
        if (ExcelType.HSSF.equals(type)) {
            return new HSSFWorkbook();
        } else if (size < 100000) {
            return new XSSFWorkbook();
        } else {
            return new SXSSFWorkbook();
        }
    }

}
