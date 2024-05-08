function checkAdd(){
  var formnm = document.getElementById("newBook")
  var bookId = document.getElementById("bookId");
  var name = document.getElementById("name");
  var unitPrice = document.getElementById("unitPrice");
  
  var author = document.getElementById("author");
  var publisher = document.getElementById("publisher");
  var disc = document.getElementById("description");
  var unitsInStock = document.getElementById("unitsInStock");
  var category = document.getElementById("category");
  
  if(bookId.value.trim().length>0 ){
	 if(!check(/^ISBN[0-9]{4,11}$/, bookId,
	     "[도서코드]\nISBN과 조합하여 12자리까지 입력하시오.\n 첫 글자는 반드시 ISBN으로 시작" )) {
		 return false;
	    }
	  }else{
		  alert("[도서코드]\nISBN과 조합하여 12자리까지 입력하시오.\n 첫 글자는 반드시 ISBN으로 시작");
		  bookId.focus();
		  return false;
	  }
   if(name.value.trim().length <4 || name.value.trim().length >15){
	   alert("[도서명]은 4글자에서 15글자 사이로 입력하시오.")
	   name.focus();
	   return false;
   }
   if(unitPrice.value.trim().length ==0 || isNaN(unitPrice.value)){
	   alert("[가격]은 숫자만 입력하시오.")
	   unitPrice.focus();
	   return false;
   }
   if(unitPrice.value<0){
	  alert("[가격]은 음수를 입력할수 없습니다.")
	   unitPrice.focus();
	   return false;   
   }
   if(author.value.trim().length==0 ){
	   alert("[저자]이름을 입력하시오");
	   author.focus();
	   return false;
   }  
   if(publisher.value.trim().length==0 ){
	   alert("[출판사명]을 입력하시오");
	   publisher.focus();
	   return false;
   }  
   
   if(disc.value.trim().length< 80){
	   alert("[상세설명]\n 100자 이상 입력하시오.")
	   disc.focus();
	   return false;
   }
   if(unitsInStock.value.length ==0 || isNaN(unitsInStock.value)) {
	   alert("[재고수]\n 숫자만 입력하시오.")
	   unitsInStock.focus();
	   return false;
   }else{
	  if(unitsInStock.value<0){
	   alert("[재고수]는 \n음수를 입력할수 없습니다.")
	   unitPrice.focus();
	   return false;   
      }  
   }
   if(category.value.trim().length ==0 ){
	   alert("[도서분류]\n를 입력하시오.")
	   category.focus();
	   return false;
   }
   formnm.submit();
}

function check(reqExp, e, msg){
	//정규화 한 코드와 비교해서 value가 맞게 설정되었는지 확인
	if(reqExp.test(e.value)){
		return true;
	}else{
		alert(msg);
		e.focus();
		return false;
	}
}

  function deleteConfirm(id) {
		if (confirm("해당 도서를 삭제합니다!!") == true)
			location.href = "./deleteBook.jsp?id=" + id;
		else
			return;
	}
	
	
	
	
	
	
	
