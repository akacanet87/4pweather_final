$(document).ready(function() {
    $('#title').on('keyup', function() {
        if($(this).val().length > 50) {
            $(this).val($(this).val().substring(0, 50));
        }
    });
    $('#instructor').on('keyup', function() {
        if($(this).val().length > 10) {
            $(this).val($(this).val().substring(0, 10));
        }
    });
    $('#summary').on('keyup', function() {
        if($(this).val().length > 50) {
            $(this).val($(this).val().substring(0, 50));
        }
    });
    $('#lang').on('keyup', function() {
        if($(this).val().length > 25) {
            $(this).val($(this).val().substring(0, 25));
        }
    });
    $('#ide').on('keyup', function() {
        if($(this).val().length > 25) {
            $(this).val($(this).val().substring(0, 25));
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
});

function checkInsertLectureCategoryValidity(){
	var flagTitle, flagInstructor, flagContent, flagSummary, flagLang, flagIde, flagImg, flagSummaryImg, flagPrice;
	flagTitle=flagInstructor=flagContent=flagSummary=flagLang=flagIde=flagImg=flagSummaryImg=flagPrice = true;
	
	if(lectureCategoryInsertForm.title.value == ""){
		$('#lec_cat_title').attr('class','form-group has-error');
		flagTitle = false;
	}else{
		$('#lec_cat_title').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.instructor.value == ""){
		$('#lec_cat_instructor').attr('class','form-group has-error');
		flagInstructor = false;
	}else{
		$('#lec_cat_instructor').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.content.value == ""){
		$('#lec_cat_content').attr('class','form-group has-error');
		flagContent = false;
	}else{
		$('#lec_cat_content').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.summary.value == ""){
		$('#lec_cat_summary').attr('class','form-group has-error');
		flagSummary = false;
	}else{
		$('#lec_cat_summary').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.lang.value == ""){
		$('#lec_cat_lang').attr('class','form-group has-error');
		flagLang = false;
	}else{
		$('#lec_cat_lang').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.ide.value == ""){
		$('#lec_cat_ide').attr('class','form-group has-error');
		flagIde = false;
	}else{
		$('#lec_cat_ide').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.imgFile.value == ""){
		$('#lec_cat_img_file').attr('class','form-group has-error');
		flagImg = false;
	}else{
		$('#lec_cat_img_file').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.summaryImgFile.value == ""){
		$('#lec_cat_summary_img_file').attr('class','form-group has-error');
		flagSummaryImg = false;
	}else{
		$('#lec_cat_summary_img_file').attr('class','form-group');
	}
	
	if(lectureCategoryInsertForm.price.value == ""){
		$('#lec_cat_price').attr('class','form-group has-error');
		flagPrice = false;
	}else{
		$('#lec_cat_price').attr('class','form-group');
	}
	
	if(flagTitle&&flagInstructor&&flagContent&&flagSummary&&flagLang&&flagIde&&flagImg&&flagSummaryImg&&flagPrice)
		return true;
	else
		return false;
}
function checkModifyLectureCategoryValidity(){
	var flagTitle, flagInstructor, flagContent, flagSummary, flagLang, flagIde, flagPrice;
	flagTitle=flagInstructor=flagContent=flagSummary=flagLang=flagIde=flagPrice = true;
	
	if(lectureCategoryDetailForm.title.value == ""){
		$('#lec_cat_title').attr('class','form-group has-error');
		flagTitle = false;
	}else{
		$('#lec_cat_title').attr('class','form-group');
	}
	
	if(lectureCategoryDetailForm.instructor.value == ""){
		$('#lec_cat_instructor').attr('class','form-group has-error');
		flagInstructor = false;
	}else{
		$('#lec_cat_instructor').attr('class','form-group');
	}
	
	if(lectureCategoryDetailForm.content.value == ""){
		$('#lec_cat_content').attr('class','form-group has-error');
		flagContent = false;
	}else{
		$('#lec_cat_content').attr('class','form-group');
	}
	
	if(lectureCategoryDetailForm.summary.value == ""){
		$('#lec_cat_summary').attr('class','form-group has-error');
		flagSummary = false;
	}else{
		$('#lec_cat_summary').attr('class','form-group');
	}
	
	if(lectureCategoryDetailForm.lang.value == ""){
		$('#lec_cat_lang').attr('class','form-group has-error');
		flagLang = false;
	}else{
		$('#lec_cat_lang').attr('class','form-group');
	}
	
	if(lectureCategoryDetailForm.ide.value == ""){
		$('#lec_cat_ide').attr('class','form-group has-error');
		flagIde = false;
	}else{
		$('#lec_cat_ide').attr('class','form-group');
	}
	
	if(lectureCategoryDetailForm.price.value == ""){
		$('#lec_cat_price').attr('class','form-group has-error');
		flagPrice = false;
	}else{
		$('#lec_cat_price').attr('class','form-group');
	}
	
	if(flagTitle&&flagInstructor&&flagContent&&flagSummary&&flagLang&&flagIde&&flagPrice)
		return true;
	else
		return false;
}
function addLectureCategory(){
	if(checkInsertLectureCategoryValidity()){
		lectureCategoryInsertForm.method="post";
		lectureCategoryInsertForm.encoding="multipart/form-data";
		lectureCategoryInsertForm.action="/admin/addleccat.do";
		lectureCategoryInsertForm.submit();
	}
}

function modifyLectureCategory(){
	if(checkModifyLectureCategoryValidity()){
		lectureCategoryDetailForm.method="post";
		lectureCategoryDetailForm.encoding="multipart/form-data";
		lectureCategoryDetailForm.action="/admin/modifyleccat.do";
		lectureCategoryDetailForm.submit();
	}
}

function deleteSomeLectureCategory(){
	if(!confirm("선택한 항목을 삭제하시겠습니까?"))
		return;
	
	var valueArr = new Array();
    var list = $('input[name=checkValue]');
    for(var i = 0; i < list.length; i++){
        if(list[i].checked){
        	var temp = {"lecturecategory_id" : list[i].value};
            valueArr.push(temp);
        }
    }
    
    $.ajax({
    	method : 'post',
		url : '/admin/deletesomeleccat.do',
		data : JSON.stringify(valueArr),
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			location.href = "/admin/listleccat.do";
		},
		error : function(xhr, stat, err) {
			console.log(err);
		}
	});
}
function deleteOneLectureCategory(lecturecategory_id){
	if(!confirm("선택한 항목을 삭제하시겠습니까?"))
		return;
	
	var delete_id = {"lecturecategory_id" : lecturecategory_id};
	console.log(delete_id);
	
	$.ajax({
    	method : 'post',
		url : '/admin/deleteoneleccat.do',
		data : JSON.stringify(delete_id),
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			location.href = "/admin/listleccat.do";
		},
		error : function(xhr, stat, err) {
			console.log(err);
		}
	});
}
function goLectrueCategory(){
	location.href="/admin/listleccat.do";
}