// step 1
$(function() {
	$('#letter-a a').click(function() {
		$('#dictionary').hide().load('a.html', function() {
			$(this).fadeIn();
		});
		
		return false;
	});
});

//step 2-1
$(function() {
    $('#letter-b a').click(function() {
        $.ajax({
            url: 'b.json',
            type: 'get',
            dataType: 'json',
            success: function(data) {
                $('#dictionary').empty();
                $.each(data, function(index, item) {
                    let html = '<div class="entry">';
                    html += '<h3 class="term">' + item.term + '</h3><br/>';
                    html += '<div class="part">' + item.part + '</div><br/>';
                    html += '<div class="definition">' + item.definition + '</div>';
                    html += '</div>';
                    
                    $('#dictionary').append(html);
                });
            }
        });
        return false;
    });
});

$(function() {
   $('#letter-b a').click(function() {
      // ajax 함수 이용
      $.ajax({
         url : 'b.json',
         dataType : 'json',
         success : function(data) {
            $('#dictionary').empty();
            data.sort(function(a, b) {
            	if (a.term < b.term) {
            		return 1;
            	} else if (a.term > b.term) {
            		return -1;
            	} else {
            		return 0;
            	}
            });
            
            $.each(data, function(index, item) {
            	let html = '<div class="entry">';
                html += '<h3 class="term">' + item.term + '</h3><br/>';
                html += '<div class="part">' + item.part + '</div><br/>';
                html += '<div class="definition">' + item.definition + '</div>';
                html += '</div>';

               // dictionary에 html 추가
               $('#dictionary').append(html);
            });
         } 
      });
	      
      return false;
	      
   });
});

//step 2 - 
//$(function() {
//	$('#letter-b a').click(function() {
//		$.getJSON('b.json', function(data) {
//			$('#dictionary').empty();
//			// 결과값: 배열 -> [{}, {}, {}] -> HTML
//			$.each(data, function(index, item) {
//				let html = '<div class="entry">';
//				html += '<h3 class="term">' + item.term + '</h3>';
//				html += '<div class="part">' + item.part + '</div>';
//				html += '<div class="definition">' + item.definition + '</div>';
//				html += '</div>';
//				
//				$('#dictionary').append(html);
//			});
//		});
//		
//		return false;
//	});
//});

//step 3 - html 파일안에 js 스크립트 파싱 후 실행
$(function() {
	$('#letter-c a').click(function() {
		$.getScript('c.js');
		
		return false;
	});
});

//step 4 xml 파일을 html 파일로 변환
$(function() {
	$('#letter-d a').click(function() {
		$.get('d.xml', function(data){
			$('#dictionary').empty();
			$(data).find('entry').each(function(index) {
				let $entry = $(this);
				let html = '<div class="entry">';
				html += '<h3 clas="term">' + $entry.attr("term") + '</h3>';
				html += '<div class="part">' + $entry.attr("part") + '</div>';
				html += '<div class="definition">' + $entry.find('definition').text() + '</div>';
				
				$('#dictionary').append(html);
			});
		});
		
		return false;
	});
});

//step 5 - jsp 파일로 데이터 전송 (GET)
$(function() {
	$('#letter-e a').click(function() {
		$.get('server3.jsp', {'term': $(this).text()}, function(data) {
			$('#dictionary').text(data);
		})
		
		return false;
	});
});

//step 6
$(function() {
	$('form').submit(function() {
		$.ajax({
			url: 'server.jsp',
			type: 'post',
			data: $(this).serialize(),
			dataType: 'text',
			success: function(data) {
				alert('댓글 등록이 완됴되었습니다.');
			}
		});
		
		return false;
	});
});















