$(function(){
/*************    方法     **************/
	//判断是否是闰年,计算每个月的天数
	function leapYear(year){
		var isLeap = year%100==0 ? (year%400==0 ? 1 : 0) : (year%4==0 ? 1 : 0);
		return new Array(31,28+isLeap,31,30,31,30,31,31,30,31,30,31);
	}

	//获得某月第一天是周几
	function firstDay(day){
		return day.getDay();
	}

	//获得当天的相关日期变量
	function dateNoneParam(){
		var day = new Date();
		var today = new Array();
		today['year'] = day.getFullYear();
		today['month'] = day.getMonth();
		today['date'] = day.getDate();
		today['hour'] = day.getHours();
		today['minute'] = day.getMinutes();
		today['second'] = day.getSeconds();
		today['week'] = day.getDay();
		today['firstDay'] = firstDay(new Date(today['year'],today['month'],1)); 
		return today;
	}

	//获得所选日期的相关变量
	function dateWithParam(year,month){
		var day = new Date(year,month);
		var date = new Array();
		date['year'] = day.getFullYear();
		date['month'] = day.getMonth();
		date['firstDay'] = firstDay(new Date(date['year'],date['month'],1));
		return date;
	}

	//生成日历代码 的方法
	//参数依次为 年 月 日 当月第一天(是星期几)
	function kalendarCode(codeYear,codeMonth,codeDay,codeFirst){
		kalendar_html = "<table id='kalendar'>\n<tr id='select'>\n<td colspan=7>\n<div id='year'>\n<ul>\n<li><input type='button' id='yearPrev' value='<<' /></li>\n<li class='selectChange'>\n<select name='year'>";
		//年 选择
		for(var i=1970;i<=codeYear+yearfloor;i++){
			if(i == codeYear){
				kalendar_html += "<option value='"+i+"' selected='true'>"+i+"</option>";
			}else{
				kalendar_html += "<option value='"+i+"'>"+i+"</option>";
			}
		}
		var amount = 0;
	
		kalendar_html += "</select>\n</li>\n<li><input type='button' id='yearNext' value='>>' /></li>\n</ul>\n</div>\n<div id='month'>\n<ul>\n<li><input type='button' id='monthPrev' value='<' /></li>\n<li class='selectChange'>\n<select name='year'>";

		
		//月 选择
		for(var j=0;j<=11;j++){
			if(j == codeMonth){
				kalendar_html += "<option value='"+j+"' selected='true'>"+month[j]+"</option>";
			}else{
				kalendar_html += "<option value='"+j+"'>"+month[j]+"</option>";
			}
		}
		var dmonth = parseInt(codeMonth)+1;
		if (dmonth < "10")
		{
			dmonth = "0"+ dmonth;
		}
		
		kalendar_html += "</select>\n</li>\n<li><input type='button' id='monthNext' value='>' /></li>\n</ul>\n</div>\n<div id='time'>\n</div>\n<div id='account' value="+codeYear+'-'+dmonth;
		kalendar_html += "></div></td>\n</tr>\n\n<tr id='week'>\n<td colspan=7>\n<ul>\n<li class='weekend'>星期日</li>\n<li>星期一</li>\n<li>星期二</li>\n<li>星期三</li>\n<li>星期四</li>\n<li>星期五</li>\n<li class='weekend'>星期六</li>\n</ul>\n</td>\n</tr>\n\n<tr id='day'>\n<td colspan=7>\n";

		//日 列表
		for(var m=0;m<6;m++){//日期共 4-6 行
			if(m >= Math.ceil((codeFirst+monthDays[codeMonth])/7)){//第五、六行是否隐藏				
				kalendar_html += "<ul class='dayList hide dayListHide"+m+"'>\n";
			}else{
				kalendar_html += "<ul class='dayList dayListHide"+m+"'>\n";
			}	

			for(var n=0;n<7;n++){//列
				if((7*m+n) < codeFirst || (7*m+n) >= (codeFirst+monthDays[codeMonth])){//某月日历中不存在的日期
					kalendar_html += "<li></li>";
				}else{
					var day = 7*m+n+1-codeFirst;
					if (day < "10"){
						day = "0"+day;
					}
					var date = codeYear+'-'+dmonth+'-'+ day;
					$.ajaxSetup({async:false}); 
					$.post("../member/getDateAmount.action",{date:date},function(data){
						amount = data;
					}).error(function(){alert("error");});
					
					if((7*m+n+1-codeFirst == codeDay)&&(((7*m+n)%7 == 0) || ((7*m+n)%7 == 6))){//当天是周末
						kalendar_html += "<li class='todayWeekend' value="+date;
					}else if(((7*m+n)%7 == 0) || ((7*m+n)%7 == 6)){//仅是周末
						kalendar_html += "<li class='weekend' value="+date;
					}else if(7*m+n+1-codeFirst == codeDay){//仅是当天
						kalendar_html += "<li class='today' value="+date;
					}else{//其他日期
						kalendar_html += "<li value="+date;
					}
					kalendar_html += ">"+(7*m+n+1-codeFirst)+"<sub>"+amount+"</sub>"+"</li>";
				}
			}
			kalendar_html += "</ul>\n";
		}
		kalendar_html += "</td>\n</tr>\n</table>";
		return kalendar_html;
	}

	//年-月select框改变数值 的方法
	//参数依次为 1、操作对象(年下拉菜单 或 月下拉菜单) 2、被选中的下拉菜单值
	function y_mChange(obj,stopId){
		obj.val(stopId);
	}

	//修改日历列表 的方法
	//参数依次为 操作对象(每一天) 月份 修改后的第一天是星期几 修改后的总天数 当天的具体日期
	function dateChange(dateObj,dateMonth,dateFirstDay,dateTotalDays,dateCurrentDay){
		//判断新日历有几行,需要显示或隐藏
		var newLine = Math.ceil((dateFirstDay+monthDays[dateMonth])/7);//新行数
		if(newLine > dateLine){//增加行
			for(var i=dateLine;i<newLine;i++){
				$('.dayListHide'+i).show();
			}
		}else if(newLine < dateLine){//减少行
			for(var i=dateLine-1;i>=newLine;i--){
				$('.dayListHide'+i).hide();
			}
		}
		//重置日期排序
		dateLine = newLine;
		/*如果改变 月 后，选中月的总天数小于当前日期，
		*如当前3.31，选中2月，可2月最多29天，则将当前日期改为选中月的最后一天，即2.39
		*/
		if(dateTotalDays < dateCurrentDay){
			dateCurrentDay = dateTotalDays;
		}
		
		var dmonth = parseInt(monthChange)+1;
		if (dmonth < "10")
		{
			dmonth = "0"+ dmonth;
		}
		var date = yearChange+'-'+dmonth;
		$.post("../member/getDateAmount.action",{date:date},function(data){
			$("#account").html("合计金额："+data+" 元");
		}).error(function(){alert("error");});
		$("#account").attr("value",date);
		for(var i=0;i<7*newLine;i++){
			if(i < dateFirstDay || i> (dateTotalDays+dateFirstDay-1)){//日历中 当月不存在的日期
				dateObj.eq(i).text('').removeClass();
			}else{
				if((i+1-dateFirstDay == dateCurrentDay) && (i%7 == 0 || i%7 == 6)){
					dateObj.eq(i).removeClass().addClass('todayWeekend');
				}else if(i%7 == 0 || i%7 == 6){//仅周末
					dateObj.eq(i).removeClass().addClass('weekend');
				}else if(i+1-dateFirstDay == dateCurrentDay){//仅当天
					dateObj.eq(i).removeClass().addClass('today');
				}else{//其他日期
					dateObj.eq(i).removeClass();
				}
				var day = i+1-dateFirstDay;
				var amount = 0;
				if (day < "10"){
					day = "0"+day;
				}
				var date = yearChange+'-'+dmonth+'-'+ day;
				$.ajaxSetup({async:false}); 
				$.post("../member/getDateAmount.action",{date:date},function(data){
					amount = data;
				}).error(function(){alert("error");});
				dateObj.eq(i).html(i+1-dateFirstDay+"<sub>"+amount+"</sub>");
				dateObj.eq(i).attr("value",date);
			}
		}
	}

/*************    缓存节点和变量     **************/
	var rili_location = $('#wrap');//日历代码的位置
	var kalendar_html = '';//记录日历自身代码 的变量
	var yearfloor = 10;//选择年份从1970到当前时间的后10年

	var someDay = dateNoneParam();//修改后的某一天,默认是当天
	var yearChange = someDay['year'];//改变后的年份，默认当年
	var monthChange = someDay['month'];//改变后的年份，默认当月

/*************   将日历代码放入相应位置，初始时显示此处内容      **************/

	//获取时间，确定日历显示内容
	var today = dateNoneParam();//当天

	/*月-日 设置*/
	var month = new Array('一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月');
	var monthDays = leapYear(today['year']);//返回数组，记录每月有多少天
	var weekDay = new Array('日','一','二','三','四','五','六');
	// alert('年:'+someDay['year']+'\n月:'+someDay['month']+'\n日:'+someDay['date']+'\n星期:'+someDay['week']+'\n本月第一天星期:'+someDay['firstDay']);return false;

	kalendar_html = kalendarCode(today['year'],today['month'],today['date'],today['firstDay']);
	rili_location.html(kalendar_html);
	
	var dmonth = today['month']+1;
	if (dmonth < "10")
	{
		dmonth = "0"+ dmonth;
	}
	var date = today['year']+'-'+dmonth;
	$.post("../member/getDateAmount.action",{date:date},function(data){
		$("#account").html("合计金额："+data+" 元");
	}).error(function(){alert("error");});

/*************   js写的日历代码中出现的节点     **************/
	var yearPrev = $('#yearPrev');//上一年按钮
	var yearNext = $('#yearNext');//下一年按钮
	var monthPrev = $('#monthPrev');//上一月按钮
	var monthNext = $('#monthNext');//下一月按钮
	var selectYear = $('#year .selectChange select');//选择年份列表
	var listYear = $('#year .selectChange select option');//所有可选年份
	var selectMonth = $('#month .selectChange select');//选择月份列表
	var listMonth = $('#month .selectChange select option');//所有可选月份
	var dateLine = Math.ceil((monthDays[today['month']]+today['firstDay'])/7);;//当前日历中有几行日期，默认是 当年当月
	var dateDay = $('#kalendar tr#day td ul.dayList li');//日历中的每一天
	var account = $('#account');


/***************************/
	//年 按钮事件
	yearPrev.bind('click',function(){
		yearChange --;
		if(yearChange < 1970){
			yearChange = 1970;
			alert('太前也没意义了...');
			return false;
		}
		//修改年份
		y_mChange(selectYear,yearChange);
		//alert(yearChange);
		//重新获得 每月天数
		monthDays = leapYear(yearChange);
		//alert(monthChange);
		//新 年-月 下的对象信息
		someDay = dateWithParam(yearChange,monthChange);
		//修改 日期 列表
		dateChange(dateDay,someDay['month'],someDay['firstDay'],monthDays[someDay['month']],today['date']);	
	});

	yearNext.bind('click',function(){
		yearChange ++;
		if(yearChange >= today['year']+yearfloor){
			yearChange = today['year']+yearfloor;
			alert('太后也没意义了...');
			return false;
		}
		//修改年份
		y_mChange(selectYear,yearChange);
		//重新获得 每月天数
		monthDays = leapYear(yearChange);//alert(monthDays);
		//新 年-月 下的对象信息
		someDay = dateWithParam(yearChange,monthChange);
		//修改 日期 列表
		dateChange(dateDay,someDay['month'],someDay['firstDay'],monthDays[someDay['month']],today['date']);	
	});

	// 月 按钮事件
	monthPrev.bind('click',function(){
		monthChange --;
		if(monthChange >= 0){//仍在本年内
			//修改月份
			y_mChange(selectMonth,monthChange);			
		}else{
			monthChange = 11;//前一年的最后一个月
			yearChange --;
			if(yearChange < 1970){
				yearChange = 1970;
				alert('太久远也没意义了...');
				return false;
			}
			//修改月份
			y_mChange(selectMonth,monthChange);
			//修改年份
			y_mChange(selectYear,yearChange);
			//重新获得 每月天数
			monthDays = leapYear(yearChange);
		}
		//新 年-月 下的对象信息
		someDay = dateWithParam(yearChange,monthChange);
		//修改 日期 列表
		dateChange(dateDay,someDay['month'],someDay['firstDay'],monthDays[someDay['month']],today['date']);	
	});

	monthNext.bind('click',function(){
		monthChange ++;
		if(monthChange <= 11){//仍在本年内
			//修改月份
			y_mChange(selectMonth,monthChange);
		}else{
			monthChange = 0;//下一年的第一个月
			yearChange ++;
			if(yearChange >= someDay['year']+yearfloor){
				yearChange = someDay['year']+yearfloor;
				alert('太久远也没意义了...');
				return false;
			}
			//修改月份
			y_mChange(selectMonth,monthChange);
			//修改年份
			y_mChange(selectYear,yearChange);
			//重新获得 每月天数
			monthDays = leapYear(yearChange);
		}
		//新 年-月 下的对象信息
		someDay = dateWithParam(yearChange,monthChange);
		//修改 日期 列表
		dateChange(dateDay,someDay['month'],someDay['firstDay'],monthDays[someDay['month']],today['date']);			
	});

	// 年 选择事件
	selectYear.bind('change',function(){
		//获得年份
		yearChange = $(this).val();
		//修改年份
		y_mChange(selectYear,yearChange);
		//重新获得 每月天数
		monthDays = leapYear(yearChange);
		//新 年-月 下的对象信息
		someDay = dateWithParam(yearChange,monthChange);
		//修改 日期 列表
		dateChange(dateDay,someDay['month'],someDay['firstDay'],monthDays[someDay['month']],today['date']);
	});

	// 月 选择事件
	selectMonth.bind('change',function(){
		//获得 月
		monthChange = $(this).val();
		//修改月份
		y_mChange(selectMonth,monthChange);
		//新 年-月 下的对象信息
		someDay = dateWithParam(yearChange,monthChange);
		//修改 日期 列表
		dateChange(dateDay,someDay['month'],someDay['firstDay'],monthDays[someDay['month']],today['date']);
	});

	/*日 鼠标事件*/
	dateDay.hover(function(){
		$(this).addClass('mouseFloat');
	},function(){
		$(this).removeClass('mouseFloat');
	});
	
	dateDay.bind('click',function(){
		var object = $(this);
		
		var time = object.attr("value");
		$.post("../member/getDetail.action",{date:time},function(data){
			if (data.Rows.length == 0){
				layer.tips('该天无费用详情!',object, {
				    tips: [1, '#3595CC'],
				    guide: 0,
				    time: 1000
				});
			}
			else{
				var info_html = "<form>\n<table class='gridtable'>\n<tr><th>会员编号</th><th>会员姓名</th><th>应交金额</th><th>实交金额</th><th>早交天数</th></tr>";
				for (var i=0;i<data.Rows.length;i++){
					 var days = data.Rows[i].days;
					 if (days > 0)
					 {
						 info_html += "<tr class='early'><td>"+data.Rows[i].uname+"</td><td>"+data.Rows[i].name+"</td>";
					 }
					 else if (days < 0)
					 {
						 info_html += "<tr class='late'><td>"+data.Rows[i].uname+"</td><td>"+data.Rows[i].name+"</td>";
					 }
					 else{
						 info_html += "<tr><td>"+data.Rows[i].uname+"</td><td>"+data.Rows[i].name+"</td>";
					 }
					
					 info_html += "<td>"+data.Rows[i].restAmount+"</td><td>"+data.Rows[i].amount+"</td><td>"+data.Rows[i].days+"</td></tr>";
					
				}
				info_html += "</table></form>";
				var mtitle =  time+"费用详情";
				//layer弹出层，显示详细信息
				layer.open({
					area:['400px', ''],
					title:mtitle,
					offset:['240px','220px'],
				    type: 1,
				    skin: 'layui-layer-lan', //样式类名
				    closeBtn: 1, //不显示关闭按钮
				    shift: 1,//动画类型
				    shadeClose: true, //开启遮罩关闭
				    content: info_html
				});
			}
		},"json");
	});
	account.bind('click',function(){
		var object = $(this);
		var time = object.attr("value");
		$.post("../member/getMonthDetail.action",{date:time},function(data){
			if (data.Rows.length == 0){
				layer.tips('该天无费用详情!',object, {
				    tips: [1, '#3595CC'],
				    guide: 0,
				    time: 1000
				});
			}
			else{
				var info_html = "<form>\n<table class='gridtable'>\n<tr><th>会员编号</th><th>会员姓名</th><th>应交金额</th><th>实交金额</th><th>早交天数</th></tr>";
				for (var i=0;i<data.Rows.length;i++){
					 var days = data.Rows[i].days;
					 if (days > 0)
					 {
						 info_html += "<tr class='early'><td>"+data.Rows[i].uname+"</td><td>"+data.Rows[i].name+"</td>";
					 }
					 else if (days < 0)
					 {
						 info_html += "<tr class='late'><td>"+data.Rows[i].uname+"</td><td>"+data.Rows[i].name+"</td>";
					 }
					 else{
						 info_html += "<tr><td>"+data.Rows[i].uname+"</td><td>"+data.Rows[i].name+"</td>";
					 }
					var d2=	new Date();
					if (data.Rows[i].days != null){
						d2.setTime(data.Rows[i].days);
						var s2=d2.format('yyyy-MM-dd');
					}
					
					 info_html += "<td>"+data.Rows[i].restAmount+"</td><td>"+data.Rows[i].amount+"</td><td>"+s2+"</td></tr>";
					
				}
				info_html += "</table></form>";
				var mtitle =  time+"费用详情";
				//layer弹出层，显示详细信息
				layer.open({
					area:['400px', ''],
					title:mtitle,
				    type: 1,
				    skin: 'layui-layer-lan', //样式类名
				    closeBtn: 1, //不显示关闭按钮
				    shift: 1,//动画类型
				    shadeClose: true, //开启遮罩关闭
				    content: info_html
				});
			}
		},"json");
	});
});