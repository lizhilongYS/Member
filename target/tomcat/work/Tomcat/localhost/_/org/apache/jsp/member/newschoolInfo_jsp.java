/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-12 03:00:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newschoolInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>来扒一扒你有哪些校友在新趋势~</title>\n");
      out.write("\n");
      out.write("<!-- <link href=\"css/index_style.css\" rel=\"stylesheet\" type=\"text/css\"> -->\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jslib/SG_area_select.js'></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jslib/iscroll.js'></script>\n");
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
      out.write("<style type=\"text/css\">\n");
      out.write(".container {\n");
      out.write("\twidth: 73%;\n");
      out.write("\tmargin-left: 0px\n");
      out.write("}\n");
      out.write("\n");
      out.write("#scllist {\n");
      out.write("\twidth: 68%;\n");
      out.write("\tmargin-left: 17px\n");
      out.write("}\n");
      out.write("\n");
      out.write("#provinceList ul li {\n");
      out.write("\tmargin-left: 6px;\n");
      out.write("\tmargin-top: 10px;\n");
      out.write("\twidth: 75px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#provinceList ul li a {\n");
      out.write("\tdisplay: block;\n");
      out.write("\twidth: 75px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#provinceList {\n");
      out.write("\tmargin-bottom: 30px;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<!-----HEADER STAR----->\n");
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t$.areaSelect();\n");
      out.write("\t\tvar page2=1;\n");
      out.write("\t\tgetData(page2);\n");
      out.write("\t});\n");
      out.write("\t//点击省份按钮获取学习信息\n");
      out.write("\tfunction getData(page2){\n");
      out.write("\t\t$(\"#provinceList\").on(\"click\",\"a\",function(){\n");
      out.write("\t\t\tif($(\"a\").hasClass('.label label-primary')){\n");
      out.write("\t\t\t\t$(\"a\").removeClass('.label label-primary');\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t$(this).addClass('.label label-primary');\n");
      out.write("\t\t\tgetSchool(page2,$(this).text());\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t//调用根据省份获取学校\n");
      out.write("\tfunction getSchool(page2,province){\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getSchoolByPage.action\",{\"province\":province,\"page2\":page2},function(data){\n");
      out.write("\t\t\tvar dataObj = eval(\"(\"+data+\")\");\n");
      out.write("\t\t\tvar navbar=dataObj.returnMap.navbar;\n");
      out.write("\t\t\t//var tatolCount = dataObj.returnMap.totalCount;\n");
      out.write("\t\t\tvar list=dataObj.returnMap.list;\n");
      out.write("\t\t\tif(list!=null&&list.length>0){\n");
      out.write("\t\t\t\t$(\".page-nav\").html(navbar);\n");
      out.write("\t\t\t\t//$(\"#num\").html(tatolCount);\n");
      out.write("\t\t\t\tdrawTable(list);\n");
      out.write("\t\t\t\tbtnclick();\n");
      out.write("\t\t\t\tdetailclick();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\telse{\n");
      out.write("\t\t\t\t$(\"#schools\").html(\"<h4 align='center'>该省暂无会员</h4>\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t//分页按钮点击事件\n");
      out.write("\tfunction btnclick(){\n");
      out.write("\t\t$(\".nav-btn\").click(function(){\n");
      out.write("\t\t\tdata=this.lang;\n");
      out.write("\t\t\tdata=data.split(\"?\");\n");
      out.write("\t\t\tgetSchool(data[1],data[0]);\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\t\t//详情点击事件\n");
      out.write("\tfunction detailclick(){\n");
      out.write("\t\t$(\".detail\").click(function(){\n");
      out.write("\t\t\tvar school=this.lang;\n");
      out.write("\t\t\tlayer.open({\n");
      out.write("\t\t\t\t  type: 2,\n");
      out.write("\t\t\t\t  title: '会员详情',\n");
      out.write("\t\t\t\t  area: ['800px', '600px'],\n");
      out.write("\t\t\t\t // closeBtn: 0, //不显示关闭按钮\n");
      out.write("\t\t\t\t  shift: 1,\n");
      out.write("\t\t\t\t  maxmin: true,\n");
      out.write("\t\t\t\t  shade: 0.5, //开启遮罩关闭\n");
      out.write("\t\t\t\t  content: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/schooldetail.jsp?school='+school,\n");
      out.write("\t\t\t\t  end: function(){\n");
      out.write("\t\t\t\t\t  getData();\n");
      out.write("\t\t\t\t    }\n");
      out.write("\t\t\t});\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\tfunction drawTable(data){\n");
      out.write("\t\t//$.ajaxSetup({async : false});\n");
      out.write("\t\tvar line=\"\";\n");
      out.write("\t\tline=line + \"<thead>\";\n");
      out.write("\t\tline=line + \"<tr class='text-c'>\";\n");
      out.write("\t\tline=line + \"<th class='xh'>序号</th>\";\n");
      out.write("\t\tline=line + \"<th class='xh'>学校名称</th>\";\n");
      out.write("\t\tline=line + \"<th class='yhm'>会员人数</th>\";\n");
      out.write("\t\tline=line + \"<th class='xm'>详情</th>\";\n");
      out.write("\t\tline=line + \"</tr>\";\n");
      out.write("\t\tline=line + \"</thead>\";\n");
      out.write("\t\tline=line + \"<tbody>\";\n");
      out.write("\t\tfor(i=0;i<data.length;i++){\t\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getSchoolMemberCount.action\",{school:data[i]},function(data1){\n");
      out.write("\t\t\t\tcount=data1;\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t//alert(count);\n");
      out.write("\t\t\tline=line + \"<tr class='text-c'>\";\n");
      out.write("\t\t\tline=line + \"<td>\" + (i+1) + \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td class='text-l'>\" + data[i] + \"</td>\";\t\t\t\n");
      out.write("\t\t\tline=line + \"<td>\" + count + \"</td>\";\n");
      out.write("\t\t\tline=line + \"<td>\" + \"<a class='detail' href='javascript:;' lang='\"+data[i]+\"'title='详情'><span class='label label-success radius'>详情</span></a>\" + \"</td>\";\n");
      out.write("\t\t\tline=line + \"</tr>\";\n");
      out.write("\t\t}\n");
      out.write("\t\tline=line + \"</tbody>\";\n");
      out.write("\t\t$(\"#schools\").html(line);\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\t<!-- 代码 结束 -->\n");
      out.write("\t<div id=\"main\">\n");
      out.write("\t\t<div id=\"provinceList\"></div>\n");
      out.write("\t\t<div id=\"scllist\">\n");
      out.write("\t\t\t<table class=\"table table-border table-bordered table-bg table-hover\"\n");
      out.write("\t\t\t\tid=\"schools\">\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<div class='page-nav' style=\"margin-top: 20px;\"></div>\n");
      out.write("\t\t</div>\n");
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
}
