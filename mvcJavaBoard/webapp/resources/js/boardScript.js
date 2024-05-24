/*
게시판 용 스크립트
*/

$(function(){
	$('#sendSubmit').on("click", function() {
		if (chkValidate()) {
			document.form1.submit();
		}
	})
	
	$('#callList').on('click', function(){
		var pageNo = document.form1.pageNum.value;
		location.href = "list.do?pageNum="+pageNo;
	})

	$('#reply').on('click', function(){
		$("form[name=form1]").attr('action', "writeForm.do")
		$("form[name=form1]").submit();
	})
	
	$('#update').on('click', function(){
		if(confirmPw()) {	
			$("form[name=form1]").attr('action', "updateForm.do")
			$("form[name=form1]").submit();			
		} else {
			alert("비밀번호가 맞지 않습니다.");
			return false;
		}
	})
	
	$('#saveContent').on("click", function() {
		if (chkValidate()) {
			document.form1.submit();
		}
	})

	$('#delete').on('click', function(){
		if(confirmPw()) {
			if (confirm("정말 삭제하시겠습니까?") === true) {			
				$("form[name=form1]").attr('action', "deletePro.do")
				$("form[name=form1]").submit();			
			}
		} else {
			alert("비밀번호가 맞지 않습니다.");
			return false;
		}
	})
	
	$('#searchBtn').on('click', function() {
		$("form[name=form1]").attr('action', "list.do");
		$("form[name=form1]").submit();			
	})
	
	
});	// ready to close;

function confirmPw() {
	var pw = prompt('비밀번호를 입력하시오.');
	var passwd = $("input[name=passwd]").val();

	if (passwd === pw) {
		return true;
	} else {
		return false;
	}
}


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

function callContent(bno) {
	// alert(bno);
	var f = document.form1;
	f.action = 'content.do';
	f.bno.value = bno;
	f.submit();
}

