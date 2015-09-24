package cn.yindatx.controller;

import com.jfinal.core.Controller;

public class Mp3PlayController extends Controller{

	public void index(){
		render("/mp3play/mp3play.html");
	}
}
