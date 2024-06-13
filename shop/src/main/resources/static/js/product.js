/**
 * 
 */

 $().ready(function(){
	$('.psubmit').on('click', function() {
		var nm = this.name;
		if(nm=='insert'){
			$('form[name=form1]').attr("action", "productMgtProc?flag=insert");
		} else {
			$('form[name=form1]').attr("action", "productMgtProc?flag=update");
		}
		if(validate()){
			$("form[name=form1]").submit();
		}
	})
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