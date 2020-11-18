package OpenPrograme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenPrograme {
	private static List<String> paths= new ArrayList<String>();
	
	
	static{
		paths.add("E:\\YNote\\YoudaoNote\\YoudaoNote.exe");
		paths.add("E:\\myclipse\\MyEclipse 2017 CI\\myeclipse.exe");
		paths.add("E:\\tim\\Bin\\QQScLauncher.exe");
		paths.add("C:\\Program Files (x86)\\Common Files\\IQIYI Video\\LStyle\\QyClient.exe");
		paths.add("C:\\Program Files\\Notepad++\\notepad++.exe");
		paths.add("E:\\navicat\\Navicat Premium\\navicat.exe");
		paths.add("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	}
	
	private static void openSimplePrograme(String path) {
		Runtime ec=Runtime.getRuntime();
		try {
			ec.exec(path);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	
	private static void openAllPrograme() {
		for(String path: paths) {
			openSimplePrograme(path);
		}
	}


	public static void main(String[] args) {
		System.out.println("欢迎主人进入\n\t欢乐敲代码游戏..");
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OpenPrograme.openAllPrograme();
		openDir.start();
	}
	
	
	
	
}
