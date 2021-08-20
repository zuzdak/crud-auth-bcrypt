package pl.kaz.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import pl.kaz.service.PostService;

@Controller
public class HomeController {

	private PostService postService;
//	 private LogsService logsService;
	
	
	@Autowired
	public HomeController(PostService postService) {
		this.postService = postService;
	}

//	 @Autowired
//	 public void setLogsService(LogsService logsService) {
//	 this.logsService = logsService;
//	 }

	@RequestMapping("/")
	public String home(Model model, HttpServletRequest request) {
		String data ="";
		String sid = request.getRequestedSessionId();
		String ip = request.getRemoteAddr();
		String sn = request.getServerName(); // remoteUser
		String ru = request.getRemoteUser();
	
		data = sid + ";"+ip + ";"+sn + ";"+ru + ";"+ getDate() +"\n" ;
		model.addAttribute("post", postService.getLatestPost());
		model.addAttribute("ip", ip);
		model.addAttribute("sn", sn);
		model.addAttribute("ru", ru);
		model.addAttribute("sid", sid);
		writeData( data);
		 saveLogs();
		return "index";
	}

	// @PostConstruct
	//@GetConstructor
	// @PostMapping
	private void saveLogs(){
//		Logs logs = new Logs();
//		Date logD = new Date();
//		// ip, log_date, session_id, user_name)
//		
//		logs.setLogDate(logD);
//		logs.setIp("126.23.22.21");
//		logs.setSessionId("Askdkdueuduu");
//		logs.setUserName("Lolek");
		
		// logsService.save(logs);
		 
	//	return null ;
	}
	
	public String takeLogs(){
//		HttpServletRequest request = null;
//		Logs logs = new Logs();
//		String sid = request.getRequestedSessionId();
//		String ip = request.getRemoteAddr();
//		String sn = request.getServerName(); // remoteUser
//		String ru = request.getRemoteUser();
//		Date logDate = new Date();
//		logs.setLogDate(logDate);
//		logs.setIp(ip);
//		logs.setSessionId(sid);
//		logs.setUserName(ru);
		
		return "index";
		
	}
	
	public void writeData(String data) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String fileName="/srv/logs/log";
		fileName = fileName + getYmDate() + ".txt";
		File file = new File(fileName);
		try {
			//File file = new File("/home/kz/logfile.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data);
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public String getDate(){
    	Date date = new Date(); // yyyy-MM-dd HH:mm:ss
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
    	return strDate;
    }
	 public String getYmDate(){
	    	Date date = new Date(); // yyyy-MM-dd HH:mm:ss
	    	DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
	        String strDate = dateFormat.format(date);
	    	return strDate;
	    }
	
}
