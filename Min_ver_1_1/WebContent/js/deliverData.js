function registMyQuestion(myquestion_id){
	if(!confirm("글을 등록하시겠습니까?")){
		
		return;
		
	}else{
		
		alert("등록되었습니다.");
		
	}
		
	
	var registQuestion_id = {"myquestion_id" : myquestion_id};
	console.log(registQuestion_id);
	
	$.ajax({
    	method : 'post',
		url : '/lecture/registquestion.do',
		data : JSON.stringify(registQuestion_id),
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			location.href = "/lecture/player.do";
		},
		error : function(xhr, stat, err) {
			console.log(err);
		}
	});
}



function deleteMyQuestion(myquestion_id){
	if(!confirm("글을 삭제하시겠습니까?")){
		
		return;
		
	}else{
		
		alert("삭제되었습니다.");
		
	}
		
	
	var deleteQuestion_id = {"myquestion_id" : myquestion_id};
	console.log(deleteQuestion_id);
	
	$.ajax({
    	method : 'post',
		url : '/lecture/deletequestion.do',
		data : JSON.stringify(registQuestion_id),
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			location.href = "/lecture/player.do";
		},
		error : function(xhr, stat, err) {
			console.log(err);
		}
	});
}



function updateMyQuestion(myquestion_id){
	if(!confirm("글을 수정하시겠습니까?")){
		
		return;
		
	}else{
		
		alert("수정되었습니다.");
		
	}
		
	
	var updateQuestion_id = {"myquestion_id" : myquestion_id};
	console.log(updateQuestion_id);
	
	$.ajax({
    	method : 'post',
		url : '/lecture/updatequestion.do',
		data : JSON.stringify(updateQuestion_id),
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			location.href = "/lecture/player.do";
		},
		error : function(xhr, stat, err) {
			console.log(err);
		}
	});
}