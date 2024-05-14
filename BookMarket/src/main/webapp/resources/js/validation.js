function checkAdd() {
	var formnm = document.querySelector('form');
	var bookId = document.getElementById('bookId');
	var name = document.getElementById('name');
	var unitPrice = document.getElementById('unitPrice');
	
	var author = document.getElementById('author');
	var publisher = document.getElementById('publisher');
	var desc = document.getElementById('description');
	var unitInStock = document.getElementById('unitsInStock');
	var category = document.getElementById('category');

	
	if (bookId.value.length > 0) {
		if (!check(/^ISBN[0-9]{4,11}$/, bookId,
	 "[도서코드]\nISBN과 조합하여 12자리까지 입력하시오.\n 첫글자는 반드시 ISBN으로 시작")) {
		return false;
		}
	} else {
		alert("[도서코드]\nISBN과 조합하여 12자리까지 입력하시오.\n 첫글자는 반드시 ISBN으로 시작");
		bookId.focus();
		return false;
	}
	
	if (name.value.trim().length < 4 || name.value.trim().length > 15) {
		alert("4~15자 이내로 입력하시오.");
		name.focus();
		return false;
	}
	
	if (unitPrice.value.length == 0 || isNaN(unitPrice.value)) {
		alert("[가격]은 숫자만 입력가능");
		unitPrice.focus();
		return false;
	}
	
	if (unitPrice.value < 0) {
		alert("[가격]은 양수만 가능");
		unitPrice.focus();
		return false;
	}
	
	if (author.value.trim().length==0 ) {
		alert("[저자] 명이 필요합니다.");
		author.focus();
		return false;
	}
	if (publisher.value.trim().length==0 ) {
		alert("[출판사] 명이 필요합니다.");
		publisher.focus();
		return false;
	} 
	
	if (desc.value.trim().length < 10) {
		alert("[상세설명] 최소 10자가 필요합니다.");
		desc.focus();
		return false;
	}
	
	if (unitInStock.value.length == 0 || isNaN(unitInStock.value)) {
		alert(unitInStock.value);
		alert("[재고수] 숫자만 입력하시오");
		unitInStock.focus();
		return false;
	} else {
		if (unitInStock.value < 0) {
		alert("[재고수]은 양수만 입력가능");
		unitInStock.focus();
		return false;
		}
	}
	if (category.value.trim().length== 0) {
		alert("[도서분류] 를 입력하시오.");
		category.focus();
		return false;
	}
	

	formnm.submit();
	// document.forms['newBook'].submit; // 위와 동일한 명령어
}

function check(reqExp, e, msg) {
	// 정규화한 코드와 비교해 value가 맞게 설정되었는지 확인
	if (reqExp.test(e.value)) {
		return true;
	} else {
		alert(msg);
		e.focus;
		return false;
	}
}

function deleteConfirm(id) {
	if (confirm("해당 도서를 삭제합니다!!") == true) {
		location.href = "./deleteBook.jsp?id=" + id;		
	}
	else {
		return;
	}
}

function checkForm() {
	if (!document.newMember.id.value) {
		alert("아이디를 입력하세요.");
		return false;
	}

	if (!document.newMember.password.value) {
		alert("비밀번호를 입력하세요.");
		return false;
	}

	if (document.newMember.password.value != document.newMember.password_confirm.value) {
		alert("비밀번호를 동일하게 입력하세요.");
		return false;
	}
	newMember.submit();
}

function checkData() {
	if (!document.newWrite.name.value) {
		alert("이름을 입력하세요.");
		return false;
	}
	if (!document.newWrite.subject.value) {
		alert("제목을 입력하세요.");
		return false;
	}
	if (!document.newWrite.content.value) {
		alert("내용을 입력하세요.");
		return false;
	}		
	document.newWrite.submit();
}

