$(document).ready(function() {
    $('#title').on('keyup', function() {
        if($(this).val().length > 50) {
            $(this).val($(this).val().substring(0, 50));
        }
    });
    $('#content').on('keyup', function() {
        if($(this).val().length > 50) {
            $(this).val($(this).val().substring(0, 50));
        }
    });
    $('#summary').on('keyup', function() {
        if($(this).val().length > 50) {
            $(this).val($(this).val().substring(0, 50));
        }
    });
    $('#link').on('keyup', function() {
        if($(this).val().length > 100) {
            $(this).val($(this).val().substring(0, 100));
        }
    });
    $('#thumbnail').on('keyup', function() {
        if($(this).val().length > 100) {
            $(this).val($(this).val().substring(0, 100));
        }
    });
    $('input[name=checkAll]').click(function(){
    	var list = $('input[name=checkValue]');
    	for(var i=0; i<list.length; ++i)
    		list[i].checked = $('input[name=checkAll]').is(':checked');
    });
    $('input[name=checkValue]').click(function(){
    	if($('input[name=checkValue]:checked').length == 10){
    		$('input[name=checkAll]')[0].checked = true;
    	}else{
    		$('input[name=checkAll]')[0].checked = false;
    	}
    });
    $('#list_lec_cat_id').change(function(){
    	var lecturecategory_id = $('#list_lec_cat_id option:selected').val();
    	location.href="/admin/listlec.do?select="+lecturecategory_id;
    });
    $('#title').on('keyup',function(){
    	$('#lec_btn').removeAttr("disabled");
    });
    $('#content').on('keyup',function(){
    	$('#lec_btn').removeAttr("disabled");
    });
    $('#link').on('keyup',function(){
    	$('#lec_btn').removeAttr("disabled");
    });
    $('#title').on('keyup',function(){
    	$('#lec_btn').removeAttr("disabled");
    });
    $('#thumbnail').change(function(){
    	$('#lec_btn').removeAttr("disabled");
    });
    $('#lecturefile').change(function(){
    	$('#lec_btn').removeAttr("disabled");
    });
});

function checkInsertLectureValidity(){
	var flagCategoryId, flagTitle, flagContent, flagLink, flagthumbnail;
	flagCategoryId=flagTitle=flagContent=flagLink=flagthumbnail = true;
	
	if(lectureForm.lecturecategory_id.value == -1){
		$('#lec_category_id').attr('class','form-group has-error');
		flagTitle = false;
	}else{
		$('#lec_category_id').attr('class','form-group');
	}
	
	if(lectureForm.title.value == ""){
		$('#lec_title').attr('class','form-group has-error');
		flagTitle = false;
	}else{
		$('#lec_title').attr('class','form-group');
	}
	
	if(lectureForm.content.value == ""){
		$('#lec_content').attr('class','form-group has-error');
		flagContent = false;
	}else{
		$('#lec_content').attr('class','form-group');
	}
	
	if(lectureForm.link.value == ""){
		$('#lec_link').attr('class','form-group has-error');
		flagLink = false;
	}else{
		$('#lec_link').attr('class','form-group');
	}
	
	if(lectureForm.thumbnail.value == ""){
		$('#lec_thumbnail').attr('class','form-group has-error');
		flagthumbnail = false;
	}else{
		$('#lec_thumbnail').attr('class','form-group');
	}
		
	if(flagTitle&&flagContent&&flagLink&&flagthumbnail)
		return true;
	else
		return false;
}
function checkModifyLectureValidity(){
	var flagCategoryId, flagTitle, flagContent, flagLink, flagthumbnail;
	flagCategoryId=flagTitle=flagContent=flagLink=flagthumbnail = true;
	
	if(lectureDetailForm.lecturecategory_id.value == -1){
		$('#lec_category_id').attr('class','form-group has-error');
		flagTitle = false;
	}else{
		$('#lec_category_id').attr('class','form-group');
	}
	
	if(lectureDetailForm.title.value == ""){
		$('#lec_title').attr('class','form-group has-error');
		flagTitle = false;
	}else{
		$('#lec_title').attr('class','form-group');
	}
	
	if(lectureDetailForm.content.value == ""){
		$('#lec_content').attr('class','form-group has-error');
		flagContent = false;
	}else{
		$('#lec_content').attr('class','form-group');
	}
	
	if(lectureDetailForm.link.value == ""){
		$('#lec_link').attr('class','form-group has-error');
		flagLink = false;
	}else{
		$('#lec_link').attr('class','form-group');
	}
	
	if(lectureDetailForm.thumbnail.value == ""){
		$('#lec_thumbnail').attr('class','form-group has-error');
		flagthumbnail = false;
	}else{
		$('#lec_thumbnail').attr('class','form-group');
	}
		
	if(flagTitle&&flagContent&&flagLink&&flagthumbnail)
		return true;
	else
		return false;
}
function addLecture(){
	if(checkInsertLectureValidity()){
		lectureForm.method="post";
		lectureForm.encoding="multipart/form-data";
		lectureForm.action="/admin/addlec.do";
		lectureForm.submit();
	}
}

function modifyLecture(){
	if(checkModifyLectureValidity()){
		lectureDetailForm.method="post";
		lectureDetailForm.encoding="multipart/form-data";
		lectureDetailForm.action="/admin/modifylec.do";
		lectureDetailForm.submit();
	}
}

function deleteSomeLecture(select){
	if(!confirm("선택한 항목을 삭제하시겠습니까?"))
		return;
	
	var valueArr = new Array();
    var list = $('input[name=checkValue]');
    for(var i = 0; i < list.length; i++){
        if(list[i].checked){
        	var temp = {"lecture_id" : list[i].value};
            valueArr.push(temp);
        }
    }

    $.ajax({
    	method : 'post',
		url : '/admin/deletesomelec.do',
		data : JSON.stringify(valueArr),
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			location.href = "/admin/listlec.do?select="+select;
		},
		error : function(xhr, stat, err) {
			console.log(err);
		}
	});
}
function deleteOneLecture(lecture_id, select){
	if(!confirm("선택한 항목을 삭제하시겠습니까?"))
		return;
	
	var delete_id = {"lecture_id" : lecture_id};

	$.ajax({
    	method : 'post',
		url : '/admin/deleteonelec.do',
		data : JSON.stringify(delete_id),
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			location.href = "/admin/listlec.do?select="+select;
		},
		error : function(xhr, stat, err) {
			console.log(err);
		}
	});
}

function goLectrueAll(){
	location.href="/admin/listlec.do?select=0";
}

function checkVideoUrl(){
	var url = $('#link').val();
	if(url.indexOf('vimeo.com') == -1){
		alert("URL을 확인해 주세요!");
		return;
	}
	
	var videoId = url.substring(url.lastIndexOf("/")+1, url.length);
	var apiUrl = "http://vimeo.com/api/v2/video/"+ videoId+".json";
	var embedUrl = "https://player.vimeo.com/video/" + videoId;

	var JsonArray = new Array();
	$.getJSON(apiUrl, function(data) {
		var thumbnail = data[0].thumbnail_large;
		alert("동영상이 확인되었습니다.");
		$('#thumbnail').val(thumbnail);
		$('#link').val(embedUrl);
		
	});
}
