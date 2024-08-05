$(function() {
	// 1. <ol id="note"></ol> -> 생성해서 <div id="footer"> 앞에 위치하도록 하자.
	$('<ol id="note"></ol>').insertBefore('#footer');
	
	// 2. <span class="footnote">앞에<a id="">[1]</a>
	$('span.footnote').each(function(idx) {
		$($('<a id="context-' + (idx + 1) + '">[' + (idx + 1) + ']</a>')).insertBefore(this);
	});
	
	// 3. <ol> 태그 자식으로 <span>을 이동
	$('span.footnote').each(function() {
		$(this).appendTo('ol.#note').wrap('<li></li>');
	});
	
	// 4. span안에 <a href="idx">context_1</a> 가 생성되도록 하자.
	$('span.footnote').each(function(idx) {
		$('<a href="#context-' + (idx + 1) + '">context_' + (idx + 1) + '</a>')
		.appendTo(this);
	});
	
});	