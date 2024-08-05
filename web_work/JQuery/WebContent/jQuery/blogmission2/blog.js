$(function(){
	$(window).on('load', function(){
		$.ajax({
			url: 'server.jsp',
			type: 'get',
			data: $(this).serialize(),
			dataType: 'json',
			success: function(data) {
				$('#list').empty();
				$.each(data, function(index, item) {
					let html = '<div class="comments card mt-3 mb-3 mx-5">';
					html += '<div class="card-header d-flex justify-content-between align-items-center">';
					html += '<h5 class="card-title mb-0">' + item.title + '</h5>';
					html += '<button type="button" class="btn btn-danger btn-sm">X</button></div>';
					html += '<div class="card-body bg-white">';
					html += '<p class="contents card-text">' + item.contents + '</p>';
					html += '<p class="writer card-text text-muted small fst-italic">' + item.writer + '</p>';
					html += '</div>';
					html += '</div>';
	                
	                $('#list').append(html);
				})
			}
		});
		
		return false;
	});	
});

$(function() {
	$('body').on('click', '.btn', function() {
		$(this).parent('div').parent('div').remove();
	});
});

$(function(){
	$('form').submit(function() {
		$.ajax({
			url: 'server.jsp',
			type: 'post',
			data: $(this).serialize(),
			dataType: 'json',
			success: function(data) {
				$('#list').empty();
				$.each(data, function(index, item) {
					let html = '<div class="comments card mt-3 mb-3 mx-5">';
					html += '<div class="card-header d-flex justify-content-between align-items-center">';
					html += '<h5 class="card-title mb-0">' + item.title + '</h5>';
					html += '<button type="button" class="btn btn-danger btn-sm">X</button></div>';
					html += '<div class="card-body bg-white">';
					html += '<p class="contents card-text">' + item.contents + '</p>';
					html += '<p class="writer card-text text-muted small fst-italic">' + item.writer + '</p>';
					html += '</div>';
					html += '</div>';
	                
	                $('#list').append(html);
				})
			}
		});
		
		return false;
	});		
});
