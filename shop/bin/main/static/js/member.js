/**
 * 회원관리용
 */

$().ready(function(){
	var idSubmitChk = 1; 
	var pwcheck=false;
	
	$('#submitTop').on('click', function(){
		if(chkValidate('LoginForm')) {
			$("form[name=LoginForm]").attr('action', 'loginProc');
			$("form[name=LoginForm]").submit();
		}
	})
	
	$('#logout_btn').on('click', function(){
		if(chkValidate('LoginForm')) {
			$("form[name=LoginForm]").attr('action', 'logoutProc');
			$("form[name=LoginForm]").submit();
		}
	})
	
	$('#submit1').on('click', function(){
		if(chkValidate('form1')) {
			if(idSubmitChk==1){
				alert('아이디 중복\n다시 확인해 주세요');
				$('#idchk').focus();
				return false;
			}
			if(!pwcheck) {	// pwcheck가 다르면 false이므로 참이어야 안으로 들어감
				alert("패스워드가 다릅니다.");
				return false;
			}
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
					idSubmitChk = 1;	// 전송블기
				} else {
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color', 'blue');
					$('font[id=warning]').text('사용가능한 아이디 입니다');
					$('#idchk').focus();
					idSubmitChk = 0;	// 전송가능
				}
			}
		})
	})
	
	$('#check1, #check2').keyup(function(){
		$('font[id=check]').text('');	// 글씨 쓰는 곳 지우기
		if($('#check1').val()!=$('#check2').val()) {
			$('font[id=check]').text('');
			$('font[id=check]').attr('color', 'red');
			$('font[id=check]').text('패스워드가 다릅니다');
			pwcheck=false;
		} else {
			$('font[id=check]').text('');
			$('font[id=check]').attr('color', 'green');
			$('font[id=check]').text('동일한 패스워드');
			pwcheck=true;
		}
	});
})

function chkValidate(formNm) {
	var flen = $("form[name="+formNm+"] .chk").length;
	for (var i=0; i < flen; i++) {
		if( $("form[name="+formNm+"] .chk").eq(i).val() == "" 
		|| $("form[name="+formNm+"] .chk").eq(i).val() == null 
		|| $("form[name="+formNm+"] .chk").eq(i).val().trim() == "") {
			alert($("form[name="+formNm+"] .chk").eq(i).attr('title')+' 은/는 필수입력입니다.');
			$("form[name="+formNm+"] .chk").eq(i).focus();
			return false;
		}
	}
	return true;
}