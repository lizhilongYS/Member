/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-21 11:17:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class commpanyaccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/H-ui_v3.0/css/H-ui.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/page.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".table .text-c th {\n");
      out.write("\ttext-align: center;\n");
      out.write("\tline-height: 25px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table .text-c td {\n");
      out.write("\ttext-align: center;\n");
      out.write("\tline-height: 28px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layer-v2.4/layer.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/jslib/currency.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function(){\n");
      out.write("\t//layer加载 添加费用页面\n");
      out.write("\t$(\"#add\").unbind(\"click\").click(function(){\n");
      out.write("\t\tlayer.open({\n");
      out.write("\t\t\t  type: 2,\n");
      out.write("\t\t\t  title: '添加账目',\n");
      out.write("\t\t\t  area: ['800px', '600px'],\n");
      out.write("\t\t\t  shift: 1,\n");
      out.write("\t\t\t  shade: 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/companyaccount/add.jsp?ftype=1',\n");
      out.write("\t\t\t  end: function(){\n");
      out.write("\t\t\t\tgetData();\n");
      out.write("\t\t\t  }\n");
      out.write("\t\t});\n");
      out.write("\t})\n");
      out.write("\t//管理记账人\t\t功能以后实现\n");
      out.write("\tvar page = 1;\n");
      out.write("\t\n");
      out.write("\t$.ajaxSetup({async:false});\n");
      out.write("\t$(\"[name='assistant']\").change(function(){\n");
      out.write("\t\tgetData();\n");
      out.write("\t})\n");
      out.write("\tshowAssist();//展示assist 需要放在最前面\n");
      out.write("\tgetData();\n");
      out.write("\tmodify();\n");
      out.write("\tdeleteNode();\n");
      out.write("\tshow();\n");
      out.write("\ttextOn();\n");
      out.write("\taccountReview();\n");
      out.write("\t/*获取不同种类的费用信息*/\n");
      out.write("\t$(\".butname\").click(function(){\n");
      out.write("\t\tvar buttons =$(\".butname\");\n");
      out.write("\t\tbuttons.removeClass(\"active\");\n");
      out.write("\t    $(this).addClass(\"active\");\n");
      out.write("\t\tgetData();\n");
      out.write("\t});\n");
      out.write("\t//分页按钮点击事件\n");
      out.write("\tfunction btnclick(){\n");
      out.write("\t\t$(\".nav-btn\").click(function(){\n");
      out.write("\t\t\tpage=this.lang;\n");
      out.write("\t\t\tgetData();\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\t//展示费用使用详情\n");
      out.write("\tfunction getData(){\n");
      out.write("\t\t//设置同步\n");
      out.write("\t\t$.ajaxSetup({async:false});\n");
      out.write("\t\tvar json = {\"admin.id\":$(\"[name='assistant']\").val(),ftype:1,\"page.currentPage\":page};\n");
      out.write("\t\t//查看 北京地区 或者重庆地区按钮是否被选中\n");
      out.write("\t\t$(\".butname\").each(function(i,e){\n");
      out.write("\t\t\tif($(this).hasClass(\"active\") && (this.lang != \"0\")){\n");
      out.write("\t\t\t\tjson = {\"admin.id\":$(\"[name='assistant']\").val(),ftype:1,\"province.id\":this.lang,\"page.currentPage\":page}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t})\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/comAccount/getComAccountByPage.action\",json,function(data){\n");
      out.write("\t\t\n");
      out.write("\t\t\tvar dataObj = eval(\"(\"+data+\")\");\n");
      out.write("\t\t\tvar navbar=dataObj.returnMap.navbar;\n");
      out.write("\t\t\tvar data=dataObj.returnMap.list;\n");
      out.write("\t\t\tif(data.length == 0){\n");
      out.write("\t\t\t\t$(\"#tbody\").html(\"\");\n");
      out.write("\t\t\t\t$(\"#msg\").html(\"该记账人没有记账记录！\");\n");
      out.write("\t\t\t\treturn;\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\t$(\"#msg\").html(\"\");\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(\".page-nav\").html(navbar);\n");
      out.write("\t\t\tbtnclick();\n");
      out.write("\t\t\tdrawTable(data);\n");
      out.write("\t\t\t//设置备注\n");
      out.write("\t\t\tvar maxwidth = 10;\n");
      out.write("\t\t\tfor(i=0;i<data.length;i++){\n");
      out.write("\t\t\t\tif ($(\"#text\"+i).text().length > maxwidth) {\n");
      out.write("\t\t\t\t\t$(\"#text\"+i).text($(\"#text\"+i).text().substring(0, maxwidth) + \"...\");\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\telse{\n");
      out.write("\t\t\t\t\t$(\"#text\"+i).text($(\"#text\"+i).text());\n");
      out.write("\t\t\t\t}\t\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t//绘制表格\n");
      out.write("\tfunction drawTable(data){\n");
      out.write("\t\tvar line = \"\";\n");
      out.write("\t\tfor(i in data){\n");
      out.write("\t\t\t//获取操作\n");
      out.write("\t\t\tvar operation=\"\";\n");
      out.write("\t\t\toperation+=\"<a herf='#' title='审核' style='text-decoration:none;font-size:16px' class='log' lang='\"+data[i].id+\",\"+ data[i].review +\"'><i class='Hui-iconfont'>&#xe623;</i>\";\n");
      out.write("\t\t\toperation+=\"<a href='javascript:void(0)' class='tit' lang='\"+data[i].id+\"'>┆&nbsp;&nbsp;详情&nbsp;|</a>\";\t\n");
      out.write("\t\t\toperation+=\"<a class='icon-delete-middle' href='javascript:;' lang='\"+data[i].id+\",\"+ data[i].admin.id +\"'title='删除'>\";\n");
      out.write("\t\t\toperation+=\"<i class='Hui-iconfont'>&#xe6e2;</i>\";\n");
      out.write("\t\t\toperation+=\"</a>\";\n");
      out.write("\t\t\toperation+=\"<a href='javascript:void(0)' class='mod' lang='\"+data[i].id+\",\"+ data[i].admin.id +\"'>|&nbsp;修改</a>\";\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tline += \"<tr>\";\n");
      out.write("\t\t\tline += \"<td>\"+ i +\"</td>\";\n");
      out.write("\t\t\tline += \"<td>\"+ data[i].province.name +\"</td>\";\n");
      out.write("\t\t\tline += \"<td>\"+ data[i].companyFirm.name +\"</td>\";\n");
      out.write("\t\t\tif(data[i].mtype == 0){\n");
      out.write("\t\t\t\tline += \"<td>支出</td>\";\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tline += \"<td>收入</td>\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tline += \"<td>\"+ data[i].money +\"</td>\";\n");
      out.write("\t\t\tline += \"<td>\"+ data[i].admin.realname +\"</td>\";\n");
      out.write("\t\t\tline += \"<td>\"+ data[i].formatTime +\"</td>\";\n");
      out.write("\t\t\tline += \"<td><a herf='#' class='flag' lang='\"+data[i].id+\"'>\";\n");
      out.write("\t\t\tline += showFlag(data[i].review);\n");
      out.write("\t\t\tline += \"</a></td>\";\n");
      out.write("\t\t\tif(data[i].remark == \"\"){\n");
      out.write("\t\t\t\tline +=\"<td class='text' id='text\"+i+\"' lang='未填写备注'>无</td>\";\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tline +=\"<td class='text' id='text\"+i+\"' lang='\"+data[i].remark+\"'>\"+ data[i].remark +\"</td>\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tline += \"<td>\"+ operation +\"</td>\";\n");
      out.write("\t\t\tline += \"</tr>\";\n");
      out.write("\t\t}\n");
      out.write("\t\t$(\"#tbody\").html(line);\n");
      out.write("\t}\n");
      out.write("\t//修改功能\n");
      out.write("\tfunction modify(){\n");
      out.write("\t\t$(\"#tbody\").on('click','.mod',function(){\n");
      out.write("\t\t\t//解决权限问题 \n");
      out.write("\t\t\tvar caid  = this.lang.split(\",\")[0];\n");
      out.write("\t\t\tvar aid  = this.lang.split(\",\")[1];\n");
      out.write("\t\t\t//原来根据cauthority判断改成根据authority判断\n");
      out.write("\t\t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.authority}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" != \"1\"){\n");
      out.write("\t\t\t\tif(aid != \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"){\n");
      out.write("\t\t\t\t\tlayer.msg(\"<strong style='color:green;'>只有本人才能修改此费用信息！</strong>\", {icon: 6});\n");
      out.write("\t\t\t\t\treturn;\n");
      out.write("\t\t\t\t} \n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(this).unbind();\n");
      out.write("\t\t\tlayer.open({\n");
      out.write("\t\t\t\t  type: 2,\n");
      out.write("\t\t\t\t  title: '修改账目',\n");
      out.write("\t\t\t\t  area: ['800px', '600px'],\n");
      out.write("\t\t\t\t  shift: 1,\n");
      out.write("\t\t\t\t  shade: 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/companyaccount/modify.jsp?id='+caid+\"&ftype=1\",\n");
      out.write("\t\t\t\t  end: function(){\n");
      out.write("\t\t\t\t\t  //location.reload();\n");
      out.write("\t\t\t\t\t  getData();\n");
      out.write("\t\t\t\t  }\n");
      out.write("\t\t\t});\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\t//删除功能\n");
      out.write("\tfunction deleteNode(){\n");
      out.write("\t\t$(\"#tbody\").on('click','.icon-delete-middle',function(){\n");
      out.write("\t\t\tvar caid  = this.lang.split(\",\")[0];\n");
      out.write("\t\t\tvar aid  = this.lang.split(\",\")[1];\n");
      out.write("\t\t\t//解决权限问题 ,原来根据cauthority判断改成根据authority判断\n");
      out.write("\t\t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.authority}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" != \"1\"){\n");
      out.write("\t\t\t\t//如果不是本人操作\n");
      out.write("\t\t\t\tif(aid != \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"){\n");
      out.write("\t\t\t\t\tlayer.msg(\"<strong style='color:green;'>只有本人才能删除此费用信息！</strong>\", {icon: 6});\n");
      out.write("\t\t\t\t\treturn;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t//如果是本人操作  但是费用已经被审核了\n");
      out.write("\t\t\t\tvar review = $(this).siblings(\".log\").prop(\"lang\").split(\",\")[1];\n");
      out.write("\t\t\t\tif(review == \"1\"){\n");
      out.write("\t\t\t\t\tlayer.msg(\"<strong style='color:green;'>费用信息已经审核,只有管理员才能删除！</strong>\", {icon: 6});\n");
      out.write("\t\t\t\t\treturn;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tvar s1 = \"您确定要<b style='color:red;'>删除</b>此费用信息?<br />\";\n");
      out.write("\t\t\tlayer.confirm(s1,{\n");
      out.write("\t\t\t\tbtn : [ '确定', '放弃' ],\n");
      out.write("\t\t\t\tarea : [ '570px' ]\n");
      out.write("\t\t\t},function() {\n");
      out.write("\t\t\t\t$(this).unbind();\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/comAccount/deleteComAccountById.action\",{caid:caid},function(data){\n");
      out.write("\t\t\t\t\tif(data == \"1\"){\n");
      out.write("\t\t\t\t\t\tlayer.closeAll();\n");
      out.write("\t\t\t\t\t\tgetData();\n");
      out.write("\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"<strong style='color:red;'>删除信息失败！</strong>\", {icon: 2});\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t})\n");
      out.write("\t\t\t});\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\t/* 查看某一条的费用详情 */\n");
      out.write("\tfunction show() {\n");
      out.write("\t\t$(\"#tbody\").on('click','.tit',function(){\n");
      out.write("\t\t\t$(this).unbind();\n");
      out.write("\t\t\tvar id = this.lang;\n");
      out.write("\t\t\tlayer.open({\n");
      out.write("\t\t\t\ttype : 2,\n");
      out.write("\t\t\t\ttitle : '查看费用详情',\n");
      out.write("\t\t\t\tarea : [ '780px', '550px' ],\n");
      out.write("\t\t\t\tshift : 1,\n");
      out.write("\t\t\t\tshade : 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t\tcontent : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/companyaccount/lookdetails.jsp?id='+id,\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t//备注鼠标悬停事件\n");
      out.write("\tfunction textOn(){\n");
      out.write("\t\t$(\"#tbody\").on('click','.text',function(){\n");
      out.write("\t\t\tvar id=\"#\"+this.id;\t\t\t\n");
      out.write("\t\t\tlayer.tips(this.lang, id,{time:5000,closeBtn: 2});\n");
      out.write("\t\t\t});\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t//获取审核状态\n");
      out.write("\tfunction showFlag(flag){\n");
      out.write("\t\tif(flag==1){\n");
      out.write("\t\t\tstatus=\"<span class='label label-success radius'>已审核</span>\";\n");
      out.write("\t\t}else{\n");
      out.write("\t\t\tstatus=\"<span class='label label-warning radius'>未审核</span>\";\n");
      out.write("\t\t}\n");
      out.write("\t\treturn status;\n");
      out.write("\t}\n");
      out.write("\t//加载审核方法\n");
      out.write("\tfunction accountReview(){\n");
      out.write("\t\t$(\"#tbody\").on('click','.log',function(){\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tvar logLang = this.lang.split(\",\");\n");
      out.write("\t\t\tvar caid  = logLang[0];\n");
      out.write("\t\t\tvar review = logLang[1];\n");
      out.write("\t\t\t//解决权限问题,原来根据cauthority判断改成根据authority判断\n");
      out.write("\t\t\tvar authority = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.authority}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\n");
      out.write("\t\t\tif(authority != \"1\"){\n");
      out.write("\t\t\t\tlayer.msg(\"<strong style='color:green;'>你没有权限审核此信息！</strong>\", {icon: 6});\n");
      out.write("\t\t\t\treturn;\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tif(review == \"1\"){\n");
      out.write("\t\t\t\t\tlayer.msg(\"<strong style='color:green;'>已经审核过了,无需再次审核！</strong>\", {icon: 6})\n");
      out.write("\t\t\t\t\treturn;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tvar s1 = \"您确定要<b style='color:red;'>审核</b>此费用信息?<br />\";\n");
      out.write("\t\t\tlayer.confirm(s1,{\n");
      out.write("\t\t\t\tbtn : [ '确定', '放弃' ],\n");
      out.write("\t\t\t\tarea : [ '570px' ]\n");
      out.write("\t\t\t},function() {\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/comAccount/ReviewComAccountById.action\",{id:caid,review:1},function(data){\n");
      out.write("\t\t\t\t\tif(data == \"1\"){\n");
      out.write("\t\t\t\t\t\tlayer.closeAll();\n");
      out.write("\t\t\t\t\t\tgetData();\n");
      out.write("\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"<strong style='color:red;'>审核信息失败！</strong>\", {icon: 2});\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t})\n");
      out.write("\t\t\t});\n");
      out.write("\t\t})\t\n");
      out.write("\t}\n");
      out.write("\t//加载assistant \n");
      out.write("\tfunction showAssist(){\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/comAccount/showAssist.action\",function(data){\n");
      out.write("\t\t\tvar line =\"<option value='0' selected>所有人</option>\";\n");
      out.write("\t\t\tfor( i in data){\n");
      out.write("\t\t\t\tline += \"<option value=\"+ data[i].id +\">\"+ data[i].realname +\"</option>\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(\"[name='assistant']\").html(line);\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("})\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t<h1 class=\"text-c\">VIP软件开发账目</h1>\n");
      out.write("\t<div class=\"panel panel-secondary\">\n");
      out.write("\t\t<div class=\"panel-header\">\n");
      out.write("\t\t\t<div style=\"float: left;\">\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"flag\" value=\"0\">\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\" id=\"add\">\n");
      out.write("\t\t\t\t\t<i class=\"fa fa-plus\" aria-hidden=\"true\"></i>添加账目\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"btn-group\" style=\"float: left\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary radius butname active\"\n");
      out.write("\t\t\t\t\tlang=\"0\">所有信息</button>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary radius butname\"\n");
      out.write("\t\t\t\t\tlang=\"22\">重庆地区</button>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary radius butname\"\n");
      out.write("\t\t\t\t\tlang=\"1\">北京地区</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"form-group\" style=\"margin-left: 20px;\">\n");
      out.write("\t\t\t\t<span class=\"select-box radius\"\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px; background: white;\"> <select\n");
      out.write("\t\t\t\t\tclass=\"select\" name=\"assistant\">\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t\t</span>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"panel-primary\">\n");
      out.write("\t\t\t<table class=\"table table-border table-bg table-bordered radius\">\n");
      out.write("\t\t\t\t<thead class=\"text-c\">\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<th>序号</th>\n");
      out.write("\t\t\t\t\t\t<th>地区</th>\n");
      out.write("\t\t\t\t\t\t<th>费用类型</th>\n");
      out.write("\t\t\t\t\t\t<th>支出费用(元)</th>\n");
      out.write("\t\t\t\t\t\t<th>收入费用(元)</th>\n");
      out.write("\t\t\t\t\t\t<th>记账人</th>\n");
      out.write("\t\t\t\t\t\t<th>账目时间</th>\n");
      out.write("\t\t\t\t\t\t<th>审核状态</th>\n");
      out.write("\t\t\t\t\t\t<th>备注</th>\n");
      out.write("\t\t\t\t\t\t<th>操作</th>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</thead>\n");
      out.write("\t\t\t\t<tbody id=\"tbody\" class='text-c'>\n");
      out.write("\t\t\t\t</tbody>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<div id=\"msg\" style=\"color: red; font-weight: bold; font-size: 15px;\"\n");
      out.write("\t\t\t\talign=\"center\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"page-nav\" style=\"float: right; margin-top: 10px;\"\n");
      out.write("\t\t\tid=\"paging\"></div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
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
    // /admin/commpanyaccount.jsp(297,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin==null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\n');
        out.write('	');
        out.write('	');
        if (true) {
          _jspx_page_context.forward("/user/login.jsp");
          return true;
        }
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
