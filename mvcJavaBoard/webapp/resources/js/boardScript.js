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
});	// ready to close;

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