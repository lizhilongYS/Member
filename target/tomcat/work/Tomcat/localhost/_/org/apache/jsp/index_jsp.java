/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-05 05:43:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>IT精英会员俱乐部-为我们的事业保驾护航!</title>\n");
      out.write("<link rel=\"shortcut icon\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/favicon.ico\" />\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/chocolat.css\"\n");
      out.write("\ttype=\"text/css\" media=\"screen\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<meta name=\"keywords\"\n");
      out.write("\tcontent=\"Expire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("<script type=\"application/x-javascript\"> \n");
      out.write("\taddEventListener(\"load\", function() { \n");
      out.write("\tsetTimeout(hideURLbar, 0); }, false); \n");
      out.write("\tfunction hideURLbar(){ window.scrollTo(0,1); } \n");
      out.write("\t</script>\n");
      out.write("<script src=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/flexslider.css\"\n");
      out.write("\ttype=\"text/css\" media=\"screen\" />\n");
      out.write("<!--scrolling-->\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jslib/move-top.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jslib/easing.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t\tjQuery(document).ready(function($) {\n");
      out.write("\t\t\t$(\".scroll\").click(function(event){\t\t\n");
      out.write("\t\t\t\tevent.preventDefault();\n");
      out.write("\t\t\t\t$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t\tfunction open(){\n");
      out.write("\t\tif(session.getAttribute(\"myuser\")==null) {\t\n");
      out.write("\t\talert(\"请输入用户名！\"); document.form_name.username.focus(); return false;\n");
      out.write("\t\t}else document.form_name.action=\"aaa.htm\";\n");
      out.write("\t\t};\n");
      out.write("\t</script>\n");
      out.write("<!--scrolling-->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!--top-header-->\n");
      out.write("\t<div id=\"home\" class=\"top-header\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"logo\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"top-menu\">\n");
      out.write("\t\t\t\t<span class=\"menu\"><img src=\"images/nav-icon.png\" alt=\"\" /></span>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a class=\"scroll\" href=\"#home\">首页</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"user/benifit.jsp\">服务</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"scroll\" href=\"#service\">课程</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"user/questions.jsp\">问题</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"user/about.jsp\">关于</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"scroll\" href=\"#contact\">联系</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t<!-- script-for-menu -->\n");
      out.write("\t\t\t\t<script>\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t$(\"span.menu\").click(function(){\n");
      out.write("\t\t\t\t\t\t\t\t$(\".top-menu ul\").slideToggle(\"slow\" , function(){\n");
      out.write("\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t </script>\n");
      out.write("\t\t\t\t<!-- script-for-menu -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!--header-->\n");
      out.write("\t<div class=\"header\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"banner-info\">\n");
      out.write("\t\t\t\t<h2>IT精英会员俱乐部,为你的事业保驾护航!</h2>\n");
      out.write("\t\t\t\t<p>不论性别,学历,年龄,肤色,只要你和我们一样对IT技术领域充满浓厚兴趣,并愿意为她矢志不渝,不管路有多长,我们愿意陪着你,一路的走下去！！</p>\n");
      out.write("\t\t\t\t<a href=\"user/benifit.jsp\">Click</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!--Service-->\n");
      out.write("\t<div id=\"service\" class=\"service\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<h3>免费服务</h3>\n");
      out.write("\t\t\t<div class=\"service-grids\">\n");
      out.write("\t\t\t\t<div class=\"icon-grids\">\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 futr-grid futr1\">\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-pic\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"icon text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-phone\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-info\">\n");
      out.write("\t\t\t\t\t\t\t<h4>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">免费评估</a>\n");
      out.write("\t\t\t\t\t\t\t</h4>\n");
      out.write("\t\t\t\t\t\t\t<p>不要相信任何人都可以学会软件开发的鬼话！通过你的年龄，学历，过往学习和工作经历，给你一个综合评分，根据评分结果对你是否适合学，多久可以学会，学完以后在职场上的预期待遇进行评估。</p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 futr-grid\">\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-pic\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"icon text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-thumbs-up\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-info\">\n");
      out.write("\t\t\t\t\t\t\t<h4>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">免费课程</a>\n");
      out.write("\t\t\t\t\t\t\t</h4>\n");
      out.write("\t\t\t\t\t\t\t<p>我们有丰富的免费体验课程，这些课程已经有上百万的点击量，获得学习者无数好评！我们的课程特点是：通俗易懂，注重实际，学习周期短。只要把我们的课程内容弄懂，就可以胜任企业中最复杂的项目开发任务。</p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"icon-grids grids2\">\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 futr-grid futr1\">\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-pic\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"icon text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-picture\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-info\">\n");
      out.write("\t\t\t\t\t\t\t<h4>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">免费指导</a>\n");
      out.write("\t\t\t\t\t\t\t</h4>\n");
      out.write("\t\t\t\t\t\t\t<p>学习中遇到问题怎么办？如果有名师随时在你身边，为你提供学习帮助，效率是否会事半功倍？强哥领导的技术服务团队，随时在线，通过电话，网络，远程控制等多种方式，解决你的所有疑难问题。</p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 futr-grid\">\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-pic\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"icon text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"icon-info\">\n");
      out.write("\t\t\t\t\t\t\t<h4>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">免费测试</a>\n");
      out.write("\t\t\t\t\t\t\t</h4>\n");
      out.write("\t\t\t\t\t\t\t<p>勿在浮沙筑高楼!如果你感觉学起来很痛苦，总有一些问题连接不起来，那是因为你的基础没有打好。学完强哥的基础课程后，找强哥做一个基础测试，然后再接着往后学，你会感觉很多问题都豁然开朗。</p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"footer\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<p>\n");
      out.write("\t\t\t\tCopyright &copy; 2004 - 2016.IT精英会员俱乐部.All Rights Reserved.<a\n");
      out.write("\t\t\t\t\ttarget=\"_blank\" href=\"http://www.xinqushi.net\"></a>\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t\t<div class=\"social\">\n");
      out.write("\t\t\t\t<a href=\"#\"><i class=\"facebook\"></i></a> <a href=\"#\"><i\n");
      out.write("\t\t\t\t\tclass=\"twitter\"></i></a> <a href=\"#\"><i class=\"dribble\"></i></a> <a\n");
      out.write("\t\t\t\t\thref=\"#\"><i class=\"google\"></i></a> <a href=\"#\"><i\n");
      out.write("\t\t\t\t\tclass=\"youtube\"></i></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"arrow\">\n");
      out.write("\t\t\t\t<a class=\"scroll\" href=\"#home\"><img src=\"images/top.png\" alt=\"\"></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!---->\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t\t\t/*\n");
      out.write("\t\t\t\tvar defaults = {\n");
      out.write("\t\t\t\tcontainerID: 'toTop', // fading element id\n");
      out.write("\t\t\t\tcontainerHoverID: 'toTopHover', // fading element hover id\n");
      out.write("\t\t\t\tscrollSpeed: 1200,\n");
      out.write("\t\t\t\teasingType: 'linear' \n");
      out.write("\t\t\t\t};\n");
      out.write("\t\t\t\t*/\n");
      out.write("\t\t$().UItoTop({ easingType: 'easeOutQuart' });\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\t<a href=\"#to-top\" id=\"toTop\" style=\"display: block;\"> <span\n");
      out.write("\t\tid=\"toTopHover\" style=\"opacity: 1;\"> </span></a>\n");
      out.write("\t<!---->\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /index.jsp(58,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.TURE!=null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<h1>\n");
        out.write("\t\t\t\t\t\t<a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/clue/myjumps.jsp\">Join</a>\n");
        out.write("\t\t\t\t\t</h1>\n");
        out.write("\t\t\t\t");
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

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /index.jsp(63,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.TURE==null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<h1>\n");
        out.write("\t\t\t\t\t\t<a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/user/login.jsp\">Join</a>\n");
        out.write("\t\t\t\t\t</h1>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
