package com.crm.util;

import java.lang.ref.WeakReference;

import javax.servlet.ServletConfig;

import org.springframework.web.context.ServletConfigAware;

public class WebUtil implements ServletConfigAware {

	private static WeakReference<ServletConfig> servletConfigRef;

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		servletConfigRef = new WeakReference<ServletConfig>(servletConfig);
	}

	public static String buildRelativeUrl(String url) {
		return servletConfigRef.get().getServletContext().getContextPath() + "/" + url;
	}
	
	
	
}
