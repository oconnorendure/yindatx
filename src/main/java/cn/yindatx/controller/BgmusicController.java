package cn.yindatx.controller;

import java.util.List;

import cn.yindatx.bo.Music;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class BgmusicController extends Controller{

	public void index(){
		Page bjyy_page = Music.dao.paginate(getParaToInt(0, 1), 10,"select *","from music where type='beijingyinyue' order by id asc");
		List<Music> bjyy = bjyy_page.getList();
		setAttr("bjyy", bjyy);
		render("/bgmusic/bgmusic.html");
	}
}
