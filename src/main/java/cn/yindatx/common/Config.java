package cn.yindatx.common;

import org.beetl.ext.jfinal.BeetlRenderFactory;

import cn.yindatx.controller.AboutController;
import cn.yindatx.controller.AnswerController;
import cn.yindatx.controller.BgmusicController;
import cn.yindatx.controller.CaseController;
import cn.yindatx.controller.ContactController;
import cn.yindatx.controller.DubbingController;
import cn.yindatx.controller.IndexController;
import cn.yindatx.controller.MakeController;
import cn.yindatx.controller.OrderController;
import cn.yindatx.controller.PaymentController;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;

public class Config extends JFinalConfig{

	private boolean isLocal = isDevMode();
	
	/**
     * 配置常量
     */
	@Override
	public void configConstant(Constants me) {
		if (isLocal) {
            me.setDevMode(true);
        }
        me.setError404View("/common/404.html");
        me.setError500View("/common/500.html");
        me.setMainRenderFactory(new BeetlRenderFactory());
	}

	/**
     * 配置处理器
     */
	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("base"));
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
     * 配置路由
     */
	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class).add("/about",AboutController.class);
		me.add("/case",CaseController.class).add("/dubbing",DubbingController.class);
		me.add("/bgmusic",BgmusicController.class).add("/answer",AnswerController.class);
		me.add("/make",MakeController.class).add("/order",OrderController.class);
		me.add("/payment",PaymentController.class).add("/contact",ContactController.class);
	}
	
	 private boolean isDevMode(){
	        String osName = System.getProperty("os.name");
	        return osName.indexOf("Windows") != -1;
	    }

}
