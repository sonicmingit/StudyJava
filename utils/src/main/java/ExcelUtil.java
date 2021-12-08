/*
package top.sonicming.springbootdemo.utils;

import top.sonicming.springbootdemo.utils.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @program: macao-travel-route-management
 * @description: 行程规划管理后台-数据录入-热门推荐操作
 * @author: hao.yiming
 * @create: 2019-12-19 15:54
 **//*

@Service
public class todo_ExcelUtil  {





    */
/**
     * excel进度占比
     *//*

    public static final int EXCEL_PCT = 50;
    */
/**
     * 操作数据库进度占比
     *//*

    public static final int DB_PCT = 50;


    */
/**
     * 数据库字符长度
     *//*

    public static final int STR_LEN = 45;

    */
/**
     * 数据库数字长度
     *//*

    public static final int NUM_LEN = 11;


    */
/**
     * 操作(deal_type)列号
     *//*

    public static final String OP_COL = "J";
    */
/**
     * 新增操作
     *//*

    public static final String ADD = "I";
    */
/**
     * 修改操作
     *//*

    public static final String MOD = "U";
    */
/**
     * 删除操作
     *//*

    public static final String DEL = "D";
    */
/**
     * 无操作
     *//*

    public static final String NONE = "NONE";

    */
/**
     * 错误行号
     *//*

    private int logi;

    */
/**
     * 错误列号
     *//*

    private int logj;

    */
/**
     * 错误记录
     *//*

    private List<String> errList = new ArrayList<>();

    */
/**
     * @Title: hotTripImport 热门推荐数据录入
     * @Description: Excel数据导入数据库
     * @Param: [file] excel文件
     * @return: com.aliyun.gts.bpaas.response.ResultMap
     * @Author: hao.yiming
     * @Date: 2019-12-19 15:44
     * @version: v1.0
     *//*

    @Override
    @Async
    public ResultMap hotTripImport(MultipartFile file) {
        long time = System.currentTimeMillis();
        //PCT_开始
        pct.initIng();
        //文件名
        String fileName = file.getOriginalFilename().toLowerCase();
        //扩展名
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        //转换流
        //FileInputStream in = null;
        InputStream in = null;
        try {
           // in = (FileInputStream) file.getInputStream();
            in = file.getInputStream();
        } catch (IOException e) {
            */
/*返回_文件读取错误*//*

            logger.error("文件转换流失败");
            //PCT_进度错误
            pct.setError(BizCodeEnum.INTERFACE_CALL_EXCEPTION.getMessage());
            return ApiResultUtil.failResult(BizCodeEnum.INTERFACE_CALL_EXCEPTION);
        }
        //从第3行Row(数据),第A列Col(id),第J列Col为操作参数,开始读
        //todo 考虑参数提出
        //清空之前错误列表
        errList.clear();
        Map<String, List<HotRecomendTrip>> varMap = readExcelToDao(suffix, in, 3, "A", 0, "J");
        */
/*返回_校验有错误直接返回失败,并返回失败列表*//*

        if (errList.size() != 0) {
            ResultMap resultMap = ApiResultUtil.failResult(BizCodeEnum.PARAMETER_CHECK_EXCEPTION);
            resultMap.setData(errList);
            logger.error("错误列表", errList);
            //PCT_进度错误,错误信息提示
            pct.setError(errList);
            return resultMap;
        }
        logger.info("excel读取完成,耗时{}", System.currentTimeMillis() - time);
        */
/*开始操作数据库*//*

        // 存放操作结果
        Map<String, Object> result = new HashMap<>(4);
        if (!CollectionUtils.isEmpty(varMap)) {
            int addNum = varMap.get(ADD).size();
            int modNum = varMap.get(MOD).size();
            int delNum = varMap.get(DEL).size();
            int noneNum = varMap.get(NONE).size();
            int allNum = addNum + modNum + delNum;
            */
/*返回_全部没有修改参数,返回错误*//*

            if (allNum == 0) {
                //PCT_进度错误,操作列全错误
                pct.setError("用户" + OP_COL + "列操作参数错误");
                return ApiResultUtil.failResult(BizCodeEnum.USER_TRIP_DETAIL_ABNORMAL_OPERATION);
            }
            //批量新增
            if (addNum != 0) {
                result.put(ADD, hotRecomendTripDao.insertBatch(varMap.get(ADD)));
                //PCT_更新进度,当前操作/总操作*数据库时间占比
                pct.setProgress((int) (pct.getProgress() + (addNum / allNum * DB_PCT)));
            }
            //批量修改
            if (modNum != 0) {
                result.put(MOD, hotRecomendTripDao.updateBatch(varMap.get(MOD)));
                //PCT_更新进度,当前操作/总操作*数据库时间占比
                pct.setProgress((int) (pct.getProgress() + (modNum / allNum * DB_PCT)));
            }
            //批量删除
            if (delNum != 0) {
                result.put(DEL, hotRecomendTripDao.deleteBatch(varMap.get(DEL)));
                //PCT_更新进度,当前操作/总操作*数据库时间占比
                pct.setProgress((int) (pct.getProgress() + (delNum / allNum * DB_PCT)));
            }
            //无操作
            if (noneNum != 0) {
                //拼接返回提示
                StringBuilder str = new StringBuilder("第");
                for (HotRecomendTrip h : varMap.get(NONE)) {
                    str.append(h.getDt()).append(",");
                }
                str.deleteCharAt(str.lastIndexOf(",")).append("行操作参数错误");
                result.put(NONE, str);
            }

        }
        logger.info("导入总耗时{}", System.currentTimeMillis() - time);
        */
/*返回_操作成功返回*//*

        //PCT_完成
        pct.setCompleted(result);
        return ApiResultUtil.successResult(result);
    }

    */
/**
     * @Title: hotTripExport 热门推荐数据导出
     * @Description: 数据库导出至Excel
     * @return: com.aliyun.gts.bpaas.response.ResultMap
     * @Author: hao.yiming
     * @Date: 2019-12-19 15:45
     * @version: v1.0
     *//*

    public void hotTripExport(HttpServletResponse response) {
        long time = System.currentTimeMillis();
        //查询所有数据
        List<HotRecomendTrip> hrtList = hotRecomendTripDao.selectAll();
        logger.info("查询数据完成,共{}条", hrtList.size());
        //创建Excel
        XSSFWorkbook wb = new XSSFWorkbook();
        //创建Sheet
        Sheet sheet = wb.createSheet();
        // todo 看需不需要设置格式
        //创建表头
        int rowHeadNum = createRowHead(sheet);
        //循环写值
        for (int i = 0; i < hrtList.size(); i++) {
            //创建行,从表头后开始
            Row row = sheet.createRow(i + rowHeadNum);
            //实体类参数个数
            //int j = hrtList.get(0).getClass().getDeclaredFields().length;
            int j = 0;
            //创建单元格,赋值
            row.createCell(j++).setCellValue(hrtList.get(i).getId());
            row.createCell(j++).setCellValue(hrtList.get(i).getReName());
            row.createCell(j++).setCellValue(hrtList.get(i).getTripLableId());
            row.createCell(j++).setCellValue(hrtList.get(i).getTripTraffic());
            row.createCell(j++).setCellValue(hrtList.get(i).getTripDays());
            row.createCell(j++).setCellValue(hrtList.get(i).getDayOrder());
            row.createCell(j++).setCellValue(hrtList.get(i).getPoiId());
            row.createCell(j++).setCellValue(hrtList.get(i).getPoiOrder());
            row.createCell(j++).setCellValue(hrtList.get(i).getTripDesigner());
            //row.createCell(j++).setCellValue(hrtList.get(i).getDt());
            //row.createCell(j++).setCellValue(hrtList.get(i).getReId());
        }
        */
/*测试写入本地*//*

        */
/*try {
            FileOutputStream fileOut = new FileOutputStream("D:\\热门行程列表.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
        }*//*

        */
/*开始导出文件*//*

        try {
            //清空response
            response.reset();
            //设置response的Header
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(ExcelConstant.EXPORT_FILENAME, "utf-8") + "." + ExcelConstant.XLSX);
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            //将excel写入到输出流中
            wb.write(os);
            logger.info("导出Excel文件成功!耗时{}毫秒", System.currentTimeMillis() - time);
            os.flush();
            os.close();
            wb.close();
        } catch (IOException e) {
            logger.error("导出Excel文件失败");
            throw new ConsumerException("导出Excel文件失败");
        }
    }

    */
/**
     * @param response
     * @Title: hotTripTemplate
     * @Description: 热门推荐Excel模版下载
     * @Param: [response]
     * @return: void
     * @Author: hao.yiming
     * @Date: 2019-12-23 13:32
     * @version: v1.0
     *//*

    @Override
    public void hotTripTemplate(HttpServletResponse response) {
        //创建Excel
        XSSFWorkbook wb = new XSSFWorkbook();
        //创建Sheet
        Sheet sheet = wb.createSheet();

        //创建表头
        int rowHeadNum = createRowHead(sheet);
        // 添加操作列
        Row row = sheet.getRow(0);
        row.createCell(row.getLastCellNum()).setCellValue("处理类型");
        Row row2 = sheet.getRow(1);
        row2.createCell(0).setCellValue("如果是增加由系统自动生成，此处不需要填写。如果是删除和更新提供\n");
        row2.createCell(row2.getLastCellNum()).setCellValue("deal_type");
        Row row3 = sheet.createRow(rowHeadNum++);
        row3.createCell(row.getLastCellNum() - 1).setCellValue("I增加 D删除 U更新");
        */
/*开始导出文件*//*

        try {
            //清空response
            response.reset();
            //设置response的Header
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(ExcelConstant.TEMPLATE_FILENAME, "utf-8") + "." + ExcelConstant.XLSX);
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            //将excel写入到输出流中
            wb.write(os);
            logger.info("导出Excel文件成功!");
            os.flush();
            os.close();
            wb.close();
        } catch (IOException e) {
            logger.error("导出Excel文件失败");
            throw new ConsumerException("导出Excel文件失败");
        }

    }

    */
/**
     * @Title: createRowHead
     * @Description: 创建表头
     * @Param: [sheet]
     * @return: int 数据行号
     * @Author: hao.yiming
     * @Date: 2019-12-23 15:19
     * @version: v1.0
     *//*

    private int createRowHead(Sheet sheet) {
        //创建表头
        int rowHeadNum = 0;
        Row rowHead = sheet.createRow(rowHeadNum++);
        int n = 0;
        rowHead.createCell(n++).setCellValue("推荐行程id");
        rowHead.createCell(n++).setCellValue("推荐行程名称");
        rowHead.createCell(n++).setCellValue("标签id");
        rowHead.createCell(n++).setCellValue("出行方式");
        rowHead.createCell(n++).setCellValue("行程天数");
        rowHead.createCell(n++).setCellValue("天数排序序号");
        rowHead.createCell(n++).setCellValue("poiid");
        rowHead.createCell(n++).setCellValue("poi排序序号");
        rowHead.createCell(n++).setCellValue("行程设计标签");
        //创建第二行
        Row rowHead2 = sheet.createRow(rowHeadNum++);
        n = 0;
        rowHead2.createCell(n++).setCellValue("");
        rowHead2.createCell(n++).setCellValue("re_name");
        rowHead2.createCell(n++).setCellValue("trip_lable_id");
        rowHead2.createCell(n++).setCellValue("trip_traffic");
        rowHead2.createCell(n++).setCellValue("trip_days");
        rowHead2.createCell(n++).setCellValue("day_order");
        rowHead2.createCell(n++).setCellValue("poi_id");
        rowHead2.createCell(n++).setCellValue("poi_order");
        rowHead2.createCell(n++).setCellValue("trip_designer");
        return rowHeadNum;
    }


    */
/**
     * @Title: readExcelToDao 读取Excel数据到实体
     * @Description: 读取Excel数据到实体
     * @Param: [suffix 文件扩展名, in 文件流, startRow 开始行号, startColStr 开始列号(字母), sheetNum, opColStr 操作列]
     * @return: java.util.Map<java.lang.String, java.util.List < com.aliyun.gts.bpaas.dao.entity.HotRecomendTrip>> key操作->value实体类集合
     * @Author: hao.yiming
     * @Date: 2019-12-22 14:50
     * @version: v1.0
     *//*

    //@Async
    Map<String, List<HotRecomendTrip>> readExcelToDao(String suffix, InputStream in, int startRow, String startColStr, int sheetNum, String opColStr) {
        //列字母转换数字
        int startCol = excelColStrToNum(startColStr);
        //怎删改集合
        List<HotRecomendTrip> addList = new ArrayList<>();
        List<HotRecomendTrip> modList = new ArrayList<>();
        List<HotRecomendTrip> delList = new ArrayList<>();
        // 没有获取操作的数据,DealTime为行号
        List<HotRecomendTrip> noneList = new ArrayList<>();
        //放至所有操作集合
        Map<String, List<HotRecomendTrip>> varMap = new HashMap<>(16);
        //记录日志用
        logi = startRow;
        int j = startCol - 1;
        try {
            // 判断文件创建不同的类
            Workbook wb = ExcelConstant.XLS.equals(suffix) ? new HSSFWorkbook(in) : new XSSFWorkbook(in);
            // sheet 从0开始
            Sheet sheet = wb.getSheetAt(sheetNum);
            // 取得最后一行的行号
            int rowNum = sheet.getLastRowNum() + 1;
            // 行 循环开始
            for (int i = startRow - 1; i < rowNum; i++) {
                logi = i + 1;
                // 行号
                Row row = sheet.getRow(i);
                // 列号
                j = startCol - 1;
                // 获取判断操作,传入判断操作列号(从0开始,所有比实际-1) -> J列(j=10)
                String op = getCellFormatValue(row.getCell(excelColStrToNum(opColStr) - 1));
                //存放行数据
                HotRecomendTrip var = new HotRecomendTrip();
                // 获取实体
                var = setHotRecomendTrip(row, j, op);
                switch (op) {
                    case ADD:
                        addList.add(var);
                        break;
                    case MOD:
                        modList.add(var);
                        break;
                    case DEL:
                        delList.add(var);
                        break;
                    default:
                        //没有操作的行把DealTime写入行号
                        var.setDt(i + 1 + "");
                        noneList.add(var);
                        break;
                }
                //PCT_记录百分数,10条更新一次
                if (i % 10 == 0) {
                    pct.setProgress((int) (((double) i / (double) rowNum) * EXCEL_PCT));
                }
            }
        } catch (Exception e) {
            String loc = excelColNumToStr(logj) + logi;
            //添加错误列表
            errList.add(loc + "数据格式错误");
        }
        //PCT_记录百分数,独取完
        pct.setProgress(EXCEL_PCT);
        varMap.put(ADD, addList);
        varMap.put(MOD, modList);
        varMap.put(DEL, delList);
        varMap.put(NONE, noneList);
        return varMap;
    }


    */
/**
     * @Title: setHotRecomendTrip
     * @Description: 从Excel列读取数据并写入HotRecomendTrip实体类, 不可复用
     * @Param: [row, j 开始的列序号,op 操作]
     * @return: com.aliyun.gts.bpaas.entity.TbHotRecomendTrip
     * @Author: hao.yiming
     * @Date: 2019-12-20 9:13
     * @version: v1.0
     *//*

    private HotRecomendTrip setHotRecomendTrip(Row row, int j, String op) throws Exception {
        //todo 添加数字长度
        //获取行号
        int i = row.getRowNum() + 1;
        HotRecomendTrip var = new HotRecomendTrip();
        try {
            //A id,读取校验ID
            //非新增,必须有正确值
            if (MOD.equals(op) || DEL.equals(op)) {
                try {
                    var.setId((long) row.getCell(Short.parseShort(j++ + "")).getNumericCellValue());
                } catch (Exception e) {
                    errList.add(excelColNumToStr(j) + i + "该操作需填写正确的ID");
                }
                //删除只读取ID
                if (DEL.equals(op)) {
                    return var;
                }
            } else {
                //新增直接给0
                var.setId(0);
                j++;
            }
            //B ReName
            String reName = getCellFormatValue(row.getCell(Short.parseShort(j++ + "")));
            var.setReName(reName);
            if (StringUtils.isEmpty(reName)) {
                errList.add(excelColNumToStr(j) + i + "不能为空");
            }
            if (reName.length() > STR_LEN) {
                errList.add(excelColNumToStr(j) + i + "长度不能大于" + STR_LEN);
            }
            //C TripLableId
            String tripLableId = getCellFormatValue(row.getCell(Short.parseShort(j++ + "")));
            var.setTripLableId(tripLableId);
            if (StringUtils.isEmpty(tripLableId)) {
                errList.add(excelColNumToStr(j) + i + "不能为空");
            }
            if (tripLableId.length() > STR_LEN) {
                errList.add(excelColNumToStr(j) + i + "长度不能大于" + STR_LEN);
            }
            //D TripTraffic
            String tripTraffic = getCellFormatValue(row.getCell(Short.parseShort(j++ + "")));
            var.setTripTraffic(tripTraffic);
            if (StringUtils.isEmpty(tripTraffic)) {
                errList.add(excelColNumToStr(j) + i + "不能为空");
            }
            if (tripTraffic.length() > STR_LEN) {
                errList.add(excelColNumToStr(j) + i + "长度不能大于" + STR_LEN);
            }
            //E TripDays
            try {
                long tripDays = (long) row.getCell(Short.parseShort(j++ + "")).getNumericCellValue();
                if (tripDays < 1) {
                    errList.add(excelColNumToStr(j) + i + "不能小于1");
                }
                if ((tripDays + "").length() > NUM_LEN) {
                    errList.add(excelColNumToStr(j) + i + "长度不能大于" + NUM_LEN);
                }
                var.setTripDays(tripDays);
            } catch (Exception e) {
                errList.add(excelColNumToStr(j) + i + "数据格式错误");
            }
            //F DayOrder
            try {
                long dayOrder = (long) row.getCell(Short.parseShort(j++ + "")).getNumericCellValue();
                if (dayOrder < 1) {
                    errList.add(excelColNumToStr(j) + i + "不能小于1");
                }
                if ((dayOrder + "").length() > NUM_LEN) {
                    errList.add(excelColNumToStr(j) + i + "长度不能大于" + NUM_LEN);
                }
                var.setDayOrder(dayOrder);
            } catch (Exception e) {
                errList.add(excelColNumToStr(j) + i + "数据格式错误");
            }
            //G PoiId
            String poiId = getCellFormatValue(row.getCell(Short.parseShort(j++ + "")));
            var.setPoiId(poiId);
            if (StringUtils.isEmpty(poiId)) {
                errList.add(excelColNumToStr(j) + i + "不能为空");
            }
            if (poiId.length() > STR_LEN) {
                errList.add(excelColNumToStr(j) + i + "长度不能大于" + STR_LEN);
            }
            //H PoiOrder
            try {
                long poiOrder = (long) row.getCell(Short.parseShort(j++ + "")).getNumericCellValue();
                if (poiOrder < 0) {
                    errList.add(excelColNumToStr(j) + i + "不能小于0");
                }
                if ((poiOrder + "").length() > NUM_LEN) {
                    errList.add(excelColNumToStr(j) + i + "长度不能大于" + NUM_LEN);
                }
                var.setPoiOrder(poiOrder);
            } catch (Exception e) {
                errList.add(excelColNumToStr(j) + i + "数据格式错误");
            }
            //I TripDesigner
            String tripDesigner = getCellFormatValue(row.getCell(Short.parseShort(j++ + "")));
            var.setTripDesigner(tripDesigner);
            if (StringUtils.isEmpty(tripDesigner)) {
                errList.add(excelColNumToStr(j) + i + "不能为空");
            }
            if (tripDesigner.length() > STR_LEN) {
                errList.add(excelColNumToStr(j) + i + "长度不能大于" + STR_LEN);
            }
            //ReId
            var.setReId(var.getReName());
            //DealTime
            var.setDt(DateUtil.getNowDealTime());
        } catch (Exception e) {
            logj = j;
            throw new Exception();
        }
        return var;
    }


    */
/**
     * @Title: readExcelToList
     * @Description: 读取Excel数据转换成String并存入map -> get(列).get(var行) -> varList.get(0).get("var0");
     * @Param: [in 文件流, startRow 开始行号, startCol 开始列号, sheetNum]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.String>>
     * @Author: hao.yiming
     * @Date: 2019-12-19 22:25
     * @version: v1.0
     *//*

    public static List<Map<String, String>> readExcelToList(FileInputStream in, int startRow, int startCol, int sheetNum) {
        //列集合
        List<Map<String, String>> varList = new ArrayList<>();
        try {
            HSSFWorkbook wb = new HSSFWorkbook(in);
            // sheet 从0开始
            HSSFSheet sheet = wb.getSheetAt(sheetNum);
            // 取得最后一行的行号
            int rowNum = sheet.getLastRowNum() + 1;
            // 行 循环开始
            for (int i = startRow; i < rowNum; i++) {
                //行Map
                Map<String, String> var = new HashMap<>(16);
                // 行
                HSSFRow row = sheet.getRow(i);
                // 每行的最后一个单元格位置
                int cellNum = row.getLastCellNum();
                // 列 循环开始
                for (int j = startCol; j < cellNum; j++) {
                    HSSFCell cell = row.getCell(Short.parseShort(j + ""));
                    var.put("var" + j, getCellFormatValue(cell));
                }
                varList.add(var);
            }

        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        //get(列).get(var行)
        //varList.get(0).get("var0");
        return varList;
    }


    */
/**
     * @Title: excelColStrToNum
     * @Description: Excel列字母转数字
     * @Param: [colStr] Str列号
     * @return: int 数字
     * @Author: hao.yiming
     * @Date: 2019-12-22 14:55
     * @version: v1.0
     *//*

    public static int excelColStrToNum(String colStr) {
        int num = 0;
        int result = 0;
        for (int i = 0; i < colStr.length(); i++) {
            char ch = colStr.charAt(colStr.length() - i - 1);
            num = (int) (ch - 'A' + 1);
            num *= Math.pow(26, i);
            result += num;
        }
        return result;
    }


    */
/**
     * @Title: excelColNumToStr
     * @Description: Excel列数字转字母
     * @Param: [columnIndex] 数字
     * @return: String 还原的列号
     * @Author: hao.yiming
     * @Date: 2019-12-22 14:55
     * @version: v1.0
     *//*

    public static String excelColNumToStr(int columnIndex) {
        if (columnIndex <= 0) {
            return null;
        }
        String columnStr = "";
        columnIndex--;
        do {
            if (columnStr.length() > 0) {
                columnIndex--;
            }
            columnStr = ((char) (columnIndex % 26 + (int) 'A')) + columnStr;
            columnIndex = (int) ((columnIndex - columnIndex % 26) / 26);
        } while (columnIndex > 0);
        return columnStr;
    }


    */
/**
     * @Title: getCellFormatValue
     * @Description: 判断表格内容进行转换, 返回String格式
     * @Param: [cell] 表格内容
     * @return: java.lang.String
     * @Author: hao.yiming
     * @Date: 2019-12-19 21:23
     * @version: v1.0
     *//*

    public static String getCellFormatValue(Cell cell) {
        String cellValue = null;
        if (null != cell) {
            // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
            switch (cell.getCellType()) {
                //数字
                case NUMERIC:
                    cellValue = String.valueOf((int) cell.getNumericCellValue());
                    break;
                //字符串
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                //公式
                case FORMULA:
                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                        cellValue = cell.getDateCellValue() + "";
                    } else {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                //空白
                */
/*case BLANK:
                    cellValue = "";
                    break;*//*

                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case ERROR:
                    cellValue = String.valueOf(cell.getErrorCellValue());
                    break;
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }


}
*/
