var CustomersData = 
{Rows:[{"id":"1","cardCode":"2013456","cardTypeName":"IC卡","gradeName":"青铜会员","openDate":"2013-111-12","createUserName":"Berlin","createTime":"123156456","statusName":"未使用"}]}

$.ajax({
	url:'/memberCard/getAllNormalUseCardCode.do',
		method:'POST',
		dataType:'json',
		success:function(data){
			alert(data);
			CustomersData=data;
		
		}
	});



