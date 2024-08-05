// step 1
// $(function() {
// 	$('#switcher-large').on('click', function() {
// 		$('body').addClass('large');
// 	});
// });

// step 2 -> large Print -> large.Narrow Column -> narrow, Default -> 처음
// addClass('클래스명'), removeClass('클래스명')
// $(function() {
// 	$('#switcher-large').on('click', function() {
// 		$('body').removeClass('narrow').addClass('large');
// 	});
	
// 	$('#switcher-narrow').on('click', function() {
// 		$('body').removeClass('large').addClass('narrow');
// 	});
	
// 	$('#switcher-default').on('click', function() {
// 		$('body').removeClass('large').removeClass('narrow');
// 	});
// });

// step 3: 클릭한 버튼만 selected 스타일 적용해보자.
// $(function() {
// 	$('#switcher-large').on('click', function() {
// 		$('body').removeClass('narrow')
// 		.addClass('large');
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 	});
	
// 	$('#switcher-narrow').on('click', function() {
// 		$('body').removeClass('large')
// 		.addClass('narrow');
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 	});
	
// 	$('#switcher-default').on('click', function() {
// 		$('body').removeClass('large').removeClass('narrow');
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 	});
// });


// step 4: 중복되는 select 관련 코드들을 최적화 하자.
// $(function() {
// 	$('#switcher-large').on('click', function() {
// 		$('body').removeClass('narrow')
// 		.addClass('large');
// 	});
	
// 	$('#switcher-narrow').on('click', function() {
// 		$('body').removeClass('large')
// 		.addClass('narrow');
// 	});
	
// 	$('#switcher-default').on('click', function() {
// 		$('body').removeClass('large').removeClass('narrow');
// 	});
	
// 	$('#switcher .button').on('click', function() {
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 	})
// });

//step 5: 전체적으로 중복코드를 최적화 해보자.
// $(function() {	
// 	$('#switcher .button').on('click', function() {
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 		$('body').removeClass();
		
// 		if (this.id === 'switcher-large')
// 			$('body').addClass('large');
// 		else if (this.id === 'switcher-narrow')
// 			$('body').addClass('narrow');
// 	})
// });

//step 6: 이벤트 통합 함수 사용 -> 개별 이벤트 함수로 리팩토링 할 수 있다.
// $(function() {	
// 	$('#switcher .button').click(function() {
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 		$('body').removeClass();
		
// 		if (this.id === 'switcher-large')
// 			$('body').addClass('large');
// 		else if (this.id === 'switcher-narrow')
// 			$('body').addClass('narrow');
// 	})
// });


// // step 7
$(function() {
	$('#switcher .button').hover(function() {
		$(this).addClass('hover');
	}, function() {
		$(this).removeClass('hover');
	});
});

//step 8: <h3>스타일 변환기</h3> 클릭 했을 때 => 버튼 3개를 화면에서 사라지게 하자.
// $(function() {	
// 	$('#switcher h3').click(function() {
// 		$('#switcher .button').toggleClass('hidden');
// 	})
	
// 	$('#switcher .button').click(function() {
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 		$('body').removeClass();
		
// 		if (this.id === 'switcher-large')
// 			$('body').addClass('large');
// 		else if (this.id === 'switcher-narrow')
// 			$('body').addClass('narrow');
// 	})
// });

// step 9: 이벤트 버블링 문제를 방지해보자.
// $(function() {	
// 	$('#switcher').click(function() {
// 		$('#switcher .button').toggleClass('hidden');
// 	})
	
// 	$('#switcher .button').click(function(e) {
// 		$('.button').removeClass('selected');
// 		$(this).addClass('selected');
// 		$('body').removeClass();
		
// 		if (this.id === 'switcher-large')
// 			$('body').addClass('large');
// 		else if (this.id === 'switcher-narrow')
// 			$('body').addClass('narrow');
		
// 		e.stopPropagation();
// 	})
// });

//step 10:	통합 함수인 on으로 변경 -> off('click')
//			large, narrow 버튼을 클릭 후, 버튼이 사라지게 하는 이벤트 해제
$(function() {	
	$('#switcher').on('click.kcc', function() {
		$('#switcher .button').toggleClass('hidden');
	});
	
	$('#switcher .button').click(function(e) {
		$('.button').removeClass('selected');
		$(this).addClass('selected');
		$('body').removeClass();
		
		if (this.id === 'switcher-large')
			$('body').addClass('large');
		else if (this.id === 'switcher-narrow')
			$('body').addClass('narrow');
		
		e.stopPropagation();
	});
	
	$('switcher').on('click.kosa', function() {
		alert('다른 이벤트 발생');
	});
	
	$('#switcher-large, #switcher-narrow').click(function() {
		$('#switcher').off('click.kcc');
	});
	
	$('#switcher').trigger('click.kcc');
	
});















