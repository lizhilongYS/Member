/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-06 04:29:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class assistantsetup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/hello.tld", Long.valueOf(1527863328000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fshowNum_0026_005furl_005fclassName2_005fclassName1_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fh_005fshowNum_0026_005furl_005fclassName2_005fclassName1_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fh_005fshowNum_0026_005furl_005fclassName2_005fclassName1_005fnobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=UTF-8>\r\n");
      out.write("<title>基础设置-Java互助学习VIP群业务运行系统</title>\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css?time=20161215\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"shortcut icon\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/Icon.ico\" />\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/H-ui_v3.0/css/H-ui.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/page.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layer-v2.4/layer.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\r\n");
      out.write("\t\t//第一次进来默认设置\r\n");
      out.write("\t\tgetData(\"艾渊\");\r\n");
      out.write("\t\t//加载密码重置\r\n");
      out.write("\t\tmycellclick();\r\n");
      out.write("\t\t//控制隐藏和显示div\r\n");
      out.write("\t\tvar current=document.getElementById(\"menu1\"); \r\n");
      out.write("\t   \tif($(\"#member\").val()==\"\")  \r\n");
      out.write("\t     {  \r\n");
      out.write("\t       current.style.display=\"none\";  \r\n");
      out.write("\t     }\r\n");
      out.write("\t   \tvar name=null;\r\n");
      out.write("\t\t//设置选中会员的id\r\n");
      out.write("\t\t$(\"#tabsC\").on('click','.setMember',function(){\r\n");
      out.write("\t\t\t$(\"#tabsC li a span\").css(\"color\",\"#212122\")\r\n");
      out.write("\t\t\t$(this).children(\"span\").css(\"color\",\"red\");\r\n");
      out.write("\t\t\t//current.style.display=\"block\";  \r\n");
      out.write("\t\t\tvar reStripTags = /<\\/?.*?>/g;\r\n");
      out.write("\t\t\tvar textOnly = this.innerHTML.replace(reStripTags, ''); //只有文字的结果\r\n");
      out.write("\t\t\tname=textOnly;\r\n");
      out.write("\t\t\t$(\"#tabsC2\").html(\"\");\r\n");
      out.write("\t\t\tgetData(name);\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t$.ajaxSetup ({\r\n");
      out.write("\r\n");
      out.write("\t    cache: false //关闭AJAX相应的缓存\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//第一次点击进来的默认值\r\n");
      out.write("\t\tfunction getData(name) {\r\n");
      out.write("\t\t\t$.ajaxSetup({\r\n");
      out.write("\t\t\t\tasync : false\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getMemInfoByName.action\",{mname:name}, function(data) {\r\n");
      out.write("\t\t\t\tvar dataObj = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\t\tdrawTable(dataObj);\r\n");
      out.write("\t\t\t\tclickRows();\r\n");
      out.write("\t\t\t\tsummarytdclick();\r\n");
      out.write("\t\t\t\tsetupclick();\r\n");
      out.write("\t\t\t\tmycellclick();\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction drawTable(data) {\r\n");
      out.write("\t\t\tvar line = \"\";\r\n");
      out.write("\t\t\t\tline += \"<tr class='rows'>\";\r\n");
      out.write("\t\t\t\tline += \"<td>\" + data.name + \"</td>\";\r\n");
      out.write("\t\t\t\tline += \"<td>\" + data.member.name + \"</td>\";\r\n");
      out.write("\t\t\t\tline += \"<td class='td-status' lang='\"+ data.member.id + \",\" + data.member.name + \"'>\";\r\n");
      out.write("\t\t\t\tif (data.member.summaryflag == '1') {\r\n");
      out.write("\t\t\t\t\tline += \"<span class='label label-danger radius'>需要</span>\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tline += \"<span class='label label-success radius'>不需要</span>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tline += \"</td>\";\r\n");
      out.write("\t\t\t\tif (data.admin != null) {\r\n");
      out.write("\t\t\t\t\tline += \"<td>\" + data.admin.realname + \"</td>\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tline += \"<td>\" + \"\" + \"</td>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tline += \"<td>\";\r\n");
      out.write("\t\t\t\tline += \"<a href='javascript:void(0)' lang='\"\r\n");
      out.write("\t\t\t\t\t\t+ data.member.id + \",\" + data.member.name\r\n");
      out.write("\t\t\t\t\t\t+ \"' class='setup' >设置</a>\";\r\n");
      out.write("\t\t\t\tline += \"</td>\";\r\n");
      out.write("\t\t\t\tline=line + \"<td>\" + \"<a href='javascript:void(0)' lang='\"\r\n");
      out.write("\t\t\t\t\t\t+ data.id + \"' class='mycell' >重置</a>\" + \"</td>\";\r\n");
      out.write("\t\t\t\tline += \"</tr>\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#tbody\").html(line);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//周报标记td点击事件\r\n");
      out.write("\t\tfunction summarytdclick() {\r\n");
      out.write("\t\t\t$(\".td-status\").click(function() {\r\n");
      out.write("\t\t\t\tvar data = this.lang.split(\",\");\r\n");
      out.write("\t\t\t\tvar id = data[0];\r\n");
      out.write("\t\t\t\tvar name = data[1];\r\n");
      out.write("\t\t\t\tvar msg = \"\"\r\n");
      out.write("\t\t\t\t//alert($(this).children(\"span\").text());\r\n");
      out.write("\t\t\t\tif ($(this).children(\"span\").text() == \"需要\") {\r\n");
      out.write("\t\t\t\t\tmsg = \"你确定要设置\\\"不需要\\\"提交周报？\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tmsg = \"你确定要设置\\\"需要\\\"提交周报？\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tlayer.confirm(msg,{btn : [ '确定', '取消' ]},function(index, layero) {\r\n");
      out.write("\t\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/toggleSummryflag.action\",{id : id},function() {\r\n");
      out.write("\t\t\t\t\t\tgetData(name);\r\n");
      out.write("\t\t\t\t\t\tlayer.closeAll();\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction setupclick() {\r\n");
      out.write("\t\t\t$(\".setup\").click(function() {\r\n");
      out.write("\t\t\t\tvar data = this.lang.split(\",\");\r\n");
      out.write("\t\t\t\tvar id = data[0];\r\n");
      out.write("\t\t\t\tvar name = data[1];\r\n");
      out.write("\t\t\t\tlayer.open({\r\n");
      out.write("\t\t\t\t\t\ttype : 2,\r\n");
      out.write("\t\t\t\t\t\ttitle : '设置小助手',\r\n");
      out.write("\t\t\t\t\t\tarea : [ '600px', '361px' ],\r\n");
      out.write("\t\t\t\t\t\t// closeBtn: 0, //不显示关闭按钮\r\n");
      out.write("\t\t\t\t\t\tshift : 1,\r\n");
      out.write("\t\t\t\t\t\tshade : 0.5, //开启遮罩关闭\r\n");
      out.write("\t\t\t\t\t\tcontent : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/assistantselect.jsp?id='\r\n");
      out.write("\t\t\t\t\t\t\t\t+ id + '&name=' + name,\r\n");
      out.write("\t\t\t\t\t\tend : function() {\r\n");
      out.write("\t\t\t\t\t\t\tgetData(name);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//密码重置\r\n");
      out.write("\t\tfunction mycellclick(){\r\n");
      out.write("\t\t\t$.ajaxSetup({\r\n");
      out.write("\t\t\t\tasync : false\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\".mycell\").click(function(data){\r\n");
      out.write("\t\t\t\tvar authority;\r\n");
      out.write("\t\t\t\tvar lang=this.lang;\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/checkAdminAuthorith.action\",function(data){\r\n");
      out.write("\t\t\t\t\tif(data == 1)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tauthority=data;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t\t\t\tif(authority==1)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t/*重置密码，弹出对话框，确认是否要重置密码*/\r\n");
      out.write("\t\t\t\t\tlayer.confirm(\r\n");
      out.write("\t\t\t\t\t\t\t'您确定要重置该用户密码吗?重置密码将删除该用户的原始密码，请谨慎操作！',\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\tbtn : [ '是', '否' ]\r\n");
      out.write("\t\t\t\t\t\t\t},//按钮一的回调函数\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\t $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/getPwd.action\",{id:lang},function(data){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\".mycell\").html(\"\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\".mycell\").parent().text(data); \r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.closeAll('dialog');\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\talert(\"您不具备该权限，请联系管理员!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/jslib/currency.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"tag\" style=\"padding-right: 50px;\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_h_005fshowNum_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"msg\"></div>\r\n");
      out.write("\t<div id=\"tabsC\" style=\"margin-bottom: 20px;\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<h1 class=\"text-c\">VIP会员基础设置</h1>\r\n");
      out.write("\t<div class=\"mt-20\">\r\n");
      out.write("\t\t<table id=\"users\"\r\n");
      out.write("\t\t\tclass=\"table table-border table-bg table-bordered radius\">\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"panel panel-secondary\">\r\n");
      out.write("\t\t<!-- <div class=\"panel-header\"></div> -->\r\n");
      out.write("\t\t<div class=\"panel-primary\">\r\n");
      out.write("\t\t\t<table class=\"table table-border table-bg table-bordered radius\">\r\n");
      out.write("\t\t\t\t<thead class='text-c'>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>会员编号</th>\r\n");
      out.write("\t\t\t\t\t\t<th>会员姓名</th>\r\n");
      out.write("\t\t\t\t\t\t<th>是否需要写周报</th>\r\n");
      out.write("\t\t\t\t\t\t<th>小助手姓名</th>\r\n");
      out.write("\t\t\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t\t\t\t<th>密码重置</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"tbody\" class='text-c'></tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class='page-nav' style=\"float: right; margin-top: 10px;\"></div>\r\n");
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

  private boolean _jspx_meth_h_005fshowNum_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  h:showNum
    test.ShowNum _jspx_th_h_005fshowNum_005f0 = (test.ShowNum) _005fjspx_005ftagPool_005fh_005fshowNum_0026_005furl_005fclassName2_005fclassName1_005fnobody.get(test.ShowNum.class);
    _jspx_th_h_005fshowNum_005f0.setPageContext(_jspx_page_context);
    _jspx_th_h_005fshowNum_005f0.setParent(null);
    // /admin/assistantsetup.jsp(187,2) name = className2 type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_h_005fshowNum_005f0.setClassName2("setMember");
    // /admin/assistantsetup.jsp(187,2) name = className1 type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_h_005fshowNum_005f0.setClassName1("num");
    // /admin/assistantsetup.jsp(187,2) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_h_005fshowNum_005f0.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}/member/getAllNames.action", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_h_005fshowNum_005f0 = _jspx_th_h_005fshowNum_005f0.doStartTag();
    if (_jspx_th_h_005fshowNum_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fh_005fshowNum_0026_005furl_005fclassName2_005fclassName1_005fnobody.reuse(_jspx_th_h_005fshowNum_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fshowNum_0026_005furl_005fclassName2_005fclassName1_005fnobody.reuse(_jspx_th_h_005fshowNum_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /admin/assistantsetup.jsp(194,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ADMIN==null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (true) {
          _jspx_page_context.forward("/user/login.jsp");
          return true;
        }
        out.write('\r');
        out.write('\n');
        out.write('	');
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
