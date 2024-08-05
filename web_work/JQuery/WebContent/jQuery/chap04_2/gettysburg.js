$(function() {
	$('div.label').click(function() {
		const pWidth = $('div.speech p').outerWidth();
		const divWidth = $('#switcher').outerWidth();
		
//		console.log(pWidth + ':' + divWidth);
		const num = parseInt(pWidth) - parseInt(divWidth);
		
		$('#switcher').fadeTo('fast', 0.5)
		.animate({marginLeft: num}, 'slow')
		.fadeTo('fast', 1.0).slideUp('slow', function() {
			$(this).css('background', 'red').slideDown('slow');
		});
	});
});

//1. 2번째 p 태그를 화면에서 숨겨보자. (:hide())
// 2. <a>read more -> 클릭: 사라진 p태그를 화면에 보이기 함
// slideUp() + slideDown() -> slideToggle()
// read more 클릭 -> read less
// read less 클릭 -> read more
// text(값): 텍스트 값을 변경, text(): 텍스트 값을 추출
$(function() {
	$('.speech p').eq(1).hide();
	
	$('a.more').click(function() {
		$('.speech p').eq(1).slideToggle('slow');
	
		const $link = $(this);
		if ($link.text() == 'read more')
			$link.text('read less');
		else
			$link.text('read more');
	});
});

// large -> 기존 폰트 크기 1.2배 커지도록
// small -> 기존 폰트크기 1.2배 작아지도록
// default -> 처음 글자 크기
// css('fontSize), css('fontSize', 12px)
//$(function() {
//	const $speech = $('div.speech');
//	const defaultFontSize = parseInt($('.speech p').css('fontSize'));
//	$('#switcher-large').click(function() {
//		$speech
//		.animate({fontSize: parseInt($('.speech p').css('fontSize')) * 1.2 + 'px'}, 'slow');
//	});
//	$('#switcher-small').click(function() {
//		$speech
//		.animate({fontSize: parseInt($('.speech p').css('fontSize')) / 1.2 + 'px'}, 'slow');
//	});
//	$('#switcher-default').click(function() {
//		$speech
//		.animate({fontSize: defaultFontSize + 'px'}, 'slow');
//	});
//});

// 교수님 버전
$(function() {
	const $speech = $('div.speech');
	const defaultFontSize = parseInt($speech.css('fontSize'));

	$('#switcher button').click(function() {
		let num = parseInt($speech.css('fontSize'));
		
		switch(this.id) {
		case 'switcher-large':
			num *= 1.2;
			break;
		case 'switcher-small':
			num /= 1.2;
			break;
		default:
			num = defaultFontSize;
		break;
		}
		
		$speech.animate({fontSize : num + 'px'}, 'slow');
	});
});

