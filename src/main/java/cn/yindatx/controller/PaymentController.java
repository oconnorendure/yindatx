package cn.yindatx.controller;

import com.jfinal.core.Controller;

public class PaymentController extends Controller{

	public void index(){
		render("/payment/payment.html");
	}
}
