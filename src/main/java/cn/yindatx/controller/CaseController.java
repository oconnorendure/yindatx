package cn.yindatx.controller;

import java.util.List;

import cn.yindatx.bo.Music;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class CaseController extends Controller{

	public void index(){
		Page jituan_page = Music.dao.paginate(getParaToInt(0, 1), 20,"select *","from music where type='jituancailing' order by id asc");
		List<Music> jituan = jituan_page.getList();
		setAttr("jituan", jituan);
		render("/case/case.html");
	}
}
