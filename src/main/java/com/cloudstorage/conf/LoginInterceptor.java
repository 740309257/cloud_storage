package com.cloudstorage.conf;

import com.cloudstorage.entity.User;
import com.cloudstorage.util.CloudContants;
import com.cloudstorage.util.util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 11:14 2017/12/31 0031
 **/
public class LoginInterceptor implements HandlerInterceptor {

	private static Log logger = LogFactory.getLog(LoginInterceptor.class);

	//url和权限对应表
	private RegexHashMap<String, Set<String>> urlMap;

	private Set<String> publicUrl;

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception{
//		logger.info(util.toJson(urlMap));
//		logger.info(util.toJson(publicUrl));

		String requestUri = httpServletRequest.getRequestURI();
		if(publicUrl.contains(requestUri)){
			logger.info("访问公开url:" + requestUri);
			return true;
		}

		logger.info("当前访问url:" + requestUri);
		HttpSession session = httpServletRequest.getSession();
		User user = (User) session.getAttribute(CloudContants.SESSION_USER_KEY);
		if(user != null){
			logger.info(user.toString());
			List<String> userRoles = (List<String>) session.getAttribute(CloudContants.SESSION_ROLE_KEY);
			if(userRoles == null){
				logger.error(user.getId() + "权限为空");
				return false;
			}
			logger.info("用户权限: " + util.toJson(userRoles));
			Set<String> permittedRoles = this.urlMap.get(requestUri);
			logger.info("所需权限: " + util.toJson(permittedRoles));
			for (String role : userRoles) {
				if(permittedRoles.contains(role)){
					LoginContext.saveLoginInfo(user);
					return true;
				}
			}
			logger.error(user.getId() + "无权限");
			httpServletResponse.setStatus(HttpStatus.BAD_GATEWAY.value());
			httpServletResponse.getWriter().write("403无权限");
			return false;
		} else {
			logger.error("session中用户信息为空");
			httpServletResponse.sendRedirect("/main_page");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception{
		LoginContext.removeLoginInfo();
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception{

	}

	public RegexHashMap<String, Set<String>> getUrlMap(){
		return urlMap;
	}

	public void setUrlMap(RegexHashMap<String, Set<String>> urlMap){
		this.urlMap = urlMap;
	}

	public Set<String> getPublicUrl(){
		return publicUrl;
	}

	public void setPublicUrl(Set<String> publicUrl){
		this.publicUrl = publicUrl;
	}
}
