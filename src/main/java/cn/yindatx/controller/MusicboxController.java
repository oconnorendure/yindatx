package cn.yindatx.controller;

import com.jfinal.core.Controller;

public class MusicboxController extends Controller{

	public void index(){
		System.out.println("come in ");
		render("/musicbox/musicbox.html");
	}
	
	public void play(){
		forwardAction("/music");
	}
}
