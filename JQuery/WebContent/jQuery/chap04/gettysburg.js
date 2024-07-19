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