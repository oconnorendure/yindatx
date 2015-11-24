package cn.yindatx.controller;

import com.jfinal.core.Controller;

public class DubbingController extends Controller{

	public void index(){
		render("/dubbing/dubbing.html");
	}
	
	public void detail(){
		render("/dubbing/dubbing_detail.html");
	}
}
