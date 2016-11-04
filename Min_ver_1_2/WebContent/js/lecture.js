$(document).ready(function() {
	$('#sendQuestion').on('click', function() {
		if (!confirm('등록하시겠습니까?'))
			return;
	
		var myquestion_content = $('#content').val();
		var lecture_id = $('#lecture_id').val();
		var member_id = $('#member_id').val();
		var json = {
			"content" : myquestion_content,
			"lecture_id" : lecture_id,
			"member_id" : member_id
		}
		$.ajax({
			url : '/myquestion/registQuestion.do',
			type : 'post',
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			data : JSON.stringify(json),
			success : function(data) {			
				$('#showQList').prepend(
					'<li><div><h3>나의 질문내용 </h3><p>'+ data.content
					+ '</p></div><div style="display:none;"><h3>답변</h3><p id="reply_'+data.myquestion_id+'"></p></div></li>');
				$('#content').val('');
			
			}
		});
	});
	$("registHomework").click(function() {
		if (!confirm('등록하시겠습니까?'))
			return;
		
		var formData = new FormData();
		var file = this.files[0];                      //multiple 속성이 있으면 files 에는 다수의 객체가 할당됨
		formData.append("homework", file);
		
		$.ajax({
			async : true,
			method : 'post',
			url : '/member/sendHomework.do',
			processData : false,
			data : formData,
			contentType : false,
			success : function(data) {
				
				alert("일단 요까지 "+data);
			
			}
		});
	});
});

function goList(){
	
	form1.action="/lecture/list.do";
	form1.submit();
	
}
function registHomework() {

	form1.encoding = "multipart/form-data";
	form1.action = "/";

}