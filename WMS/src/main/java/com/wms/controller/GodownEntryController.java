package com.wms.controller;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wms.bean.Cargo;
import com.wms.bean.Godown;
import com.wms.bean.GodownEntry;
import com.wms.bean.Receiving;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.ReadXls;
import com.wms.service.CargoService;
import com.wms.service.GodownEntryService;
import com.wms.service.GodownService;
import com.wms.service.ReceivingService;
/**
 * 
 *
 */
@Controller
@RequestMapping("/putstorage")
public class GodownEntryController extends BaseController {
	
	@Autowired
	private GodownEntryService godownEntryService;
	
    @Autowired
    private GodownService godownService;
	
	@Autowired
	private ReceivingService receivingService;
	
	@Autowired
	private CargoService cargoService;

	
	@RequestMapping("/receiving")
	public String ruchuPage(){
		return "putstorage/receiving";
	} 
	
	@RequestMapping("/readExcle")
	public String Excle(@RequestParam("file") MultipartFile file, HttpServletRequest request,Model model){
		try {
			String path = (GodownEntryController.class.getResource("/").toString()).substring(6);
			if(!file.isEmpty()){
				Streams.copy(file.getInputStream(),new FileOutputStream(path+"/"+file.getOriginalFilename()),true);
			}
			URL url = GodownEntryController.class.getResource("/"+file.getOriginalFilename());
			List<List<String>> list = ReadXls.readxls(url.getFile());
			GodownEntry g = new GodownEntry();
			List<String> obj = list.get(2);
				for(int j=0;j<14;j++){
					g.setgName(obj.get(0));//货物名称
					g.setgStorerid(obj.get(1));//货主
					g.setgPhone(Integer.valueOf(obj.get(2).trim().substring(0, obj.get(2).length()-2)).toString());//号码
					g.setgSippingno(obj.get(3));//客户托单号
					g.setgWhid(Integer.valueOf(obj.get(4).trim().length()-2).toString());//仓库编码
					g.setgSupplierid(obj.get(5));//供应商
					if("".equals(obj.get(6))){
						g.setgNumber(0);
					}else{
						g.setgNumber(Integer.valueOf(obj.get(6).trim().substring(0, obj.get(6).length()-2)));//数量
					}
					g.setgHeavy(Double.valueOf(obj.get(7).trim().substring(0, obj.get(7).length()-2)));//重量
					g.setgNum(Double.valueOf(obj.get(8).trim().substring(0, obj.get(8).length()-2)));//体积
					if("越库".equals(obj.get(9).trim())){
						g.setgCrossflag(0+"");
					}else{
						g.setgCrossflag(1+"");
					}
					if("整进".equals(obj.get(10).trim())){
						g.setgDirectflag(0+"");
					}else{
						g.setgDirectflag(1+"");
					}
					g.setgTime(updateTime("".equals(obj.get(11))?null:obj.get(11)));//时间
					g.setgAdminid(Integer.valueOf(obj.get(12).trim().substring(0, obj.get(12).length()-2)));//管理员编号
					g.setgSkumodel(obj.get(13));//货物型号
				}
				System.out.println(g.toString());
				model.addAttribute("godown", g);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "putstorage/receiving";
	}
	
	
	@PostMapping("/save")
	@ResponseBody
	public Object save(GodownEntry godownEntry,Receiving receiving,String sgTime, String srTime){
		godownEntry.setgTime(updateTime(sgTime));
		receiving.setrTime(updateTime(srTime));
		int a = godownEntryService.insert(godownEntry);
		int b = receivingService.insert(receiving);
		Cargo g = new Cargo();
		g.setcName(receiving.getrName());
		g.setcReceivedate(receiving.getrTime());
		g.setcShippingno(receiving.getrSippingno());
		g.setcSkumodel(receiving.getrSkumodel());
		g.setcStorerid(receiving.getrStorerid());
		g.setcSupplierid(receiving.getrSupplierid());
		g.setcTotalvolume(receiving.getrNum());
		g.setcWhid(receiving.getrWhid());
		g.setcNum(receiving.getrNumber());
		g.setcTotalweight(receiving.getrHeavy());
		int d = run(receiving);
		int c = cargoService.insert(g);
		if(a>0 && b>0 && c>0&&d>0){
			return renderSuccess("添加成功");
		}else{
			return renderError("添加失败");
		}
	}
	
	 /**
     * 把字符串时间转成Date类型
     *
     * @param time
     * @return
     */
    private Date updateTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    private int run(Receiving receiving){
    	Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
    	g.setGoRdvolume(g.getGoRdvolume()-receiving.getrNum());//可用容积
    	g.setGoUsevolume(g.getGoUsevolume()+receiving.getrNum());//已用容积
    	int a = godownService.updateByPrimaryKey(g);
    	if(a>0){
    		return 1;
    	}else{
    		return 0;
    	}
    }

}
