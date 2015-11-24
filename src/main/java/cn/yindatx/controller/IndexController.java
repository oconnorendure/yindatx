package cn.yindatx.controller;

import java.util.List;

import cn.yindatx.bo.Music;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class IndexController extends Controller{

	public void index(){
		init();
	}
	
	public void home(){
		init();
	}
	
	private void init(){
		        //集团彩铃
				Page jituan_page = Music.dao.paginate(getParaToInt(0, 1), 10,"select *","from music where type='jituancailing' order by id asc");
				List<Music> jituan = jituan_page.getList();
				setAttr("jituan", jituan);
				//广告配音
				Page ggpy_page = Music.dao.paginate(getParaToInt(0, 1), 10,"select *","from music where type='guagngaopeiyin' order by id asc");
				List<Music> ggpy = ggpy_page.getList();
				setAttr("ggpy", ggpy);
				//播音简介
				Page byjj_page = Music.dao.paginate(getParaToInt(0, 1), 10,"select *","from music where type='boyinjianjie' order by id asc");
				List<Music> byjj = byjj_page.getList();
				setAttr("byjj", byjj);
				//背景音
				Page bjyy_page = Music.dao.paginate(getParaToInt(0, 1), 10,"select *","from music where type='beijingyinyue' order by id asc");
				List<Music> bjyy = bjyy_page.getList();
				setAttr("bjyy", bjyy);
				render("/common/index.html");
	}
}
