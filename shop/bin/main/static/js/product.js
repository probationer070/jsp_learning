/**
 * 
 */

 $().ready(function(){
	/* 최종일때 주석 해제*/
	/*var nlen = $('.number').length;
	for(var i=0; i<nlen; i++) {
		var n = $('.number').eq(i).val();
		var to_n = n.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,",");
		$('.number').eq(i).val(to_n);
	}*/
	
	$('.psubmit').on('click', function() {
		var nm = this.name;
		if(nm=='insert'){
			$('form[name=form1]').attr("action", "productMgtProc?flag=insert");
		} else {
			$('form[name=form1]').attr("action", "productMgtProc?flag=update");
		}
		if(validate()){
			$('.inNum').each(function(){
				var valWithoutComma = $(this).val().replace(/[,]/g, "");
				$(this).val(valWithoutComma);
			});
			$("form[name=form1]").submit();
		}	
	})
	
	$('.inNum').on('keyup change propertychange input paste',function(){
		var nlen = $('.inNum').length;
		for(var i=0; i<nlen; i++) {
			var n = $('.inNum').eq(i).val().replace(/[^0-9,]/g,'');
			var tmpn = n.replace(/[,]/g, '');
			$('.inNum').eq(i).val(numberWithCommas(tmpn));
		}
	});
	
	$('.cartAdd').on('click', () => {
		var q = $('input[name=quantity]').val();
		var s = $('input[name=stock]').val();
		if(!$.isNumeric(q.replace(/[,]/g, ""))){
			alert("숫자만 입력 가능합니다");
			$('input[name=quantity]').focus();
			return false;
		}
		if(parseInt(q.replace(/[,]/g, ""))>parseInt(s.replace(/[,]/g, ""))) {
			alert("재고가 부족 합니다");
			$('input[name=quantity]').focus();
			return false;
		}
		$('.inNum').each(function(){
			var valWithoutComma = $(this).val().replace(/[,]/g, "");
			$(this).val(valWithoutComma);
		});
		$('.number').each(function(){
			var valWithoutComma = $(this).val().replace(/[,]/g, "");
			$(this).val(valWithoutComma);
		});
		$("form[name=form1]").submit();
	})
	
	$('.pDetail').on('click', function() {
		var p_no = $(this).closest('tr').find('input[name=p_no]').val();
		location.href='/productDetail?p_no='+p_no;
	});
 })
 
 function validate() {
	var flen = $("form[name=form1] .chk").length;
	for (var i=0; i < flen; i++) {
		if( $('form[name=form1] .chk').eq(i).val() == "" || 
			$('form[name=form1] .chk').eq(i).val() == null ||
			$('form[name=form1] .chk').eq(i).val().trim() == "") {
				alert($('form[name=form1] .chk').eq(i).attr('title')+' 은/는 필수입력입니다.');
				$('form[name=form1] .chk').eq(i).focus();
				return false;
		}
	}
	return true;
}

function numberWithCommas(num) {
	var parts = num.toString().split(".");
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",")
	+ (parts[1] ? "," + parts[1] : "");
}