package cn.yindatx.common;

import org.beetl.ext.jfinal.BeetlRenderFactory;

import cn.yindatx.bo.Music;
import cn.yindatx.controller.AboutController;
import cn.yindatx.controller.AnswerController;
import cn.yindatx.controller.BgmusicController;
import cn.yindatx.controller.CaseController;
import cn.yindatx.controller.ContactController;
import cn.yindatx.controller.DubbingController;
import cn.yindatx.controller.IndexController;
import cn.yindatx.controller.MakeController;
import cn.yindatx.controller.Mp3PlayController;
import cn.yindatx.controller.MusicboxController;
import cn.yindatx.controller.OrderController;
import cn.yindatx.controller.PaymentController;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;

public class Config extends JFinalConfig{

	private boolean isLocal = isDevMode();
	
	/**
     * 配置常量
     */
	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("jdbc.properties");
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
	public void configPlugin(Plugins me) {
		DruidPlugin druid = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"),getProperty("driverClass"));
		me.add(druid);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druid);
		arp.setDialect(new MysqlDialect());
		
		me.add(arp);
		arp.addMapping("music", Music.class);	// 映射blog 表到 Blog模型
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
		me.add("/musicbox",MusicboxController.class).add("/mp3play",Mp3PlayController.class);
	}
	
	 private boolean isDevMode(){
	        String osName = System.getProperty("os.name");
	        return osName.indexOf("Windows") != -1;
	    }

}
