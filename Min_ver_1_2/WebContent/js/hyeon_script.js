var naver_id_login;
var state;

$(document).ready(function() {
	naver_id_login = new naver_id_login("hFDs8AYug94popiC4KWr", "http://localhost:9090/MinSsaem/");
	state = naver_id_login.getUniqState();
	
	naver_id_login.setButton("white", 2, 40);
	naver_id_login.setDomain(".service.com");
	naver_id_login.setState(state);
	//naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
	
	$('#btnLogin').click(function(){
		$('.modal-content').css("top", Math.max(0, (($(window).height() - $('.modal-content').outerHeight()) / 2) + $(window).scrollTop()) + "px");
		$('.modal-content').css("left", Math.max(0, (($(window).width() - $('.modal-content').outerWidth()) / 2) + $(window).scrollLeft()) + "px");
		$('#loginModal').css('display', 'block');
		
	});
	$('#loginModal').click(function(event){
		if(event.target === $('.modal-content')[0])
			return;
		$('#loginModal').css('display', 'none');
	});
});

function naverSignInCallback() {
	alert(naver_id_login.getProfileData('email'));
	alert(naver_id_login.getProfileData('nickname'));
	//alert(naver_id_login.getProfileData('age'));
}

