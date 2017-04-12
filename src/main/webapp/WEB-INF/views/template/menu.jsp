<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
		<c:forEach items="${menu}" var="menu_lv1">
			<dl id="menu-article">
				<dt><i class="Hui-iconfont">&#xe616;</i> ${menu_lv1.name}<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<c:forEach items="${menu_lv1.childResources}" var="menu_lv2">
							<li><a data-href="${menu_lv2.url}" data-title="${menu_lv2.name}" href="javascript:void(0)">${menu_lv2.name}</a></li>
						</c:forEach>
					</ul>
				</dd>
			</dl>
		</c:forEach>
	</div>
</aside>