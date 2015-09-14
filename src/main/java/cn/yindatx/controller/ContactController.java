package cn.yindatx.controller;

import com.jfinal.core.Controller;

public class ContactController extends Controller{

	public void index(){
		render("/contact/contact.html");
	}
}
