package cn.yindatx.controller;

import cn.yindatx.bo.Music;

import com.jfinal.core.Controller;

public class Mp3PlayController extends Controller{

	public void index(){
		String mid = getRequest().getQueryString();
		Music mp3 = Music.dao.findById(mid.replace("mid=",""));
		setAttr("mp3", mp3);
		render("/mp3play/mp3play.html");
	}
}
