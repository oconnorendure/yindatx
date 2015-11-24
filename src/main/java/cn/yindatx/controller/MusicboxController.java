package cn.yindatx.controller;

import com.jfinal.core.Controller;

public class MusicboxController extends Controller{

	public void index(){
		String mid = getRequest().getQueryString();
		setAttr("mid",mid.replace("mid=",""));
		render("/musicbox/musicbox.html");
	}
	
	public void play(){
		forwardAction("/music");
	}
}
