/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-21 10:30:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getnosummarymembers_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=UTF-8>\r\n");
      out.write("<title>周报管理-未及时提交周报学员名单</title>\r\n");
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
      out.write("/resources/jslib/currency.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layer/layer-v2.0/layer/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tgetData(1);\r\n");
      out.write("\t\tfunction getData(page){\r\n");
      out.write("\t\t\t$.ajaxSetup({async : false});\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getNoSummaryMembersByPage.action\",\r\n");
      out.write("\t\t\t\t\t{page:page},function(data){\r\n");
      out.write("\t\t\t\t//alert(data);\r\n");
      out.write("\t\t\t\tvar dataObj = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\t\t//alert(dataObj.COUNT);\r\n");
      out.write("\t\t\t\tvar list = dataObj.LIST;\r\n");
      out.write("\t\t\t\tdrawTable(list);\r\n");
      out.write("\t\t\t\tvar navbar = dataObj.navbar;\r\n");
      out.write("\t\t\t\t$(\".page-nav\").html(navbar);\r\n");
      out.write("\t\t\t\t$(\".nav-btn\").click(function(){\r\n");
      out.write("\t\t\t\t\tvar page=this.lang;\r\n");
      out.write("\t\t\t\t\tgetData(page);\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t})\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction drawTable(list){\r\n");
      out.write("\t\t\tvar line = \"\";\r\n");
      out.write("\t\t\tfor(var i=0;i<list.length;i++){\r\n");
      out.write("\t\t\t\tline = line + \"<tr>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td>\" + (i+1) + \"</td>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td>\" + list[i].num + \"</td>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td>\" + list[i].name + \"</td>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td>\" + list[i].sex + \"</td>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td style='text-align:left;'>\" + list[i].school + \"</td>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td><u><a target='_blank' href='http://wpa.qq.com/msgrd?v=1&uin=\" \r\n");
      out.write("\t\t\t\t\t\t+ list[i].qq + \"&site=qq&menu=yes'>\" + list[i].qq\r\n");
      out.write("\t\t\t\t\t\t+\"</a></u></td>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td>\" + list[i].phone + \"</td>\";\r\n");
      out.write("\t\t\t\t/*\r\n");
      out.write("\t\t\t\tvar begintime = new Date(list[i].begintime);\r\n");
      out.write("\t\t\t\tvar strdate = begintime.getFullYear()+\"-\"+(begintime.getMonth()+1)+\"-\"+begintime.getDate();\r\n");
      out.write("\t\t\t\tline = line + \"<td>\" + strdate + \"</td>\";\r\n");
      out.write("\t\t\t\tline = line + \"<td>\" + list[i].adminname + \"</td>\";\r\n");
      out.write("\t\t\t\t*/\r\n");
      out.write("\t\t\t\tline = line + \"<td> <input type='checkbox'checked='true' class='cancelsummarycb' lang='\" + list[i].usertype+\",\" + list[i].id + \"'\" +  + \"</td>\";\r\n");
      out.write("\t\t\t\tline = line + \"</tr>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#tbody\").html(line);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".cancelsummarycb\").click(function(){\r\n");
      out.write("\t\t\tvar str = $(this).attr(\"lang\").split(\",\");\r\n");
      out.write("\t\t\tvar usertype = str[0];\r\n");
      out.write("\t\t\tvar id = str[1];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(this).prop(\"checked\")==true){\r\n");
      out.write("\t\t\t\t//alert(\"true\");\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/setSummaryFlag.action\",\r\n");
      out.write("\t\t\t\t\t\t{usertype:usertype,id:id,flag:1});\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t//alert(\"false\");\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/setSummaryFlag.action\",\r\n");
      out.write("\t\t\t\t\t\t{usertype:usertype,id:id,flag:0});\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<h1 class=\"text-c\"\r\n");
      out.write("\t\tstyle=\"width: 95%; margin-bottom: 10px; margin-top: -20px;\">未及时提交周报的学员名单</h1>\r\n");
      out.write("\t<div class=\"panel panel-secondary\"\r\n");
      out.write("\t\tstyle=\"width: 80%; margin-left: 5%; margin-right: 10%;\">\r\n");
      out.write("\t\t<div class=\"panel-header\">\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary radius\" id=\"download\">生成表格</button>\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-primary radius\" target=\"_blank\" id=\"dl\">点击下载</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"panel-primary\">\r\n");
      out.write("\t\t\t<table class=\"table table-border table-bg table-bordered radius\">\r\n");
      out.write("\t\t\t\t<thead class='text-c'>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>序号</th>\r\n");
      out.write("\t\t\t\t\t\t<th>学号</th>\r\n");
      out.write("\t\t\t\t\t\t<th>真实姓名</th>\r\n");
      out.write("\t\t\t\t\t\t<th>性别</th>\r\n");
      out.write("\t\t\t\t\t\t<th>学校名称</th>\r\n");
      out.write("\t\t\t\t\t\t<th>QQ号码</th>\r\n");
      out.write("\t\t\t\t\t\t<th>电话号码</th>\r\n");
      out.write("\t\t\t\t\t\t<th>需交周报</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"tbody\" class='text-c'></tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class='page-nav'\r\n");
      out.write("\t\tstyle=\"width: 80%; margin-top: 10px; margin-left: 5%; margin-right: 10%;\"></div>\r\n");
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
    // /admin/getnosummarymembers.jsp(89,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
