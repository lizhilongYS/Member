/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-07 06:12:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class navbar1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>管理后台</title>\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/H-ui_v3.0/css/H-ui.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/bootstrap/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/icon/H~ui_ICON_1.0.8/iconfont.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/navbar/css/index.css\"\r\n");
      out.write("\ttype=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".checkfee {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layer-v2.4/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/navbar/js/tendina.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/navbar/js/common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script src=\"http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<style>\r\n");
      out.write(".left-menu {\r\n");
      out.write("\tleft: 0px;\r\n");
      out.write("\tz-index: 9999\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".right-content {\r\n");
      out.write("\tz-index: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".content {\r\n");
      out.write("\theight: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bg {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tbackground: rgba(0, 0, 0, 0.5);\r\n");
      out.write("\tposition: fixed;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tz-index: 10;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media ( max-width :992px) {\r\n");
      out.write("\t.left-menu {\r\n");
      out.write("\t\tleft: -180px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.left-menu.on {\r\n");
      out.write("\t\tleft: 0px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.right-content {\r\n");
      out.write("\t\tmargin-left: 0px;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("/*html5兼容*/\r\n");
      out.write("article, aside, dialog, footer, header, section, footer, nav, figure,\r\n");
      out.write("\tmenu {\r\n");
      out.write("\tdisplay: block\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t//菜单隐藏和显示\r\n");
      out.write("\t\t$(\".menu_icon\").click(function(){\r\n");
      out.write("\t\t\t$(\".left-menu\").addClass(\"on\");\r\n");
      out.write("\t\t\t$(\".bg\").fadeIn();\r\n");
      out.write("\t\t}) \r\n");
      out.write("\t\t$(\".bg\").click(function(){\r\n");
      out.write("\t\t\t$(\".left-menu\").removeClass(\"on\");\r\n");
      out.write("\t\t\t$(\".bg\").fadeOut();\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t//关闭AJAX相应的缓存\r\n");
      out.write("\t\t$.ajaxSetup({cache : false});\r\n");
      out.write("\t\tsession();\r\n");
      out.write("\t\tsetFeeVisible();\t\t\r\n");
      out.write("\t\t$(\"html\").click(function() {\r\n");
      out.write("\t\t\tsession();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t$(\"#wrap\").load(getAnchor());\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".menuItem\").click(function() {\r\n");
      out.write("\t\t\t$(\"#wrap\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" + $(this).attr(\"href\").substring(1));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\tvar t;\r\n");
      out.write("\t//根据登录权限判断，如果是超级管理员蔡显示费用相关链接\r\n");
      out.write("\tfunction setFeeVisible(){\r\n");
      out.write("\t\tvar authority = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ADMIN.authority}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\t\tif (authority==\"1\"){\r\n");
      out.write("\t\t\t$(\".checkfee\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction session() {\r\n");
      out.write("\t\tclearTimeout(t);\r\n");
      out.write("\t\t$.ajaxSetup({async : false});\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/checkAdminSession.action\",function(data) {\r\n");
      out.write("\t\t\tif (data == \"1\") {\r\n");
      out.write("\t\t\t\tt = setTimeout(\"session()\", 1000 * 60 * 120);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tlocation.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/login.jsp\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction exit() {\r\n");
      out.write("\t\tif (confirm(\"确定要退出吗？\")) {\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/clearSession.action\",function() {\r\n");
      out.write("\t\t\t\twindow.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index.jsp\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction AdminInfo() {\r\n");
      out.write("\t\tlayer.open({\r\n");
      out.write("\t\t\ttype : 2,\r\n");
      out.write("\t\t\ttitle : '权限管理',\r\n");
      out.write("\t\t\tarea : [ '900px', '600px' ],\r\n");
      out.write("\t\t\tshift : 1,\r\n");
      out.write("\t\t\tmaxmin : true,\r\n");
      out.write("\t\t\tcontent : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/adminInfo.jsp',\r\n");
      out.write("\t\t\tend : function() {\r\n");
      out.write("\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction modifyChmod() {\r\n");
      out.write("\t\tlayer.open({\r\n");
      out.write("\t\t\ttype : 2,\r\n");
      out.write("\t\t\ttitle : '权限管理',\r\n");
      out.write("\t\t\tarea : [ '600px', '350px' ],\r\n");
      out.write("\t\t\tshift : 1,\r\n");
      out.write("\t\t\tmaxmin : true,\r\n");
      out.write("\t\t\tcontent : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/showAllAdmin.jsp',\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getAnchor() {\r\n");
      out.write("\t\tvar anchor = window.location.hash;\r\n");
      out.write("\t\tif(anchor == \"\" || anchor == \"#\") {\r\n");
      out.write("\t\t\treturn \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/infoshow.jsp\";\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\tif ($(\"#mem\").val() != 0) {\r\n");
      out.write("\t\t\t\treturn \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/lookmemberinformation.jsp\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/check.jsp\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t*/\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" + anchor.substring(1);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction hidePhoneMenu(){\r\n");
      out.write("\t\tif($(\"body\").width()<667){\r\n");
      out.write("\t\t\t$(\".left-menu\").removeClass(\"on\");\r\n");
      out.write("\t\t\t$(\".bg\").fadeOut();\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--顶部-->\r\n");
      out.write("\t<div class=\"top\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-2 col-xs-2\">\r\n");
      out.write("\t\t\t\t\t<div class=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu_icon\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"../images/menu_icon.png\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<span style=\"background-color: #333; color: #fff\">菜单</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-10 col-xs-10\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float: left\">\r\n");
      out.write("\t\t\t\t\t\t<span\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-size: 16px; line-height: 45px; padding-left: 20px; color: #fff; width: 100%;\">VIP会员管理中心</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"ad_setting\" class=\"ad_setting\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"ad_setting_a\" href=\"javascript:; \">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin1.realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu-uu\" style=\"display: none\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"ad_setting_ul\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"ad_setting_ul_li\" onclick=\"AdminInfo()\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"javascript:;\"> <i class=\"icon-signout glyph-icon\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"font-bold\">个人信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 管理员权限判断 1为超级管理员  -->\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"ad_setting_ul_li\" onclick=\"exit()\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"javascript:;\"> <i class=\"icon-signout glyph-icon\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"font-bold\">退出</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"use_xl\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/navbar/images/right_menu.png\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--顶部结束-->\r\n");
      out.write("\t<!--菜单-->\r\n");
      out.write("\t<div class=\"left-menu\" style=\"float: left;\">\r\n");
      out.write("\t\t<ul id=\"menu\">\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"\r\n");
      out.write("\t\t\t\thref=\"#/member/infoshow.jsp\" class=\"menuItem\" title=\"主页\"><i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe625;</i>主页</a></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe6cc;</i>会员管理\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/check.jsp\" class=\"menuItem\" \r\n");
      out.write("\t\t\t\t\t\ttitle=\"会员审核\"><i></i><i></i><i></i>会员审核</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/infomanagement.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"信息管理\"><i></i><i></i><i></i>信息管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/assistantsetup.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"会员基础设置\"><i></i><i></i><i></i>基础设置</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/membercommunication.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"沟通信息\"><i></i><i></i><i></i>沟通信息</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/checkimage1.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"图片管理\"><i></i><i></i><i></i>图片管理</a></li>\r\n");
      out.write("\t\t\t\t\t<!-- <li><a href=\"#/admin/initpwd.jsp\" class=\"menuItem\" title=\"密码管理\"><i></i><i></i><i></i>密码管理</a></li> -->\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/lookmemberinformation.jsp\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"menuItem\" title=\"详细信息\"><i></i><i></i><i></i>详细信息</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/uploading/photowall.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"会员照片\"><i></i><i></i><i></i>会员照片</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/member/newschoolInfo.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"学校信息\"><i></i><i></i><i></i>学校信息</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe62b;</i>体验管理\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/experiencer/manageExperience.jsp\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"menuItem\" title=\"体验用户\"><i></i><i></i><i></i>体验用户</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/expassistantsetup.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"体验者基础设置\"><i></i><i></i><i></i>基础设置</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/experiencer/allInformation.jsp\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"menuItem\" title=\"体验者详细信息\"><i></i><i></i><i></i>详细信息</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/clue/clueManagement.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"跟踪管理\"><i></i><i></i><i></i>跟踪管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/experiencer/monthlyMembership.jsp\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"menuItem\" title=\"月入会员\"><i></i><i></i><i></i>月入会员</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"\r\n");
      out.write("\t\t\t\thref=\"#/admin/allcommunications.jsp\" class=\"menuItem\" title=\"沟通汇总\"><i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe6d0;</i>沟通汇总</a></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe647;</i>周报管理\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/getnosummarymembers.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"缺交人员\"><i></i><i></i><i></i>缺交人员</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/looksummarys.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"周报管理\"><i></i><i></i><i></i>周报管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/dailyLog/dailyLogs.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"工作日志\"><i></i><i></i><i></i>工作日志</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/allWeekly.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"所有周报\"><i></i><i></i><i></i>所有周报</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe63a;</i>费用管理\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/pay.jsp\" class=\"menuItem\" title=\"会员缴费\"><i></i><i></i><i></i>会员缴费</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"checkfee\"><a href=\"#/admin/feedetailTwo.action\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"menuItem\" title=\"缴费审核\"><i></i><i></i><i></i>缴费审核</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"checkfee\"><a href=\"#/admin/feepay.action\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"menuItem\" title=\"应缴费用\"><i></i><i></i><i></i>应缴费用</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"checkfee\"><a href=\"#/admin/fee.action\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"menuItem\" title=\"缴费信息\"><i></i><i></i><i></i>缴费信息</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/thanksgiving/restinfo.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"利息市场\"><i></i><i></i><i></i>利息市场</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/calculator.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"费用计算\"><i></i><i></i><i></i>费用计算</a></li>\r\n");
      out.write("\t\t\t\t\t<!-- <li><a href=\"javascript:;\" title=\"费用统计\"><i></i><i></i><i></i>费用统计</a></li> -->\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe63a;</i>公司账目\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/companyaccount.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"软件开发\"><i></i><i></i><i></i>软件开发</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/commpanyaccount.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"技术培训\"><i></i><i></i><i></i>技术培训</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"\r\n");
      out.write("\t\t\t\thref=\"#/admin/history.jsp\" class=\"menuItem\" title=\"来访记录\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe70c;</i>来访记录\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"\r\n");
      out.write("\t\t\t\thref=\"#/admin/notice.jsp\" class=\"menuItem\" title=\"公告管理\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe63b;</i>公告管理\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"\r\n");
      out.write("\t\t\t\thref=\"#/admin/dutymanagement.jsp\" class=\"menuItem\" title=\"值班管理\">\r\n");
      out.write("\t\t\t\t\t<i></i><i class=\"Hui-iconfont\">&#xe623;</i>值班管理\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe61c;</i>课程进度\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/coursesmanage1.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"课程管理\"><i></i><i></i><i></i>课程管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/setcategory.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"专业设置\"><i></i><i></i><i></i>专业设置</a></li>\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t<li><a href=\"#/course/progressbycategory.jsp\" class=\"menuItem\" title=\"会员进度\"><i></i><i></i><i></i>会员进度</a></li>-->\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#/admin/checkquestions.jsp\" class=\"menuItem\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"问答审核\"><i></i><i></i><i></i>问答审核</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"\r\n");
      out.write("\t\t\t\thref=\"#/admin/resources.jsp\" class=\"menuItem\" title=\"学习资源\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe623;</i>学习资源\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li class=\"menu-list\"><a style=\"cursor: pointer\"\r\n");
      out.write("\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index.jsp\"> <i></i><i\r\n");
      out.write("\t\t\t\t\tclass=\"Hui-iconfont\">&#xe66b;</i>返回首页\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"bg\"></div>\r\n");
      out.write("\t<div class=\"right-content\">\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"wrap\" style=\"padding-left: 0; margin-top: 0;\"></div>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"mem\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myuser.member.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /admin/navbar1.jsp(210,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.admin.authority == 1 }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<li class=\"ad_setting_ul_li\" onclick=\"modifyChmod()\"><a\r\n");
        out.write("\t\t\t\t\t\t\t\t\thref=\"javascript:;\"> <i class=\"icon-signout glyph-icon\"></i>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"font-bold\">权限管理</span>\r\n");
        out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
