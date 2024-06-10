/**
 * 회원관리용
 */

$().ready(function(){
	var idSubmitChk = 1; 
	
	$('#submitTop').on('click', function(){
		if(chkValidate()) {
			$("form[name=form1]").attr('action', 'loginProc');
			$("form[name=form1]").submit();
		}
	})
	
	$('#logout_btn').on('click', function(){
		if(chkValidate) {
			$("form[name=form1]").attr('action', 'logoutProc');
			$("form[name=form1]").submit();
		}
	})
	
	$('#idchk').on('propertychange change paste input', function(){
		$.ajax({
			async:true,
			type:'post',
			url:'idCheck',
			data:{'mem_id':$('#idchk').val()},
			dataType:'json',
			success:function(data){
				if (data>0) {
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color', 'red');
					$('font[id=warning]').text('이미 존재하는 아이디 입니다');
					$('#idchk').focus();
					idSubmitChk = 1;
				} else {
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color', 'blue');
					$('font[id=warning]').text('사용가능한 아이디 입니다');
					$('#idchk').focus();
					idSubmitChk = 0;
				}
			}
		})
		
	})
})

function chkValidate() {
	var flen = $("form[name=form1] .chk").length;
	for (var i=0; i < flen; i++) {
		if( $('.chk').eq(i).val() == "" || 
			$('.chk').eq(i).val() == null ||
			$('.chk').eq(i).val().trim() == "") {
				alert($('.chk').eq(i).attr('title')+' 은/는 필수입력입니다.');
				$('.chk').eq(i).focus();
				return false;
		}
	}
	return true;
}