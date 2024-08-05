// $(): 팩토리 함수
$(function() {
	$('#selected-plays > li').addClass('horizontal');
	$('li:not(.horizontal)').addClass('sub-level');
	
	$('a[href $= pdf]').addClass('pdflink');
	$('a[href ^= mailto]').addClass('mailto');
	
	// not select: 팩토리 함수에 포함되어 작성된다.
//	$('a[href *= henry]:not(.mailto)').addClass('henrylink');
	// not 함수: not이라는 함수를 따로 체인함수로도 작성할 수 있다.
	$('a[href *= henry]').not('.mailto').addClass('henrylink');
	
	// $('tr:odd')/addClass('alt'); // 짝수번째
	// $('tr:nth-child(odd)').addClass('alt'); // 홀수번째
	$('tr').filter(':odd').addClass('alt'); // 짝수번째
	
//	$('td:contains(Henry)').nextAll().andSelf().addClass('highlight');
//	$('td:contains(Henry)').parent().find('td').addClass('highlight');
	$('td:contains(Henry)').parent().first('td' ).addClass('highlight');

	// each() -> 배열을 받아서 각각의 작업을 수행
	// $.each(배열, function(index, item){배열의 각 요소의 작업 수행})
	// $('선택자').each(function(index, item){각 요소(선택자)들의 작업 수행})
	
});
