/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-05 05:53:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class looksummarys_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("<title>查看周报</title>\n");
      out.write("<link\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/ueditor/themes/default/css/ueditor.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layer/layui/css/layui.css\">\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/looksummary.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/tableTemplet/css/H-ui.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layer/layer-v2.0/layer/layer.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/jslib/currency.js\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("td {\n");
      out.write("\tvertical-align: middle;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function(){\n");
      out.write("\t//第一次点击进来的默认值\n");
      out.write("\tvar checkType=\"all\";\n");
      out.write("\tvar weekType=\"current\";\n");
      out.write("\tvar ownerType=\"所有人\";\n");
      out.write("\tvar title;\n");
      out.write("\tvar page2=1;\n");
      out.write("\tvar assistant=0;\n");
      out.write("\tvar assistantLength;\n");
      out.write("\t/*去除返回功能\n");
      out.write("\t//从查看返回\n");
      out.write("\t//获取url中的参数,以便返回\n");
      out.write("    (function ($) {\n");
      out.write("        $.getUrlParam = function (name) {\n");
      out.write("            var reg = new RegExp(\"(^|&)\" + name + \"=([^&]*)(&|$)\");\n");
      out.write("            var r = window.location.search.substr(1).match(reg);\n");
      out.write("            if (r != null) return unescape(r[2]); return null;\n");
      out.write("        }\n");
      out.write("    })(jQuery);\n");
      out.write("\tif($.getUrlParam('page2')!=null)\n");
      out.write("\t{\n");
      out.write("\t    page2 = $.getUrlParam('page2');\n");
      out.write("\t    checkType = $.getUrlParam('checkType');\n");
      out.write("\t    weekType = $.getUrlParam('weekType');\n");
      out.write("\t    setWeekTypeCheck(weekType);\n");
      out.write("\t    title = $.getUrlParam('title');\n");
      out.write("\t}\n");
      out.write("\t*/\n");
      out.write("\tgetData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t$(\"#search-summary\").click(function(){\n");
      out.write("\t\tcheckType=$(\"[name='checkType']\").val();\n");
      out.write("\t\tweekType=$(\"[name='weekType']\").val();\n");
      out.write("\t\townerType=$(\"[name='ownerType']\").val();\n");
      out.write("\t\ttitle=$(\"[name='title']\").val();\n");
      out.write("\t\tpage2=1;\n");
      out.write("\t\tassistant=$(\"[name='assistant']\").val();\n");
      out.write("\t\t//设置weekType\n");
      out.write("\t\tif($(\"#weekType-2\").is(\":checked\"))\n");
      out.write("\t\t{\n");
      out.write("\t\t\t//alert($(\"#weekType-2\").val());\n");
      out.write("\t\t\tweekType=$(\"#weekType-2\").val();\n");
      out.write("\t\t}\n");
      out.write("\t\tif($(\"#weekType-3\").is(\":checked\"))\n");
      out.write("\t\t{\n");
      out.write("\t\t\t//alert($(\"#weekType-3\").val());\n");
      out.write("\t\t\tweekType=$(\"#weekType-3\").val();\n");
      out.write("\t\t}\n");
      out.write("\t\tif($(\"#weekType-4\").is(\":checked\"))\n");
      out.write("\t\t{\n");
      out.write("\t\t\t//alert($(\"#weekType-4\").val());\n");
      out.write("\t\t\tweekType=$(\"#weekType-4\").val();\n");
      out.write("\t\t}\t\n");
      out.write("\t\t//alert(checkType);\n");
      out.write("\t\t//alert(weekType);\n");
      out.write("\t\t//alert(title);\n");
      out.write("\t\t//alert(page2);\t\t\t\n");
      out.write("\t\tgetData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t\t//设置assistant,保留之前被选中的状态\n");
      out.write("\t\tfor(i=0;i<=assistantLength;i++){\n");
      out.write("\t\t\tif(assistant==$(\"#assistant\"+i).val())\n");
      out.write("\t\t\t{\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$(\"#assistant\"+i).attr(\"selected\",true);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\t//alert(assistant);\n");
      out.write("\t})\t\n");
      out.write("\tfunction setWeekTypeCheck(weekType)\n");
      out.write("\t{\n");
      out.write("\t\tif(weekType==\"all\"){\n");
      out.write("\t\t\t$(\"#weekType-1\").attr(\"checked\",true);\n");
      out.write("\t\t}\n");
      out.write("\t\tif(weekType==\"previous\"){\n");
      out.write("\t\t\t$(\"#weekType-2\").attr(\"checked\",true);\n");
      out.write("\t\t}\n");
      out.write("\t\tif(weekType==\"current\"){\n");
      out.write("\t\t\t$(\"#weekType-3\").attr(\"checked\",true);\n");
      out.write("\t\t}\n");
      out.write("\t\tif(weekType==\"next\"){\n");
      out.write("\t\t\t$(\"#weekType-4\").attr(\"checked\",true);\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\tfunction getData(checkType,weekType,ownerType,title,page2,assistant){\n");
      out.write("\t\t$.ajaxSetup({async:false});\n");
      out.write("\t\tgetAssistant();\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/getSummarysByNameWithPage.action\",{checkType:checkType,weekType:weekType,ownerType:ownerType,title:title,page2:page2,assistant:assistant},function(data){\n");
      out.write("\t\t\t//alert(data);\n");
      out.write("\t\t\tvar dataObj = eval(\"(\"+data+\")\");\n");
      out.write("\t\t\tvar navbar=dataObj.returnMap.navbar;\n");
      out.write("\t\t\tvar tatolCount=dataObj.returnMap.totalCount;\n");
      out.write("\t\t\tvar list=dataObj.returnMap.list;\n");
      out.write("\t\t\tvar title=dataObj.returnMap.title;\n");
      out.write("\t\t\tvar titleTip=dataObj.returnMap.titleTip;\n");
      out.write("\t\t\t//alert(title)\n");
      out.write("\t\t\t$(\"#titleTip\").html(titleTip);\n");
      out.write("\t\t\t$(\".page-nav\").html(navbar);\n");
      out.write("\t\t\tbtnclick();\n");
      out.write("\t\t\t$(\"#TATOLCOUNT\").html(tatolCount);\n");
      out.write("\t\t\t$(\"[name='title']\").val(title);\n");
      out.write("\t\t\tdrawTable(list);\n");
      out.write("\t\t\ttitclick();\n");
      out.write("\t\t\ttrclick();\n");
      out.write("\t\t\tmodifySum();\n");
      out.write("\t\t\tdelSum();\n");
      out.write("\t\t\tselect();\n");
      out.write("\t\t\tbatchDelSum();\n");
      out.write("\t\t\tgetCommunicateInfo();\n");
      out.write("\t\t})\n");
      out.write("\t\t\n");
      out.write("\t}\t\n");
      out.write("\tfunction btnclick(){\n");
      out.write("\t\t$(\".nav-btn\").click(function(){\n");
      out.write("\t\t\tpage2=this.lang;\n");
      out.write("\t\t\tgetData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t\t})\n");
      out.write("\t}\t\n");
      out.write("\tfunction getAssistant(){\n");
      out.write("\t\t$.ajaxSetup({async:false});\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/getAll.action\",function(data){\n");
      out.write("\t\t\tassistantLength=data.length;\n");
      out.write("\t\t\tvar line=\"\";\n");
      out.write("\t\t\tline=line + \"<option value='0' id='assistant0'>不限</option>\";\n");
      out.write("\t\t\tfor(i=0;i<data.length;i++){\n");
      out.write("\t\t\t\tline=line + \"<option value='\" + data[i].id + \"' id='assistant\"+(i+1)+\"'>\" + data[i].realname + \"</option>\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(\"[name='assistant']\").html(line);\n");
      out.write("\t\t})\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t//查看周报\t\n");
      out.write("\tfunction showSum(id){\n");
      out.write("\t\t\t//location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/membersumcomment1.jsp?page2=\"+page2+\"&checkType=\"+checkType+\"&weekType=\"+weekType+\"&title=\"+title+\"&id=\"+id;\n");
      out.write("\t\t\t//window.open(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/membersumcomment1.jsp?id=\"+id);\n");
      out.write("\t\tlayer.open({\n");
      out.write("\t\t\t  type: 2,\n");
      out.write("\t\t\t  title: '查看周报',\n");
      out.write("\t\t\t  area: ['800px', '500px'],\n");
      out.write("\t\t\t // closeBtn: 0, //不显示关闭按钮\n");
      out.write("\t\t\t  shift: 1,\n");
      out.write("\t\t\t  maxmin: true,\n");
      out.write("\t\t\t  shade: 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/membersumcomment1.jsp?id='+id,\n");
      out.write("\t\t\t//点击关闭页面修改，返回是否点击了审查，修改审查样式\n");
      out.write("\t\t\t//点击叉和关闭都可以修改审核样式\n");
      out.write("\t\t\t  btn: ['关闭'],\n");
      out.write("\t\t\t  end: function(index){\n");
      out.write("\t\t\t\t  //\tgetData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t\t\t\t //var body = layer.getChildFrame('body', index);  \n");
      out.write("\t\t\t\t //var data=body.contents().find(\"#look\").val();\n");
      out.write("\t\t\t\t// alert(data);\n");
      out.write("\t\t\t\t if($(\"#look\").val()==\"1\")\n");
      out.write("\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t  \t$(\".label label-danger radius,[ lang='\"+id+\"']\").find(\"span\").attr(\"class\",\"label label-success radius\");\n");
      out.write("\t\t\t\t\t  \t$(\".label label-danger radius,[ lang='\"+id+\"']\").find(\"span\").text(\"已审核\");\n");
      out.write("\t\t\t\t\t };\n");
      out.write("\t\t\t\t  getData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t\t\t\t  layer.close(index);\n");
      out.write("\t\t\t   },\n");
      out.write("\t\t});\n");
      out.write("\t\n");
      out.write("\t}\n");
      out.write("\tfunction titclick(){\n");
      out.write("\t\t$(\".tit\").click(function(){\n");
      out.write("\t\t\tvar id=this.lang;\n");
      out.write("\t\t\tshowSum(id);\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\tfunction trclick(){\n");
      out.write("\t\t//火狐对last不支持，在不该被点的td里面机上noclick的class\n");
      out.write("\t\t//$(\"tr td:not(':first,:last')\").click(function(){\n");
      out.write("\t\t$(\"tr td:not(.noclick)\").click(function(){\n");
      out.write("\t\t\tvar id=this.parentNode.lang;\n");
      out.write("\t\t\tshowSum(id);\n");
      out.write("\t\t})\n");
      out.write("\n");
      out.write("\t}\n");
      out.write("\t//修改周报信息,暂时只有修改title的功能\n");
      out.write("\tfunction modifySum(){\n");
      out.write("\t\t$(\".mod\").click(function(){\n");
      out.write("\t\t\tif(weekType!=\"all\"){\n");
      out.write("\t\t\t\tweekType=\"now\"; \n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tvar id=this.lang;\n");
      out.write("\t\t \t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/getSumById.action\",{\"id\":id},function(data){\n");
      out.write("\t\t \t\tvar title=data.title;\n");
      out.write("\t\t \t\tlayer.open({\n");
      out.write("\t\t\t\t\t\t  type: 2,\n");
      out.write("\t\t\t\t\t\t  title: '修改',\n");
      out.write("\t\t\t\t\t\t  area: ['600px', '361px'],\n");
      out.write("\t\t\t\t\t\t // closeBtn: 0, //不显示关闭按钮\n");
      out.write("\t\t\t\t\t\t  shift: 1,\n");
      out.write("\t\t\t\t\t\t  shade: 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t\t\t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/modifysum.jsp?title='+title+'&id='+id,\n");
      out.write("\t\t\t\t\t\t  end: function(){\n");
      out.write("\t\t\t\t\t\t\t  \tgetData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t\t\t\t\t\t    }\n");
      out.write("\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t})\t\t\n");
      out.write("\t\t\t})\n");
      out.write("\t}\n");
      out.write("\t//如果第一个被选中，下面的所有都要被选中，如果第一个没有被选中，下面的所有都不要被选中。\n");
      out.write("\tfunction select()\n");
      out.write("\t{\n");
      out.write("\t\t$(\"input[type='checkbox']:first\").click(function(){\n");
      out.write("\t\t\t$(\"input[type='checkbox']\").not(\":first\").prop(\"checked\",$(this).prop(\"checked\"));\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\tfunction delSum(){\n");
      out.write("\t\t$(\".icon-delete-middle\").click(function(){\n");
      out.write("\t\t\tvar id=this.lang;\t\t\t\n");
      out.write("\t\t\t//alert(id)\n");
      out.write("\t\t\tif(!confirm('您确定要删除此条记录吗？'))\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\treturn;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\telse\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t$.ajaxSetup({async:false});\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/delSummary.action\",{id:id},function(){\n");
      out.write("\t\t\t\tgetData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t//批量删除周报\n");
      out.write("\tfunction batchDelSum(){\n");
      out.write("\t\t$(\"#batchDel\").click(function(){\n");
      out.write("\t\t\tvar ids=\"\"; //存储所有ID用的，哪些被选中就存起来\n");
      out.write("\t\t\tvar i=0; //ID的数量\n");
      out.write("\t\t\t$(\"input[type='checkbox']\").each(function(index, element) {\n");
      out.write("\t            if(index>0)\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\tif($(this).prop(\"checked\"))\n");
      out.write("\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\tvar id=$(this).parent().parent().children().eq(1)\n");
      out.write("\t\t\t            .children().eq(0).val();\n");
      out.write("\t\t\t\t\t\tids+=id;\n");
      out.write("\t\t\t\t\t\ti++;\n");
      out.write("\t\t\t\t\t\tids+=\",\";\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}\t\t\n");
      out.write("\t\t\t});\t\n");
      out.write("\t\t\tif(ids.length>1)\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\tids=ids.substring(0,ids.length-1);\n");
      out.write("\t\t\t\t//alert(ids)\n");
      out.write("\t\t\t\tif(!confirm(\"你确定要删除这\" + i +\"条记录吗\"))\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\treturn;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\telse\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\t$.ajaxSetup({async:false});\n");
      out.write("\t\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/batchDelSummary.action\",{ids:ids},function(){\n");
      out.write("\t\t\t\t\t\tgetData(checkType,weekType,ownerType,title,page2,assistant);\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\tfunction drawTable(data){\n");
      out.write("\t\tvar line=\"\";\n");
      out.write("\t\tline=line + \"<thead>\";\n");
      out.write("\t\tline=line + \"<tr class='text-c'>\";\n");
      out.write("\t\tline=line + \"<th class='ck'><input type='checkbox' name='' value=''></th>\";\n");
      out.write("\t\tline=line + \"<th class='xh'>序号</th>\";\n");
      out.write("\t\tline=line + \"<th class='yhm'>用户名</th>\";\n");
      out.write("\t\tline=line + \"<th class='xm'>姓名</th>\";\n");
      out.write("\t\tline=line + \"<th class='zbbt'>周报标题</th>\";\t\n");
      out.write("\t\tline=line + \"<th class='tjsj'>提交时间</th>\";\n");
      out.write("\t\tline=line + \"<th class='xzs'>小助手</th>\";\n");
      out.write("\t\tline=line + \"<th class='zt'>状态</th>\";\n");
      out.write("\t\tline=line + \"<th style='width: 50px;'>沟通</th>\";\n");
      out.write("\t\tline=line + \"<th class='cz'>操作</th>\";\n");
      out.write("\t\tline=line + \"</tr>\";\n");
      out.write("\t\tline=line + \"</thead>\";\n");
      out.write("\t\tline=line + \"<tbody>\";\n");
      out.write("\t\tfor(i=0;i<data.length;i++){\n");
      out.write("\t\t\tvar title=\"\";\n");
      out.write("\t\t\tvar time=\"\";\n");
      out.write("\t\t\tvar assistant=\"\";\n");
      out.write("\t\t\tvar operation=\"\";\n");
      out.write("\t\t\tvar  status=\"\";\n");
      out.write("\t\t\tvar recom=\"\";\n");
      out.write("\t\t\tif(data[i].sid==0){\n");
      out.write("\t\t\t\ttitle=$(\"[name='title']\").val();\n");
      out.write("\t\t\t\tstatus=\"<span class='label label-warning radius'>未提交</span>\";\n");
      out.write("\t\t\t\tif(data[i].arealname!=null){\n");
      out.write("\t\t\t\t\tassistant=data[i].arealname;\n");
      out.write("\t\t\t\t}\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\ttitle=data[i].title;\n");
      out.write("\t\t\t\ttime=data[i].time.split(\" \")[0];\n");
      out.write("\t\t\t\tif(data[i].arealname!=null){\n");
      out.write("\t\t\t\t\tassistant=data[i].arealname;\n");
      out.write("\t\t\t\t}\t\t\t\n");
      out.write("\t\t\t\tif(data[i].ischeckval == '0')\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\tstatus=\"<span class='label label-danger radius' lang=\"+data[i].sid+\"'>未审核</span>\";\n");
      out.write("\t\t\t\t}else{\n");
      out.write("\t\t\t\t\tstatus=\"<span class='label label-success radius'>已审核</span>\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tif(data[i].recommendval=='1')\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\trecom=\"<span class='layui-badge layui-bg-orange' >荐</span>\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\telse\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\trecom=\"&nbsp;&nbsp;&nbsp;&nbsp;\";\t\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\toperation=\"<a href='javascript:void(0)' class='tit' lang='\"+data[i].sid+\"'>查看&nbsp;|</a>\";\t\n");
      out.write("\t\t\t\toperation+=\"<a class='icon-delete-middle' href='javascript:;' lang='\"+data[i].sid+\"'title='删除'>\";\n");
      out.write("\t\t\t\toperation+=\"<i class='Hui-iconfont'>&#xe6e2;</i>\";\n");
      out.write("\t\t\t\toperation+=\"</a>\";\n");
      out.write("\t\t\t\toperation+=\"<a href='javascript:void(0)' class='mod' lang='\"+data[i].sid+\"'>|&nbsp;修改</a>\";\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tline=line + \"<tr  class='text-c tr' lang='\"+data[i].sid+\"'>\";\n");
      out.write("\t\t\tline=line + \"<td class='noclick'>\" + \"<input type='checkbox' name='' value=''>\" + \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td>\" + (i+1) +\"<input type='hidden' value=\"+data[i].sid +\"> \"+ \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td>\" + data[i].num + \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td>\" + data[i].name + \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td style='white-space: nowrap'>\" + title + \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td>\" + time + \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td>\" + assistant + \"</td>\";\n");
      out.write("\t\t\tline=line +\"<td class='td-status'>\";\n");
      out.write("\t\t\tline=line+status;\n");
      out.write("\t\t\tline=line +\"</td>\";\t\n");
      out.write("\t\t\tline += \"<td class='noclick'><a href='javascript:void(0)' class='gtxx' lang='\" + data[i].id +\"&\"+data[i].identityType +\"&\"+ data[i].num +\"'>沟通</a></td>\";\n");
      out.write("\t\t\tline=line +\"<td class='noclick'>\";\n");
      out.write("\t\t\tline=line +recom+\"&nbsp;&nbsp;\"+ operation;\n");
      out.write("\t\t\tline=line+\"</td>\"\n");
      out.write("\t\t\tline=line + \"</tr>\";\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t\tline=line + \"</tbody>\";\n");
      out.write("\t\t$(\"#period\").html(line);\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t//更改按钮点击事件\n");
      out.write("\t$(\"#btnscope\").click(function(){\n");
      out.write("\t\tlayer.open({\n");
      out.write("\t\t\t  type: 2,\n");
      out.write("\t\t\t  title: '周报所属',\n");
      out.write("\t\t\t  area: ['700px', '300px'],\n");
      out.write("\t\t\t // closeBtn: 0, //不显示关闭按钮\n");
      out.write("\t\t\t  shift: 1,\n");
      out.write("\t\t\t  shade: 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/summary/scopechoice.jsp',\n");
      out.write("\t\t\t  end: function(){\n");
      out.write("\t\t\t\townerType=$(\"[name='ownerType']\").val();\n");
      out.write("\t\t\t\tif(ownerType!=\"所有人\")\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\tgetAssistant();\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t  }\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\"#weekType-1\").click(function(){\n");
      out.write("\t\tif($('#checkType option:selected').val()=='nonsubmit'){\n");
      out.write("\n");
      out.write("\t\t\tvar line='<option value=\"all\">不限</option>';\n");
      out.write("\t\t\tline=line + '<option value=\"checked\">已审核</option>';\n");
      out.write("\t\t\tline=line + '<option value=\"nonchecked\">未审核</option>';\n");
      out.write("\t\t\tline=line + '<option value=\"nonsubmit\">未提交</option>';\n");
      out.write("\t\t\t$(\"#checkType\").html(line);\n");
      out.write("\t\t}\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t//查看沟通信息\n");
      out.write("\tfunction getCommunicateInfo() {\n");
      out.write("\t\t$(\".gtxx\").click(function(){\n");
      out.write("\t\t\tvar str = this.lang.split(\"&\");\n");
      out.write("\t\t\tvar num = str[2];\n");
      out.write("\t\t\tvar n=num.indexOf(\"X\");\n");
      out.write("\t\t\tif(n==0){\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\talert(\"跟踪者不能点呦~\");\n");
      out.write("\t\t\t\treturn false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tvar userID = str[0];\n");
      out.write("\t\t\tvar userType = null;\n");
      out.write("\t\t\tif(str[1] == \"true\") {\n");
      out.write("\t\t\t\tuserType = \"member\";\n");
      out.write("\t\t\t} else {\n");
      out.write("\t\t\t\tuserType=\"experience\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tlayer.open({\n");
      out.write("\t\t\t\ttype: 2,\n");
      out.write("\t\t\t\ttitle: '会员信息和沟通信息',\n");
      out.write("\t\t\t\tarea: ['700px', '450px'],\n");
      out.write("\t\t\t\tshift: 1,\n");
      out.write("\t\t\t\tshade: 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t\tcontent: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/PersonalInfoAndCommunication.jsp?userID='+userID+\"&userType=\"+userType,\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\t\n");
      out.write("\t}\n");
      out.write("});\t\n");
      out.write("\tfunction checkTypeChange(text){\n");
      out.write("\t\tif(text=='nonsubmit')\n");
      out.write("\t\t{\n");
      out.write("\t\t\t$(\"[name='ownerType']\").val(\"所有人\");\n");
      out.write("\t\t\t$.ajaxSetup({async:false});\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/getAll.action\",function(data){\n");
      out.write("\t\t\t\tassistantLength=data.length;\n");
      out.write("\t\t\t\tvar line=\"\";\n");
      out.write("\t\t\t\tline=line + \"<option value='0' id='assistant0'>不限</option>\";\n");
      out.write("\t\t\t\tfor(i=0;i<data.length;i++){\n");
      out.write("\t\t\t\t\tline=line + \"<option value='\" + data[i].id + \"' id='assistant\"+(i+1)+\"'>\" + data[i].realname + \"</option>\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t$(\"[name='assistant']\").html(line);\n");
      out.write("\t\t\t})\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<input type=\"hidden\" id=\"look\" value=\"0\">\n");
      out.write("\t<div class=\"text-c\">\n");
      out.write("\t\t<form id=\"\">\n");
      out.write("\t\t\t小助手： <span class=\"select-box inline\"> <select name=\"assistant\"\n");
      out.write("\t\t\t\tclass=\"select\">\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t\t</span>&nbsp; &nbsp; 审核状态： <span class=\"select-box inline\"> <select\n");
      out.write("\t\t\t\tid=\"checkType\" name=\"checkType\" class=\"select\"\n");
      out.write("\t\t\t\tonchange=\"checkTypeChange(this.value);\">\n");
      out.write("\t\t\t\t\t<option value=\"all\">不限</option>\n");
      out.write("\t\t\t\t\t<option value=\"checked\">已审核</option>\n");
      out.write("\t\t\t\t\t<option value=\"nonchecked\">未审核</option>\n");
      out.write("\t\t\t\t\t<option value=\"nonsubmit\">未提交</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t\t</span>&nbsp; &nbsp; 周报所属： <span class=\"select-box inline\"> <input\n");
      out.write("\t\t\t\ttype=\"text\" id=\"scopetext\" name=\"ownerType\" value=\"所有人\"\n");
      out.write("\t\t\t\tdisabled=\"true\" style=\"width: 50px;\" /> <input type=\"button\"\n");
      out.write("\t\t\t\tid=\"btnscope\" value=\"更改\" />\n");
      out.write("\t\t\t</span> &nbsp; &nbsp; <input type=\"radio\" id=\"weekType-1\" name=\"weekType\"\n");
      out.write("\t\t\t\tvalue=\"all\"> <label for=\"weekType-1\">全部</label>&nbsp; <input\n");
      out.write("\t\t\t\ttype=\"radio\" id=\"weekType-2\" name=\"weekType\" value=\"previous\">\n");
      out.write("\t\t\t<label for=\"weekType-2\">向前一周</label>&nbsp; <input type=\"radio\"\n");
      out.write("\t\t\t\tid=\"weekType-3\" name=\"weekType\" value=\"current\" checked> <label\n");
      out.write("\t\t\t\tfor=\"weekType-3\">本周</label>&nbsp; <input type=\"radio\"\n");
      out.write("\t\t\t\tid=\"weekType-4\" name=\"weekType\" value=\"next\"> <label\n");
      out.write("\t\t\t\tfor=\"weekType-4\">向后一周</label>&nbsp; &nbsp; <input type=\"hidden\"\n");
      out.write("\t\t\t\tname=\"title\" value=\"\">\n");
      out.write("\t\t\t<button name=\"\" id=\"search-summary\" class=\"btn btn-success\"\n");
      out.write("\t\t\t\ttype=\"button\">\n");
      out.write("\t\t\t\t<i class=\"Hui-iconfont\">&#xe665;</i> 搜周报\n");
      out.write("\t\t\t</button>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"cl pd-5 bg-1 bk-gray mt-20\" id=\"title\"\n");
      out.write("\t\tstyle=\"text-align: left;\">\n");
      out.write("\t\t<span id=\"titleTip\" style=\"padding-left: 35%;\"></span> <span class=\"r\">共有数据：<strong\n");
      out.write("\t\t\tid=\"TATOLCOUNT\"></strong> 条\n");
      out.write("\t\t</span> <span class=\"l\"><a href=\"javascript:;\"\n");
      out.write("\t\t\tclass=\"btn btn-danger radius\" id=\"batchDel\"><i\n");
      out.write("\t\t\t\tclass=\"Hui-iconfont\">&#xe6e2;</i> 批量删除</a></span>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"mt-20\">\n");
      out.write("\t\t<table class=\"table table-border table-bg table-bordered radius\"\n");
      out.write("\t\t\tid=\"period\">\n");
      out.write("\t\t</table>\n");
      out.write("\t</div>\n");
      out.write("\t<br>\n");
      out.write("\t<div class='page-nav' style=\"padding-right: 120px\"></div>\n");
      out.write("\n");
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
}
