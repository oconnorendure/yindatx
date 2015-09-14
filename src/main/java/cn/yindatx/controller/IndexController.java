package cn.yindatx.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller{

	public void index(){
		render("/common/index.html");
	}
}
