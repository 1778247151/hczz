/**
 * func:自定义常用的日期处理方法
 * 
 * @author yumaochun
 * 时间：2015-09-24
 */
(function($){
	window.date = $.date = {
		/**
		 * func:获取当前日期  如：2015-04-10
		 * 
		 * @param split   日期分隔符     如：'-','/'
		 * @returns
		 */
		getCurrentDate:function(split){
			var date=new Date();
		    return $.date.formatDate(date,split);
		},
		/**
		 * func:获取当前日期  如：2015-04-10 10:21:40
		 * 
		 * @param split   日期分隔符     如：'-','/'
		 * @returns
		 */
		getCurrentDateTime:function(split){
			var date=new Date();
		    return $.date.formatDateTime(date,split);
		},
		/**
		 * func:当指定日期字符串转换成时间戳  如：2015-04-10
		 * 
		 * @param dateStr   需要转换的日期字符串     如：2016-04-05
		 * @param split     日期分隔符     如：'-','/'
		 * @returns
		 */
		getTimestamp:function(dateStr)
		{
			date = new Date(Date.parse(dateStr.replace(/-/g, "/")));
			date = date.getTime();
		    return date;
		},
		
		/**
		 * func:对一位数字始终保留两位数，一位数前面加0
		 * 
		 * @param number      要处理的数字
		 * @returns
		 */
		fillTwoNumber:function(number){
			if(number<10){
				return "0"+number;
			}else{
				return number;
			}
		},
		/**
		 * func:格式化日期   如：2015-04-10
		 * 
		 * @param date     new Date() 日期
		 * @param split    分隔符  如：'-','/'
		 * @returns {String}
		 */
		formatDate:function(date,split){			
			var year=date.getFullYear();//获取年份
			var month=date.getMonth()+1;//获取当前月份(0-11,0代表1月) 
			month=$.date.fillTwoNumber(month);
			var day=date.getDate();//获取当前日(1-31)
			day=$.date.fillTwoNumber(day);
			//var day=date.getDay(); //获取当前星期X(0-6,0代表星期天) 
			var dataStr=year+""+split+""+month+""+split+""+day;
			return dataStr;
		},
		/**
		 * func:格式化日期  如：2015-04-10 10:21:20
		 * 
		 * @param date    new Date() 日期
		 * @param split   分隔符  如：'-','/'
		 * @returns {String}
		 */
		formatDateTime:function(date,split){
			var hours=date.getHours(); //获取当前小时数(0-23) 
			//如果是1位数填充0
			hours=$.date.fillTwoNumber(hours);
			var minutes=date.getMinutes(); //获取当前分钟数(0-59) 
			minutes=$.date.fillTwoNumber(minutes);
			var seconds=date.getSeconds(); //获取当前秒数(0-59)
			seconds=$.date.fillTwoNumber(seconds);
			var dateStr=$.date.formatDate(date,split)+" "+hours+":"+minutes+":"+seconds;
			return dateStr;
		},
		/**
		 * func:对指定日期增加天数(有时分秒)    如：2015-04-10 10:21:05 增加5天返回：2015-04-15 10:21:05
		 * 
		 * @param date      需要处理的日期
		 * @param days      需要增加的天数
		 * @param spilt     日期分隔符  如：'-','/'
		 * @returns   返回新日期：2015-04-15 10:21:05
		 */
		addDaysToDateTime:function(date,days,spilt){
			var newDate=new Date(date.getTime() + days*24*60*60*1000);
			return $.date.formatDateTime(newDate,spilt);
		},
		/**
		 * func:对指定日期增加天数    如：2015-04-10  增加5天返回：2015-04-15
		 * 
		 * @param date      需要处理的日期
		 * @param days      需要增加的天数
		 * @param spilt     日期分隔符  如：'-','/'
		 * @returns   返回新日期：2015-04-15
		 */
		addDaysToDate:function(date,days,spilt){
			var newDate=new Date(date.getTime() + days*24*60*60*1000);
			return $.date.formatDate(newDate,spilt);
		},
		/**
		 * func:对指定日期减少天数(有时分秒)    如：2015-04-10 10:21:05  减少5天返回：2015-04-05 10:21:05
		 * 
		 * @param date     需要处理的日期
		 * @param days     需要增加的天数
		 * @param spilt    日期分隔符  如：'-','/'
		 * @returns      返回新日期：2015-04-05 10:21:05
		 */
		reduceDaysToDateTime:function(date,days,spilt){
			var newDate=new Date(date.getTime() - days*24*60*60*1000);
			return $.date.formatDateTime(newDate,spilt);
		},
		/**
		 * func:对指定日期减少天数    如：2015-04-10  减少5天返回：2015-04-05
		 * 
		 * @param date     需要处理的日期
		 * @param days     需要增加的天数
		 * @param spilt    日期分隔符  如：'-','/'
		 * @returns      返回新日期：2015-04-05
		 */
		reduceDaysToDate:function(date,days,spilt){
			var newDate=new Date(date.getTime() - days*24*60*60*1000);
			return $.date.formatDate(newDate,spilt);
		},
		/**
		 * 
		 * @param dateStr  日期字符串（以"-"分割）   如：2016-04-12
		 * @param n     增加月份数  如：2
		 * @returns {String}   返回：添加月份后的日期
		 */
		addMonth:function(dateStr,n){
//			var s=dateStr.split("-");
//		    var yy=parseInt(s[0]); 
//		    var mm=parseInt(s[1]-1);
//		    var dd=parseInt(s[2]);
//		    var dt=new Date(yy,mm,dd);
//		    dt.setMonth(dt.getMonth()+n);
//		    if( (dt.getYear()*12+dt.getMonth()) > (yy*12+mm + n) )
//		     {
//		        dt=new Date(dt.getYear(),dt.getMonth(),0);
//		     }
//		    var year = dt.getFullYear();
//		    var month = dt.getMonth()+1;
//		    month=$.date.fillTwoNumber(month);
//		    var days = dt.getDate();
//		    days=$.date.fillTwoNumber(days);
//		    var dd= year+"-"+month+"-"+days;
//		    return dd;
			//将日期字符串转换为日期
			var date=$.date.getDate(dateStr);
			date.setMonth(date.getMonth()+n);
			var newDate=$.date.formatDate(date,"-");
			return newDate;

		},
		/**
		 * 
		 * fun:将日期字符串转为日期
		 *
		 * @author yumaochun
		 * @date 2016年5月31日
		 * @param dateStr   2016-04-11
		 */
		getDate:function(dateStr){
			var str = dateStr.replace(/-/g,"/");
			var date = new Date(str );
			return date;
		},
		/**
		 * 
		 * fun:对指定的日期添加或减少天数
		 * 
		 * @param dateStr               指定的日期字符串
		 * @param days                  增加或减少天数
		 * @param spilt                 返回日期分割符号“-”
		 * @returns    返回：添加或减少天数的日期
		 */
		addOrReduceDays:function(dateStr,days,spilt){
			var date=new Date(dateStr);
			var newDate=new Date(date.getTime() + days*24*60*60*1000);
			return $.date.formatDate(newDate,spilt);
		},
		/**
		 * fun:判断对象是否为空
		 * 
		 * @param obj                待判断的对象
		 * @returns {Boolean}        返回：true-是空对象，false-不是空对象
		 */
		isEmptyObject: function( obj ) { 
			for ( var name in obj ) { 
				alert();
			     return false; 
			} 
			return true; 
		},
		/**
		 **判断是否为当年当月的最后一天
		 */
		isLastDay:function(yearV,monthV,dayV){
			var new_year = yearV; //取当前的年份 
			 var new_month = monthV+1;//取下一个月的第一天，方便计算（最后一天不固定） 
			 if(new_month>12) //如果当前大于12月，则年份转到下一年 
			 { 
			 new_month -=12; //月份减 
			 new_year++; //年份增 
			 } 
			 var new_date = new Date(new_year,new_month,1); //取当年当月中的第一天 
			 var lastDay = (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期 
			 if(lastDay==dayV){
			 return true;
			 }else{
			 return false;
			 }
		},
		/**
		 * 
		 * fun:根据日期获取当前月份最后一天的号数
		 *
		 * @author yumaochun
		 * @date 2016年5月5日
		 * @param dateStr    处理的日期，如：2016-04-11
		 * @returns {Number}   返回：当前月份最后一天的号数
		 */
		getCurrentMonthLastDay:function(dateStr){
			var s=dateStr.split("-");
		    var yy=parseInt(s[0]); 
		    var mm=parseInt(s[1]-1);
		    var dd=parseInt(s[2]);
		    var dt=new Date(yy,mm,dd);
		    dt.setMonth(dt.getMonth()+1);
		    dt.setDate(1);
		    var lastDay=$.date.reduceDaysToDateTime(dt,1,"-");
			return lastDay;
		},
		/**
		 **计算距离月底还有几天
		 */
		getLastDayAway:function(yearV,monthV,dayV){
		   var new_year = yearV; //取当前的年份 
		   var new_month = monthV+1;//取下一个月的第一天，方便计算（最后一天不固定）
		   if(new_month>12) //如果当前大于12月，则年份转到下一年 
		   { 
		      new_month -=12; //月份减 
		      new_year++; //年份增 
		   }
		   var new_date = new Date(new_year,new_month,1); //取当年当月中的第一天 
		   var lastDay = (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期
		   var away_day = lastDay-dayV; 
		   return away_day;
		},
		/**
		 * 
		 * fun:计算两个日期之间间隔的天数
		 *
		 * @author yumaochun
		 * @date 2016年5月31日
		 * @param startDate               起始时间  如：2016-04-11
		 * @param endDate                 结束时间  如：2016-04-20
		 * @return   返回：相差的天数     返回：10
		 */
		getDays:function(startDate,endDate){
			var tempStart=$.date.getTimestamp(startDate);
			var tempEnd=$.date.getTimestamp(endDate);
			var days=(tempEnd-tempStart)/(1000 * 60 * 60 * 24);
			return days;
			
		},
		/**
		 * 
		 * fun:计算两个日期之间间隔的月份数和天数
		 *
		 * @author yumaochun
		 * @date 2016年5月30日
		 * @param startDate    起始日期
		 * @param endDate      结束日期
		 */
		getMonthAndDays:function(startDate, endDate){
			//整月数
			var month=$.date.getDateMonthSub(startDate, endDate);
			//整月数对应的天数
			var newDate=$.date.addMonth(startDate,month);
			//alert(newDate);
			//整天数
			var days=$.date.getDays(newDate,endDate)*1+1;
			var monthStr=month*1==0?"":month+"月";
			var daysStr=days*1==0?"":days+"天";
			return monthStr+daysStr;
		},
		/**
		 * @param startDate
		 * 开始日期
		 * @param endDate
		 * 结束日期
		 * @return 计算相差月份，必须满足正好一个月才进一
		 */
		getDateMonthSub:function(startDate, endDate) {
		 if (startDate == null || startDate == undefined || startDate == ""
		 || endDate == null || endDate == undefined || endDate == "")
		 return 0;
		 var newDate=$.date.addOrReduceDays(endDate,1,"-");//增加一天
		 var endDate = new Date(newDate);
		 var startDate = new Date(startDate);
		 var renNumber = 0;
		 var yearToMonth = (endDate.getFullYear() - startDate.getFullYear()) * 12;
		 // 计算年份相差月份
		 renNumber += yearToMonth;

		var startYear = startDate.getFullYear();// 开始日期-年份
		 var endYear = endDate.getFullYear();// 结束日期-年份
		 var startMon = startDate.getMonth();// 开始日期-月份
		 var endMon = endDate.getMonth();// 结束日期-月份
		 var startDay = startDate.getDate();// 开始日期-日
		 var endDay = endDate.getDate();// 开始日期-日

		var monthToMonth = endDate.getMonth() - startDate.getMonth();
		 // 计算月份相差
		 renNumber += monthToMonth;

		// 如果开始日期是最后一天并且结束日期不是最后一天，那么返回值-1
		 if ($.date.isLastDay(startYear, startMon, startDay)
		 && !$.date.isLastDay(endYear, endMon, endDay)) {
		 renNumber -= 1;
		 return renNumber;
		 } else {
		 // 如果开始日期和结束日期都不是最后一天
		 if (!$.date.isLastDay(startYear, startMon, startDay)
		 && !$.date.isLastDay(endYear, endMon, endDay)) {
		 // 如果都不是最后一天，就需要计算开始日期和结束日期的天数距离结束还有几天,分别为start_last,end_last
		 var start_last = $.date.getLastDayAway(startYear, startMon, startDay);
		 var end_last = $.date.getLastDayAway(endYear, endMon, endDay);
		 
		 // 如果结束日期距离月底的天数比开始日期距离月底的天数大，则返回值-1
		 if (end_last > start_last) {
		 renNumber -= 1;
		 return renNumber;
		 } else {
		 return renNumber;
		 }

		} else {
		 // 如果开始日期和结束日期的天都是当月的最后一天，那么相差月份就是实际月份相减的值
		 // 其他情况都直接返回renNumber
		 return renNumber;
		 }

		}
		},
	};
	
})(jQuery);